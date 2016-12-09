package com.epicness.game.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public abstract class MyScreen extends ScreenAdapter {

    protected Button[] buttons;

    public Button[] getButtons() {
        return buttons;
    }

    abstract void makeButtons();

    public abstract void render(float delta, SpriteBatch batch);
}
