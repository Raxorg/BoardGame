package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.ui.buttons.Button;

// Hola amor, aqui has tus cosas :3

public class HaniiScreen extends MyScreen {

    private static HaniiScreen instance = new HaniiScreen();

    private HaniiScreen() {
        makeButtons();
    }

    public static HaniiScreen getInstance() {
        return instance;
    }

    @Override
    void makeButtons() {
        // Aquì haces tus botones :3
        buttons = new Button[1];    // Si añades un botón agranda el arreglo
        buttons[0] = new Button(
                Assets.button1,
                Gdx.graphics.getWidth() - Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Color.RED
        ) {

            @Override
            public void onTouchUp() {
                ScreenManager.setCurrentScreen(GameScreen.getInstance());
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        for (Button b : buttons) {
            batch.setColor(b.getColor());
            batch.draw(
                    b.getTexture(),
                    b.getX(),
                    b.getY(),
                    b.getWidth(),
                    b.getHeight()
            );
        }
        batch.setColor(Color.WHITE);
    }
}
