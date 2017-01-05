package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.BoardGame;
import com.epicness.game.actors.Dice;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 05/01/2017.
 * :D
 */

public class ThrowDiceToMoveAction extends Action {

    private Dice dice;
    private boolean throwed, doneAction2;

    private static ThrowDiceToMoveAction instance = new ThrowDiceToMoveAction();

    private ThrowDiceToMoveAction() {
        dice = new Dice(
                Metrics.phoneWidth / 4 - (Metrics.tabHeight * 0.3f) / 2,
                Metrics.tabHeight * 0.6f,
                Metrics.tabHeight * 0.3f,
                Metrics.tabHeight * 0.3f,
                1
        );
        dice.setVisible(true);
        makeButtons();
    }

    public static ThrowDiceToMoveAction getInstance() {
        return instance;
    }

    @Override
    void draw(boolean left, float delta, SpriteBatch batch) {
        dice.draw(left, delta, batch);
        for (Button b : buttons) {
            b.draw(left, batch);
        }
    }

    @Override
    void makeButtons() {
        buttons = new Button[2];
        buttons[0] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 4 - (Metrics.tabHeight * 0.2f) / 2,
                Metrics.tabHeight * 0.3f,
                Metrics.tabHeight * 0.2f,
                Metrics.tabHeight * 0.2f,
                Color.ORANGE
        ) {
            @Override
            public void onTouchUp() {
                if (!throwed) {
                    if (dice.isStopped()) {
                        dice.setStopped(false);
                    }
                    throwed = true;
                    Assets.diceSound.loop();
                    Assets.diceSound.play();
                } else {
                    int playerIndex = PlayerManager.getInstance().getPlayerIndex();
                    if (PlayerManager.getInstance().getPlayers()[playerIndex].getCurrentActionIndex() == 2) {
                        dice.setStopped(true);
                        Listener.setLoading(true);
                        BoardGame.firebaseInterface.action2(
                                PlayerManager.getInstance().getPlayerIndex(),
                                dice.getCurrentFace()
                        );
                    }
                    Assets.diceSound.stop();
                }
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.dice5));
        buttons[1] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 4 - (Metrics.tabHeight * 0.2f) / 2,
                0,
                (Metrics.phoneWidth / 2) * 0.2f,
                (Metrics.phoneWidth / 2) * 0.2f,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                if (doneAction2) {
                    ActionsTab.getInstance().setCurrentAction(BuyFactorsAction.getInstance().reset());
                }
            }
        };
        buttons[1].setImage(new TextureRegion(Assets.next));
    }

    @Override
    Action reset() {
        throwed = false;
        return this;
    }

    public void doneAction2() {
        Listener.setLoading(false);
        PlayerManager.getInstance().updateCurrentActionIndex(
                PlayerManager.getInstance().getPlayerIndex(),
                3
        );
        buttons[1].setColor(Color.RED);
        doneAction2 = true;
    }
}
