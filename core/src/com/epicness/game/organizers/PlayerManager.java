package com.epicness.game.organizers;

import com.badlogic.gdx.graphics.Color;
import com.epicness.game.BoardGame;
import com.epicness.game.actors.Board;
import com.epicness.game.actors.Player;
import com.epicness.game.firebase.GetterManager;
import com.epicness.game.firebase.SetterManager;
import com.epicness.game.input.Listener;
import com.epicness.game.screens.CharacterSelection;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public class PlayerManager {

    private static PlayerManager instance = new PlayerManager();

    private Player[] players;
    private String assignedPlayer;

    private PlayerManager() {
        players = new Player[4];
        players[0] = new Player(Color.ORANGE, 0, 0);
        players[1] = new Player(Color.CYAN, 1, 0);
        players[2] = new Player(Color.YELLOW, 0, 1);
        players[3] = new Player(Color.GREEN, 1, 1);
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

    public void updatePosition(int player, int position) {
        players[player].move(Board.getInstance().getCell(position));
    }

    public void updatePlayerAssignmentFromDatabase(int player, String phoneID) {
        if (phoneID.equals("none")) {
            SetterManager.getInstance().setPhoneID(
                    player,
                    BoardGame.phoneID
            );
            assignedPlayer = "player" + player;
            Listener.setLoading(false);
            ScreenManager.setCurrentScreen(CharacterSelection.getInstance());
        } else {
            if (player < 3) {
                GetterManager.getInstance().getPlayerAssignment(player + 1, BoardGame.phoneID);
            } else {
                System.out.println("All players taken");
            }
        }
    }

    public void setAssignedPlayer(String assignedPlayer) {
        this.assignedPlayer = assignedPlayer;
        Listener.setLoading(false);
        ScreenManager.setCurrentScreen(CharacterSelection.getInstance());
    }

    public String getAssignedPlayer() {
        return assignedPlayer;
    }

    public void updatePhoneID(int player, String phoneID) {
        players[player].setPhoneID(phoneID);
    }

    public int checkPhoneID(String phoneID) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getPhoneID().equals(phoneID)) {
                return i;
            }
        }
        return -1;
    }
}
