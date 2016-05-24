package com.josijalu.game;

import com.badlogic.gdx.math.Vector2;

public class Projectile {

    private Vector2 pos;
    private Vector2 velocity;
    private Player shooter;
    private int loops = 0;

    public Projectile(Vector2 pos, Vector2 velocity, Player shooter) {
        this.pos = pos;
        this.velocity = velocity;
        this.shooter = shooter;

    }

    //calculates the next pos of the moved on Bullet
    public void next() {
        pos = pos.add(getVelocity());
        loops++;
    }

    //getter und setter

    private Vector2 getVelocity() {
        return velocity;
    }
    public Vector2 getPosition() {
        return pos;
    }

    private void setPosition(Vector2 pos) {
        this.pos = pos;
    }

    public Player getShooter() {
        return shooter;
    }

    public int getLoops() {
        return loops;
    }

    private void setShooter(Player shooter) {
        this.shooter = shooter;
    }

}
