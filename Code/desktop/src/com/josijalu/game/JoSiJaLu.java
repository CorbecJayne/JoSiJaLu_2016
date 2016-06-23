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
    private Player player1;
    private Player player2;
//    private ArrayList<Player> players = new ArrayList<Player>(); Unused
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
        player1 = new Player("bird", new Vector2(0, 0));
        player2 = new Player("pig", new Vector2(1856, 0));
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

        //Movement Player 1
        //makes the player 1 move with the speed that is saved in his class
        int speed1 = player1.getSpeed()*100;
        float x1 = player1.getPosition().x;
        float y1 = player1.getPosition().y;
        //When holding down a Button, the Player will move in one vertical or horizontal direction
        if (Gdx.input.isKeyPressed(Input.Keys.A) &&! Gdx.input.isKeyPressed(Input.Keys.W) &&! Gdx.input.isKeyPressed(Input.Keys.S) &&! Gdx.input.isKeyPressed(Input.Keys.D)) {
            x1 -= speed1 * Gdx.graphics.getDeltaTime();
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.D) &&! Gdx.input.isKeyPressed(Input.Keys.W) &&! Gdx.input.isKeyPressed(Input.Keys.S) &&! Gdx.input.isKeyPressed(Input.Keys.A)) {
            x1 += speed1 * Gdx.graphics.getDeltaTime();
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.S) &&! Gdx.input.isKeyPressed(Input.Keys.W) &&! Gdx.input.isKeyPressed(Input.Keys.A) &&! Gdx.input.isKeyPressed(Input.Keys.D)){
            y1 -= speed1 * Gdx.graphics.getDeltaTime();
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.W) &&! Gdx.input.isKeyPressed(Input.Keys.A) &&! Gdx.input.isKeyPressed(Input.Keys.S) &&! Gdx.input.isKeyPressed(Input.Keys.D)){
            y1 += speed1 * Gdx.graphics.getDeltaTime();
        }
        //When holding down two Buttons at the same time, the Player will move in one diagonal direction
        else if (Gdx.input.isKeyPressed(Input.Keys.A) && Gdx.input.isKeyPressed(Input.Keys.S)) {
            x1 -= (speed1 * Gdx.graphics.getDeltaTime()) / 2;
            y1 -= (speed1 * Gdx.graphics.getDeltaTime()) / 2;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D) && Gdx.input.isKeyPressed(Input.Keys.W)) {
            x1 += (speed1 * Gdx.graphics.getDeltaTime()) / 2;
            y1 += (speed1 * Gdx.graphics.getDeltaTime()) / 2;
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.S) && Gdx.input.isKeyPressed(Input.Keys.D)) {

            y1 -= (speed1 * Gdx.graphics.getDeltaTime()) / 2;
            x1 += (speed1 * Gdx.graphics.getDeltaTime()) / 2;
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A)) {
            x1 -= (speed1 * Gdx.graphics.getDeltaTime())/ 2;
            y1 += (speed1 * Gdx.graphics.getDeltaTime())/ 2;
        }
        //When holding down two Buttons at the same time, the Player will stop moving
        else if (Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.S)) {

        }

        else if (Gdx.input.isKeyPressed(Input.Keys.A) && Gdx.input.isKeyPressed(Input.Keys.D)) {

        }


        //Movement Player 2
        //makes the player 2 move with the speed that is saved in his class
        int speed2 = player2.getSpeed()*100;
        float x2 = player2.getPosition().x;
        float y2 = player2.getPosition().y;
        //When holding down a Button, the Player will move in one vertical or horizontal direction
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
            x2 -= speed2 * Gdx.graphics.getDeltaTime();
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            x2 += speed2 * Gdx.graphics.getDeltaTime();
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)){
            y2 -= speed2 * Gdx.graphics.getDeltaTime();
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) &&! Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)){
            y2 += speed2 * Gdx.graphics.getDeltaTime();
        }
        //When holding down two Buttons at the same time, the Player will move in one diagonal direction
        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) && Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            x2 -= (speed2 * Gdx.graphics.getDeltaTime()) / 2;
            y2 -= (speed2 * Gdx.graphics.getDeltaTime()) / 2;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) && Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            x2 += (speed2 * Gdx.graphics.getDeltaTime()) / 2;
            y2 += (speed2 * Gdx.graphics.getDeltaTime()) / 2;
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) && Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {

            y2 -= (speed2 * Gdx.graphics.getDeltaTime()) / 2;
            x2 += (speed2 * Gdx.graphics.getDeltaTime()) / 2;
        }

        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) && Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            x2 -= (speed2 * Gdx.graphics.getDeltaTime())/ 2;
            y2 += (speed2 * Gdx.graphics.getDeltaTime())/ 2;
        }
        //When holding down two Buttons at the same time, the Player will stop moving
        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) && Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {

        }

        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT) && Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {

        }


        //Prove if players colliding with window border
        if (x1 < 0) x1 = 0;
        if (x1 > game.width - player1.getSize()) x1 = game.width - player1.getSize();
        if (y1 < 0) y1 = 0;
        if (y1 > game.height - player1.getSize()) y1 = game.height - player1.getSize();


        if (x2 < 0) x2 = 0;
        if (x2 > game.width - player2.getSize()) x2 = game.width - player2.getSize();
        if (y2 < 0) y2 = 0;
        if (y2 > game.height - player2.getSize()) y2 = game.height - player2.getSize();

        player1.setPosition(x1, y1);
        player2.setPosition(x2, y2);

        //update the mouse position in the Playerclass
        player1.update_mouse_position();
        //handle the shooting
        if (Gdx.input.isButtonPressed(Input.Keys.LEFT) && bullets.isEmpty()) {
            bullets.add(new Projectile(player1.getPosition(), player1.getDirectionVector(), player1));
        }
        //camera stuff combined with drawing stuff
        game.batch.setProjectionMatrix(camera.combined);
        //drawing the objects
        game.batch.begin();
        game.batch.draw(player1.getGraphic(), player1.getPosition().x, player1.getPosition().y, player1.getSize(), player1.getSize());
        game.batch.draw(player2.getGraphic(), player2.getPosition().x, player2.getPosition().y, player2.getSize(), player2.getSize());
        game.batch.draw(player1.getGraphicAim(), player1.getMouse_position().x, player1.getMouse_position().y, 64, 64);
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
        player1.getGraphic().dispose();
        player2.getGraphic().dispose();
        player1.getGraphicAim().dispose();
        batch.dispose();
        projectile_graphic.dispose();
    }
}
