package com.mygdx.josijalu_game.entity.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.TextureManager;
import com.mygdx.josijalu_game.entity.Player;

/**
 * Created by User on 30.06.2016.
 */
public class HealthBar extends HudElement {

    private int maxHealth, girth = 64;
    private Player player;

    public HealthBar(Player player) {
        super(TextureManager.HEALTH, new Vector2(0, 0));

        this.player = player;
        maxHealth = player.health;

        if (player.playerTwo)
            position = new Vector2(JosijaluGameClass.WIDTH / 2, JosijaluGameClass.HEIGHT - girth);
        else
            position = new Vector2(0, JosijaluGameClass.HEIGHT - girth);


    }

    @Override
    public void update() {

    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(sprite, position.x, position.y, maxHealth, girth);
        spriteBatch.draw(TextureManager.DAMAGE, position.x, position.y, maxHealth - player.health, girth);
    }

}
