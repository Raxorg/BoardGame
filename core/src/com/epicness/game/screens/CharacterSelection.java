package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.BoardGame;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.PlayerManager;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public class CharacterSelection extends MyScreen {

    private String loadingText = "";
    private float loadingWidth, loadingHeight;
    private final String chooseText = "Elige tu personaje",
            readyText = "Estoy listo";
    private float textHeight, textSpaceHeight;
    private float imageWidth, imageHeight, characterSpace, imageYPos;
    private float colorButtonSize, arrowXPosition;

    private static CharacterSelection instance = new CharacterSelection();

    private CharacterSelection() {
        float availableWidth = Metrics.phoneWidth;
        float availableHeight = Metrics.phoneHeight;

        characterSpace = Metrics.phoneWidth * 0.08f;
        availableWidth -= characterSpace * 5;

        imageWidth = Metrics.phoneWidth * 0.15f;
        availableWidth -= imageWidth * 4;

        imageHeight = imageWidth * 4 / 3;
        availableHeight -= imageHeight;

        textHeight = Metrics.phoneHeight * 0.1f;
        availableHeight -= textHeight;

        textSpaceHeight = Metrics.phoneHeight * 0.05f;
        availableHeight -= textSpaceHeight;

        imageYPos = Metrics.phoneHeight - textSpaceHeight * 2 - textHeight - imageHeight;

        colorButtonSize = imageWidth / 3;

        arrowXPosition = Metrics.phoneWidth;

        if (availableWidth < 0 || availableHeight < 0) {
            System.out.println("DIMENSIONS CORRUPTED");
        }

        makeButtons();

        Text.setScale(0, 0.2f);
        loadingWidth = Text.getTextWidth(0, loadingText);
        loadingHeight = Text.getTextHeight(0, loadingText);
    }

    public static CharacterSelection getInstance() {
        return instance;
    }

    @Override
    void makeButtons() {
        buttons = new Button[5];
        //------------
        // CHARACTERS
        //------------
        buttons[0] = new Button(
                Assets.hayek,
                characterSpace,
                imageYPos,
                imageWidth,
                imageHeight,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                BoardGame.firebaseInterface.verifyCharacter("hayek");
                loadingText = "Cargando...";
                loadingWidth = Text.getTextWidth(0, loadingText);
                loadingHeight = Text.getTextHeight(0, loadingText);
                Listener.setLoading(true);
                arrowXPosition = characterSpace + imageWidth / 2 - colorButtonSize / 2;
            }
        };
        buttons[1] = new Button(
                Assets.keynes,
                characterSpace * 2 + imageWidth,
                imageYPos,
                imageWidth,
                imageHeight,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                BoardGame.firebaseInterface.verifyCharacter("keynes");
                loadingText = "Cargando...";
                loadingWidth = Text.getTextWidth(0, loadingText);
                loadingHeight = Text.getTextHeight(0, loadingText);
                Listener.setLoading(true);
                arrowXPosition = characterSpace * 2 + imageWidth * 1.5f - colorButtonSize / 2;
            }
        };
        buttons[2] = new Button(
                Assets.marx,
                characterSpace * 3 + imageWidth * 2,
                imageYPos,
                imageWidth,
                imageHeight,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                BoardGame.firebaseInterface.verifyCharacter("marx");
                loadingText = "Cargando...";
                loadingWidth = Text.getTextWidth(0, loadingText);
                loadingHeight = Text.getTextHeight(0, loadingText);
                Listener.setLoading(true);
                arrowXPosition = characterSpace * 3 + imageWidth * 2.5f - colorButtonSize / 2;
            }
        };
        buttons[3] = new Button(
                Assets.smith,
                characterSpace * 4 + imageWidth * 3,
                imageYPos,
                imageWidth,
                imageHeight,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                BoardGame.firebaseInterface.verifyCharacter("smith");
                loadingText = "Cargando...";
                loadingWidth = Text.getTextWidth(0, loadingText);
                loadingHeight = Text.getTextHeight(0, loadingText);
                Listener.setLoading(true);
                arrowXPosition = characterSpace * 4 + imageWidth * 3.5f - colorButtonSize / 2;
            }
        };
        // The start button
        buttons[4] = new Button(
                Assets.button5,
                Metrics.phoneWidth / 2 - imageWidth,
                imageYPos - colorButtonSize * 4,
                imageWidth * 2,
                imageWidth * 2 / 5,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                if (PlayerManager.getInstance().getPlayers()[PlayerManager.getInstance().getPlayerIndex()].getCharacter().equals("none")) {
                    loadingText = "Sin personaje";
                    loadingWidth = Text.getTextWidth(0, loadingText);
                    loadingHeight = Text.getTextHeight(0, loadingText);
                } else {
                    ScreenManager.setCurrentScreen(Game.getInstance());
                }
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        Text.setScale(0, 0.25f);
        Text.bordered.setColor(Color.PURPLE);
        Text.bordered.draw(
                batch,
                chooseText,
                Metrics.phoneWidth / 2 - Text.getTextWidth(0, chooseText) / 2,
                Metrics.phoneHeight - textSpaceHeight
        );
        for (Button b : buttons) {
            b.draw(true, batch);
        }
        // Draws "Ihe ready button
        Text.setScale(0, 0.25f);
        Text.bordered.setColor(Color.PURPLE);
        Text.bordered.draw(
                batch,
                readyText,
                Metrics.phoneWidth / 2 - Text.getTextWidth(0, readyText) / 2,
                imageYPos - textSpaceHeight * 5.25f
        );
        Text.setScale(0, 0.2f);
        Text.bordered.setColor(Color.WHITE);
        Text.bordered.draw(
                batch,
                loadingText,
                Gdx.graphics.getWidth() - loadingWidth - loadingHeight,
                loadingHeight * 2
        );

        batch.draw(
                Assets.arrow,
                arrowXPosition,
                imageYPos - colorButtonSize * 2,
                colorButtonSize,
                colorButtonSize
        );
    }

    public void doneVerifyingCharacter(String character, int characterIndex) {
        if (characterIndex == -1) {
            PlayerManager.getInstance().updateCharacter(PlayerManager.getInstance().getPlayerIndex(), character);
            Listener.setLoading(false);
            loadingText = "";
        } else {
            Listener.setLoading(false);
            loadingText = "No disponible";
            loadingWidth = Text.getTextWidth(0, loadingText);
            loadingHeight = Text.getTextHeight(0, loadingText);
        }
    }
}
