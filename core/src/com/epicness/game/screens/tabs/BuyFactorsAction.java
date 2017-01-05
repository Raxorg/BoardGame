package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 04/01/2017.
 * :D
 */

public class BuyFactorsAction extends Action {

    private static BuyFactorsAction instance = new BuyFactorsAction();

    private BuyFactorsAction() {
        makeButtons();
    }

    public static BuyFactorsAction getInstance() {
        return instance;
    }

    @Override
    void draw(boolean left, float delta, SpriteBatch batch) {

    }

    @Override
    void makeButtons() {
        buttons = new Button[0];
    }

    @Override
    Action reset() {
        return this;
    }
}
