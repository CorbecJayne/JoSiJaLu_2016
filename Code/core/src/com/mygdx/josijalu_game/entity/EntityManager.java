package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.josijalu_game.camera.OrthoCamera;
import com.mygdx.josijalu_game.screen.GameOverScreen;
import com.mygdx.josijalu_game.screen.ScreenManager;

/**
 * Created by User on 28.06.2016.
 */
public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private Vector2 mousePos;

    public EntityManager() {
    }

    public Vector2 getMousePos() {
        return new Vector2(mousePos);
    }

    public void update(OrthoCamera camera) {
        mousePos = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
        for (Entity e : entities) {
            e.update();
//            if (e.outOfBounds())
//                entities.removeValue(e, false);
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
                    if (p.playerTwo && !m.playerTwo) {
                        entities.removeValue(m, false);
                        p.health -= 50;
                        if (p.health <= 0)
                            ScreenManager.setScreen(new GameOverScreen(false));
                    } else if (!p.playerTwo && m.playerTwo) {
                        entities.removeValue(m, false);
                        p.health -= 50;
                        if (p.health <= 0)
                            ScreenManager.setScreen(new GameOverScreen(true));
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

    public boolean gameOver() {
        return getPlayers().size == 1;
    }

}
