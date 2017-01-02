package com.epicness.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.epicness.game.organizers.Assets;
import com.epicness.game.screens.tabs.Tab;
import com.epicness.game.ui.buttons.Button;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by LUCIA PAREDES on 01/01/2017.
 */
public class Dice extends MyScreen implements ApplicationListener{

    private float x = 0f, y = 0f;
    private float time = 0f;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private Animation animation;
    private float animationTime;


    @Override
    void makeButtons() {
        buttons = new Button[0];
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        time += delta;
        TextureRegion currentRegion = animation.getKeyFrame(time, true);
        batch.draw(
                currentRegion,
                x,
                y,
                Gdx.graphics.getHeight() / 6,
                Gdx.graphics.getHeight() / 6
        );
    }

    @Override
    public void create() {
        batch = new SpriteBatch();

        // camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 480);

        animation = new Animation(1/10f,
                new TextureRegion(new Texture("animation/dice1.png")),
                new TextureRegion(new Texture("animation/dice2.png")),
                new TextureRegion(new Texture("animation/dice3.png")),
                new TextureRegion(new Texture("animation/dice4.png")),
                new TextureRegion(new Texture("animation/dice5.png")),
                new TextureRegion(new Texture("animation/dice6.png")));
        animation.setPlayMode(Animation.PlayMode.LOOP);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(animation.getKeyFrame(animationTime += Gdx.graphics.getDeltaTime()), 200, 200);
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
