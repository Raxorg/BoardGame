package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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

    }

    @Override
    public void render(float delta, SpriteBatch batch) {

    }

}
