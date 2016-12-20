package com.epicness.game.screens.tabs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public abstract class Tab {

    protected Button[] buttons;
    protected boolean left;
    protected float offset;

    public Button[] getButtons() {
        return buttons;
    }

    abstract void makeButtons();

    public Tab setLeft(Boolean left) {
        this.left = left;
        if (!left) {
            offset = Gdx.graphics.getWidth() / 2;
        }
        return this;
    }

    public boolean getLeft() {
        return left;
    }

    public abstract void render(float delta, SpriteBatch batch);
}

