package com.mygdx.josijalu_game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.TextureManager;
import com.mygdx.josijalu_game.camera.OrthoCamera;
import com.mygdx.josijalu_game.entity.EntityManager;
import com.mygdx.josijalu_game.entity.Player;
import com.mygdx.josijalu_game.entity.Reticle;
import com.mygdx.josijalu_game.entity.hud.HUD;
import com.mygdx.josijalu_game.entity.hud.HealthBar;

/**
 * Created by User on 26.06.2016.
 */
public class GameScreen extends Screen {

    private OrthoCamera camera;
    private EntityManager entityManager;
    private HUD hud;

    @Override
    public void create() {
        camera = new OrthoCamera();

        entityManager = new EntityManager();
        entityManager.addEntity(new Reticle(entityManager));

        entityManager.addEntity(new Player(new Vector2(0, (JosijaluGameClass.HEIGHT - TextureManager.PLAYER_ONE.getHeight()) / 2), new Vector2(0, 0), entityManager, false));
        entityManager.addEntity(new Player(new Vector2(JosijaluGameClass.WIDTH - TextureManager.PLAYER_TWO.getWidth(), (JosijaluGameClass.HEIGHT - TextureManager.PLAYER_TWO.getHeight()) / 2), new Vector2(0, 0), entityManager, true));

        hud = new HUD();

        hud.addElement(new HealthBar(entityManager.getPlayers().first()));
        hud.addElement(new HealthBar(entityManager.getPlayers().get(1)));

    }

    @Override
    public void update() {
        camera.update();
        entityManager.update(camera);

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(TextureManager.BACKGROUND, 0, 0, JosijaluGameClass.WIDTH, JosijaluGameClass.HEIGHT);
        entityManager.render(spriteBatch);
        hud.render(spriteBatch);

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
