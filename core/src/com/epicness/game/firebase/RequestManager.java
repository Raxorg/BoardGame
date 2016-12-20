package com.epicness.game.firebase;

/**
 * Created by Groxar on 20/12/2016.
 * :D
 */

public class RequestManager {


    private static RequestManager instance = new RequestManager();

    private FirebaseInterface firebaseInterface;

    private RequestManager() {

    }

    public static RequestManager getInstance() {
        return instance;
    }

    public static void setFirebaseInterface() {

    }

    public void requestCharacterAvailable(String character) {
            firebaseInterface.addCharacterListener(character);
    }
}
