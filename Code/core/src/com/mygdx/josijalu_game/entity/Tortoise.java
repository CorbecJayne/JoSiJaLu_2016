package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.TextureManager;
import com.mygdx.josijalu_game.screen.GameScreen;

/**
 * Created by Yuanren on 06/07/2016.
 */
public class Tortoise extends Entity{

    private final EntityManager entityManager;
    public static int getSize(){
        return 200;
    }
    public Tortoise(Vector2 position, Vector2 velocity, EntityManager entityManager){
        super(TextureManager.TORTOISE, position, velocity);
        size = getSize();
        this.entityManager = entityManager;
        entityManager.addEntity(new PowerUp(position.cpy(), velocity.cpy()));
    }
    @Override
    public void update() {
        position.add(velocity);
    }
    public Vector2 getPosition(){
        return position;
    }
}
