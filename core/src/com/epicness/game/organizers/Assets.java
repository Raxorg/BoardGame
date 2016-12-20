package com.epicness.game.organizers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class Assets {

    private static boolean loaded;
    public static TextureRegion dado1, dado2, dado3, dado4, dado5, dado6;
    public static TextureRegion button1, button2, button3, button4, button5;
    public static TextureRegion hayek, keynes, marx, smith;
    public static Texture bg, board, player, tab, infocard, miniplayer, characters;

    public static void load() {
        if (!loaded) {
            Texture dados = new Texture(Gdx.files.internal("dados.png"));
            dados.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            dado1 = new TextureRegion(dados, 0, 0, 100, 100);
            dado2 = new TextureRegion(dados, 100, 0, 100, 100);
            dado3 = new TextureRegion(dados, 0, 100, 100, 100);
            dado4 = new TextureRegion(dados, 100, 100, 100, 100);
            dado5 = new TextureRegion(dados, 0, 200, 100, 100);
            dado6 = new TextureRegion(dados, 100, 200, 100, 100);
            Texture buttons = new Texture(Gdx.files.internal("buttons.png"));
            buttons.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            button1 = new TextureRegion(buttons, 0, 0, 100, 100);
            button2 = new TextureRegion(buttons, 0, 100, 200, 100);
            button3 = new TextureRegion(buttons, 0, 200, 300, 100);
            button4 = new TextureRegion(buttons, 0, 300, 400, 100);
            button5 = new TextureRegion(buttons, 0, 400, 500, 100);
            bg = new Texture(Gdx.files.internal("bg.png"));
            bg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            board = new Texture(Gdx.files.internal("board.png"));
            board.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            player = new Texture(Gdx.files.internal("player.png"));
            player.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            tab = new Texture(Gdx.files.internal("tab.png"));
            tab.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            infocard = new Texture(Gdx.files.internal("infocard.png"));
            infocard.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            miniplayer = new Texture(Gdx.files.internal("miniplayer.png"));
            miniplayer.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            characters = new Texture(Gdx.files.internal("images/characters.jpg"));
            hayek = new TextureRegion(characters, 0, 0, 300, 400);
            keynes = new TextureRegion(characters, 300, 0, 300, 400);
            marx = new TextureRegion(characters, 0, 400, 300, 400);
            smith = new TextureRegion(characters, 300, 400, 300, 400);
        }
        loaded = true;
    }

    public static boolean isLoaded() {
        return loaded;
    }

}
