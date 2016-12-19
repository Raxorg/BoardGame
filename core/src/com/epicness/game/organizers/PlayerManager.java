package com.epicness.game.organizers;

import com.epicness.game.actors.Board;
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

    public static PlayerManager getInstance() {
        return instance;
    }

    public void updateMoney(int player, Integer money) {
        players[player].setMoney(money);
    }

    public Player[] getPlayers() {
        return players;
    }

    public void updatePosition(int player, Integer position) {
        players[player].move(Board.getInstance().getCell(position));
    }
}
