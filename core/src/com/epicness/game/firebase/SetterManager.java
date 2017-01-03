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

    /**
     * Updates the database if the player has been taken
     *
     * @param player
     * @param phoneID
     */
    public void setPhoneID(int player, String phoneID) {
        firebaseInterface.setPlayerPhoneID(player, phoneID);
    }

    /**
     * Updates the database with the character owner
     *
     * @param player
     * @param character
     */
    public void setCharacter(int player, String character) {
        firebaseInterface.setCharacter(player, character);
    }
}