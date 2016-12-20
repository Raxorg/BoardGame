package com.epicness.game.organizers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;


/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class Text {

    public static BitmapFont bordered, normal;
    private static float ratio;

    public static float getTextWidth(boolean isBordered, String text) {
        GlyphLayout layout;
        if (isBordered) {
            layout = new GlyphLayout(bordered, text);
        } else {
            layout = new GlyphLayout(normal, text);
        }
        return layout.width;
    }

    public static float getTextHeight(boolean isBordered, String text) {
        GlyphLayout layout;
        if (isBordered) {
            layout = new GlyphLayout(bordered, text);
        } else {
            layout = new GlyphLayout(normal, text);
        }
        return layout.height;
    }

    public static void load() {
        bordered = new BitmapFont(Gdx.files.internal("fonts/bordered.fnt"));
        bordered.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        bordered.setColor(Color.PURPLE);
        normal = new BitmapFont(Gdx.files.internal("fonts/normal.fnt"));
        normal.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        normal.setColor(Color.BLACK);
        ratio = Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
    }

    public static void setScale(boolean isBordered, float scale) {
        if (isBordered) {
            bordered.getData().setScale(scale * Gdx.graphics.getDensity() * ratio);
        } else {
            normal.getData().setScale(scale * Gdx.graphics.getDensity() * ratio);
        }
    }

}
