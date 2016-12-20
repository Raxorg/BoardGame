package com.epicness.game.firebase;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */
public class Updater {

    private FirebaseInterface firebaseInterface;

    public Updater(FirebaseInterface firebaseInterface) {
        this.firebaseInterface = firebaseInterface;
    }

    public void characterOwnerUpdate(String character, String owner) {
        firebaseInterface.updateCharacterOwner(character, owner);
    }
}