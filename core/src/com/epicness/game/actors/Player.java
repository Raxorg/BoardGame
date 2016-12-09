package com.epicness.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.epicness.game.organizers.Assets;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class Player {

    private int money;
    private Texture texture;
    private float x = 0, y = 0, width = 0, height = 0;
    private Board.Cell cell;

    public Player() {
        money = 1000;
        texture = Assets.player;
        width = Board.getInstance().getSide() * 0.1f;
        height = Board.getInstance().getSide() * 0.15f;
        cell = Board.getInstance().getCell(0);
        x = cell.getX();
        y = cell.getY();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void move(Board.Cell cell) {
        this.cell = cell;
        x = cell.getX();
        y = cell.getY();
    }

    public void draw(float delta, SpriteBatch batch) {
        batch.draw(
                texture,
                x,
                y,
                width,
                height
        );
    }

}
