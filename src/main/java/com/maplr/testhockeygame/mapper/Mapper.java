package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public TeamDto teamToTeamDto(Team team) {
        return new TeamDto(team.getId(),
                team.getCoach(),
                team.getYear(),
                playersToPlayerDtos(team));
    }

    public PlayerDto playerToPlayerDto(Player player, Team team) {
        Player captain = team.getCaptain();
        return new PlayerDto(player.getNumber(),
                player.getName(),
                player.getLastname(),
                player.getPosition(),
                captain.equals(player) ? true : null);
    }

    private List<PlayerDto> playersToPlayerDtos(Team team) {
        Set<Player> players = team.getPlayers();
        return players.stream()
                .map(player -> playerToPlayerDto(player, team))
                .collect(Collectors.toList());
    }
}
