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

    void setSectors(int player, String sectors);

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

    void getSectors(int player);

    // Other getters

    void getTurn();

    void getGameStarted();

    void getWinner();

    //------------------
    //      OTHER
    //------------------

    void verifyPhoneID(String phoneID);

    void requestPlayerForPhoneID(String phoneID);

    void verifyCharacter(String character);

    void refreshCharacterSelection();

    void refreshWaitAction();

    // Gives the player factors
    void action1(int player, int workforce, int land, int capital);

    // Moves the player and gives money accordingly
    void action2(int player, int diceResult);

    void gameStartedAdvice(boolean gameStarted);

    void refreshCurrentActionIndexes();

    void refreshFactorCards(int player);

    void buyFactor(int player, int factor);

    void refreshFactorsToUpgradeCard(int card);

    void upgradeCard(int player, int factor);

    void updateSectorsToCheckWinCondition();

    void passTurn();

    void endGame(int winner);

    void resetDatabase();
}
