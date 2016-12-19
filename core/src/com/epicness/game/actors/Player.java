package com.epicness.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.organizers.Assets;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class Player {

    private int money;
    private TextureRegion texture;
    private float x = 0, y = 0, width = 0, height = 0, offsetX = 0, offsetY = 0;
    private Board.Cell cell;
    private Color color = null;
    private int time = 0;
    private int timecell = 0;

    public Player(Color color, float offsetX, float offsetY) {
        money = 1000;
        texture = new TextureRegion(Assets.player);
        width = Board.getInstance().getSide() * 0.05f;
        height = Board.getInstance().getSide() * 0.075f;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        move(Board.getInstance().getCell(0));
        this.color = color;
    }

    public Color getColor() {
        return color;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void move(Board.Cell cell) {
        this.cell = cell;
        x = Board.getInstance().getSide() / 2 - width;
        x += (float) (Math.cos(Math.toRadians(-cell.getAngle() + 80f))) * Board.getInstance().getSide() * 0.425;
        x += offsetX * width;
        y = Board.getInstance().getSide() / 2 - height;
        y += (float) (Math.sin(Math.toRadians(-cell.getAngle() + 80f))) * Board.getInstance().getSide() * 0.425;
        y += offsetY * height;
    }

    public void draw(boolean left, float delta, SpriteBatch batch) {
        float offset = 0;
        offset = left ? 0 : Gdx.graphics.getWidth() / 2;
        batch.draw(
                texture,        // texture region
                x + offset,     // xpos
                y,              // ypos
                width / 2,      // originx
                height / 2,     // originy
                width,          // width
                height,         // height
                1,              // scalex
                1,              // scaley
                -cell.getAngle() - 10f // rotation
        );
    }
}
