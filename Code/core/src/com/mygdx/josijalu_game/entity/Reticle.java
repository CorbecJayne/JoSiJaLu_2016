package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.TextureManager;

/**
 * Created by User on 30.06.2016.
 */
public class Reticle extends Entity {

    EntityManager entityManager;

    public static int getSize() {
        return 64;
    }

    public Reticle(EntityManager entityManager) {
        super(TextureManager.RETICLE, new Vector2(0, 0), new Vector2(0, 0));
        this.entityManager = entityManager;
        size = getSize();
    }

    @Override
    public void update() {
        position.x = entityManager.getMousePos().x - sprite.getWidth() / 2;
        position.y = entityManager.getMousePos().y - sprite.getHeight() / 2;

    }

}
