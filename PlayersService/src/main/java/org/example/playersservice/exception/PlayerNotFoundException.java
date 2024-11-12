package org.example.playersservice.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String playerID) {
        super(String.format("No player with the id: %s was found.", playerID));
    }
}
