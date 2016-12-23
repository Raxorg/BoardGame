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
     * @return instance of singleton
     */
    public static SetterManager getInstance() {
        return instance;
    }

    /**
     * Connection setter with Firebase
     * @param firebaseInterface
     */
    public void setFirebaseInterface(FirebaseInterface firebaseInterface) {
        this.firebaseInterface = firebaseInterface;
    }

    //---------------------------
    //           BODY
    //---------------------------


    /**
     * Updates the database with the character owner
     * @param character
     * @param owner is the player owner
     */
    public void setOwner(String character, String owner) {
        firebaseInterface.setCharacterOwner(character, owner);
    }

    // Se debe hacer un update hacia la base de datos de si un jugador ha sido tomado

    /**
     * Updates the database if the player has been taken
     * @param player
     * @param taken
     */
    public void setTaken(int player, boolean taken) {
        firebaseInterface.setPlayerTaken(player, taken);
    }
}