package com.mygdx.josijalu_game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.JosijaluGameClass;

/**
 * Created by User on 26.06.2016.
 */
public abstract class Entity {

    protected Vector2 position, velocity;
    protected int size;
    protected Sprite sprite;

    public Entity(Texture texture, Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
        sprite = new Sprite(texture);
    }

    public abstract void update();

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.draw(sprite, position.x, position.y);

    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBoundsRect() {
        return new Rectangle(position.x, position.y, sprite.getWidth(), sprite.getHeight());

    }

    public Circle getBounds() {
        if (sprite.getWidth() == sprite.getHeight())
            return new Circle(position.x, position.y, sprite.getWidth() / 2);
        boolean portrait = sprite.getHeight() > sprite.getWidth();
        float min = Math.min(sprite.getWidth(), sprite.getHeight());
        float max = Math.max(sprite.getWidth(), sprite.getHeight());
        if (portrait)
            return new Circle(position.x, position.y + (max - min) / 2, min);
        else
            return new Circle(position.x + (max - min) / 2, position.y, min / 2);

    }

    public Ellipse getBoundsElps() {
        return new Ellipse(position.x, position.y, sprite.getWidth(), sprite.getHeight());

    }

    public void setDirection(float x, float y) {
        velocity.set(x, y);
        velocity.scl(Gdx.graphics.getDeltaTime());
    }

    public void setVelocity(Vector2 v) {
        velocity.set(v);
        velocity.scl(Gdx.graphics.getDeltaTime());
    }

    public boolean outOfBounds() {
        return position.x <= -sprite.getWidth() || position.x >= JosijaluGameClass.WIDTH || position.y <= -sprite.getHeight() || position.y >= JosijaluGameClass.HEIGHT;
    }

    public boolean outOfBounds(Vector2 position) {
        return position.x <= -sprite.getWidth() || position.x >= JosijaluGameClass.WIDTH || position.y <= -sprite.getHeight() || position.y >= JosijaluGameClass.HEIGHT;
    }

    public static boolean outOfBounds(Vector2 position, Texture texture) {
        return position.x <= -texture.getWidth() || position.x >= JosijaluGameClass.WIDTH || position.y <= -texture.getHeight() || position.y >= JosijaluGameClass.HEIGHT;
    }

}
