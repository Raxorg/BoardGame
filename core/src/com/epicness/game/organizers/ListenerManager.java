package com.epicness.game.organizers;

/**
 * Created by Groxar on 22/12/2016.
 * Listener manager
 */

public class ListenerManager {

    private static ListenerManager instance = new ListenerManager();

    private ListenerManager() {

    }

    public static ListenerManager getInstance() {
        return instance;
    }

    /**
     * Adds a temporary listener to get the value of the specified reference
     * @param player specifies the player to get the value from
     * @param reference is the reference in the database
     */
    public void addListenerForPlayer(int player, String reference) {
        switch (player) {
            case 0:

                break;

        }
    }
}
