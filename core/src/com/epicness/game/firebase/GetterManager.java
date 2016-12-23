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
     * @return singleton instance
     */
    public static GetterManager getInstance() {
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
     * Checks if the character is available
     * @param requestedCharacter  is the name of the character
     */
    public void getCharacterAvailable(String requestedCharacter) {
        firebaseInterface.getCharacterAvailable(requestedCharacter);
    }

    /**
     * Gets a player assignment
     * @param requestedPlayer is the number of the player requested
     */
    public void getPlayerAssignment(int requestedPlayer) {
        firebaseInterface.getPlayerAssignment(requestedPlayer);
    }
}
