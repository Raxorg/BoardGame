package com.epicness.game.screens.tabs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.actors.Dice;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.Text;
import com.epicness.game.screens.Game;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by LUCIA PAREDES on 01/01/2017.
 * :D
 */
public class ActionsTab extends Tab {

    private static ActionsTab instance = new ActionsTab();
    private Action[] actions;
    private Action currentAction;

    private ActionsTab() {
        makeActions();
        makeButtons();
    }

    public static ActionsTab getInstance() {
        return instance;
    }

    private void makeActions() {
        actions = new Action[2];
        actions[0] = WaitAction.getInstance();
        actions[1] = ThrowDiceAction.getInstance();
        // TODO SABER LA ACCION SEGUN DATABASE
        currentAction = actions[0];
    }

    @Override
    void makeButtons() {
        buttons = new Button[0];
    }

    public void yourTurn() {
        currentAction = ThrowDiceAction.getInstance();
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        currentAction.draw(left, delta, batch);
        buttons = currentAction.getButtons();
        Game.getInstance().updateButtons();
        /*
        Text.normal.setColor(Color.WHITE);
        Text.setScale(1, 0.2f);
        Text.normal.draw(
                batch,
                action1,
                tabOffset + buttonXPos + buttonWidth * 0.1f,
                Metrics.tabHeight - buttonHeight * 1.3f
        );
        Text.setScale(1, 0.25f);
        Text.normal.draw(
                batch,
                action2,
                tabOffset + buttonXPos + buttonWidth * 0.05f,
                Metrics.tabHeight - 3 * buttonHeight - buttonHeight * 0.3f
        );*/
    }
}

abstract class Action {
    /* private String action2 = "Comprar factores";
       private String action3 = "Negociar";
       private String action4 = "Ascender nivel";
       private String action5 = "Lanzamiento final"; */

    protected int firstButtonIndex, lastButtonIndex;
    protected Button[] buttons;

    abstract void draw(boolean left, float delta, SpriteBatch batch);

    int getFirstButtonIndex() {
        return firstButtonIndex;
    }

    int getLastButtonIndex() {
        return lastButtonIndex;
    }

    public Button[] getButtons() {
        return buttons;
    }
}

class WaitAction extends Action {

    private float titleWidth, titleHeight;

    private static WaitAction instance = new WaitAction();

    private WaitAction() {
        Text.setScale(0, 0.2f);
        titleWidth = Text.getTextWidth(0, "Esperando turno");
        titleHeight = Text.getTextHeight(0, "Esperando turno");
        firstButtonIndex = 0;
        lastButtonIndex = 0;
        makeButtons();
    }

    public static WaitAction getInstance() {
        return instance;
    }

    private void makeButtons() {
        buttons = new Button[1];
        buttons[0] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 4 - (Metrics.tabHeight / 5) / 2,
                Metrics.tabHeight / 2 - (Metrics.tabHeight / 5) / 2,
                Metrics.tabHeight / 5,
                Metrics.tabHeight / 5,
                Color.YELLOW
        ) {
            @Override
            public void onTouchUp() {
                // TODO REFRESH TURN
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.refresh));
    }

    public void draw(boolean left, float delta, SpriteBatch batch) {
        float offset;
        offset = left ? 0 : Gdx.graphics.getWidth() / 2;
        // Draws the title
        Text.setScale(0, 0.2f);
        Text.bordered.setColor(Color.WHITE);
        Text.bordered.draw(
                batch,
                "Esperando turno",
                offset + Metrics.phoneWidth / 4 - titleWidth / 2,
                Metrics.tabHeight - 2 * titleHeight
        );
        for (Button b : buttons) {
            b.draw(left, batch);
        }
    }

}

class ThrowDiceAction extends Action {

    private Dice dice;
    private float titleWidth, titleHeight;
    private boolean throwed;
    private int diceValue = -1;

    private static ThrowDiceAction instance = new ThrowDiceAction();

    private ThrowDiceAction() {
        Text.setScale(0, 0.2f);
        titleWidth = Text.getTextWidth(0, "Lanzamiento inicial");
        titleHeight = Text.getTextHeight(0, "Lanzamiento inicial");
        dice = new Dice(
                Metrics.phoneWidth / 4 - (Metrics.tabHeight / 6) / 2,
                Metrics.tabHeight / 2 - (Metrics.tabHeight / 6) / 2,
                Metrics.tabHeight / 6,
                Metrics.tabHeight / 6

        );
        dice.setVisible(true);

        firstButtonIndex = 1;
        lastButtonIndex = 1;
        makeButtons();
    }

    public static ThrowDiceAction getInstance() {
        return instance;
    }

    private void makeButtons() {
        buttons = new Button[1];
        buttons[0] = new Button(
                Assets.button3,
                Metrics.phoneWidth / 4 - (3 * Metrics.tabHeight / 10) / 2,
                Metrics.tabHeight / 2 - (Metrics.tabHeight / 6) / 2 - 2 * (Metrics.tabHeight / 10),
                3 * Metrics.tabHeight / 10,
                Metrics.tabHeight / 10,
                Color.ORANGE
        ) {
            @Override
            public void onTouchUp() {
                if (!throwed) {
                    if (dice.isStopped()) {
                        dice.setStopped(false);
                        throwed = true;
                    }
                }
                if (throwed) {
                    dice.setStopped(true);
                    diceValue = dice.getCurrentFace();
                }
            }
        };
    }

    public void draw(boolean left, float delta, SpriteBatch batch) {
        float offset;
        offset = left ? 0 : Gdx.graphics.getWidth() / 2;
        // Draws the dice
        dice.draw(left, delta, batch);
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
}