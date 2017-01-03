package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.BoardGame;
import com.epicness.game.firebase.GetterManager;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class MainMenu extends MyScreen {

    private String loadingText = "Loading...";
    private String play = "PLAY";
    private float playWidth, playHeight, loadingWidth, loadingHeight;

    private static MainMenu instance = new MainMenu();
    private boolean loading;

    private MainMenu() {
        Text.setScale(true, 0.35f);
        playWidth = Text.getTextWidth(true, play);
        playHeight = Text.getTextHeight(true, play);
        Text.setScale(true, 0.2f);
        loadingWidth = Text.getTextWidth(true, loadingText);
        loadingHeight = Text.getTextHeight(true, loadingText);
        makeButtons();
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
                int phoneIDInUse = PlayerManager.getInstance().checkPhoneID(BoardGame.phoneID);
                if (phoneIDInUse != -1) {
                    PlayerManager.getInstance().setAssignedPlayer("player" + phoneIDInUse);
                } else {
                    GetterManager.getInstance().getPlayerAssignment(0, BoardGame.phoneID);
                }
                loadingText = "Loading...";
                Listener.setLoading(true);
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        for (Button b : buttons) {
            b.draw(true, batch);
        }
        Text.setScale(true, 0.35f);
        Text.bordered.setColor(Color.PURPLE);
        Text.bordered.draw(
                batch,
                play,
                Gdx.graphics.getWidth() / 2 - playWidth / 2,
                Gdx.graphics.getHeight() / 2 + playHeight / 2
        );
        Text.setScale(true, 0.2f);
        Text.bordered.setColor(Color.WHITE);
        Text.bordered.draw(
                batch,
                loadingText,
                Gdx.graphics.getWidth() - loadingWidth,
                loadingHeight * 2
        );
    }

    public void setLoading(String loading) {
        this.loadingText = loading;
    }
}
