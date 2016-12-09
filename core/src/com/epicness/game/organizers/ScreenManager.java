package com.epicness.game.organizers;

import com.epicness.game.BoardGame;
import com.epicness.game.screens.MyScreen;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class ScreenManager {
    private static MyScreen currentScreen;

    public static MyScreen getCurrentScreen() {
        return currentScreen;
    }

    public static void setCurrentScreen(MyScreen screen) {
        BoardGame.buttonListener.setButtons(screen.getButtons());
        currentScreen = screen;
    }
}
