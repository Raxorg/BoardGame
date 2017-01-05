package com.epicness.game.screens.tabs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.BoardGame;
import com.epicness.game.actors.Dice;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 04/01/2017.
 * :D
 */
public class ThrowFirstDiceAction extends Action {

    private Dice workforceDice, landDice, capitalDice;
    private float titleWidth, titleHeight;
    private boolean throwed, doneAction1;
    private String workforce, land, capital;

    private static ThrowFirstDiceAction instance = new ThrowFirstDiceAction();

    private ThrowFirstDiceAction() {
        Text.setScale(0, 0.2f);
        titleWidth = Text.getTextWidth(0, "Lanzamiento inicial");
        titleHeight = Text.getTextHeight(0, "Lanzamiento inicial");
        float diceSize = ((Metrics.phoneWidth / 2) / 10) * 2;
        workforceDice = new Dice(
                diceSize * 0.5f,
                Metrics.tabHeight / 2 - (Metrics.tabHeight / 6) / 2,
                diceSize,
                diceSize,
                1f
        );
        workforceDice.setVisible(true);
        landDice = new Dice(
                diceSize * 2,
                Metrics.tabHeight / 2 - (Metrics.tabHeight / 6) / 2,
                diceSize,
                diceSize,
                1.25f
        );
        landDice.setVisible(true);
        capitalDice = new Dice(
                diceSize * 3.5f,
                Metrics.tabHeight / 2 - (Metrics.tabHeight / 6) / 2,
                diceSize,
                diceSize,
                0.75f
        );
        capitalDice.setVisible(true);

        firstButtonIndex = 1;
        lastButtonIndex = 1;
        makeButtons();
        workforce = "";
        land = "";
        capital = "";
    }

    public static ThrowFirstDiceAction getInstance() {
        return instance;
    }

    void makeButtons() {
        buttons = new Button[2];
        buttons[0] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 4 - (Metrics.tabHeight / 10) / 2,
                Metrics.tabHeight / 2 - (Metrics.tabHeight / 6) / 2 - 2 * (Metrics.tabHeight / 10),
                Metrics.tabHeight / 10,
                Metrics.tabHeight / 10,
                Color.ORANGE
        ) {
            @Override
            public void onTouchUp() {
                if (!throwed) {
                    if (workforceDice.isStopped()) {
                        workforceDice.setStopped(false);
                    }
                    if (landDice.isStopped()) {
                        landDice.setStopped(false);
                    }
                    if (capitalDice.isStopped()) {
                        capitalDice.setStopped(false);
                    }
                    throwed = true;
                } else {
                    workforceDice.setStopped(true);
                    landDice.setStopped(true);
                    capitalDice.setStopped(true);
                    Listener.setLoading(true);
                    BoardGame.firebaseInterface.action1(
                            PlayerManager.getInstance().getPlayerIndex(),
                            workforceDice.getCurrentFace(),
                            landDice.getCurrentFace(),
                            capitalDice.getCurrentFace()
                    );
                }
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.dice5));
        buttons[1] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 4 - (Metrics.tabHeight / 6) / 2,
                0,
                Metrics.tabHeight / 6,
                Metrics.tabHeight / 6,
                Color.GRAY
        ) {
            @Override
            public void onTouchUp() {
                if (doneAction1) {
                    ActionsTab.getInstance().setCurrentAction(BuyFactorsAction.getInstance().reset());
                }
            }
        };
        buttons[1].setImage(new TextureRegion(Assets.next));
    }

    public void draw(boolean left, float delta, SpriteBatch batch) {
        float offset;
        offset = left ? 0 : Gdx.graphics.getWidth() / 2;
        // Draws the 1st dice
        workforceDice.draw(left, delta, batch);
        // Draws the 2nd dice
        landDice.draw(left, delta, batch);
        // Draws the 3rd dice
        capitalDice.draw(left, delta, batch);
        // Draws the title
        Text.setScale(0, 0.2f);
        Text.bordered.setColor(Color.WHITE);
        Text.bordered.draw(
                batch,
                "Lanzamiento inicial",
                offset + Metrics.phoneWidth / 4 - titleWidth / 2,
                Metrics.tabHeight - 2 * titleHeight
        );
        for (Button b : buttons) {
            b.draw(left, batch);
        }
    }

    @Override
    Action reset() {
        throwed = false;
        buttons[1].setColor(Color.GRAY);
        return this;
    }

    public void doneAction1() {
        Listener.setLoading(false);
        PlayerManager.getInstance().updateCurrentActionIndex(
                PlayerManager.getInstance().getPlayerIndex(),
                2
        );
        buttons[1].setColor(Color.RED);
        doneAction1 = true;
    }
}
