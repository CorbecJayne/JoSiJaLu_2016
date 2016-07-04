package com.mygdx.josijalu_game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.SoundManager;
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
        SoundManager.gameOver.play(0.01f); //Macht aus irgendeinem Grund keinen Unterschied;
        SoundManager.gameOver.play();
        if (playerTwoWon)
            SoundManager.pigLaugh.play();

        this.game = game;
        camera = new OrthoCamera();
        camera.resize();
        if (playerTwoWon)
            texture = TextureManager.PLAYER_LEFT_WON;
        else
            texture = TextureManager.PLAYER_RIGHT_WON;


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            dispose();
            game.setScreen(new MainMenuScreen(game));
        }
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(texture, JosijaluGameClass.WIDTH / 2, JosijaluGameClass.HEIGHT / 2 - 50, 200, 200);
        game.font.draw(game.batch, "Winner is:", JosijaluGameClass.WIDTH / 2 + 10, JosijaluGameClass.HEIGHT / 2 + 90, 0, 0, false);
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
