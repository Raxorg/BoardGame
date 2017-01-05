package com.epicness.game.screens.tabs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.BoardGame;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.screens.MainMenu;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 04/01/2017.
 * :D
 */
public class WaitAction extends Action {

    private float titleWidth, titleHeight, loadingWidth, loadingHeight;
    private String loadingText = "";

    private static WaitAction instance = new WaitAction();

    private WaitAction() {
        Text.setScale(0, 0.2f);
        titleWidth = Text.getTextWidth(0, "Esperando turno");
        titleHeight = Text.getTextHeight(0, "Esperando turno");
        loadingWidth = Text.getTextWidth(0, "Actualizando");
        loadingHeight = Text.getTextHeight(0, "Actualizando");
        firstButtonIndex = 0;
        lastButtonIndex = 0;
        makeButtons();
    }

    public static WaitAction getInstance() {
        return instance;
    }

    void makeButtons() {
        buttons = new Button[1];
        buttons[0] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 4 - (Metrics.tabHeight / 5) / 2,
                Metrics.tabHeight / 2 - (Metrics.tabHeight / 5) / 2,
                Metrics.tabHeight / 5,
                Metrics.tabHeight / 5,
                Color.YELLOW
        ) {
            @Override
            public void onTouchUp() {
                loadingText = "Actualizando";
                loadingWidth = Text.getTextWidth(0, loadingText);
                loadingHeight = Text.getTextHeight(0, loadingText);
                BoardGame.firebaseInterface.refreshWaitAction();
                MainMenu.getInstance().getAllDataFromDatabase();
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.refresh));
    }

    public void draw(boolean left, float delta, SpriteBatch batch) {
        float offset = left ? 0 : Metrics.phoneWidth / 2;
        // Draws the title
        Text.setScale(0, 0.2f);
        Text.bordered.setColor(Color.WHITE);
        Text.bordered.draw(
                batch,
                "Esperando turno",
                offset + Metrics.phoneWidth / 4 - titleWidth / 2,
                Metrics.tabHeight - 2 * titleHeight
        );
        // Draws buttons
        for (Button b : buttons) {
            b.draw(left, batch);
        }
        // Draws loadingText
        Text.setScale(0, 0.2f);
        Text.bordered.setColor(Color.WHITE);
        Text.bordered.draw(
                batch,
                loadingText,
                offset + Metrics.phoneWidth / 4 - loadingWidth / 2,
                loadingHeight * 2
        );
    }

    @Override
    Action reset() {
        return this;
    }

    public void doneRefreshing() {
        int turn = PlayerManager.getInstance().getPlayerTurn();
        int playerIndex = PlayerManager.getInstance().getPlayerIndex();
        if (turn % 4 == playerIndex) {
            if (turn <= 3) {
                PlayerManager.getInstance().updateCurrentActionIndex(
                        PlayerManager.getInstance().getPlayerIndex(),
                        1
                );
                ActionsTab.getInstance().setCurrentAction(ThrowFirstDiceAction.getInstance().reset());
            } else {
                PlayerManager.getInstance().updateCurrentActionIndex(
                        PlayerManager.getInstance().getPlayerIndex(),
                        2
                );
                ActionsTab.getInstance().setCurrentAction(ThrowDiceToMoveAction.getInstance().reset());
            }
        }
        loadingText = "";
    }

}
