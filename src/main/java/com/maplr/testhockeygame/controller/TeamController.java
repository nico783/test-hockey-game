package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{year}")
    public ResponseEntity<TeamDto> findTeamByYear(@PathVariable(value = "year") long year) {
        return ResponseEntity.ok(teamService.findTeam(year));
    }

    @PostMapping(value = "/{year}/player", produces = "application/json")
    public ResponseEntity<PlayerDto> addPlayer(@PathVariable(value = "year") long year, @RequestBody PlayerDto playerDto) {
        // An endpoint /api/team/{year}/player/{player-number} should be created to access the created resource.
        return ResponseEntity
                .created(URI.create("/api/team/" + year + "/player/" + playerDto.getNumber()))
                .body(teamService.addPlayer(year, playerDto));
    }

    @PutMapping(value = "/{year}/player/captain/{ID}", produces = "application/json")
    public ResponseEntity<PlayerDto> updateCaptain(@PathVariable(value = "year") long year,
                                                   @PathVariable(value = "ID") long captainNumber) {
        return ResponseEntity
                .ok(teamService.updateCaptain(year, captainNumber));
    }

}
