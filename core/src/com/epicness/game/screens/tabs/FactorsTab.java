package com.epicness.game.screens.tabs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.epicness.game.BoardGame;
import com.epicness.game.actors.Player;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 02/01/2017.
 * :D
 */

public class FactorsTab extends Tab {

    private enum Type {HUMAN_DEVELOPMENT, INFRASTRUCTURE, NATURAL_RESOURCES, TECHNOLOGY}

    private FactorCard[] factorCards;

    private static FactorsTab instance = new FactorsTab();

    private FactorsTab() {
        makeCards();
        makeButtons();
    }

    public static FactorsTab getInstance() {
        return instance;
    }

    private void makeCards() {
        factorCards = new FactorCard[4];
        float cardXSpace = (Metrics.phoneWidth / 2f) / 31f;
        float cardYSpace = Metrics.tabHeight / 31f;
        float cardWidth = cardXSpace * 14f;
        float cardHeight = cardWidth * (2f / 3f);
        factorCards[0] = new FactorCard(
                cardXSpace,
                Metrics.tabHeight - cardYSpace - cardHeight,
                cardWidth,
                cardHeight,
                Type.HUMAN_DEVELOPMENT
        );
        factorCards[1] = new FactorCard(
                2 * cardXSpace + cardWidth,
                Metrics.tabHeight - cardYSpace - cardHeight,
                cardWidth,
                cardHeight,
                Type.INFRASTRUCTURE
        );
        factorCards[2] = new FactorCard(
                cardXSpace,
                Metrics.tabHeight - 2 * cardYSpace - 2 * cardHeight,
                cardWidth,
                cardHeight,
                Type.NATURAL_RESOURCES
        );
        factorCards[3] = new FactorCard(
                2 * cardXSpace + cardWidth,
                Metrics.tabHeight - 2 * cardYSpace - 2 * cardHeight,
                cardWidth,
                cardHeight,
                Type.TECHNOLOGY
        );
    }

    public FactorCard[] getFactorCards() {
        return factorCards;
    }

    @Override
    void makeButtons() {
        buttons = new Button[1];
        buttons[0] = new Button(
                Assets.button1,
                Metrics.phoneWidth / 4 - (Metrics.tabHeight / 7) / 2,
                0,
                Metrics.tabHeight / 7,
                Metrics.tabHeight / 7,
                Color.RED

        ) {
            @Override
            public void onTouchUp() {
                int playerIndex = PlayerManager.getInstance().getPlayerIndex();
                BoardGame.firebaseInterface.refreshFactorCards(playerIndex);
                Listener.setLoading(true);
            }
        };
        buttons[0].setImage(new TextureRegion(Assets.refresh));
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        for (Button b : buttons) {
            b.draw(left, batch);
        }
        for (FactorCard card : factorCards) {
            card.draw(batch);
        }
    }

    public void doneRefreshingFactorCards() {
        int playerIndex = PlayerManager.getInstance().getPlayerIndex();
        Player player = PlayerManager.getInstance().getPlayers()[playerIndex];
        factorCards[0].setLevel(player.getHumanDevelopment());
        factorCards[1].setLevel(player.getInfrastructure());
        factorCards[2].setLevel(player.getNaturalResources());
        factorCards[3].setLevel(player.getTechnology());
        Listener.setLoading(false);
    }

    private class FactorCard {

        private float x, y, width, height;
        private float workforceCostWidth, landCostWidth, capitalCostWidth,
                factorNameWidth, levelWidth, incomeWidth;
        private String factorName = "", level = "", income = "";
        private int workforceCost, landCost, capitalCost;
        private Type type;
        private Color color;

        private FactorCard(float x, float y, float width, float height, Type type) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.type = type;
            color = Color.WHITE;
        }

