package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.BoardGame;
import com.epicness.game.firebase.GetterManager;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class MainMenu extends MyScreen {

    private String loadingText = "Cargando...";
    private String play = "JUGAR";
    private float playWidth, playHeight, loadingWidth, loadingHeight;
    private boolean requestingData;

    private static MainMenu instance = new MainMenu();

    private MainMenu() {
        Text.setScale(0, 0.35f);
        playWidth = Text.getTextWidth(0, play);
        playHeight = Text.getTextHeight(0, play);
        Text.setScale(0, 0.2f);
        loadingWidth = Text.getTextWidth(0, loadingText);
        loadingHeight = Text.getTextHeight(0, loadingText);
        makeButtons();
        getAllDataFromDatabase();
    }

    public static MainMenu getInstance() {
        return instance;
    }

    public void makeButtons() {
        buttons = new Button[1];
        buttons[0] = new Button(
                Assets.button3,
                Gdx.graphics.getWidth() / 2 - 1.5f * (Gdx.graphics.getHeight() / 6),
                Gdx.graphics.getHeight() / 2 - (Gdx.graphics.getHeight() / 6) / 2,
                3 * (Gdx.graphics.getHeight() / 6),
                Gdx.graphics.getHeight() / 6,
                Color.RED
        ) {
            @Override
            public void onTouchUp() {
                BoardGame.firebaseInterface.verifyPhoneID(BoardGame.phoneID);
                Listener.setLoading(true);
                loadingText = "Cargando...";
                loadingWidth = Text.getTextWidth(0, loadingText);
                loadingHeight = Text.getTextHeight(0, loadingText);
                Assets.buttonSound.play();
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        for (Button b : buttons) {
            b.draw(true, batch);
        }
        Text.setScale(0, 0.35f);
        Text.bordered.setColor(Color.PURPLE);
        Text.bordered.draw(
                batch,
                play,
                Gdx.graphics.getWidth() / 2 - playWidth / 2,
                Gdx.graphics.getHeight() / 2 + playHeight / 2
        );
        Text.setScale(0, 0.2f);
        Text.bordered.setColor(Color.WHITE);
        Text.bordered.draw(
                batch,
                loadingText,
                Gdx.graphics.getWidth() - loadingWidth - loadingHeight,
                loadingHeight * 2
        );
    }

    public void getAllDataFromDatabase() {
        requestingData = true;
        Listener.setLoading(true);
        GetterManager.getInstance().getGameStarted();
        for (int i = 0; i < 4; i++) {
            GetterManager.getInstance().getCapital(i);
            GetterManager.getInstance().getCharacter(i);
            GetterManager.getInstance().getCurrentActionIndex(i);
            GetterManager.getInstance().getLand(i);
            GetterManager.getInstance().getMoney(i);
            GetterManager.getInstance().getPhoneID(i);
            GetterManager.getInstance().getPosition(i);
            GetterManager.getInstance().getSectors(i);
            GetterManager.getInstance().getWorkforce(i);
        }
        GetterManager.getInstance().getTurn();
    }

    public boolean isRequestingData() {
        return requestingData;
    }

    public void doneLoadingData() {
        requestingData = false;
        loadingText = "";
        Listener.setLoading(false);
    }

    public void doneVerifyingPhoneID(int phoneIDIndex) {
        if (phoneIDIndex == -1) {
            BoardGame.firebaseInterface.requestPlayerForPhoneID(BoardGame.phoneID);
        } else {
            PlayerManager.getInstance().setPlayerIndex(phoneIDIndex);
            loadingText = "";
            Listener.setLoading(false);
            ScreenManager.setCurrentScreen(CharacterSelection.getInstance());
        }
    }

    public void doneRequestingPlayerForPhoneID(int phoneIDIndex) {
        if (phoneIDIndex == -1) {
            loadingText = "Juego completo";
            loadingWidth = Text.getTextWidth(0, loadingText);
            loadingHeight = Text.getTextHeight(0, loadingText);
        } else {
            PlayerManager.getInstance().setPlayerIndex(phoneIDIndex);
            PlayerManager.getInstance().updatePhoneID(
                    PlayerManager.getInstance().getPlayerIndex(),
                    BoardGame.phoneID
            );
            loadingText = "";
            Listener.setLoading(false);
            ScreenManager.setCurrentScreen(CharacterSelection.getInstance());
        }
    }
}
