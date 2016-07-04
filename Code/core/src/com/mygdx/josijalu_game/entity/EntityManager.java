package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.SoundManager;
import com.mygdx.josijalu_game.camera.OrthoCamera;
import com.mygdx.josijalu_game.screen.GameOverScreen;

/**
 * Created by User on 28.06.2016.
 */
public class EntityManager {

    final JosijaluGameClass game;
    private final byte gameMode; //0: Standard; 1: Defence; 2: Asteroids

    private final Array<Entity> entities;
    private Vector2 mousePos;


    public EntityManager(final JosijaluGameClass game, final byte gameMode) {
        this.gameMode = gameMode;
        this.game = game;
        entities = new Array<Entity>();
    }

    public Vector2 getMousePos() {
        return new Vector2(mousePos);
    }

    public void update(OrthoCamera camera) {
        mousePos = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());


        for (Entity e : entities) {
            e.update();
        }
        for (Missile m : getMissiles())
            if (m.outOfBounds())
                entities.removeValue(m, false);
        checkCollisions();

    }

    public void render(SpriteBatch spriteBatch) {
        for (Entity e : entities)
            e.render(spriteBatch);

    }

    private void checkCollisions() {
        for (Player p : getPlayers()) {
            for (Missile m : getMissiles()) {
                if (p.getBounds().overlaps(m.getBounds())) {
                    if (gameMode == 1 && !p.playerTwo) {
                        SoundManager.hit.play();
                        entities.removeValue(m, false);
                        p.health -= Missile.DAMAGE;
                        if (p.health <= 0) {
                            game.setScreen(new GameOverScreen(false, game));
                        }
                    } else if (p.playerTwo && !m.playerTwo) {
                        SoundManager.hit.play();
                        entities.removeValue(m, false);
                        p.health -= Missile.DAMAGE;
                        if (p.health <= 0) {
                            game.setScreen(new GameOverScreen(true, game));
                        }
                    } else if (!p.playerTwo && m.playerTwo) {
                        SoundManager.hit.play();
                        entities.removeValue(m, false);
                        p.health -= Missile.DAMAGE;
                        if (p.health <= 0) {
                            game.setScreen(new GameOverScreen(false, game));
                        }
                    }
                }

            }
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public Array<Player> getPlayers() {
        Array<Player> ret = new Array<Player>();
        for (Entity e : entities)
            if (e instanceof Player)
                ret.add((Player) e);
        return ret;
    }

    private Array<Missile> getMissiles() {
        Array<Missile> ret = new Array<Missile>();
        for (Entity e : entities)
            if (e instanceof Missile)
                ret.add((Missile) e);
        return ret;
    }

}
