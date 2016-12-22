package com.epicness.game.firebase;

/**
 * Created by Groxar on 20/12/2016.
 * :D
 */

public class GetterManager {

    //---------------------------
    //           BASEx
    //---------------------------

    private static GetterManager instance = new GetterManager();

    private FirebaseInterface firebaseInterface;

    // Constructor privado
    private GetterManager() {

    }

    // Instancia de la clase singleton
    public static GetterManager getInstance() {
        return instance;
    }

    // Setter de la conexión con firebase
    public void setFirebaseInterface(FirebaseInterface firebaseInterface) {
        this.firebaseInterface = firebaseInterface;
    }

    //---------------------------
    //           BODY
    //---------------------------

    // Ve si un personaje está disponible
    public void getCharacterAvailable(String requestedCharacter) {
        firebaseInterface.getCharacterAvailable(requestedCharacter);
    }

    // Pide la asignación de un player
    public void getPlayerAssignment(int requestedPlayer) {
        firebaseInterface.getPlayerAssignment(requestedPlayer);
    }
}
