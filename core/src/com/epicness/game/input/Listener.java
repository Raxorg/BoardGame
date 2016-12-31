package com.epicness.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.epicness.game.ui.buttons.MenuButtonListener;

/**
 * Created by Groxar on 09/11/2016.
 * Hello :D
 */

public class Listener extends InputAdapter {

    private MenuButtonListener menuButtonListener;
    private static boolean loading = true;

    public static void setLoading(boolean l) {
        loading = l;
    }

    public Listener(MenuButtonListener menuButtonListener) {
        this.menuButtonListener = menuButtonListener;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (loading) {
            return false;
        }
        screenY = Gdx.graphics.getHeight() - screenY;
        if (pointer == 0) {
            calculateCellTouched(screenX, screenY);
            return menuButtonListener.touchUp(screenX, screenY, pointer, button);
        }
        return false;
    }

    private void calculateCellTouched(int x, int y) {
        /*if (x >= Metrics.left && x <= Metrics.right &&
                y >= Metrics.bottom && y <= Metrics.top) {
            int column = (int) ((x - Metrics.left) / Metrics.cellSize);
            int row = (int) ((y - Metrics.bottom) / Metrics.cellSize);
            if (GameLogic.getInstance().isGameStarted()) {
                GameLogic.getInstance().cellTouched(row, column);
            }
        }*/
    }
}