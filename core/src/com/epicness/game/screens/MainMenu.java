package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.firebase.GetterManager;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Text;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class MainMenu extends MyScreen {

    private String requestingPlayer;
    private String loadingText = "loading";
    private String play = "PLAY";
    private float playWidth, playHeight;

    private static MainMenu instance = new MainMenu();

    private MainMenu() {
        Text.setScale(true, 0.35f);
        playWidth = Text.getTextWidth(true, play);
        playHeight = Text.getTextHeight(true, play);
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
                GetterManager.getInstance().getPlayerAssignment(0);
                requestingPlayer = "player1";
                loadingText = "Loading...";
                Listener.setLoading(true);
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        for (Button b : buttons) {
            batch.setColor(b.getColor());
            batch.draw(
                    b.getTexture(),
                    b.getX(),
                    b.getY(),
                    b.getWidth(),
                    b.getHeight()
            );
        }
        Text.setScale(true, 0.35f);
        Text.bordered.draw(
                batch,
                play,
                Gdx.graphics.getWidth() / 2 - playWidth / 2,
                Gdx.graphics.getHeight() / 2 + playHeight / 2
        );
    }
}
