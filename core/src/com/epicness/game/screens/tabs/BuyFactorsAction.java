package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.BoardGame;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 04/01/2017.
 * :D
 */

public class BuyFactorsAction extends Action {

    private String title;
    private float titleWidth, titleHeight;
    private float xSpace, buttonYSpace, buttonSize;

    private static BuyFactorsAction instance = new BuyFactorsAction();

    private BuyFactorsAction() {
        Text.setScale(0, 0.2f);
        title = "Comprar factores";
        titleWidth = Text.getTextWidth(0, title);
        titleHeight = Text.getTextHeight(0, title);
        makeButtons();
    }

    public static BuyFactorsAction getInstance() {
        return instance;
    }

    @Override
    void draw(boolean left, float delta, SpriteBatch batch) {
        float offset = left ? 0 : Metrics.phoneWidth / 2;
        for (Button b : buttons) {
            b.draw(left, batch);
        }
        // Draw title
        Text.setScale(0, 0.2f);
        Text.bordered.setColor(Color.WHITE);
        Text.bordered.draw(
                batch,
                title,
                offset + Metrics.phoneWidth / 4 - titleWidth / 2,
                Metrics.tabHeight - 2 * titleHeight
        );
        // Draw workforce image
        batch.draw(
                Assets.workforceIcon,
                offset + xSpace,
                Metrics.tabHeight * 0.7f - buttonSize - buttonYSpace,
                buttonSize,
                buttonSize
        );
        // Draw land image
        batch.draw(
                Assets.landIcon,
                offset + xSpace,
                Metrics.tabHeight * 0.7f - 2 * buttonSize - 2 * buttonYSpace,
                buttonSize,
                buttonSize
        );
        // Draw capital image
        batch.draw(
                Assets.capitalIcon,
                offset + xSpace,
                Metrics.tabHeight * 0.7f - 3 * buttonSize - 3 * buttonYSpace,
                buttonSize,
                buttonSize
        );
    }

    @Override
    void makeButtons() {
        buttons = new Button[4];
        xSpace = (Metrics.phoneWidth / 2) / 4;
        buttonYSpace = (Metrics.tabHeight * 0.7f) / 13f;
        buttonSize = buttonYSpace * 3f;
        float buttonXPos = (Metrics.phoneWidth / 2) - xSpace - buttonSize;
        buttons[0] = new Button(
                Assets.button1,
                buttonXPos,
                Metrics.tabHeight * 0.7f - buttonSize - buttonYSpace,
                buttonSize,
                buttonSize,
                Color.YELLOW
        ) {
            @Override
            public void onTouchUp() {
                int playerIndex = PlayerManager.getInstance().getPlayerIndex();
                if (PlayerManager.getInstance().getPlayers()[playerIndex].getCurrentActionIndex() == 3) {
                    Listener.setLoading(true);
                    Text.setScale(0, 0.2f);
                    title = "Cargando...";
                    titleWidth = Text.getTextWidth(0, title);
                    titleHeight = Text.getTextHeight(0, title);

                    BoardGame.firebaseInterface.buyFactor(PlayerManager.getInstance().getPlayerIndex(), 0);
                }
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.plus));
        buttons[1] = new Button(
                Assets.button1,
                buttonXPos,
                Metrics.tabHeight * 0.7f - 2 * buttonSize - 2 * buttonYSpace,
                buttonSize,
                buttonSize,
                Color.YELLOW
        ) {
            @Override
            public void onTouchUp() {
                int playerIndex = PlayerManager.getInstance().getPlayerIndex();
                if (PlayerManager.getInstance().getPlayers()[playerIndex].getCurrentActionIndex() == 3) {
                    Listener.setLoading(true);
                    Text.setScale(0, 0.2f);
                    title = "Cargando...";
                    titleWidth = Text.getTextWidth(0, title);
                    titleHeight = Text.getTextHeight(0, title);

                    BoardGame.firebaseInterface.buyFactor(PlayerManager.getInstance().getPlayerIndex(), 1);
                }
            }
        };
        buttons[1].setImage(new TextureRegion(Assets.plus));
        buttons[2] = new Button(
                Assets.button1,
                buttonXPos,
                Metrics.tabHeight * 0.7f - 3 * buttonSize - 3 * buttonYSpace,
                buttonSize,
                buttonSize,
                Color.YELLOW
        ) {
            @Override
            public void onTouchUp() {
                int playerIndex = PlayerManager.getInstance().getPlayerIndex();
                if (PlayerManager.getInstance().getPlayers()[playerIndex].getCurrentActionIndex() == 3) {
                    Listener.setLoading(true);
                    Text.setScale(0, 0.2f);
                    title = "Cargando...";
                    titleWidth = Text.getTextWidth(0, title);
                    titleHeight = Text.getTextHeight(0, title);

                    BoardGame.firebaseInterface.buyFactor(PlayerManager.getInstance().getPlayerIndex(), 2);
                }
            }
        };
        buttons[2].setImage(new TextureRegion(Assets.plus));
        buttons[3] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 2 - Metrics.phoneWidth / 10,
                0,
                Metrics.phoneWidth / 10,
                Metrics.phoneWidth / 10,
                Color.RED
        ) {
            @Override
            public void onTouchUp() {
                PlayerManager.getInstance().updateCurrentActionIndex(
                        PlayerManager.getInstance().getPlayerIndex(),
                        4
                );
                ActionsTab.getInstance().setCurrentAction(UpgradeCardsAction.getInstance().reset());
            }
        };
        buttons[3].setImage(new TextureRegion(Assets.next));
    }

    public void doneBuyingFactor() {
        Text.setScale(0, 0.2f);
        title = "Comprar factores";
        titleWidth = Text.getTextWidth(0, title);
        titleHeight = Text.getTextHeight(0, title);
        Listener.setLoading(false);
    }

    @Override
    Action reset() {
        return this;
    }
}
