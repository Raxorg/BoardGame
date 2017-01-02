package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.actors.Board;
import com.epicness.game.actors.Player;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.ui.buttons.Button;

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
        buttons = new Button[0];
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        Board.getInstance().draw(left, batch);
        for (Player p : PlayerManager.getInstance().getPlayers()) {
            batch.setColor(p.getColor());
            p.draw(left, delta, batch);
        }
        /*batch.setColor(0, 0.75f, 0.75f, 1);
        if (dice.isVisible()) {
            dice.draw(delta, batch);
        }*/
        for (Button b : buttons) {
            b.draw(left, batch);
        }
    }
}
