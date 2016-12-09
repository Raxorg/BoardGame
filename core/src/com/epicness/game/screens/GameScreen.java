package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.actors.Board;
import com.epicness.game.actors.Dice;
import com.epicness.game.actors.Player;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class GameScreen extends MyScreen {

    private Dice dice = null;
    private Player[] players = new Player[2];

    private static GameScreen instance = new GameScreen();

    private GameScreen() {
        dice = new Dice();
        makeButtons();
        players[0] = new Player();
        players[1] = new Player();
    }

    public static GameScreen getInstance() {
        return instance;
    }

    public void makeButtons() {
        buttons = new Button[2];
        buttons[0] = new Button(
                Assets.button1,
                0,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Color.GREEN
        ) {
            @Override
            public void onTouchUp() {
                ScreenManager.setCurrentScreen(MenuScreen.getInstance());
            }
        };
        buttons[1] = new Button(
                Assets.button1,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Color.ORANGE
        ) {
            @Override
            public void onTouchUp() {
                if (dice.isVisible()) {
                    dice.setVisible(false);
                } else {
                    dice.resetTime();
                    dice.setVisible(true);
                }
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        Board.getInstance().draw(batch);
        for (Player p : players) {
            p.draw(delta, batch);
        }
        batch.setColor(0, 0.75f, 0.75f, 1);
        if (dice.isVisible()) {
            dice.draw(delta, batch);
        }
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
        batch.setColor(Color.WHITE);
    }
}
