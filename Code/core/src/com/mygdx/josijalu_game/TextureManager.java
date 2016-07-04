package com.mygdx.josijalu_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by User on 26.06.2016.
 */
public class TextureManager {

    public static Texture BACKGROUND = new Texture(Gdx.files.internal("assets/graphics/background.png"));

    public static Texture PLAYER_LEFT = new Texture(Gdx.files.internal("assets/graphics/pig.png")); // Pig
    public static Texture PLAYER_RIGHT = new Texture(Gdx.files.internal("assets/graphics/bird.png")); // bird

    public static Texture MISSILE_LEFT = new Texture(Gdx.files.internal("assets/graphics/missile.png")); // pig's missile
    public static Texture MISSILE_RIGHT = new Texture(Gdx.files.internal("assets/graphics/missile.png")); // bird's missile

    public static Texture PLAYER_LEFT_WON = new Texture(Gdx.files.internal("assets/graphics/pig.png")); //pig won
    public static Texture PLAYER_RIGHT_WON = new Texture(Gdx.files.internal("assets/graphics/bird.png")); //bird won

    public static Texture RETICLE = new Texture(Gdx.files.internal("assets/graphics/reticle.png"));

    public static Texture HEALTH = new Texture(Gdx.files.internal("assets/graphics/health.png"));
    public static Texture DAMAGE = new Texture(Gdx.files.internal("assets/graphics/damage.png"));

}
