package com.epicness.game.ui.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

/**
 * Created by Luchox on 26/09/2015.
 * A button listener
 */
public class AllPurposeButtonListener extends InputAdapter {

    private Button[] buttons;

    public void setButtons(Button[] buttons) {
        this.buttons = buttons;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (pointer != 0) {
            return false;
        }
        screenY = Gdx.graphics.getHeight() - screenY;
        for (Button b : buttons) {
            if (b.isWithin(screenX, screenY)) {
                b.onTouchUp();
            }
        }
        return true;
    }
}
