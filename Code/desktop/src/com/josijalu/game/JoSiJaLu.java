package com.josijalu.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class JoSiJaLu extends ApplicationAdapter {
    private Texture player_graphic;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Rectangle player_graphic_hitbox;
    //creating objects
    @Override
    public void create() {
        //create a camera view
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 800);
        //this is important for the grafical stuff
        batch = new SpriteBatch();
        //creating the player graphic
        player_graphic_hitbox = new Rectangle();
        player_graphic_hitbox.x = 10;
        player_graphic_hitbox.y = 10;
        player_graphic_hitbox.width = 64;
        player_graphic_hitbox.height = 64;
        player_graphic = new Texture(Gdx.files.internal("graphics/player_graphic.png"));
    }

    //frames
    @Override
    public void render() {
        //clearing the screen
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //cpdate the camera view (camera is fullscreen so until now there is nothing to update)
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        //drawing the objects
        batch.begin();
        batch.draw(player_graphic, player_graphic_hitbox.x, player_graphic_hitbox.y);
        batch.end();
    }
}
