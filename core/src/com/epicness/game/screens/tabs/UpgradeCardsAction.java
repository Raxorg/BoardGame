package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.BoardGame;
import com.epicness.game.actors.Player;
import com.epicness.game.input.Listener;
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

public class UpgradeCardsAction extends Action {

    private String title;
    private float titleWidth, titleHeight;

    private static UpgradeCardsAction instance = new UpgradeCardsAction();

    private UpgradeCardsAction() {
        Text.setScale(0, 0.2f);
        title = "Mejorar tarjetas";
        titleWidth = Text.getTextWidth(0, title);
        titleHeight = Text.getTextHeight(0, title);
        makeButtons();
    }

    public static UpgradeCardsAction getInstance() {
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
                Metrics.tabHeight - titleHeight
        );
    }

    @Override
    void makeButtons() {
        buttons = new Button[5];
        float buttonSize = Metrics.tabHeight * 0.2f;
        float xSpace = (Metrics.phoneWidth / 2 - buttonSize * 2) / 3;
        float ySpace = (Metrics.tabHeight - buttonSize * 2) / 3;

        buttons[0] = new Button(
                Assets.button1,
                xSpace,
                Metrics.tabHeight - buttonSize - ySpace,
                buttonSize,
                buttonSize,
                Color.PURPLE
        ) {
            @Override
            public void onTouchUp() {
                int playerIndex = PlayerManager.getInstance().getPlayerIndex();
                if (PlayerManager.getInstance().getPlayers()[playerIndex].getCurrentActionIndex() == 4) {
                    Listener.setLoading(true);
                    Text.setScale(0, 0.2f);
                    title = "Cargando...";
                    titleWidth = Text.getTextWidth(0, title);
                    titleHeight = Text.getTextHeight(0, title);

                    BoardGame.firebaseInterface.refreshFactorsToUpgradeCard(0);
                }
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.humanDevelopment));
        buttons[1] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 2 - buttonSize - xSpace,
                Metrics.tabHeight - buttonSize - ySpace,
                buttonSize,
                buttonSize,
                Color.PURPLE
        ) {
            @Override
            public void onTouchUp() {
                int playerIndex = PlayerManager.getInstance().getPlayerIndex();
                if (PlayerManager.getInstance().getPlayers()[playerIndex].getCurrentActionIndex() == 4) {
                    Listener.setLoading(true);
                    Text.setScale(0, 0.2f);
                    title = "Cargando...";
                    titleWidth = Text.getTextWidth(0, title);
                    titleHeight = Text.getTextHeight(0, title);

                    BoardGame.firebaseInterface.refreshFactorsToUpgradeCard(1);
                }
            }
        };
        buttons[1].setImage(new TextureRegion(Assets.infrastructure));
        buttons[2] = new Button(
                Assets.button1,
                xSpace,
                ySpace,
                buttonSize,
                buttonSize,
                Color.PURPLE
        ) {
            @Override
            public void onTouchUp() {
                int playerIndex = PlayerManager.getInstance().getPlayerIndex();
                if (PlayerManager.getInstance().getPlayers()[playerIndex].getCurrentActionIndex() == 4) {
                    Listener.setLoading(true);
                    Text.setScale(0, 0.2f);
                    title = "Cargando...";
                    titleWidth = Text.getTextWidth(0, title);
                    titleHeight = Text.getTextHeight(0, title);

                    BoardGame.firebaseInterface.refreshFactorsToUpgradeCard(2);
                }
            }
        };
        buttons[2].setImage(new TextureRegion(Assets.naturalResources));
        buttons[3] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 2 - buttonSize - xSpace,
                ySpace,
                buttonSize,
                buttonSize,
                Color.PURPLE
        ) {
            @Override
            public void onTouchUp() {
                int playerIndex = PlayerManager.getInstance().getPlayerIndex();
                if (PlayerManager.getInstance().getPlayers()[playerIndex].getCurrentActionIndex() == 4) {
                    Listener.setLoading(true);
                    Text.setScale(0, 0.2f);
                    title = "Cargando...";
                    titleWidth = Text.getTextWidth(0, title);
                    titleHeight = Text.getTextHeight(0, title);

                    MainMenu.getInstance().getAllDataFromDatabase();
                    BoardGame.firebaseInterface.refreshFactorsToUpgradeCard(3);
                }
            }
        };
        buttons[3].setImage(new TextureRegion(Assets.technology));
        buttons[4] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 4 - (Metrics.phoneWidth / 10) / 2,
                Metrics.tabHeight / 2 - (Metrics.phoneWidth / 10) / 2,
                Metrics.phoneWidth / 10,
                Metrics.phoneWidth / 10,
                Color.RED
        ) {
            @Override
            public void onTouchUp() {
                // TODO VERIFY WIN CONDITION
                // TODO PASS TURN
            }
        };
        buttons[4].setImage(new TextureRegion(Assets.next));
    }

    public void doneRefreshingFactorsToUpgradeCard(int card) {
        boolean canBuy = false;
        int playerIndex = PlayerManager.getInstance().getPlayerIndex();
        Player player = PlayerManager.getInstance().getPlayers()[playerIndex];
        String newSectors = "";
        switch (card) {
            case 0:
                if (player.getWorkforce() >= (player.getHumanDevelopment() + 1) &&
                        player.getLand() >= (player.getHumanDevelopment() + 1) &&
                        player.getCapital() >= (player.getHumanDevelopment() + 1) * 2) {
                    PlayerManager.getInstance().updateWorkforce(
                            playerIndex,
                            player.getWorkforce() - (player.getHumanDevelopment() + 1)
                    );
                    PlayerManager.getInstance().updateLand(
                            playerIndex,
                            player.getLand() - (player.getHumanDevelopment() + 1)
                    );
                    PlayerManager.getInstance().updateCapital(
                            playerIndex,
                            player.getCapital() - (player.getHumanDevelopment() + 1) * 2
                    );
                    canBuy = true;
                }
                break;
            case 1:
                if (player.getWorkforce() >= (player.getInfrastructure() + 1) &&
                        player.getLand() >= (player.getInfrastructure() + 1) * 2 &&
                        player.getCapital() >= (player.getInfrastructure() + 1)) {
                    PlayerManager.getInstance().updateWorkforce(
                            playerIndex,
                            player.getWorkforce() - (player.getInfrastructure() + 1)
                    );
                    PlayerManager.getInstance().updateLand(
                            playerIndex,
                            player.getLand() - (player.getInfrastructure() + 1) * 2
                    );
                    PlayerManager.getInstance().updateCapital(
                            playerIndex,
                            player.getCapital() - (player.getInfrastructure() + 1)
                    );
                    canBuy = true;
                }
                break;
            case 2:
                if (player.getWorkforce() >= (player.getNaturalResources() + 1) * 2 &&
                        player.getLand() >= (player.getNaturalResources() + 1) &&
                        player.getCapital() >= (player.getNaturalResources() + 1)) {
                    PlayerManager.getInstance().updateWorkforce(
                            playerIndex,
                            player.getWorkforce() - (player.getNaturalResources() + 1) * 2
                    );
                    PlayerManager.getInstance().updateLand(
                            playerIndex,
                            player.getLand() - (player.getNaturalResources() + 1)
                    );
                    PlayerManager.getInstance().updateCapital(
                            playerIndex,
                            player.getCapital() - (player.getNaturalResources() + 1)
                    );
                    canBuy = true;
                }
                break;
            case 3:
                if (player.getWorkforce() >= (player.getTechnology() + 1) * 2 &&
                        player.getLand() >= (player.getTechnology() + 1) &&
                        player.getCapital() >= (player.getTechnology() + 1) * 2) {
                    PlayerManager.getInstance().updateWorkforce(
                            playerIndex,
                            player.getWorkforce() - (player.getTechnology() + 1) * 2
                    );
                    PlayerManager.getInstance().updateLand(
                            playerIndex,
                            player.getLand() - (player.getTechnology() + 1)
                    );
                    PlayerManager.getInstance().updateCapital(
                            playerIndex,
                            player.getCapital() - (player.getTechnology() + 1) * 2
                    );
                    canBuy = true;
                }
                break;
        }
        if (canBuy) {
            BoardGame.firebaseInterface.upgradeCard(PlayerManager.getInstance().getPlayerIndex(), card);
        } else {
            Text.setScale(0, 0.2f);
            title = "Mejorar tarjetas";
            titleWidth = Text.getTextWidth(0, title);
            titleHeight = Text.getTextHeight(0, title);
            Listener.setLoading(false);
        }
    }

    public void doneUpgradingCard() {
        Text.setScale(0, 0.2f);
        title = "Mejorar tarjetas";
        titleWidth = Text.getTextWidth(0, title);
        titleHeight = Text.getTextHeight(0, title);
        Listener.setLoading(false);
    }

    @Override
    Action reset() {
        return this;
    }
}
