package com.epicness.game.organizers;

import com.epicness.game.actors.Player;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public class PlayerManager {

    private static PlayerManager instance = new PlayerManager();

    private Player[] players;

    private PlayerManager() {
        players = new Player[4];
    }

    public PlayerManager getInstance() {
        return instance;
    }
}
