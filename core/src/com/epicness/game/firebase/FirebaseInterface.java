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

    void setCharacter(int player, String character);

    void setPlayerPhoneID(int player, String phoneID);

    //------------------
    //     GETTERS
    //------------------

    void getPlayerAssignment(int player, String phoneID);

    void getCharacterAssignment(int player, String character);
}
