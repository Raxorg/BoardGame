package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 18/12/2016.
 */

public abstract class Tab {

    protected Button[] buttons;

    public Button[] getButtons() {
        return buttons;
    }

    abstract void makeButtons();

    public abstract void render(float delta, SpriteBatch batch);
}

