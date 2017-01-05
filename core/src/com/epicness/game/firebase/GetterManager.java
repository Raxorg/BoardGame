package com.epicness.game.firebase;

/**
 * Created by Groxar on 20/12/2016.
 * :D
 */

public class GetterManager {

    //---------------------------
    //           BASE
    //---------------------------

    private static GetterManager instance = new GetterManager();

    private FirebaseInterface firebaseInterface;

    /**
     * Private constructor
     */
    private GetterManager() {

    }

    /**
     * Instance of the singleton class
     *
     * @return singleton instance
     */
    public static GetterManager getInstance() {
        return instance;
    }

    /**
     * Connection setter with Firebase
     *
     * @param firebaseInterface
     */
    public void setFirebaseInterface(FirebaseInterface firebaseInterface) {
        this.firebaseInterface = firebaseInterface;
    }

    //---------------------------
    //           BODY
    //---------------------------

    public void getGameStarted() {
        firebaseInterface.getGameStarted();
    }

    public void getCapital(int player) {
        firebaseInterface.getCapital(player);
    }

    public void getCharacter(int player) {
        firebaseInterface.getCharacter(player);
    }

    public void getCurrentActionIndex(int player) {
        firebaseInterface.getCurrentActionIndex(player);
    }

    public void getLand(int player) {
        firebaseInterface.getLand(player);
    }

    public void getMoney(int player) {
        firebaseInterface.getMoney(player);
    }

    public void getPhoneID(int player) {
        firebaseInterface.getPhoneID(player);
    }

    public void getPosition(int player) {
        firebaseInterface.getPosition(player);
    }

    public void getWorkforce(int player) {
        firebaseInterface.getWorkforce(player);
    }

    public void getTurn() {
        firebaseInterface.getTurn();
    }

    public void getSectors(int player) {
        firebaseInterface.getSectors(player);
    }
}
