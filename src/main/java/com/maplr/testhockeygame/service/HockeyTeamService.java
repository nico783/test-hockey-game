package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.Team;
import com.maplr.testhockeygame.mapper.Mapper;
import com.maplr.testhockeygame.repository.PlayerRepository;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HockeyTeamService {
    private final TeamRepository teamRepository;
    private final Mapper mapper;

    public HockeyTeamService(TeamRepository teamRepository, Mapper mapper) {
        this.teamRepository = teamRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public TeamDto findTeam(long year) {
        Optional<Team> team = teamRepository.findTeamByYearAndFetchPlayers(year);
        if(team.isPresent()) {
            return mapper.teamToTeamDto(team.get());
        } else {
            throw new IllegalArgumentException("There is no defined team for this year : [" + year +"].");
        }
    }
}
