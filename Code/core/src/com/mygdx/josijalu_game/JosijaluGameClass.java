package com.mygdx.josijalu_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.josijalu_game.screen.MainMenuScreen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JosijaluGameClass extends Game {
    public static int HEIGHT = 1080, WIDTH = 1920;
    public SpriteBatch batch;
    public BitmapFont font;

    public JosijaluGameClass() {
    }

    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.setScreen(new MainMenuScreen(this));
    }

    public void render() {
        super.render(); //important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
