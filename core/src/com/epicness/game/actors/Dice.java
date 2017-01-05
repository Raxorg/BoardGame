package com.epicness.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.organizers.Assets;

/**
 * This class will draw and animate the dice
 * @author Luis Frontanilla, Lucia Paredes
 *
 */
public class Dice {

    private TextureRegion currentRegion;
    private Animation animation = null;
    private float x = 0f, y = 0f, width = 0f, height = 0f;
    private float time = 0f;
    private boolean visible = false;
    private boolean stopped = true;
    private float speed;

    /**
     * Constructor of dice initializes its parameters
     * @param x position of dice
     * @param y position of dice
     * @param width of dice
     * @param height of dice
     * @param speed of the dice animation
     */
    public Dice(float x, float y, float width, float height, float speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        TextureRegion[] regions = new TextureRegion[6]; //different faces from dice
        regions[0] = Assets.dice1;
        regions[1] = Assets.dice2;
        regions[2] = Assets.dice3;
        regions[3] = Assets.dice4;
        regions[4] = Assets.dice5;
        regions[5] = Assets.dice6;
        currentRegion = regions[0];
        animation = new Animation(0.025f * speed, regions); //Animates the dice with regions
        time = 0f;
    }

    /**
     * Getter of dice x position
     * @return x position
     */
    public float getX() {
        return x;
    }

    /**
     * Setter of dice x position
     * @param x position
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Getter of dice y position
     * @return y position
     */
    public float getY() {
        return y;
    }

    /**
     * Setter of dice y position
     * @param y position
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Sets dice to visible
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Getter of visible state of dice
     * @return if dice is visible or not
     */
    public Boolean isVisible() {
        return visible;
    }

    /**
     * Getter of current face of dice
     * @return number of face
     */
    public int getCurrentFace() {
        if (currentRegion == Assets.dice1)
            return 1;
        if (currentRegion == Assets.dice2)
            return 2;
        if (currentRegion == Assets.dice3)
            return 3;
        if (currentRegion == Assets.dice4)
            return 4;
        if (currentRegion == Assets.dice5)
            return 5;
        if (currentRegion == Assets.dice6)
            return 6;

        return 0;
    }

    /**
     * Sets the die to stopped
     * @param stopped
     */
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    /**
     * Getter of stopped state of die
     * @return if die is stopped or not
     */
    public boolean isStopped() {
        return stopped;
    }

    /**
     * Draws the dice, sets its position and stops animation
     * @param left, if true then dice get drawn in left tab
     * @param delta time in milliseconds between two frames
     * @param batch allow to draw the dice
     */
    public void draw(boolean left, float delta, SpriteBatch batch) {
        float offset = left ? 0 : Gdx.graphics.getWidth() / 2;
        if (!stopped) {
            time += delta;
            currentRegion = animation.getKeyFrame(time, true);
        }
        if (visible) {
            batch.draw(
                    currentRegion,
                    x + offset,
                    y,
                    width,
                    height
            );
        }
    }
}
