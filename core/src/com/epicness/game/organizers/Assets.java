package com.epicness.game.organizers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class Assets {

    private static boolean loaded;
    public static TextureRegion dice1, dice2, dice3, dice4, dice5, dice6;
    public static TextureRegion button1, button2, button3, button4, button5;
    public static TextureRegion hayek, keynes, marx, smith;
    public static Texture bg, board, player, tab, infocard, miniplayer, miniboard, characters,
            minichart, minicard, miniactions, arrow, workforceIcon, landIcon, capitalIcon,
            chart, refresh, next, plus, factorCard, factorCardFG, factorCardBG,
            humanDevelopment, infrastructure, naturalResources, technology;
    public static Sound buttonSound, pageSound, diceSound;

    public static void load() {
        if (!loaded) {
            // Dice
            Texture dice1tex = new Texture(Gdx.files.internal("animation/dice1.png"));
            dice1tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            dice1 = new TextureRegion(dice1tex);
            Texture dice2tex = new Texture(Gdx.files.internal("animation/dice2.png"));
            dice2tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            dice2 = new TextureRegion(dice2tex);
            Texture dice3tex = new Texture(Gdx.files.internal("animation/dice3.png"));
            dice3tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            dice3 = new TextureRegion(dice3tex);
            Texture dice4tex = new Texture(Gdx.files.internal("animation/dice4.png"));
            dice4tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            dice4 = new TextureRegion(dice4tex);
            Texture dice5tex = new Texture(Gdx.files.internal("animation/dice5.png"));
            dice5tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            dice5 = new TextureRegion(dice5tex);
            Texture dice6tex = new Texture(Gdx.files.internal("animation/dice6.png"));
            dice6tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            dice6 = new TextureRegion(dice6tex);
            // Buttons
            Texture buttons = new Texture(Gdx.files.internal("buttons.png"));
            buttons.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            button1 = new TextureRegion(buttons, 0, 0, 100, 100);
            button2 = new TextureRegion(buttons, 0, 100, 200, 100);
            button3 = new TextureRegion(buttons, 0, 200, 300, 100);
            button4 = new TextureRegion(buttons, 0, 300, 400, 100);
            button5 = new TextureRegion(buttons, 0, 400, 500, 100);
            // Other
            bg = new Texture(Gdx.files.internal("bg.png"));
            bg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            board = new Texture(Gdx.files.internal("board.png"));
            board.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            chart = new Texture(Gdx.files.internal("images/chart.png"));
            chart.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            player = new Texture(Gdx.files.internal("player.png"));
            player.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            tab = new Texture(Gdx.files.internal("tab.png"));
            tab.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            arrow = new Texture(Gdx.files.internal("images/arrow.png"));
            arrow.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            next = new Texture(Gdx.files.internal("images/next.png"));
            next.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            refresh = new Texture(Gdx.files.internal("images/refresh.png"));
            refresh.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            plus = new Texture(Gdx.files.internal("images/plus.png"));
            plus.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            infocard = new Texture(Gdx.files.internal("infocard.png"));
            infocard.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            // Production factors
            workforceIcon = new Texture(Gdx.files.internal("images/helmet.png"));
            workforceIcon.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            landIcon = new Texture(Gdx.files.internal("images/land.png"));
            landIcon.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            capitalIcon = new Texture(Gdx.files.internal("images/money.png"));
            capitalIcon.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            factorCard = new Texture(Gdx.files.internal("images/factorcard.png"));
            factorCard.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            factorCardFG = new Texture(Gdx.files.internal("images/factorcardfg.png"));
            factorCardFG.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            factorCardBG = new Texture(Gdx.files.internal("images/factorcardbg.png"));
            factorCardBG.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            humanDevelopment = new Texture(Gdx.files.internal("IDH.png"));
            humanDevelopment.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            infrastructure = new Texture(Gdx.files.internal("I.png"));
            infrastructure.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            naturalResources = new Texture(Gdx.files.internal("RN.png"));
            naturalResources.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            technology = new Texture(Gdx.files.internal("T.png"));
            technology.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            // Tab images
            miniplayer = new Texture(Gdx.files.internal("images/miniplayer.png"));
            miniplayer.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            miniboard = new Texture(Gdx.files.internal("images/miniboard.png"));
            miniboard.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            minichart = new Texture(Gdx.files.internal("images/minichart.png"));
            minichart.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            minicard = new Texture(Gdx.files.internal("images/minicard.png"));
            minicard.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            miniactions = new Texture(Gdx.files.internal("images/miniactions.png"));
            miniactions.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            // Characters
            characters = new Texture(Gdx.files.internal("images/characters.jpg"));
            hayek = new TextureRegion(characters, 0, 0, 300, 400);
            keynes = new TextureRegion(characters, 300, 0, 300, 400);
            marx = new TextureRegion(characters, 0, 400, 300, 400);
            smith = new TextureRegion(characters, 300, 400, 300, 400);
            // Sounds
            buttonSound = Gdx.audio.newSound(Gdx.files.internal("sounds/button.wav"));
            pageSound = Gdx.audio.newSound(Gdx.files.internal("sounds/page.wav"));
            diceSound = Gdx.audio.newSound(Gdx.files.internal("sounds/shakedice.wav"));
        }
        loaded = true;
    }

    public static boolean isLoaded() {
        return loaded;
    }

}
