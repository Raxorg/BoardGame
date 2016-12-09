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

    private Animation animation = null;
    private float x = 0f, y = 0f;
    private float time = 0f;
    private boolean visible = false;

    public Dice() {
        TextureRegion[] regions = new TextureRegion[6];
        regions[0] = Assets.dado1;
        regions[1] = Assets.dado2;
        regions[2] = Assets.dado3;
        regions[3] = Assets.dado4;
        regions[4] = Assets.dado5;
        regions[5] = Assets.dado6;
        animation = new Animation(0.25f, regions);
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

    public void draw(float delta, SpriteBatch batch) {
        time += delta;
        TextureRegion currentRegion = animation.getKeyFrame(time, true);
        batch.draw(
                currentRegion,
                x,
                y,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6
        );
    }
}
