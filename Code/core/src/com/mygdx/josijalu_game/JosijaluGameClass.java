package com.mygdx.josijalu_game;

import shadering.Shadering;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.josijalu_game.screen.GameScreen;
import com.mygdx.josijalu_game.screen.ScreenManager;

public class JosijaluGameClass extends ApplicationAdapter {
    public static int HEIGHT = 1080, WIDTH = 1920;

    SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch(1000, Shadering.createDefaultShader());
        ScreenManager.setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        if (ScreenManager.getCurrentScreen() != null)
            ScreenManager.getCurrentScreen().dispose();
        batch.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (ScreenManager.getCurrentScreen() != null)
            ScreenManager.getCurrentScreen().update();

        if (ScreenManager.getCurrentScreen() != null)
            ScreenManager.getCurrentScreen().render(batch);

//		batch.begin();
//		batch.end();
    }

    @Override
    public void resize(int width, int height) {
        if (ScreenManager.getCurrentScreen() != null)
            ScreenManager.getCurrentScreen().resize(width, height);
    }

    @Override
    public void pause() {
        if (ScreenManager.getCurrentScreen() != null)
            ScreenManager.getCurrentScreen().pause();
    }

    @Override
    public void resume() {
        if (ScreenManager.getCurrentScreen() != null)
            ScreenManager.getCurrentScreen().resume();
    }


}
