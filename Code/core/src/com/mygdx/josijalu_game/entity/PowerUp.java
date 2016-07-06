package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.TextureManager;

/**
 * Created by Yuanren on 06/07/2016.
 */
public class PowerUp extends Entity{
    private static int getSize(){
        return 50;
    }
    public PowerUp(Vector2 position, Vector2 direction) {
        super(TextureManager.POWUP, position, direction);
        size = getSize();
    }

    @Override
    public void update() {
        position = Tortoise.getStaticPosition();
    }
}
