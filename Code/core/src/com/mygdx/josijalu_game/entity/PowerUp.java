package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.TextureManager;

/**
 * Created by Yuanren on 06/07/2016.
 */
public class PowerUp extends Entity {
    private static int getSize() {
        return 50;
    }

    public PowerUp(Vector2 position, Vector2 velocity) {
        super(TextureManager.POWUP, position, velocity);
        size = getSize();
    }

    public void whenHit(boolean PlayerTwo) {
        if (PlayerTwo)
            System.out.println("Birdy McBirdface has activated a PowerUp");
        else
            System.out.println("Piggy McPigface has activated a PowerUp");
    }

    @Override
    public void update() {
        position.add(velocity);
    }
}
