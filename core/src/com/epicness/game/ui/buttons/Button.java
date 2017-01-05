package com.epicness.game.ui.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public abstract class Button {
    private TextureRegion texture, image;
    private float x;
    private float y;
    private float width;
    private float height;
    private Color color;
    private float offset = 0;

    public Button(TextureRegion texture, float x, float y, float width, float height, Color color) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public boolean isWithin(int x, int y) {
        return x >= this.x + offset && x <= this.x + offset + width
                && y >= this.y && y <= this.y + height;
    }

    public void draw(boolean left, SpriteBatch batch) {
        offset = left ? 0 : Gdx.graphics.getWidth() / 2;
        batch.setColor(color);
        batch.draw(
                texture,
                x + offset,
                y,
                width,
                height
        );
        batch.setColor(Color.WHITE);
        if (image != null && color != Color.CLEAR) {
            batch.draw(
                    image,
                    x + width / 2f - height * 0.75f / 2f + offset,
                    y + height / 2f - height * 0.75f / 2f,
                    height * 0.75f,
                    height * 0.75f
            );
        }
    }

    public void setImage(TextureRegion image) {
        this.image = image;
    }

    public abstract void onTouchUp();

    public TextureRegion getTexture() {
        return texture;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
