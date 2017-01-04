package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 02/01/2017.
 * :D
 */

public class InnerBoardTab extends Tab {

    private static InnerBoardTab instance = new InnerBoardTab();

    private InnerBoardTab() {
        makeButtons();
    }

    public static InnerBoardTab getInstance() {
        return instance;
    }

    @Override
    void makeButtons() {
        buttons = new Button[0];
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        for (Button b : buttons) {
            b.draw(left, batch);
        }
        batch.draw(
                Assets.chart,
                0 + tabOffset,
                0,
                Metrics.tabHeight * 0.95f,
                Metrics.tabHeight * 0.95f
                );
    }
}
