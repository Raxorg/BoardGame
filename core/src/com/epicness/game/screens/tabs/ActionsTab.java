package com.epicness.game.screens.tabs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.actors.Dice;
import com.epicness.game.organizers.Assets;
import com.epicness.game.ui.buttons.Button;

/**
 * Created by LUCIA PAREDES on 01/01/2017.
 */
public class ActionsTab extends Tab {

    private static ActionsTab instance = new ActionsTab();
    private Dice dice;

    private ActionsTab() {
        dice = new Dice();
        makeButtons();
    }

    public static ActionsTab getInstance() {
        return instance;
    }

    @Override
    void makeButtons() {
        buttons = new Button[1];
        buttons[0] = new Button(
                Assets.button2,
                0,
                0,
                2 * (Gdx.graphics.getHeight() / 6),
                Gdx.graphics.getHeight() / 6,
                Color.BLUE
        ) {
            @Override
            public void onTouchUp() {
               //TODO: hacer que el dado cambie sus caras
                System.out.println("0");
            }
        };
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        dice.draw(delta, batch);
    }
}