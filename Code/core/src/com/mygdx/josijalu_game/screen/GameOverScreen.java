package com.mygdx.josijalu_game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.josijalu_game.TextureManager;
import com.mygdx.josijalu_game.camera.OrthoCamera;

/**
 * Created by User on 28.06.2016.
 */
public class GameOverScreen extends Screen {

    private OrthoCamera camera;
    private Texture texture;

    public GameOverScreen(boolean playerTwoWon) {
        if (playerTwoWon)
            texture = TextureManager.PLAYER_TWO_WON;
        else
            texture = TextureManager.PLAYER_ONE_WON;

    }

    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();

    }

    @Override
    public void update() {
        camera.update();

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(texture, 0, 0);
        spriteBatch.end();

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

}
