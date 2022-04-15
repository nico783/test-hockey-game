package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.Team;
import com.maplr.testhockeygame.service.HockeyTeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final HockeyTeamService hockeyTeamService;

    public TeamController(HockeyTeamService hockeyTeamService) {
        this.hockeyTeamService = hockeyTeamService;
    }

    @GetMapping("/{year}")
    public ResponseEntity<TeamDto> findTeamByYear(@PathVariable(value = "year") long year){
        return ResponseEntity.ok(hockeyTeamService.findTeam(year));
    }
}
