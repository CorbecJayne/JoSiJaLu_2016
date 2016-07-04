package com.mygdx.josijalu_game.screen;

import com.mygdx.josijalu_game.SoundManager;
import shadering.Shadering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.camera.OrthoCamera;

/**
 * Created by User on 29.06.2016.
 */
public class MainMenuScreen implements Screen {

    final JosijaluGameClass game;
    private OrthoCamera camera;
    private Stage stage;
    private TextButton.TextButtonStyle textButtonStyle;
    private Pixmap pixmap;
    private Skin skin;
    private BitmapFont font;

    public MainMenuScreen(final JosijaluGameClass game) {
        if (SoundManager.ambientNoise.isPlaying() == true){
            SoundManager.ambientNoise.stop();
            SoundManager.ambientNoise.dispose();
        }
        this.game = game;
        camera = new OrthoCamera();
        stage = new Stage(new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera()),
                new SpriteBatch(1000, Shadering.createDefaultShader()));

        camera.resize();

        Gdx.input.setInputProcessor(stage);

        pixmap = new Pixmap(400, 70, Pixmap.Format.RGBA8888);
        skin = new Skin();
        font = new BitmapFont();
        textButtonStyle = new TextButton.TextButtonStyle();

        pixmap.setColor(Color.GREEN);
        pixmap.fill();

        skin.add("default", font);
        skin.add("white", new Texture(pixmap));
        skin.add("default", textButtonStyle);

        textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
        textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");

        //button Singleplayer:
        // Create a button with the "default" TextButtonStyle.
        final TextButton tbStandard = new TextButton("Standard", textButtonStyle);
        tbStandard.setPosition(JosijaluGameClass.WIDTH / 2 - 200, JosijaluGameClass.HEIGHT / 2 + 110);
        stage.addActor(tbStandard);
        tbStandard.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                tbStandard.setText("Loading...");
                dispose();
                game.setScreen(new GameScreen(game, (byte) 0));
            }
        });
        //button Join:
        // Create a button with the "default" TextButtonStyle.
        final TextButton tbAsteroids = new TextButton("Asteroids", textButtonStyle);
        tbAsteroids.setPosition(JosijaluGameClass.WIDTH / 2 - 200, JosijaluGameClass.HEIGHT / 2 + 20);
        stage.addActor(tbAsteroids);
        tbAsteroids.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                tbStandard.setText("Loading...");
                dispose();
                game.setScreen(new GameScreen(game, (byte) 2));
            }
        });
        //button Host:
        // Create a button with the "default" TextButtonStyle.
        final TextButton tbDefence = new TextButton("Defence", textButtonStyle);
        tbDefence.setPosition(JosijaluGameClass.WIDTH / 2 - 200, JosijaluGameClass.HEIGHT / 2 - 70);
        stage.addActor(tbDefence);
        tbDefence.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                tbStandard.setText("Loading...");
                dispose();
                game.setScreen(new GameScreen(game, (byte) 1));
            }
        });
        //button Quit Game:
        // Create a button with the "default" TextButtonStyle.
        final TextButton textButton_Exit = new TextButton("Quit Game", textButtonStyle);
        textButton_Exit.setPosition(JosijaluGameClass.WIDTH / 2 - 200, JosijaluGameClass.HEIGHT / 2 - 160);
        stage.addActor(textButton_Exit);
        textButton_Exit.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        //here the button code ends
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "The Epic Battle of Little Big River", JosijaluGameClass.WIDTH / 2 - 500, JosijaluGameClass.HEIGHT / 2 + 300);
        game.batch.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
    }

    @Override
    public void dispose() {
        stage.dispose();
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
