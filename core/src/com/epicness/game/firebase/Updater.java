package com.epicness.game.firebase;

/**
 * Created by Groxar on 18/12/2016.
 * :D
 */
public class Updater {

    private FirebaseInterface firebaseInterface;

    public Updater(FirebaseInterface firebaseInterface) {
        this.firebaseInterface = firebaseInterface;
    }



    public void updateGrid(int position, char content, boolean reset) {
        //firebaseInterface.updateGrid(position, content, reset);
    }

    public void updateTurn(int turn) {
        //firebaseInterface.updateTurn(turn);
    }

    public void updateReady(boolean ready, int player) {
        //firebaseInterface.updateReady(ready, player);
    }

    public void updateGameStarted(boolean gameStarted) {
        //firebaseInterface.updateGameStarted(gameStarted);
    }

    public static void gridUpdate(String snapshot) {
        /*
        int counter = 0;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                Grid.getInstance().setContent(snapshot.charAt(counter), row, column);
                counter++;
            }
        }*/
    }

    public static void turnUpdate(int snapshot) {
        /*
        Turn.getInstance().updateTurn(snapshot);
        */
    }

    public static void gameStartedUpdate(boolean started) {
        /*
        GameLogic.getInstance().updateStarted(started);
        TextManager.getInstance().updateLoadingText("Fight!");
        */
    }

    public static void readyUpdate(int player, boolean ready) {
        /*
        GameLogic.getInstance().updateReady(player, ready);
        */
    }
}