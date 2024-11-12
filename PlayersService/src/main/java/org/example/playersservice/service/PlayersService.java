package org.example.playersservice.service;

import java.util.List;

import org.example.playersservice.api.model.Player;

public interface PlayersService {

    Player getPlayer(String playerID);
    List<Player> getAllPlayers();
}
