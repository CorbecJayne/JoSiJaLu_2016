package com.mygdx.josijalu_game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.SoundManager;
import com.mygdx.josijalu_game.TextureManager;
import com.mygdx.josijalu_game.camera.OrthoCamera;
import com.mygdx.josijalu_game.entity.*;
import com.mygdx.josijalu_game.entity.hud.HUD;
import com.mygdx.josijalu_game.entity.hud.HealthBar;

/**
 * Created by User on 26.06.2016.
 */
public class GameScreen implements Screen {

    final JosijaluGameClass game;
    private OrthoCamera camera;

    private EntityManager entityManager;
    private HUD hud;

    private final byte gameMode; //0: Standard; 1: Defence; 2: Asteroids

    float totalTime = 60; //starting at 30 seconds
    static float playTime = 0; //time played

    public static float getPlayTime() {
        return playTime;
    }

    public static void setPlayTime(float playTime) {
        GameScreen.playTime = playTime;
    }

    private static int xBoundaries = 150;
    private static int yBoundaries = 50;
    private static int riverWidth = 200;

    public static int getxBoundaries() {
        return xBoundaries;
    }

    public static int getyBoundaries() {
        return yBoundaries;
    }

    public static int getRiverWidth() {
        return riverWidth;
    }


    public GameScreen(final JosijaluGameClass game, final byte gameMode) {

        SoundManager.gameStart.play();
        SoundManager.ambientNoise.play();

        this.gameMode = gameMode;

        this.game = game;
        camera = new OrthoCamera();

        entityManager = new EntityManager(game, gameMode);

        if (gameMode == 1)
            entityManager.addEntity(new Reticle(entityManager));

        entityManager.addEntity(new Player(new Vector2(300, (JosijaluGameClass.HEIGHT - 200) / 2), new Vector2(0, 0), entityManager, false, gameMode));
        entityManager.addEntity(new Player(new Vector2((JosijaluGameClass.WIDTH + GameScreen.getRiverWidth()) / 2 - 50, (JosijaluGameClass.HEIGHT - 200) / 2), new Vector2(0, 0), entityManager, true, gameMode));
        entityManager.addEntity(new Tortoise(new Vector2(JosijaluGameClass.WIDTH  / 2- 100, JosijaluGameClass.HEIGHT + 200), new Vector2(0, 0)));
        entityManager.addEntity(new PowerUp(new Vector2(0,0), new Vector2(0,0)));

        hud = new HUD();

        hud.addElement(new HealthBar(entityManager.getPlayers().first()));
        if (gameMode != 1)
            hud.addElement(new HealthBar(entityManager.getPlayers().get(1)));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //return to the menu if "Esc" is pressed
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            dispose();
            game.setScreen(new MainMenuScreen(game));
        }

        float deltaTime = Gdx.graphics.getDeltaTime();
        playTime += deltaTime; //time gets larger
        totalTime -= deltaTime; //if counting down
        int seconds = ((int) totalTime);
        if (seconds <= 0 && gameMode == 1) {
            dispose();
            game.setScreen(new GameOverScreen(true, game));
        }

        camera.update();
        entityManager.update(camera);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(TextureManager.BACKGROUND, 0, 0, JosijaluGameClass.WIDTH, JosijaluGameClass.HEIGHT);
        if (gameMode == 1)
            game.font.draw(game.batch, "0:" + seconds, JosijaluGameClass.WIDTH / 2 + 50, JosijaluGameClass.HEIGHT / 2 + 450, 0, 0, false);
        entityManager.render(game.batch);
        hud.render(game.batch);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
    }

    @Override
    public void dispose() {

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
}
