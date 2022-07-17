package com.bane.footballfantasymanager.resource;

import com.bane.footballfantasymanager.domain.Team;
import com.bane.footballfantasymanager.service.TeamService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TeamResource {

    private final TeamService teamService;

    public TeamResource(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/teams")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Team> createTeam(@RequestBody Team team) throws URISyntaxException {
        Team newTeam = teamService.save(team);
        return ResponseEntity.created(new URI("/api/players/" + newTeam.getId().toString())).body(newTeam);
    }

    @PutMapping("/teams")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) throws URISyntaxException {
        if(team.getId() == null) {
            return createTeam(team);
        }
        Team updatedTeam = teamService.save(team);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @GetMapping("/teams")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.findAll();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/team/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Team> getTeam(@PathVariable Long id) {
        Optional<Team> team = teamService.findOne(id);
        return new ResponseEntity(team, HttpStatus.OK);
    }

    @DeleteMapping("/team/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.delete(id);
        return ResponseEntity.ok().build();
    }
}
