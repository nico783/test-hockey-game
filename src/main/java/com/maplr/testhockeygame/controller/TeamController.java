package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.Team;
import com.maplr.testhockeygame.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * Hockeygame Controller.
 *
 * @author Nicolas Benizri
 */
@RestController
@RequestMapping("/api/team")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    /**
     * Find a {@link Team} according to the year.
     *
     * @param year identify a team.
     * @return team.
     */
    @GetMapping(value = "/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamDto> findTeamByYear(@PathVariable(value = "year") long year) {
        return ResponseEntity.ok(teamService.findTeam(year));
    }

    /**
     * Allows to create and add a {@link Player} to a {@link Team}.
     *
     * Note: an endpoint to create a player without adding him to a team was also possible ("POST /api/player").
     * However, the README suggests that isCaptain should be specifiable when creating a player.
     * We have considered in the project that the notion of "captain" is information related to a team.
     * This approach simply ensures the consistency of the data (for example, this ensures that there is no team with more than one captain).
     * (see entity documentation {@link Team}).
     * On the other hand, the README also suggests that the creation of a user should be linked to a team: "POST /api/team/{Year}".
     *
     * @param year      identifies the team on which to add the player.
     * @param playerDto player to be added to the team.
     * @return the added player.
     */
    @PostMapping(value = "/{year}/player", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerDto> addPlayer(@PathVariable(value = "year") long year,
                                               @RequestBody PlayerDto playerDto) {
        // An endpoint /api/team/{year}/player/{player-number} should be created to access the created resource.
        return ResponseEntity
                .created(URI.create("/api/team/" + year + "/player/" + playerDto.getNumber()))
                .body(teamService.addPlayer(year, playerDto));
    }

    /**
     * Allows to change the captain of a {@link Team}.
     *
     * Note: as for the functionality of adding a player,
     * we considered that the notion of a captain made more sense for a {@link Team} than for a {@link Player}.
     * This makes it possible, for example, to deal with the case of a player who is part of the 2019 and 2020 team,
     * but who was only captain in 2020.
     * This is why the endpoint is in the team controller and needs to identify the team on which to modify the captain.
     *
     * @param year identify a team.
     * @param captainNumber identify the captain.
     * @return player captain
     */
    @PutMapping(value = "/{year}/player/captain/{ID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayerDto> updateCaptain(@PathVariable(value = "year") long year,
                                                   @PathVariable(value = "ID") long captainNumber) {
        return ResponseEntity.ok(teamService.updateCaptain(year, captainNumber));
    }
}
