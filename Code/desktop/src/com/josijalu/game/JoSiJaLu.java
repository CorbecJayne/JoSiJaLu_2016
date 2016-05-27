package com.josijalu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;

public class JoSiJaLu implements Screen {
    final MainMenu game;
    private OrthographicCamera camera;
    private Texture projectile_graphic;
    public SpriteBatch batch;
    private Player player;
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Projectile> bullets = new ArrayList<Projectile>();

    //creating objects
    public JoSiJaLu(final MainMenu game) {
        this.game = game;
        //create a camera view
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.width, game.height);
        //this is important for the grafical stuff
        game.batch = new SpriteBatch();
        //creating the player incl. graphic
        player = new Player("bird", new Vector2(1856, 0));
        projectile_graphic = new Texture(Gdx.files.internal("graphics/projectile.png"));
    }

    @Override
    public void show() {

    }

    //frames
    @Override
    public void render(float delta) {
        //return to the menu if "Esc" is pressed
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new MainMenuScreen(game));
        }
        //clearing the screen
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //update the camera view (camera is fullscreen so until now there is nothing to update)
        camera.update();
        //makes the player move with ste speed that is saved in his class
        int speed = player.getSpeed();
        float x = player.getPosition().x;
        float y = player.getPosition().y;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) x -= speed * 100 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.D)) x += speed * 100 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.S)) y -= speed * 100 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.W)) y += speed * 100 * Gdx.graphics.getDeltaTime();
        if (x < 0) x = 0;
        if (x > game.width - player.getSize()) x = game.width - player.getSize();
        if (y < 0) y = 0;
        if (y > game.height - player.getSize()) y = game.height - player.getSize();
        player.setPosition(x, y);
        //update the mouse position in the Playerclass
        player.update_mouse_position();
        //handle the shooting
        if (Gdx.input.isButtonPressed(Input.Keys.LEFT) && bullets.isEmpty()) {
            bullets.add(new Projectile(player.getPosition(), player.getDirectionVector(), player));
        }
        //camera stuff combined with drawing stuff
        game.batch.setProjectionMatrix(camera.combined);
        //drawing the objects
        game.batch.begin();
        game.batch.draw(player.getGraphic(), player.getPosition().x, player.getPosition().y, player.getSize(), player.getSize());
        game.batch.draw(player.getGraphicAim(), player.getMouse_position().x, player.getMouse_position().y, 64, 64);
        //showing the Bullets and removing them if they traveled to far
        Iterator<Projectile> bulletsI = bullets.iterator();
        while (bulletsI.hasNext()) {
            Projectile bullet = bulletsI.next();
            if (bullet.getLoops() > 50) {
                bulletsI.remove();
            } else {
                bullet.next();
                game.batch.draw(projectile_graphic, bullet.getPosition().x, bullet.getPosition().y, 64, 64);
            }
        }
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    //cleanup if closing the game screen
    @Override
    public void dispose() {
        player.getGraphic().dispose();
        player.getGraphicAim().dispose();
        batch.dispose();
        projectile_graphic.dispose();
    }
}
