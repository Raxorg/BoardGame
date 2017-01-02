package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.actors.Board;
import com.epicness.game.actors.Dice;
import com.epicness.game.actors.Player;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.screens.tabs.ActionsTab;
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
        leftTab = ActionsTab.getInstance().setLeft(true);
        rightTab = InfoTab.getInstance().setLeft(false);
        dice = new Dice();
        makeButtons();
    }

    public static Game getInstance() {
        return instance;
    }

    public void makeButtons() {
        buttons = new Button[3];
        TextureRegion tab = new TextureRegion(Assets.tab);
        buttons[0] = new Button(
                tab,
                0,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                leftTab = InfoTab.getInstance();
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.miniplayer));
        buttons[1] = new Button(
                tab,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
               leftTab = BoardTab.getInstance();
            }
        };
        buttons[2] = new Button(
                tab,
                2 * Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                leftTab = ActionsTab.getInstance();
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        leftTab.render(delta, batch);
        batch.setColor(Color.WHITE);
        rightTab.render(delta, batch);

        for (Button b : buttons) {
            b.draw(batch);
        }
    }
}
