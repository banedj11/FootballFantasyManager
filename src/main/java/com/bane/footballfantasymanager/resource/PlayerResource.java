package com.bane.footballfantasymanager.resource;

import com.bane.footballfantasymanager.domain.Player;
import com.bane.footballfantasymanager.domain.User;
import com.bane.footballfantasymanager.dto.UserDTO;
import com.bane.footballfantasymanager.service.PlayerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PlayerResource {

    private final PlayerService playerService;

    public PlayerResource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/players")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) throws URISyntaxException {
        Player newPlayer = playerService.save(player);
        return ResponseEntity.created(new URI("/api/players/" + newPlayer.getId().toString())).body(newPlayer);
    }

    @PutMapping("/players")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) throws URISyntaxException {
        if(player.getId() == null) {
            return createPlayer(player);
        }
        Player updatedPlayer = playerService.save(player);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @GetMapping("/players")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.findAll();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/players/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        Optional<Player> player = playerService.findOne(id);
        return new ResponseEntity(player, HttpStatus.OK);
    }

    @DeleteMapping("/players/{id}")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
