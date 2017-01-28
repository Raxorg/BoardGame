package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;


/**
 * Created by LUCIA PAREDES on 26/01/2017.
 */
public class TablesTab extends Tab {

    private float xSpace, buttonYSpace, buttonSize;

    private static TablesTab instance = new TablesTab();

    private TablesTab() { makeButtons(); }

    public static TablesTab getInstance() { return instance; }
    @Override
    void makeButtons() {

    }

    @Override
    public void render(float delta, SpriteBatch batch) {

    }

    void draw(boolean left, float delta, SpriteBatch batch) {
        float offset = left ? 0 : Metrics.phoneWidth / 2;

        batch.draw(
                Assets.tabla1,
                0 + tabOffset,
                0,
                Metrics.tabHeight * 0.95f,
                Metrics.tabHeight * 0.95f
        );
        /*batch.draw(
                Assets.tabla2,
                0 + tabOffset,
                0,
                Metrics.tabHeight * 0.95f,
                Metrics.tabHeight * 0.95f
        );
*/
    }

}

