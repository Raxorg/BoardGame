package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.PlayerManager;
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
        for (int i = 0; i < PlayerManager.getInstance().getPlayers().length; i++) {
            float xoffset = i == 1 || i == 3 ? Metrics.tabHeight / 2 : 0;
            float yoffset = i == 0 || i == 1 ? Metrics.tabHeight / 2 : 0;
            batch.draw(
                    Assets.infocard,
                    offset + xoffset,
                    yoffset,
                    Metrics.tabHeight / 2,
                    Metrics.tabHeight / 2
            );
        }
    }

}
