package org.example.playersservice.service;

import static org.example.playersservice.config.CacheConfig.PLAYERS_CACHE_NAME;

import java.util.List;
import java.util.Optional;

import org.example.playersservice.api.model.Player;
import org.example.playersservice.exception.PlayerNotFoundException;
import org.example.playersservice.repository.PlayerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PlayersServiceImpl implements PlayersService {
    private final PlayerRepository repo;

    public PlayersServiceImpl(PlayerRepository repo){
        this.repo = repo;
    }

    @Override
    @Cacheable(value = PLAYERS_CACHE_NAME, key="#playerID")
    public Player getPlayer(String playerID) {
        Optional<Player> player = repo.findById(playerID);
        return player.orElseThrow(() -> new PlayerNotFoundException(playerID));
    }

    @Override
    public List<Player> getAllPlayers() {
        return repo.findAll();
    }
}
