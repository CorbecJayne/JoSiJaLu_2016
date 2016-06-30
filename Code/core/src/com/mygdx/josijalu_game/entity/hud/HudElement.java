package com.mygdx.josijalu_game.entity.hud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.entity.Entity;

/**
 * Created by User on 30.06.2016.
 */
public class HudElement extends Entity{
    public HudElement(Texture texture, Vector2 position) {
        super(texture, position, new Vector2(0, 0));
    }

    @Override
    public void update() {

    }
}
