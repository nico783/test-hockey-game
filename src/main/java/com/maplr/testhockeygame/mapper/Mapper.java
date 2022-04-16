package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.Player;
import com.maplr.testhockeygame.entity.Team;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper between entity and dto.
 *
 * @author Nicolas Benizri
 */
@Component
public class Mapper {

    /**
     * Map a {@link Team} entity to a {@link TeamDto}.
     *
     * @param team entity to map.
     * @return teamDto representation.
     */
    public TeamDto teamToTeamDto(Team team) {
        return new TeamDto(team.getId(),
                team.getCoach(),
                team.getYear(),
                playersToPlayerDtos(team));
    }

    /**
     * Map a {@link Player} entity to a {@link PlayerDto}.
     *
     * @param player entity to map.
     * @param team   entity to retrieve the captain's information that should appear in playerDto.
     * @return playerDto representation.
     */
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
