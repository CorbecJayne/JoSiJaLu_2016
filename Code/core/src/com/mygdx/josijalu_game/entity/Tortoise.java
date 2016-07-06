package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.TextureManager;
import com.mygdx.josijalu_game.screen.GameScreen;

/**
 * Created by Yuanren on 06/07/2016.
 */
public class Tortoise extends Entity{

    int tortoiseTime = 5;
    private final EntityManager entityManager;
    private static int getSize(){
        return 200;
    }
    public Tortoise(Vector2 position, Vector2 velocity, EntityManager entityManager){
        super(TextureManager.TORTOISE, position, velocity);
        size = getSize();
        this.entityManager = entityManager;
        velocity = new Vector2(0, 0);
        entityManager.addEntity(new PowerUp(new Vector2(0,0), velocity));
    }
    @Override
    public void update() {
        position.add(velocity);
        if(position.y <= -200){
            position= new Vector2(position.x, JosijaluGameClass.HEIGHT);
            velocity = new Vector2(0, 0);
            entityManager.addEntity(new PowerUp(new Vector2(0,0), velocity));
        }else if(GameScreen.getPlayTime()>=tortoiseTime){
            velocity = new Vector2(0, -5);
            tortoiseTime += 20;
        }
    }
    public Vector2 getPosition(){
        return position;
    }
}
