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

    void getCharacterAvailable(String character);

    void getPlayerAssignment(int player);
}
