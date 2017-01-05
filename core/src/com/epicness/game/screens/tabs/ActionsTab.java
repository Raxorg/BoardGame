package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

    public void setCurrentAction(Action currentAction) {

        this.currentAction = currentAction;
    }
}

