package com.epicness.game.firebase;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */
public class SetterManager {

    //---------------------------
    //           BASE
    //---------------------------

    private static SetterManager instance = new SetterManager();

    private FirebaseInterface firebaseInterface;

    /**
     * Private constructor
     */
    private SetterManager() {

    }


    /**
     * Instance of the singleton class
     *
     * @return instance of singleton
     */
    public static SetterManager getInstance() {
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

    public void setCapital(int player, int capital) {
        firebaseInterface.setCapital(player, capital);
    }

    public void setCharacter(int player, String character) {
        firebaseInterface.setCharacter(player, character);
    }

    public void setCurrentActionIndex(int player, int actionIndex) {
        firebaseInterface.setCurrentActionIndex(player, actionIndex);
    }

    public void setLand(int player, int land) {
        firebaseInterface.setLand(player, land);
    }

    public void setMoney(int player, int money) {
        firebaseInterface.setMoney(player, money);
    }

    public void setPhoneID(int player, String phoneID) {
        firebaseInterface.setPhoneID(player, phoneID);
    }

    public void setPosition(int player, int position) {
        firebaseInterface.setPosition(player, position);
    }

    public void setSectors(int player, String sectors) {
        firebaseInterface.setSectors(player, sectors);
    }

    public void setWorkforce(int player, int workforce) {
        firebaseInterface.setWorkforce(player, workforce);
    }
}