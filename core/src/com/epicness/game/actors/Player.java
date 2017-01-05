package com.epicness.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.firebase.SetterManager;
import com.epicness.game.organizers.Assets;
import com.epicness.game.organizers.PlayerManager;

/**
 * Created by Groxar on 02/12/2016.
 * :D
 */

public class Player {

    private TextureRegion texture;
    private float x = 0, y = 0, width = 0, height = 0, offsetX = 0, offsetY = 0;
    private Board.Cell cell;
    private Color color = null;
    // These are on the DB
    private int capital;
    private String character;
    private int currentActionIndex;
    private int land;
    private int money;
    private String phoneID;
    private int position;
    private String sectors;
    private int workforce;

    public Player(Color color, float offsetX, float offsetY) {
        texture = new TextureRegion(Assets.player);
        width = Board.getInstance().getSide() * 0.05f;
        height = Board.getInstance().getSide() * 0.075f;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        move(Board.getInstance().getCell(0));
        this.color = color;
        character = "none";
        phoneID = "none";
        sectors = "d1,i1,n1,t1";
    }

    //---------------------------
    //          SETTERS
    //---------------------------

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setCurrentActionIndex(int currentActionIndex) {
        this.currentActionIndex = currentActionIndex;
    }

    public void setLand(int land) {
        this.land = land;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setPhoneID(String phoneID) {
        this.phoneID = phoneID;
    }

    public void setPosition(int position) {
        this.position = position;
        move(Board.getInstance().getCell(position));
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    public void setWorkforce(int workforce) {
        this.workforce = workforce;
    }

    //---------------------------
    //          GETTERS
    //---------------------------

    public int getCapital() {
        return capital;
    }

    public String getCharacter() {
        return character;
    }

    public int getCurrentActionIndex() {
        return currentActionIndex;
    }

    public int getLand() {
        return land;
    }

    public int getMoney() {
        return money;
    }

    public String getPhoneID() {
        return phoneID;
    }

    public int getPosition() {
        return position;
    }

    public int getWorkforce() {
        return workforce;
    }

    public Color getColor() {
        return color;
    }

    public int getHumanDevelopment() {
        String[] indexes = sectors.split(",");
        return Integer.parseInt(indexes[0]);
    }

    public int getInfrastructure() {
        String[] indexes = sectors.split(",");
        return Integer.parseInt(indexes[1]);
    }

    public int getNaturalResources() {
        String[] indexes = sectors.split(",");
        return Integer.parseInt(indexes[2]);
    }

    public int getTechnology() {
        String[] indexes = sectors.split(",");
        return Integer.parseInt(indexes[3]);
    }

    //---------------------------
    //          OTHER
    //---------------------------

    public void move(Board.Cell cell) {
        this.cell = cell;
        x = Board.getInstance().getX() + Board.getInstance().getSide() / 2 - width;
        x += (float) (Math.cos(Math.toRadians(-cell.getAngle() + 80f))) * Board.getInstance().getSide() * 0.425;
        x += offsetX * width;
        y = Board.getInstance().getY() + Board.getInstance().getSide() / 2 - height;
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
                -cell.getAngle() - 10f - 5f * offsetX // rotation
        );
    }
}
