package com.epicness.game.organizers;

import com.badlogic.gdx.graphics.Color;
import com.epicness.game.actors.Player;
import com.epicness.game.firebase.SetterManager;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public class PlayerManager {

    private static PlayerManager instance = new PlayerManager();

    private Player[] players;
    // this is the index of the player of this phone
    private int playerIndex;
    private int playerTurn;
    private boolean gameStarted;

    private PlayerManager() {
        players = new Player[4];
        players[0] = new Player(Color.ORANGE, 0, 0);
        players[1] = new Player(Color.CYAN, 1, 0);
        players[2] = new Player(Color.YELLOW, 0, 1);
        players[3] = new Player(Color.GREEN, 1, 1);
        playerTurn = -1;
        gameStarted = false;
    }

    public static PlayerManager getInstance() {
        return instance;
    }

    //---------------------------
    //      UPDATES TO DB
    //---------------------------

    public void updateCapital(int player, int capital) {
        SetterManager.getInstance().setCapital(player, capital);
        players[player].setCapital(capital);
    }

    public void updateCharacter(int player, String character) {
        SetterManager.getInstance().setCharacter(player, character);
        players[player].setCharacter(character);
    }

    public void updateCurrentActionIndex(int player, int currentActionIndex) {
        SetterManager.getInstance().setCurrentActionIndex(player, currentActionIndex);
        players[player].setCurrentActionIndex(currentActionIndex);
    }

    public void updateLand(int player, int land) {
        SetterManager.getInstance().setLand(player, land);
        players[player].setLand(land);
    }

    public void updateMoney(int player, int money) {
        SetterManager.getInstance().setMoney(player, money);
        players[player].setMoney(money);
    }

    public void updatePhoneID(int player, String phoneID) {
        SetterManager.getInstance().setPhoneID(player, phoneID);
        players[player].setPhoneID(phoneID);
    }

    public void updatePosition(int player, int position) {
        SetterManager.getInstance().setPosition(player, position);
        players[player].setPosition(position);
    }

    public void updateWorkforce(int player, int workforce) {
        SetterManager.getInstance().setWorkforce(player, workforce);
        players[player].setWorkforce(workforce);
    }

    //---------------------------
    //      UPDATES FROM DB
    //---------------------------

    public void capitalDBUpdate(int player, int capital) {
        players[player].setCapital(capital);
    }

    public void characterDBUpdate(int player, String character) {
        players[player].setCharacter(character);
    }

    public void currentActionIndexDBUpdate(int player, int actionIndex) {
        players[player].setCurrentActionIndex(actionIndex);
    }

    public void landDBUpdate(int player, int land) {
        players[player].setLand(land);
    }

    public void moneyDBUpdate(int player, int money) {
        players[player].setMoney(money);
    }

    public void phoneIDDBUpdate(int player, String phoneID) {
        players[player].setPhoneID(phoneID);
    }

    public void positionDBUpdate(int player, int position) {
        players[player].setPosition(position);
    }

    public void sectorsDBUpdate(int player, String sectors) {
        players[player].setSectors(sectors);
    }

    public void workforceDBUpdate(int player, int workforce) {
        players[player].setWorkforce(workforce);
    }

    public void turnDBUpdate(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    //---------------------------
    //          OTHER
    //---------------------------

    public void setPlayerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }

    public int getPlayerIndex() {
        return playerIndex;
    }

    public Player[] getPlayers() {
        return players;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean getGameStarted() {
        return gameStarted;
    }
/*
    public String getAssignedPlayer() {
        return assignedPlayer;
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

    public void updateCharacterAssignmentFromDatabase(int player, String character) {
        if (character.equals("none")) {
            SetterManager.getInstance().setCharacter(
                    player,
                    CharacterSelection.getInstance().getRequestedCharacter()
            );
        }
    }

    public int checkCharacter() {
        String requestedCharacter = CharacterSelection.getInstance().getRequestedCharacter();
        for (int i = 0; i < players.length; i++) {
            if (players[i].getCharacter().equals(requestedCharacter)) {
                return i;
            }
        }
        return -1;
    }
    */
}
