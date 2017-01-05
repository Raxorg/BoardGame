package com.epicness.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.firebase.FirebaseInterface;
import com.epicness.game.firebase.GetterManager;
import com.epicness.game.firebase.SetterManager;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.screens.MainMenu;
import com.epicness.game.ui.buttons.ButtonListener;

public class BoardGame extends Game {

    private SpriteBatch batch;
    public static ButtonListener buttonListener;
    public static String phoneID;
    public static String winnerText;
    private static float winnerTextWidth, winnerTextHeight;
    public static FirebaseInterface firebaseInterface;

    void setFirebaseConnection(FirebaseInterface firebaseConnection) {
        SetterManager.getInstance().setFirebaseInterface(firebaseConnection);
        GetterManager.getInstance().setFirebaseInterface(firebaseConnection);
        firebaseInterface = firebaseConnection;
    }

    public BoardGame(String aPhoneID) {
        phoneID = aPhoneID;
    }

    @Override
    public void create() {
        Text.load();
        Assets.load();
        batch = new SpriteBatch();
        buttonListener = new ButtonListener();
        Gdx.input.setInputProcessor(new Listener(buttonListener));
        ScreenManager.setCurrentScreen(MainMenu.getInstance());
        // Don't let the user press the <- button for now
        Gdx.input.setCatchBackKey(true);
        Text.setScale(2, 3);
        winnerText = "";
        winnerTextWidth = Text.getTextWidth(2, winnerText);
        winnerTextHeight = Text.getTextHeight(2, winnerText);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setColor(Color.WHITE);
        batch.draw(Assets.bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        ScreenManager.getCurrentScreen().render(Gdx.graphics.getDeltaTime(), batch);
        Text.digits.setColor(Color.WHITE);
        Text.setScale(2, 0.5f);
        Text.digits.draw(
                batch,
                winnerText,
                Metrics.phoneWidth / 2 - winnerTextWidth / 2,
                Metrics.phoneHeight / 2 - winnerTextHeight / 2
        );
        batch.end();
    }

    public static void setWinnerCharacter(String winnerCharacter) {
        Text.setScale(2, 0.5f);
        winnerText = winnerCharacter + " wins!";
        winnerTextWidth = Text.getTextWidth(2, winnerText);
        winnerTextHeight = Text.getTextHeight(2, winnerText);
        MainMenu.getInstance().enableResetButton();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
