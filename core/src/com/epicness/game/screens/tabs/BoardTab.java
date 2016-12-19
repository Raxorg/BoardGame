package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public class BoardTab extends Tab {

    private static BoardTab instance = new BoardTab();

    private BoardTab() {
        makeButtons();
    }

    public static BoardTab getInstance() {
        return instance;
    }

    @Override
    void makeButtons() {

    }

    @Override
    public void render(float delta, SpriteBatch batch) {

    }
}
