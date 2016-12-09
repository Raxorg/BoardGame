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

    public static BitmapFont font;
    private static float ratio;

    public static float getTextWidth(String text) {
        GlyphLayout layout = new GlyphLayout(font, text);
        return layout.width;
    }

    public static float getTextHeight(String text) {
        GlyphLayout layout = new GlyphLayout(font, text);
        return layout.height;
    }

    public static void load() {
        font = new BitmapFont(Gdx.files.internal("font.fnt"));
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.setColor(Color.PURPLE);
        ratio = Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
    }

    public static void setScale(float scale) {
        font.getData().setScale(scale * Gdx.graphics.getDensity() * ratio);
    }

}
