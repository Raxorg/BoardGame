package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.BoardGame;
import com.epicness.game.actors.Board;
import com.epicness.game.actors.Dice;
import com.epicness.game.actors.Player;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.screens.tabs.ActionsTab;
import com.epicness.game.screens.tabs.BoardTab;
import com.epicness.game.screens.tabs.InfoTab;
import com.epicness.game.screens.tabs.InnerBoardTab;
import com.epicness.game.screens.tabs.MatrixTab;
import com.epicness.game.screens.tabs.Tab;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class Game extends MyScreen {

    private Tab leftTab, rightTab;
    private Player[] players = new Player[4];

    private static Game instance = new Game();

    private Game() {
        leftTab = BoardTab.getInstance().setLeft(true);
        rightTab = InfoTab.getInstance().setLeft(false);
        makeButtons();
        updateButtons();
    }

    private void updateButtons() {
        Button[] currentButtons;
        int numButtons = buttons.length + leftTab.getButtons().length + rightTab.getButtons().length;
        currentButtons = new Button[numButtons];
        int i = 0;
        for (int ia = 0; ia < buttons.length; i++, ia++) {
            currentButtons[i] = buttons[ia];
        }
        for (int ib = 0; ib < leftTab.getButtons().length; i++, ib++) {
            currentButtons[i] = leftTab.getButtons()[ib];
        }
        for (int ic = 0; ic < rightTab.getButtons().length; i++, ic++) {
            currentButtons[i] = rightTab.getButtons()[ic];
        }
        BoardGame.buttonListener.setButtons(currentButtons);
    }

    public static Game getInstance() {
        return instance;
    }

    public void makeButtons() {
        buttons = new Button[10];
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
                leftTab = BoardTab.getInstance().setLeft(true);
                updateButtons();
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.miniboard));
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
                leftTab = InfoTab.getInstance().setLeft(true);
                updateButtons();
            }
        };
        buttons[1].setImage(new TextureRegion(Assets.miniplayer));
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
                leftTab = ActionsTab.getInstance().setLeft(true);
                updateButtons();
            }
        };
        buttons[3] = new Button(
                tab,
                3 * Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                leftTab = MatrixTab.getInstance().setLeft(true);
                updateButtons();
            }
        };
        buttons[4] = new Button(
                tab,
                4 * Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                leftTab = InnerBoardTab.getInstance().setLeft(true);
                updateButtons();
            }
        };
        buttons[5] = new Button(
                tab,
                Metrics.phoneWidth / 2,
                Metrics.phoneHeight - Metrics.phoneHeight / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                rightTab = BoardTab.getInstance().setLeft(false);
                updateButtons();
            }
        };
        buttons[5].setImage(new TextureRegion(Assets.miniboard));
        buttons[6] = new Button(
                tab,
                Metrics.phoneWidth / 2 + Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                rightTab = InfoTab.getInstance().setLeft(false);
                updateButtons();
            }
        };
        buttons[6].setImage(new TextureRegion(Assets.miniplayer));
        buttons[7] = new Button(
                tab,
                Metrics.phoneWidth / 2 + 2 * Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                rightTab = ActionsTab.getInstance().setLeft(false);
                updateButtons();
            }
        };
        buttons[8] = new Button(
                tab,
                Metrics.phoneWidth / 2 + 3 * Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                rightTab = MatrixTab.getInstance().setLeft(false);
                updateButtons();
            }
        };
        buttons[9] = new Button(
                tab,
                Metrics.phoneWidth / 2 + 4 * Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 12,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 12,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                rightTab = InnerBoardTab.getInstance().setLeft(false);
                updateButtons();
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        leftTab.render(delta, batch);
        batch.setColor(Color.WHITE);
        rightTab.render(delta, batch);

        for (Button b : buttons) {
            b.draw(true, batch);
        }
    }
}
