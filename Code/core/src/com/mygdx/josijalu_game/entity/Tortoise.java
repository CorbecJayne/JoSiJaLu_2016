package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.TextureManager;
import com.mygdx.josijalu_game.screen.GameScreen;

/**
 * Created by Yuanren on 06/07/2016.
 */
public class Tortoise extends Entity{

    private static int getSize(){
        return 200;
    }
    public Tortoise(Vector2 position, Vector2 direction){
        super(TextureManager.TORTOISE, position, direction);
        size = getSize();
    }
    @Override
    public void update() {
        int neededTime = 15;
        Vector2 v = new Vector2(0, 0);
        if(GameScreen.getPlayTime()>=neededTime){
            v = new Vector2(0, -5);
            neededTime += 15;
        }
        position.add(v);
        if(position.y <= -200){
            position= new Vector2(position.x, JosijaluGameClass.HEIGHT);
        }
    }
}
