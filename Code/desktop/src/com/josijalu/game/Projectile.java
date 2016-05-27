package com.josijalu.game;

import com.badlogic.gdx.math.Vector2;

public class Projectile {

    private Vector2 position;
    private Vector2 velocity;
    private Player shooter;
    private int loops = 0;

    public Projectile(Vector2 pos, Vector2 vel, Player newShooter) {
        position = new Vector2(pos);
        velocity = vel;
        shooter = newShooter;

    }

    //calculates the next pos of the moved on Bullet
    public void next() {
        position = getPosition().add(getVelocity());
        loops++;
    }

    //getter und setter

    private Vector2 getVelocity() {
        return new Vector2(velocity);
    }
    public Vector2 getPosition() {
        return new Vector2(position);
    }

    public Player getShooter() {
        return shooter;
    }

    public int getLoops() {
        return loops;
    }

}
