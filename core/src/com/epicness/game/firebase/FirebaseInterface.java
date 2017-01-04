package com.epicness.game.firebase;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public interface FirebaseInterface {

    //------------------
    //     SETTERS
    //------------------

    void setCapital(int player, int capital);

    void setCharacter(int player, String character);

    void setCurrentActionIndex(int player, int actionIndex);

    void setLand(int player, int land);

    void setMoney(int player, int money);

    void setPhoneID(int player, String phoneID);

    void setPosition(int player, int position);

    void setWorkforce(int player, int workforce);

    //------------------
    //     GETTERS
    //------------------

    void getCapital(int player);

    void getCharacter(int player);

    void getCurrentActionIndex(int player);

    void getLand(int player);

    void getMoney(int player);

    void getPhoneID(int player);

    void getPosition(int player);

    void getWorkforce(int player);

    void getTurn();

    //------------------
    //      OTHER
    //------------------

    void verifyPhoneID(String phoneID);

    void requestPlayerForPhoneID(String phoneID);

    void verifyCharacter(String character);

    void refreshCharacterSelection();
}
