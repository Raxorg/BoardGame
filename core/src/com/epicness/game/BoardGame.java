package com.epicness.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.firebase.FirebaseInterface;
import com.epicness.game.firebase.GetterManager;
import com.epicness.game.firebase.SetterManager;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.screens.MainMenu;
import com.epicness.game.ui.buttons.AllPurposeButtonListener;

public class BoardGame extends Game {

    private SpriteBatch batch;
    public static AllPurposeButtonListener buttonListener;

    void setFirebaseConnection(FirebaseInterface firebaseInterface) {
        SetterManager.getInstance().setFirebaseInterface(firebaseInterface);
        GetterManager.getInstance().setFirebaseInterface(firebaseInterface);
    }

    @Override
    public void create() {
        Text.load();
        Assets.load();
        batch = new SpriteBatch();
        buttonListener = new AllPurposeButtonListener();
        Gdx.input.setInputProcessor(buttonListener);
        ScreenManager.setCurrentScreen(MainMenu.getInstance());

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setColor(Color.WHITE);
        batch.draw(Assets.bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ScreenManager.getCurrentScreen().render(Gdx.graphics.getDeltaTime(), batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
