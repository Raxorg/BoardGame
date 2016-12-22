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

    // Constructor privado
    private SetterManager() {

    }

    // Instancia de la clase singleton
    public static SetterManager getInstance() {
        return instance;
    }

    // Setter de la conexión con firebase
    public void setFirebaseInterface(FirebaseInterface firebaseInterface) {
        this.firebaseInterface = firebaseInterface;
    }

    //---------------------------
    //           BODY
    //---------------------------

    // Se debe hacer un update hacia la base de datos del dueño de un personaje
    public void setOwner(String character, String owner) {
        firebaseInterface.setCharacterOwner(character, owner);
    }

    // Se debe hacer un update hacia la base de datos de si un jugador ha sido tomado
    public void setTaken(int player, boolean taken) {
        firebaseInterface.setPlayerTaken(player, taken);
    }
}