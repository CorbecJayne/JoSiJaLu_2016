package com.mygdx.josijalu_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by User on 26.06.2016.
 */
public class TextureManager {

    public static Texture BACKGROUND = new Texture(Gdx.files.internal("assets/graphics/background.png"));

    public static Texture PLAYER_ONE = new Texture(Gdx.files.internal("assets/graphics/enemy.png"));
    public static Texture PLAYER_TWO = new Texture(Gdx.files.internal("assets/graphics/player.png"));

    public static Texture MISSILE_ONE = new Texture(Gdx.files.internal("assets/graphics/missile.png"));
    public static Texture MISSILE_TWO = new Texture(Gdx.files.internal("assets/graphics/missile.png"));

    public static Texture PLAYER_TWO_WON = new Texture(Gdx.files.internal("assets/graphics/enemy.png"));
    public static Texture PLAYER_ONE_WON = new Texture(Gdx.files.internal("assets/graphics/player.png"));

    public static Texture RETICLE = new Texture(Gdx.files.internal("assets/graphics/reticle.png"));

    public static Texture HEALTH = new Texture(Gdx.files.internal("assets/graphics/health.png"));
    public static Texture DAMAGE = new Texture(Gdx.files.internal("assets/graphics/damage.png"));

}
