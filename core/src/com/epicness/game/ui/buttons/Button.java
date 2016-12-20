package com.epicness.game.ui.buttons;

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

    public Button(TextureRegion texture, float x, float y, float width, float height, Color color) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public boolean isWithin(int x, int y) {
        return x >= this.x && x <= this.x + width
                && y >= this.y && y <= this.y + height;
    }

    public void draw(SpriteBatch batch) {
        batch.setColor(color);
        batch.draw(
                texture,
                x,
                y,
                width,
                height
        );
        batch.setColor(Color.WHITE);
        if (image != null) {
            batch.draw(
                    image,
                    x + width / 2f - height * 0.75f / 2f,
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
