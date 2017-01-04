package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.BoardGame;
import com.epicness.game.actors.Player;
import com.epicness.game.firebase.GetterManager;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
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
        leftTab = BoardTab.getInstance().setLeft(true).setActive(true);
        rightTab = InfoTab.getInstance().setLeft(false).setActive(true);
        makeButtons();
        updateButtons();
    }

    public void updateButtons() {
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

        // We need to update the colors of the buttons according availability
        if (BoardTab.getInstance().isActive()) {
            buttons[0].setColor(Color.GRAY);
            buttons[5].setColor(Color.GRAY);
        } else {
            buttons[0].setColor(Color.WHITE);
            buttons[5].setColor(Color.WHITE);
        }
        if (InfoTab.getInstance().isActive()) {
            buttons[1].setColor(Color.GRAY);
            buttons[6].setColor(Color.GRAY);
        } else {
            buttons[1].setColor(Color.WHITE);
            buttons[6].setColor(Color.WHITE);
        }
        if (ActionsTab.getInstance().isActive()) {
            buttons[2].setColor(Color.GRAY);
            buttons[7].setColor(Color.GRAY);
        } else {
            buttons[2].setColor(Color.WHITE);
            buttons[7].setColor(Color.WHITE);
        }
        if (MatrixTab.getInstance().isActive()) {
            buttons[3].setColor(Color.GRAY);
            buttons[8].setColor(Color.GRAY);
        } else {
            buttons[3].setColor(Color.WHITE);
            buttons[8].setColor(Color.WHITE);
        }
        if (InnerBoardTab.getInstance().isActive()) {
            buttons[4].setColor(Color.GRAY);
            buttons[9].setColor(Color.GRAY);
        } else {
            buttons[4].setColor(Color.WHITE);
            buttons[9].setColor(Color.WHITE);
        }
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
                if (!BoardTab.getInstance().isActive()) {
                    leftTab.setActive(false);
                    leftTab = BoardTab.getInstance().setLeft(true).setActive(true);
                    updateButtons();
                }
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
                if (!InfoTab.getInstance().isActive()) {
                    leftTab.setActive(false);
                    leftTab = InfoTab.getInstance().setLeft(true).setActive(true);
                    updateButtons();
                }
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
                if (!ActionsTab.getInstance().isActive()) {
                    leftTab.setActive(false);
                    leftTab = ActionsTab.getInstance().setLeft(true).setActive(true);
                    updateButtons();
                }
            }
        };
        buttons[2].setImage(new TextureRegion(Assets.miniactions));
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
                if (!MatrixTab.getInstance().isActive()) {
                    leftTab.setActive(false);
                    leftTab = MatrixTab.getInstance().setLeft(true).setActive(true);
                    updateButtons();
                    // TODO
                }
            }
        };
        buttons[3].setImage(new TextureRegion(Assets.minicard));
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
                if (!InnerBoardTab.getInstance().isActive()) {
                    leftTab.setActive(false);
                    leftTab = InnerBoardTab.getInstance().setLeft(true).setActive(true);
                    updateButtons();
                }
            }
        };
        buttons[4].setImage(new TextureRegion(Assets.minichart));
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
                if (!BoardTab.getInstance().isActive()) {
                    rightTab.setActive(false);
                    rightTab = BoardTab.getInstance().setLeft(false).setActive(true);
                    updateButtons();
                }
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
                if (!InfoTab.getInstance().isActive()) {
                    rightTab.setActive(false);
                    rightTab = InfoTab.getInstance().setLeft(false).setActive(true);
                    updateButtons();
                }
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
                if (!ActionsTab.getInstance().isActive()) {
                    rightTab.setActive(false);
                    rightTab = ActionsTab.getInstance().setLeft(false).setActive(true);
                    updateButtons();
                    // TODO
                }
            }
        };
        buttons[7].setImage(new TextureRegion(Assets.miniactions));
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
                if (!MatrixTab.getInstance().isActive()) {
                    rightTab.setActive(false);
                    rightTab = MatrixTab.getInstance().setLeft(false).setActive(true);
                    updateButtons();
                }
            }
        };
        buttons[8].setImage(new TextureRegion(Assets.minicard));
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
                if (!InnerBoardTab.getInstance().isActive()) {
                    rightTab.setActive(false);
                    rightTab = InnerBoardTab.getInstance().setLeft(false).setActive(true);
                    updateButtons();
                }
            }
        };
        buttons[9].setImage(new TextureRegion(Assets.minichart));
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
