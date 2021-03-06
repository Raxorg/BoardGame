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
    protected boolean left, active;
    protected float tabOffset;

    public Button[] getButtons() {
        return buttons;
    }

    abstract void makeButtons();

    public Tab setLeft(Boolean left) {
        this.left = left;
        if (left) {
            tabOffset = 0;
        } else {
            tabOffset = Gdx.graphics.getWidth() / 2;
        }
        return this;
    }

    public boolean getLeft() {
        return left;
    }

    public Tab setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public abstract void render(float delta, SpriteBatch batch);
}

