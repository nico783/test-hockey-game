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
                playersToPlayerDtos(team.getPlayers(), team.getCaptain()));
    }

    private List<PlayerDto> playersToPlayerDtos(Set<Player> players, Player captain) {
        return players.stream()
                .map(player -> new PlayerDto(player.getNumber(),
                        player.getName(),
                        player.getLastname(),
                        player.getPosition(),
                        captain.equals(player) ? true : null))
                .collect(Collectors.toList());
    }

    // TODO: 15/04/2022 Faire tu
}
