package com.epicness.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.Metrics;

import static com.epicness.game.actors.Board.Sector.HUMAN_DEVELOPMENT;
import static com.epicness.game.actors.Board.Sector.INFRASTRUCTURE;
import static com.epicness.game.actors.Board.Sector.NATURAL_RESOURCES;
import static com.epicness.game.actors.Board.Sector.TECHNOLOGY;

/**
 * Created by Groxar on 07/12/2016.
 * :D
 */

public class Board {
    private Texture texture = null;
    private float x = 0, y = 0, side = 0;
    private static Board instance = new Board();
    private Cell[] cells = null;

    enum Sector {
        HUMAN_DEVELOPMENT,
        INFRASTRUCTURE,
        NATURAL_RESOURCES,
        TECHNOLOGY,
    }

    private Board() {
        texture = Assets.board;
        side = Metrics.tabHeight * 0.95f;
        x = 0;
        y = 0;
        makeCells();
    }

    private void makeCells() {
        cells = new Cell[17];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(i * 21.175f);
        }
        cells[0].setSector(TECHNOLOGY);
        cells[1].setSector(INFRASTRUCTURE);
        cells[2].setSector(HUMAN_DEVELOPMENT);
        cells[3].setSector(NATURAL_RESOURCES);
        cells[4].setSector(TECHNOLOGY);
        cells[5].setSector(INFRASTRUCTURE);
        cells[6].setSector(NATURAL_RESOURCES);
        cells[7].setSector(TECHNOLOGY);
        cells[8].setSector(HUMAN_DEVELOPMENT);
        cells[9].setSector(NATURAL_RESOURCES);
        cells[10].setSector(INFRASTRUCTURE);
        cells[11].setSector(TECHNOLOGY);
        cells[12].setSector(NATURAL_RESOURCES);
        cells[13].setSector(INFRASTRUCTURE);
        cells[14].setSector(HUMAN_DEVELOPMENT);
        cells[15].setSector(INFRASTRUCTURE);
        cells[16].setSector(NATURAL_RESOURCES);
    }

    public static Board getInstance() {
        return instance;
    }

    public Cell getCell(int index) {
        return cells[index];
    }

    public void draw(boolean left, SpriteBatch batch) {
        float offset = 0;
        offset = left ? 0 : Gdx.graphics.getWidth() / 2;
        batch.draw(
                texture,
                x + offset,
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
        private Sector sector;
        private float angle;

        public Cell(float angle) {
            this.angle = angle;
        }

        public float getAngle() {
            return angle;
        }

        public void setSector(Sector sector) {
            this.sector = sector;
        }

        public int getSectorIndex() {
            switch (sector) {
                case HUMAN_DEVELOPMENT:
                    return 1;
                case INFRASTRUCTURE:
                    return 2;
                case NATURAL_RESOURCES:
                    return 3;
                default:
                    return 4;
            }
        }
    }
}
