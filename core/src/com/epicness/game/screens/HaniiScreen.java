package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.ScreenManager;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by Luchox on 09/12/2016.
 */
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
        // AQUI HACES TUS BOTONES :D
        // SI  NO TIENES BOTONES DEJALO ASI
        buttons = new Button[1];
        buttons[0] = new Button(
                Assets.button1,
                Gdx.graphics.getWidth() - Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6,
                Color.BLUE
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
