
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
 * This class will draw cells for each sector
 * @author Luis Frontanilla, Lucia Paredes
 *
 */
public class Board {

    private Texture texture = null;
    private float x = 0, y = 0, side = 0;
    private static Board instance = new Board();
    private Cell[] cells = null;

    /*
    Enumerates each sector
     */
    enum Sector {
        HUMAN_DEVELOPMENT,
        INFRASTRUCTURE,
        NATURAL_RESOURCES,
        TECHNOLOGY,
    }

    /**
     * Private constructor for the Board class, initializes the board image and its position
     */
    private Board() {
        texture = Assets.board;
        side = Metrics.tabHeight * 0.95f;
        x = 0;
        y = 0;
        makeCells();
    }

    /**
     * Creates 17 cells for the board, gives each cell a sector
     */
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

    /**
     * Getter of a board instance
     * @return instance of board
     */
    public static Board getInstance() {
        return instance;
    }

    /**
     * Getter of a cell board
     * @param index is the index of the cells array
     * @return a cell
     */
    public Cell getCell(int index) {
        return cells[index];
    }

    /**
     *
     * @param left indicates if what we are drawing is in the left tab, else in right tab
     * @param batch allow to draw
     */
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

    /**
     * Getter of side of the board
     * @return side of the board
     */
    public float getSide() {
        return side;
    }

    /**
     * Getter of x position of the board
     * @return x position
     */
    public float getX() {
        return x;
    }

    /**
     * Getter of y position of the board
     * @return y position
     */
    public float getY() {
        return y;
    }

    /**
     * The Cell class creates a cell of the board with a sector and an angle
     */
    public class Cell {
        private Sector sector;
        private float angle;

        /**
         * Initializes cell's angle
         * @param angle of cell
         */
        public Cell(float angle) {
            this.angle = angle;
        }

        /**
         * Getter of angle
         * @return angle of the cell
         */
        public float getAngle() {
            return angle;
        }

        /**
         * Setter for the sector
         * @param sector of a cell
         */
        public void setSector(Sector sector) {
            this.sector = sector;
        }

        /**
         * This functions returns a sector's index
         * @return sector index
         */
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
