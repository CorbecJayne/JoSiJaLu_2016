package com.josijalu.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Projectile {

    private Vector2 position;
    private Vector2 velocity;
    private Player shooter;
    private int loops = 0;
    private int size = 64;
    private Rectangle projectile_hitbox;

    public Projectile(Vector2 pos, Vector2 vel, Player newShooter) {
        position = new Vector2(pos);
        position.add(32,32);
        velocity = vel;
        shooter = newShooter;
        projectile_hitbox = new Rectangle(position.x, position.y, getSize(), getSize());

    }

    //calculates the next pos of the moved on Bullet
    public void next() {
        position = getPosition().add(getVelocity());
        loops++;
        projectile_hitbox.set(position.x, position.y, getSize(), getSize());
    }

    //getter und setter

    private Vector2 getVelocity() {
        return new Vector2(velocity);
    }

    public int getSize() {
        return size;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getProjectile_hitbox() {
        return projectile_hitbox;
    }

    public Player getShooter() {
        return shooter;
    }

    public int getLoops() {
        return loops;
    }

}
