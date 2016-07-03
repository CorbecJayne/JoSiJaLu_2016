package com.mygdx.josijalu_game;


import shadering.Shadering;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.josijalu_game.screen.MainMenuScreen;

public class JosijaluGameClass extends Game {
    public static int HEIGHT = 1080, WIDTH = 1920;
    public SpriteBatch batch;
    public BitmapFont font;

    public JosijaluGameClass() {
    }

    public void create() {
        batch = new SpriteBatch(1000, Shadering.createDefaultShader());
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
