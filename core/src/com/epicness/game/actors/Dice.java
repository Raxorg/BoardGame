package com.epicness.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.organizers.Assets;

/**
 * Created by Groxar on 03/12/2016.
 * :D
 */

public class Dice {

    private TextureRegion currentRegion;
    private Animation animation = null;
    private float x = 0f, y = 0f, width = 0f, height = 0f;
    private float time = 0f;
    private boolean visible = false;
    private boolean stopped = true;

    public Dice(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        TextureRegion[] regions = new TextureRegion[6];
        regions[0] = Assets.dice1;
        regions[1] = Assets.dice2;
        regions[2] = Assets.dice3;
        regions[3] = Assets.dice4;
        regions[4] = Assets.dice5;
        regions[5] = Assets.dice6;
        currentRegion = regions[0];
        animation = new Animation(0.025f, regions);
        time = 0f;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Boolean isVisible() {
        return visible;
    }

    public void resetTime() {
        time = 0;
    }

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

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void draw(boolean left, float delta, SpriteBatch batch) {
        float offset = 0;
        offset = left ? 0 : Gdx.graphics.getWidth() / 2;
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
