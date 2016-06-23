package com.josijalu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    final MainMenu game;
    private String team;
    private int speed;
    private boolean bullet_fired;
    private Vector2 position;
    private Vector2 mouse_position;
    private int player_size;
    private Rectangle player_hitbox;
    private Texture player_graphic;
    private Texture player_graphic_aim;

    public Player(String team, Vector2 position, MainMenu game) {
        //setting the player-team
        if (team == "bird" || team == "pig") this.team = team;
        else this.team = "bird";
        //movmentspeed of the Player
        speed = 3;
        //if the player has recently fired a bullet he can't fire another one
        bullet_fired = false;
        //position of the player
        this.position = position;
        //position the palyer is facing
        mouse_position = new Vector2(Gdx.input.getX(), Gdx.input.getY());
        //x- & y-size of the player
        player_size = 128;
        //the hitbox of the player, which can be checked with the overlap method of the Rectangle class
        player_hitbox = new Rectangle();
        player_hitbox.set(this.position.x, this.position.y, player_size, player_size);
        //the mouse-texture
        player_graphic_aim = new Texture(Gdx.files.internal("graphics/aim.png"));
        //the texture of the player depending on the team
        if (team == "bird")
            player_graphic = new Texture(Gdx.files.internal("graphics/bird_normal.png"));
        else if (team == "pig")
            player_graphic = new Texture(Gdx.files.internal("graphics/pig_normal.png"));
        this.game = game;
    }

    //updating the mouse position that the player is facing
    public void update_mouse_position() {
        mouse_position.set(Gdx.input.getX() - 32, -Gdx.input.getY() + 1040 - 32);
    }

    public float getDirectonAngle() {
        return getPosition().angle(getMouse_position());
    }

    public Vector2 getDirectionVector() {
        Vector2 v = getMouse_position();
        v = v.sub(getPosition());
        v = v.sub(32, 32);
        v = v.setLength(10F);
        return v;
    }

    //getter and setter methods

    public Texture getGraphic() {
        return player_graphic;
    }

    public Texture getGraphicAim() {
        return player_graphic_aim;
    }

    public Rectangle getPlayer_hitbox() {
        return player_hitbox;
    }

    public int getSize() {
        return player_size;
    }

    public void setSize(int player_size) {
        this.player_size = player_size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean isBullet_fired() {
        return bullet_fired;
    }

    public void setBullet_fired(boolean bullet_fired) {
        this.bullet_fired = bullet_fired;
    }

    public Vector2 getPosition() {
        return new Vector2(position);
    }

    public Vector2 getMouse_position() {
        return new Vector2(mouse_position);
    }

    public void setPosition(float position_x, float position_y) {
        position = new Vector2(position_x, position_y);
    }

    public void move(boolean w, boolean a, boolean s, boolean d) {
        int speed1 = getSpeed() * 100;
        float x1 = getPosition().x;
        float y1 = getPosition().y;
        //When holding down two Buttons at the same time, the Player will stop moving
        if(!w&&!a&&!s&&!d){}
        else if (w && s) {

        } else if (a && d) {

        }
        //When holding down a Button, the Player will move in one vertical or horizontal direction
        else if (a && !w && !s && !d) {
            x1 -= speed1 * Gdx.graphics.getDeltaTime();
        } else if (d && !w && !s && !a) {
            x1 += speed1 * Gdx.graphics.getDeltaTime();
        } else if (s && !w && !a && !d) {
            y1 -= speed1 * Gdx.graphics.getDeltaTime();
        } else if (w && !a && !s && !d) {
            y1 += speed1 * Gdx.graphics.getDeltaTime();
        }
        //When holding down two Buttons at the same time, the Player will move in one diagonal direction
        else if (a && s) {
            x1 -= (speed1 * Gdx.graphics.getDeltaTime()) / 2;
            y1 -= (speed1 * Gdx.graphics.getDeltaTime()) / 2;
        } else if (d && w) {
            x1 += (speed1 * Gdx.graphics.getDeltaTime()) / 2;
            y1 += (speed1 * Gdx.graphics.getDeltaTime()) / 2;
        } else if (s && d) {
            y1 -= (speed1 * Gdx.graphics.getDeltaTime()) / 2;
            x1 += (speed1 * Gdx.graphics.getDeltaTime()) / 2;
        } else if (w && a) {
            x1 -= (speed1 * Gdx.graphics.getDeltaTime()) / 2;
            y1 += (speed1 * Gdx.graphics.getDeltaTime()) / 2;
        }

        //Prove if players colliding with window border
        if (x1 < 0) x1 = 0;
        if (x1 > game.width - getSize()) x1 = game.width - getSize();
        if (y1 < 0) y1 = 0;
        if (y1 > game.height - getSize()) y1 = game.height - getSize();

        setPosition(x1, y1);

        //update the mouse position
        update_mouse_position();
    }

}