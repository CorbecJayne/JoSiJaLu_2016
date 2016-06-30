package com.mygdx.josijalu_game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.TextureManager;
import com.mygdx.josijalu_game.camera.OrthoCamera;

/**
 * Created by User on 28.06.2016.
 */
public class GameOverScreen implements Screen {

    final JosijaluGameClass game;
    private OrthoCamera camera;
    private Texture texture;

    public GameOverScreen(boolean playerTwoWon, JosijaluGameClass game) {
        this.game = game;
        camera = new OrthoCamera();
        camera.resize();
        if (playerTwoWon)
            texture = TextureManager.PLAYER_TWO_WON;
        else
            texture = TextureManager.PLAYER_ONE_WON;


    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new MainMenuScreen(game));
        }
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        game.batch.end();

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

}
