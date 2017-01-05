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
        actions = new Action[5];
        actions[0] = WaitAction.getInstance().reset();
        actions[1] = ThrowFirstDiceAction.getInstance().reset();
        actions[2] = ThrowDiceToMoveAction.getInstance().reset();
        actions[3] = BuyFactorsAction.getInstance().reset();
        actions[4] = UpgradeCardsAction.getInstance().reset();
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
    }

    public void setCurrentAction(Action currentAction) {
        this.currentAction = currentAction;
    }

}

