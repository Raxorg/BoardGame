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
        float playerWidth = side * 0.1f;
        cells = new Cell[17];
        cells[0] = new Cell(
                CellType.AZUL,
                x + side / 2 - playerWidth / 2,
                y
        );
        cells[1] = new Cell(
                CellType.AZUL,
                40,
                40
        );
        cells[2] = new Cell(
                CellType.AZUL,
                40,
                40
        );
        cells[3] = new Cell(CellType.AZUL, 40, 40);
        cells[4] = new Cell(CellType.AZUL, 40, 40);
        cells[5] = new Cell(CellType.AZUL, 40, 40);
        cells[6] = new Cell(CellType.AZUL, 40, 40);
        cells[7] = new Cell(CellType.AZUL, 40, 40);
        cells[8] = new Cell(CellType.AZUL, 40, 40);
        cells[9] = new Cell(CellType.AZUL, 40, 40);
        cells[10] = new Cell(CellType.AZUL, 40, 40);
        cells[11] = new Cell(CellType.AZUL, 40, 40);
        cells[12] = new Cell(CellType.AZUL, 40, 40);
        cells[13] = new Cell(CellType.AZUL, 40, 40);
        cells[14] = new Cell(CellType.AZUL, 40, 40);
        cells[15] = new Cell(CellType.AZUL, 40, 40);
        cells[16] = new Cell(CellType.AZUL, 40, 40);
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

    public class Cell {
        private float x, y;
        private CellType type;

        public Cell(CellType type, float x, float y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
    }
}
