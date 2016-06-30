package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.TextureManager;

/**
 * Created by User on 28.06.2016.
 */
public class Missile extends Entity {

    public boolean playerTwo;

    public Missile(Vector2 position, Vector2 direction, boolean playerTwo) {
        super(TextureManager.MISSILE_ONE, position, direction);
        this.playerTwo = playerTwo;
        if (playerTwo)
            texture = TextureManager.MISSILE_TWO;
        size = getSize();
    }

    @Override
    public Circle getBounds() {
        return new Circle(new Vector2(position.x + 16, position.y + 16), 14);
    }

    @Override
    public void update() {
        position.add(velocity);

    }

    public static int getSize() {
        return 32;
    }

}