        public void setLevel(int lv) {
            income = "Ingresos: " + lv * 50;
            switch (type) {
                case HUMAN_DEVELOPMENT:
                    switch (lv) {
                        case 1:
                            factorName = "Alfabetizacion";
                            break;
                        case 2:
                            factorName = "Primaria";
                            break;
                        case 3:
                            factorName = "Secundaria";
                            break;
                        case 4:
                            factorName = "Licenciatura";
                            break;
                        case 5:
                            factorName = "Master";
                            break;
                        case 6:
                            factorName = "Doctorado";
                            break;
                    }
                    level = "IDH Nivel " + lv;
                    workforceCost = lv;
                    landCost = lv;
                    capitalCost = lv * 2;
                    color = new Color(1, 0.35f, 0.35f, 1);
                    break;
                case INFRASTRUCTURE:
                    switch (lv) {
                        case 1:
                            factorName = "Alcantarillado";
                            break;
                        case 2:
                            factorName = "Carretera";
                            break;
                        case 3:
                            factorName = "Educacion";
                            break;
                        case 4:
                            factorName = "Comunicaciones";
                            break;
                        case 5:
                            factorName = "Electricidad";
                            break;
                        case 6:
                            factorName = "Salud";
                            break;
                    }
                    level = "Infraestructura Nivel " + lv;
                    workforceCost = lv;
                    landCost = lv * 2;
                    capitalCost = lv;
                    color = new Color(1, 1, 0.35f, 1);
                    break;
                case NATURAL_RESOURCES:
                    switch (lv) {
                        case 1:
                            factorName = "Manantial";
                            break;
                        case 2:
                            factorName = "Madera";
                            break;
                        case 3:
                            factorName = "Socavon";
                            break;
                        case 4:
                            factorName = "Hidro";
                            break;
                        case 5:
                            factorName = "Reservas de gas";
                            break;
                        case 6:
                            factorName = "Mina";
                            break;
                    }
                    level = "Recursos naturales Nivel " + lv;
                    workforceCost = lv * 2;
                    landCost = lv;
                    capitalCost = lv;
                    color = new Color(0.35f, 1, 0.35f, 1);
                    break;
                case TECHNOLOGY:
                    switch (lv) {
                        case 1:
                            factorName = "Fuerza bruta";
                            break;
                        case 2:
                            factorName = "Celular";
                            break;
                        case 3:
                            factorName = "Laboratorio";
                            break;
                        case 4:
                            factorName = "Energía renovable";
                            break;
                        case 5:
                            factorName = "Internet";
                            break;
                        case 6:
                            factorName = "Silicon Valley";
                            break;
                    }
                    level = "Tecnologia Nivel " + lv;
                    workforceCost = lv * 2;
                    landCost = lv;
                    capitalCost = lv * 2;
                    color = new Color(0.35f, 0.35f, 1, 1);
                    break;
            }
            Text.setScale(2, 0.05f);
            levelWidth = Text.getTextWidth(2, level);
            Text.setScale(2, 0.07f);
            incomeWidth = Text.getTextWidth(2, income);
            Text.setScale(2, 0.1f);
            factorNameWidth = Text.getTextWidth(2, factorName);
            Text.setScale(2, 0.04f);
            workforceCostWidth = Text.getTextWidth(2, workforceCost + "");
            landCostWidth = Text.getTextWidth(2, landCost + "");
            capitalCostWidth = Text.getTextWidth(2, capitalCost + "");
        }

        private void draw(SpriteBatch batch) {
            // Draw the bg
            batch.setColor(color);
            batch.draw(
                    Assets.factorCardBG,
                    x + tabOffset,
                    y,
                    width,
                    height
            );
            // Draw the fg
            batch.setColor(Color.WHITE);
            batch.draw(
                    Assets.factorCardFG,
                    x + tabOffset,
                    y,
                    width,
                    height
            );
            // Draw the level
            Text.setScale(2, 0.05f);
            Text.digits.setColor(Color.BLACK);
            Text.digits.draw(
                    batch,
                    level,
                    x + tabOffset + width / 2 - levelWidth / 2,
                    y + height * 0.975f
            );
            // Draw the name
            Text.setScale(2, 0.1f);
            Text.digits.setColor(Color.BLACK);
            Text.digits.draw(
                    batch,
                    factorName,
                    x + tabOffset + width / 2 - factorNameWidth / 2,
                    y + height * 0.9f
            );
            // Draw the income
            Text.setScale(2, 0.07f);
            Text.digits.setColor(Color.BLACK);
            Text.digits.draw(
                    batch,
                    income,
                    x + tabOffset + width / 2 - incomeWidth / 2,
                    y + height * 0.7f
            );
            // Draw the workforce cost
            Text.setScale(2, 0.04f);
            Text.digits.setColor(Color.BLACK);
            Text.digits.draw(
                    batch,
                    workforceCost + "",
                    x + tabOffset + width * 0.094f - workforceCostWidth / 2,
                    y + height * 0.47f
            );
            // Draw the land cost
            Text.setScale(2, 0.04f);
            Text.digits.setColor(Color.BLACK);
            Text.digits.draw(
                    batch,
                    landCost + "",
                    x + tabOffset + width * 0.4f - landCostWidth / 2,
                    y + height * 0.47f
            );
            // Draw the capital cost
            Text.setScale(2, 0.04f);
            Text.digits.setColor(Color.BLACK);
            Text.digits.draw(
                    batch,
                    capitalCost + "",
                    x + tabOffset + width * 0.702f - capitalCostWidth / 2,
                    y + height * 0.47f
            );
        }
    }
}
