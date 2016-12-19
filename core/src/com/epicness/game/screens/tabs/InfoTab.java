package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public class InfoTab extends Tab {

    private static InfoTab instance = new InfoTab();

    private InfoTab() {
        makeButtons();
    }

    public static InfoTab getInstance() {
        return instance;
    }

    @Override
    void makeButtons() {
        buttons = new Button[0];
    }

    @Override
    public void render(float delta, SpriteBatch batch) {

    }

}
