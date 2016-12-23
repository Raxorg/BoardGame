package com.epicness.game.firebase;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public interface FirebaseInterface {

    //------------------
    //     SETTERS
    //------------------

    void setMoney(int player, int money);

    void setPosition(int player, int position);

    void setCharacterOwner(String character, String owner);

    void setPlayerTaken(int player, boolean taken);

    //------------------
    //     GETTERS
    //------------------

    /**
     * Creates a temporary listener for the players' attributes
     * @param value the value to listen for
     */
    void addTempPlayerListener(int player, String value);

    void getCharacterAvailable(String character);

    void getPlayerAssignment(int player);
}
