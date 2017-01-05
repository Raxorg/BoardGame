package com.epicness.game.screens.tabs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.actors.Player;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public class InfoTab extends Tab {

    private InfoCard[] infoCards;

    private static InfoTab instance = new InfoTab();

    private InfoTab() {
        makeCards();
        makeButtons();
    }

    public static InfoTab getInstance() {
        return instance;
    }

    private void makeCards() {
        float cardSize = Metrics.tabHeight * 0.4f;
        float xSpace = (Metrics.phoneWidth / 2 - cardSize * 2) / 3;
        float ySpace = (Metrics.tabHeight - cardSize * 2) / 3;
        infoCards = new InfoCard[4];
        infoCards[0] = new InfoCard(
                xSpace,
                Metrics.tabHeight - cardSize - ySpace,
                cardSize,
                cardSize,
                Assets.hayek,
                "Hayek",
                0
        );
        infoCards[1] = new InfoCard(
                Metrics.phoneWidth / 2 - cardSize - xSpace,
                Metrics.tabHeight - cardSize - ySpace,
                cardSize,
                cardSize,
                Assets.keynes,
                "Keynes",
                1
        );
        infoCards[2] = new InfoCard(
                xSpace,
                ySpace,
                cardSize,
                cardSize,
                Assets.marx,
                "Marx",
                2
        );
        infoCards[3] = new InfoCard(
                Metrics.phoneWidth / 2 - cardSize - xSpace,
                ySpace,
                cardSize,
                cardSize,
                Assets.smith,
                "Smith",
                3
        );
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

        for (InfoCard card : infoCards) {
            card.draw(batch);
        }
    }

    private class InfoCard {

        private float x, y, width, height;
        private TextureRegion character;
        private String characterName;
        private int playerIndex;

        private InfoCard(float x, float y, float width, float height,
                         TextureRegion character, String characterName,
                         int playerIndex) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.character = character;
            this.characterName = characterName;
            this.playerIndex = playerIndex;
        }

        private void draw(SpriteBatch batch) {
            if (PlayerManager.getInstance().getPlayerIndex() == playerIndex) {
                batch.setColor(new Color(58f / 255f, 75f / 255f, 1, 1));
            } else {
                batch.setColor(new Color(1, 75f / 255f, 58f / 255f, 1));
            }
            // Draws the background
            batch.draw(
                    Assets.infocard,
                    x + tabOffset,
                    y,
                    width,
                    height
            );
            // Draws the character
            batch.setColor(Color.WHITE);
            batch.draw(
                    character,
                    x + tabOffset + width * 0.1f,
                    y + height * 0.625f,
                    width * 0.21f,
                    width * 0.28f
            );
            // Draws the name of the character
            Text.setScale(0, 0.15f);
            Text.bordered.setColor(Color.WHITE);
            Text.bordered.draw(
                    batch,
                    characterName,
                    x + tabOffset + width * 0.38f,
                    y + height * 0.93f
            );
            // Draws the money
            Text.setScale(2, 0.13f);
            Text.digits.setColor(Color.GREEN);
            Text.digits.draw(
                    batch,
                    PlayerManager.getInstance().getPlayers()[playerIndex].getMoney() + " Bs",
                    x + tabOffset + width * 0.38f,
                    y + height * 0.75f
            );
            // Draws the workforce icon
            batch.draw(
                    Assets.workforceIcon,
                    x + tabOffset + width * 0.3f,
                    y + height * 0.45f,
                    width * 0.15f,
                    width * 0.15f
            );
            // Draws the workforce
            Text.setScale(2, 0.1f);
            Text.digits.setColor(Color.WHITE);
            Text.digits.draw(
                    batch,
                    PlayerManager.getInstance().getPlayers()[playerIndex].getWorkforce() + "",
                    x + tabOffset + width * 0.55f,
                    y + height * 0.58f
            );
            // Draws the land icon
            batch.draw(
                    Assets.landIcon,
                    x + tabOffset + width * 0.3f,
                    y + height * 0.25f,
                    width * 0.15f,
                    width * 0.15f
            );
            // Draws the land
            Text.setScale(2, 0.1f);
            Text.digits.setColor(Color.WHITE);
            Text.digits.draw(
                    batch,
                    PlayerManager.getInstance().getPlayers()[playerIndex].getLand() + "",
                    x + tabOffset + width * 0.55f,
                    y + height * 0.37f
            );
            // Draws the capital icon
            batch.draw(
                    Assets.capitalIcon,
                    x + tabOffset + width * 0.3f,
                    y + height * 0.05f,
                    width * 0.15f,
                    width * 0.15f
            );
            // Draws the capital
            Text.setScale(2, 0.1f);
            Text.digits.setColor(Color.WHITE);
            Text.digits.draw(
                    batch,
                    PlayerManager.getInstance().getPlayers()[playerIndex].getCapital() + "",
                    x + tabOffset + width * 0.55f,
                    y + height * 0.16f
            );
        }
    }

}
