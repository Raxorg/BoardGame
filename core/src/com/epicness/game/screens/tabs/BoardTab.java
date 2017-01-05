package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.actors.Board;
import com.epicness.game.actors.Player;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.screens.MainMenu;
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
        buttons = new Button[1];
        buttons[0] = new Button(
                Assets.button1,
                Board.getInstance().getX() + Board.getInstance().getSide() / 2 - (Board.getInstance().getSide() / 8) / 2,
                Board.getInstance().getY() + Board.getInstance().getSide() / 2 - (Board.getInstance().getSide() / 8) / 2,
                Board.getInstance().getSide() / 8,
                Board.getInstance().getSide() / 8,
                Color.GREEN
        ) {
            @Override
            public void onTouchUp() {
                MainMenu.getInstance().getAllDataFromDatabase();
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.refresh));
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        Board.getInstance().draw(left, batch);
        for (Player p : PlayerManager.getInstance().getPlayers()) {
            batch.setColor(p.getColor());
            p.draw(left, delta, batch);
        }
        for (Button b : buttons) {
            b.draw(left, batch);
        }
    }
}
