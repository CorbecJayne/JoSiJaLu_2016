package com.josijalu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class HUD {

    public Texture getGreen() {
        return green;
    }

    public Texture getRed() {
        return red;
    }

    private Texture green;
    private Texture red;

    public HUD() {
        green = new Texture(Gdx.files.internal("graphics/green.png"));
        red = new Texture(Gdx.files.internal("graphics/red.png"));
    }
}
