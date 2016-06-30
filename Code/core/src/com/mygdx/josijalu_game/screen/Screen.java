package com.mygdx.josijalu_game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by User on 26.06.2016.
 */
public abstract class Screen {

    public abstract void create();

    public abstract void update();

    public abstract void render(SpriteBatch spriteBatch);

    public abstract void resize(int width, int height);

    public abstract void dispose();

    public abstract void pause();

    public abstract void resume();

}
