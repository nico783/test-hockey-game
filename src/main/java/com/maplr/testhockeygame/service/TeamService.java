package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.entity.Team;
import com.maplr.testhockeygame.mapper.Mapper;
import com.maplr.testhockeygame.repository.PlayerRepository;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeamService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeamService.class);

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final Mapper mapper;

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository, Mapper mapper) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public TeamDto findTeam(long year) {
        Optional<Team> team = teamRepository.findTeamByYearAndFetchPlayers(year);
        if (team.isPresent()) {
            return mapper.teamToTeamDto(team.get());
        }
        throw new IllegalArgumentException("There is no defined team for this year : [" + year + "].");
    }

    @Transactional
    public PlayerDto addPlayer(long year, PlayerDto playerDto) {
        Optional<Team> team = teamRepository.findTeamByYearAndFetchPlayers(year);
        if (team.isPresent()) {
            Player player = new Player(playerDto.getNumber(), playerDto.getName(), playerDto.getLastName(), playerDto.getPosition());

            // /!\ The player instance remains transient (even after passing through the save method).
            Player persistentPlayer = playerRepository.save(player);
            team.get().getPlayers().add(persistentPlayer);

            // In case the added player is defined as captain, this information has to be changed in his team.
            if (playerDto.getIsCaptain()) {
                team.get().setCaptain(persistentPlayer);
            }

            return mapper.playerToPlayerDto(persistentPlayer, team.get());
        }
        throw new IllegalArgumentException("Unable to add player [" + playerDto.getNumber() + "]. There is no defined team for this year [" + year + "].");
    }

    @Transactional
    public PlayerDto updateCaptain(long year, long newCaptainNumber) {
        Optional<Team> team = teamRepository.findTeamByYearAndFetchPlayers(year);

        if (team.isPresent()) {
            Optional<Player> newCaptain = team.get()
                    .getPlayers()
                    .stream()
                    .filter(player -> player.getNumber() == newCaptainNumber)
                    .findAny();

            if (newCaptain.isPresent()) {
                team.get().setCaptain(newCaptain.get());
                return mapper.playerToPlayerDto(newCaptain.get(), team.get());
            }
            throw new IllegalArgumentException("ID [" + newCaptainNumber + "] does not correspond to any player of the team [" + team.get().getId() + "].");
        }
        throw new IllegalArgumentException("Unable to update the captain. There is no defined team for this year [" + year + "].");
    }
}