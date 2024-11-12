package org.example.playersservice.api.controller;

import java.util.List;

import org.example.playersservice.api.model.Player;
import org.example.playersservice.service.PlayersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class PlayersController {
    private final PlayersService service;

    public PlayersController(PlayersService service) {
        this.service = service;
    }

    @GetMapping("/players/{playerID}")
    public Player getPlayer(@PathVariable String playerID){
        return service.getPlayer(playerID);
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return service.getAllPlayers();
    }
}
