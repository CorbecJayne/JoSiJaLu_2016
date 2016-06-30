package com.mygdx.josijalu_game.entity.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.josijalu_game.camera.OrthoCamera;

/**
 * Created by User on 30.06.2016.
 */
public class HUD {

    private final Array<HudElement> hudElements = new Array<HudElement>();

    public void update(OrthoCamera camera) {
        for (HudElement h : hudElements) {
            h.update();
        }

    }

    public void render(SpriteBatch spriteBatch) {
        for (HudElement h : hudElements)
            h.render(spriteBatch);

    }

    public void addElement(HudElement element) {
        hudElements.add(element);
    }

}
