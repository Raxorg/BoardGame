package com.epicness.game;

import android.os.Bundle;
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import android.provider.Settings.Secure;

public class AndroidLauncher extends AndroidApplication {

    private String android_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        android_id = Secure.getString(getContext().getContentResolver(),
                Secure.ANDROID_ID);

        System.out.println(android_id);

        //makes a reference to edit configurations
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        //your screen phone will never go off
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        //creates a new instance of our game
        BoardGame game = new BoardGame();

        //creates an instance of firebase connection
        FirebaseConnection firebaseConnection = new FirebaseConnection();

        //database reference for the game
        game.setFirebaseConnection(firebaseConnection);

        //initializes the game with the configuration provided
        initialize(game, config);
    }
}
