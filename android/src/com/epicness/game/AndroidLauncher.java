package com.epicness.game;

import android.os.Bundle;
import android.view.WindowManager;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.epicness.game.BoardGame;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		BoardGame game = new BoardGame();
		FirebaseConnection firebaseConnection = new FirebaseConnection(game);
		game.setFirebaseConnection(firebaseConnection);
		initialize(game, config);
	}
}
