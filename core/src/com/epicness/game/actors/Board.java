package com.epicness.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.organizers.Assets;

/**
 * Created by Groxar on 07/12/2016.
 * :D
 */

public class Board {
    private Texture texture = null;
    private float x = 0, y = 0, side = 0;
    private static Board instance = new Board();
    private Cell[] cells = null;

    enum CellType {
        ROJO,
        AZUL
    }

    private Board() {
        texture = Assets.board;
        side = Gdx.graphics.getHeight() * 0.7f;
        x = Gdx.graphics.getWidth() / 2 - side / 2;
        y = Gdx.graphics.getHeight() / 2 - side / 2;
        makeCells();
    }

    private void makeCells() {
        cells = new Cell[17];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(CellType.AZUL, i * 21.175f);
        }
    }

    public static Board getInstance() {
        return instance;
    }

    public Cell getCell(int index) {
        return cells[index];
    }

    public void draw(SpriteBatch batch) {
        batch.draw(
                texture,
                x,
                y,
                side,
                side
        );
    }

    public float getSide() {
        return side;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public class Cell {
        private CellType type;
        private float angle;

        public Cell(CellType type, float angle) {
            this.type = type;
            this.angle = angle;
        }

        public float getAngle() {
            return angle;
        }
    }
}
