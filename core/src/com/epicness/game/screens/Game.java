package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.actors.Board;
import com.epicness.game.actors.Dice;
import com.epicness.game.actors.Player;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.screens.tabs.BoardTab;
import com.epicness.game.screens.tabs.InfoTab;
import com.epicness.game.screens.tabs.Tab;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class Game extends MyScreen {

    private Tab leftTab, rightTab;
    private Dice dice = null;
    private Player[] players = new Player[4];

    private static Game instance = new Game();

    private Game() {
        leftTab = BoardTab.getInstance().setLeft(true);
        rightTab = InfoTab.getInstance().setLeft(false);
        dice = new Dice();
        makeButtons();
    }

    public static Game getInstance() {
        return instance;
    }

    public void makeButtons() {
        buttons = new Button[3];
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
                ScreenManager.setCurrentScreen(MainMenu.getInstance());
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
        buttons[2] = new Button(
                Assets.button1,
                2 * Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Color.BLUE
        ) {
            @Override
            public void onTouchUp() {
                ScreenManager.setCurrentScreen(Hanii.getInstance());
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        leftTab.render(delta, batch);
        rightTab.render(delta, batch);

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
    }
}
