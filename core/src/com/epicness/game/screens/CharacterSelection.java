package com.epicness.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.firebase.RequestManager;
import com.epicness.game.firebase.Updater;
import com.epicness.game.input.Listener;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.organizers.Text;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */

public class CharacterSelection extends MyScreen {

    private String requestingCharacter;
    private String loadingText = "loading";
    private final String chooseText = "Elegir personaje y color";
    private float textHeight, textSpaceHeight;
    private float imageWidth, imageHeight, characterSpace, imageYPos;
    private float colorButtonSize;

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

        if (availableWidth < 0 || availableHeight < 0) {
            System.out.println("DIMENSIONS CORRUPTED");
        }

        makeButtons();

        requestingCharacter = "";
    }

    public static CharacterSelection getInstance() {
        return instance;
    }

    @Override
    void makeButtons() {
        buttons = new Button[9];
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
                RequestManager.getInstance().requestCharacterAvailable("hayek");
                requestingCharacter = "hayek";
                loadingText = "Loading...";
                Listener.setLoading(true);
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
                RequestManager.getInstance().requestCharacterAvailable("keynes");
                requestingCharacter = "keynes";
                loadingText = "Loading...";
                Listener.setLoading(true);
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
                RequestManager.getInstance().requestCharacterAvailable("marx");
                requestingCharacter = "marx";
                loadingText = "Loading...";
                Listener.setLoading(true);
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
                RequestManager.getInstance().requestCharacterAvailable("smith");
                requestingCharacter = "smith";
                loadingText = "Loading...";
                Listener.setLoading(true);
            }
        };
        //------------
        //   PIECES
        //------------
        buttons[4] = new Button(
                new TextureRegion(Assets.player),
                characterSpace + imageWidth / 2 - colorButtonSize / 2,
                imageYPos - colorButtonSize * 2,
                colorButtonSize,
                colorButtonSize,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {

            }
        };
        buttons[5] = new Button(
                new TextureRegion(Assets.player),
                characterSpace * 2 + imageWidth + imageWidth / 2 - colorButtonSize / 2,
                imageYPos - colorButtonSize * 2,
                colorButtonSize,
                colorButtonSize,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {

            }
        };
        buttons[6] = new Button(
                new TextureRegion(Assets.player),
                characterSpace * 3 + imageWidth * 2 + imageWidth / 2 - colorButtonSize / 2,
                imageYPos - colorButtonSize * 2,
                colorButtonSize,
                colorButtonSize,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {

            }
        };
        buttons[7] = new Button(
                new TextureRegion(Assets.player),
                characterSpace * 4 + imageWidth * 3 + imageWidth / 2 - colorButtonSize / 2,
                imageYPos - colorButtonSize * 2,
                colorButtonSize,
                colorButtonSize,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {

            }
        };
        //------------
        //    START
        //------------
        buttons[8] = new Button(
                Assets.button5,
                Metrics.phoneWidth / 2 - imageWidth,
                imageYPos - colorButtonSize * 4,
                imageWidth * 2,
                imageWidth * 2 / 5,
                Color.WHITE
        ) {
            @Override
            public void onTouchUp() {
                ScreenManager.setCurrentScreen(Game.getInstance());
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        Text.setScale(true, 0.25f);
        Text.bordered.draw(
                batch,
                chooseText,
                Metrics.phoneWidth / 2 - Text.getTextWidth(true, chooseText) / 2,
                Metrics.phoneHeight - textSpaceHeight
        );
        for (Button b : buttons) {
            b.draw(batch);
        }
    }

    public void updateFromDatabase(String character, String owner) {
        if (requestingCharacter.equals(character)) {
            if (owner.equals("none")) {
                Updater.characterOwnerUpdate();
            } else {

            }
        }

        requestingCharacter = "";
        loadingText = "";
        Listener.setLoading(false);
    }

}
