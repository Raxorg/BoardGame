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

    public static BitmapFont bordered, normal, digits;
    private static float ratio;

    public static float getTextWidth(int textIndex, String text) {
        GlyphLayout layout;
        switch (textIndex) {
            case 0:
                layout = new GlyphLayout(bordered, text);
                break;
            case 1:
                layout = new GlyphLayout(normal, text);
                break;
            default:
                layout = new GlyphLayout(digits, text);
                break;
        }
        return layout.width;
    }

    public static float getTextHeight(int textIndex, String text) {
        GlyphLayout layout;
        switch (textIndex) {
            case 0:
                layout = new GlyphLayout(bordered, text);
                break;
            case 1:
                layout = new GlyphLayout(normal, text);
                break;
            default:
                layout = new GlyphLayout(digits, text);
                break;
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
        digits = new BitmapFont(Gdx.files.internal("fonts/digits.fnt"));
        digits.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        digits.setColor(Color.BLACK);
        ratio = Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
    }

    public static void setScale(int textIndex, float scale) {
        switch (textIndex) {
            case 0:
                bordered.getData().setScale(scale * Gdx.graphics.getDensity() * ratio);
                break;
            case 1:
                normal.getData().setScale(scale * Gdx.graphics.getDensity() * ratio);
                break;
            default:
                digits.getData().setScale(scale * Gdx.graphics.getDensity() * ratio);
                break;
        }
    }

}
