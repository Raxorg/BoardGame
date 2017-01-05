package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 04/01/2017.
 * :D
 */
abstract class Action {

    protected int firstButtonIndex, lastButtonIndex;
    protected Button[] buttons;

    abstract void draw(boolean left, float delta, SpriteBatch batch);

    abstract void makeButtons();

    abstract Action reset();

    public Button[] getButtons() {
        return buttons;
    }
}
