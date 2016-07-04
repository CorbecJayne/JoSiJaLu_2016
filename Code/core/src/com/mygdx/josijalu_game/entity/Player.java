package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.TextureManager;

/**
 * Created by User on 26.06.2016.
 */
public class Player extends Entity {

    public int health;

    public final boolean playerTwo;
    private final byte gameMode; //0: Standard; 1: Defence; 2: Asteroids

    private final EntityManager entityManager;

    private int shotSpeed = 20;
    private final int shotDelay = 200; // Delay between shots in milliseconds
    private float fireRate = 1; // 1=normal; lower fireRate -> higher shotDelay; higher fireRate -> lower shotDelay
    private long lastFire;

    private static final int speedMod = 300;
    private float speedCurrent = 2;

    public static int getSize() {
        return 200;
    }

    public Player(Vector2 position, Vector2 direction, EntityManager entityManager, boolean playerTwo, byte gameMode) {
        super(TextureManager.PLAYER_LEFT, position, direction);
        this.entityManager = entityManager;
        this.playerTwo = playerTwo;
        this.gameMode = gameMode;
        if (playerTwo)
            sprite = new Sprite(TextureManager.PLAYER_RIGHT);
        else
            sprite.flip(true, false);


        size = getSize();
        health = 900;
    }

//    @Override
//    public Circle getBounds() {
//        if (playerTwo)
//            return new Circle(new Vector2(position.x + 63, position.y + 63), 50);
//        else
//            return new Circle(new Vector2(position.x + 68, position.y + 65), 50);
//
//    }

    private Vector2 getShotVector() {
        Vector2 v = entityManager.getMousePos();
        v.sub(position);
        v.add(Reticle.getSize(), Reticle.getSize());
        v.sub(size, size);
        v.setLength(shotSpeed);
        return v;

    }

    @Override
    public void update() {

        position.add(velocity);
        {
            Vector2 v = new Vector2(0, 0);

            if (playerTwo) {
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && position.x >= JosijaluGameClass.WIDTH / 2)
                    --v.x;
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && position.x <= JosijaluGameClass.WIDTH - size)
                    ++v.x;
                if (Gdx.input.isKeyPressed(Input.Keys.UP) && position.y <= JosijaluGameClass.HEIGHT - size)
                    ++v.y;
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && position.y >= 0)
                    --v.y;
            } else {
                if (Gdx.input.isKeyPressed(Input.Keys.A) && position.x >= 0)
                    --v.x;
                if (Gdx.input.isKeyPressed(Input.Keys.D) && position.x <= JosijaluGameClass.WIDTH / 2 - size)
                    ++v.x;
                if (Gdx.input.isKeyPressed(Input.Keys.W) && position.y <= JosijaluGameClass.HEIGHT - size)
                    ++v.y;
                if (Gdx.input.isKeyPressed(Input.Keys.S) && position.y >= 0)
                    --v.y;
            }
            v.setLength(speedCurrent * speedMod);
            setVelocity(v);
        }
        switch (gameMode) {
            case 0:
                if (System.currentTimeMillis() - lastFire >= shotDelay / fireRate) {
                    Vector2 v = new Vector2(playerTwo ? -1 : 1, 0);
                    v.setLength(shotSpeed);
                    entityManager.addEntity(new Missile(position.cpy().add((playerTwo ? 0 : 1) * size - Missile.getSize() / (playerTwo ? -2 : 2), (size - Missile.getSize()) / 2), v, playerTwo));
                    lastFire = System.currentTimeMillis();
                }
                break;
            case 1:
                if (System.currentTimeMillis() - lastFire >= shotDelay / fireRate && playerTwo) {
                    entityManager.addEntity(new Missile(position.cpy().add(Missile.getSize() / 2, (size - Missile.getSize()) / 2), getShotVector(), true));
                    lastFire = System.currentTimeMillis();
                }
                break;
            case 2:
                break;


//            if (playerTwo) {
////            if (Gdx.input.isButtonPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT)) {
//                if (System.currentTimeMillis() - lastFire >= shotDelay / fireRate) {
//                    entityManager.addEntity(new Missile(position.cpy().add(Missile.getSize() / 2, (size - Missile.getSize()) / 2), getShotVector(), true));
//                    lastFire = System.currentTimeMillis();
//                }
////            }
//            } else if (gameMode != 1) {
////            if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
//                if (System.currentTimeMillis() - lastFire >= shotDelay / fireRate) {
//                    entityManager.addEntity(new Missile(position.cpy().add(size - Missile.getSize() / 2, (size - Missile.getSize()) / 2), getShotVector(), false));
//                    lastFire = System.currentTimeMillis();
//                }
////            }
//
//            }
        }
    }
}
