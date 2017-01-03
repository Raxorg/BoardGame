package com.epicness.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.epicness.game.ui.buttons.ButtonListener;

/**
 * Created by Groxar on 09/11/2016.
 * Hello :D
 */

public class Listener extends InputAdapter {

    private ButtonListener buttonListener;
    private static boolean loading = true;

    public static void setLoading(boolean l) {
        loading = l;
    }

    public Listener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (loading) {
            return false;
        }
        screenY = Gdx.graphics.getHeight() - screenY;
        if (pointer == 0) {
            return buttonListener.touchUp(screenX, screenY, pointer, button);
        }
        return false;
    }
}
