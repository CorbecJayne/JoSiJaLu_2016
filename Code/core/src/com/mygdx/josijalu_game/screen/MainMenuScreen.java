package com.mygdx.josijalu_game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.josijalu_game.JosijaluGameClass;
import com.mygdx.josijalu_game.camera.OrthoCamera;

/**
 * Created by User on 29.06.2016.
 */
public class MainMenuScreen extends Screen{

    private OrthoCamera camera;
    private Stage stage;
    private TextButton.TextButtonStyle textButtonStyle;
    private Pixmap pixmap;
    private Skin skin;
    private BitmapFont font;

    @Override
    public void create() {
        camera = new OrthoCamera();
        stage = new Stage();

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
        final TextButton textButton = new TextButton("Singleplayer", textButtonStyle);
        textButton.setPosition(JosijaluGameClass.WIDTH/2-200, JosijaluGameClass.HEIGHT/2+110);
        stage.addActor(textButton);
        textButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                textButton.setText("Loading...");
                ScreenManager.setScreen(new GameScreen());
                dispose();
            }
        });
        //button Join:
        // Create a button with the "default" TextButtonStyle.
        final TextButton textButton_Join = new TextButton("Join Lan-Game", textButtonStyle);
        textButton_Join.setPosition(JosijaluGameClass.WIDTH/2-200, JosijaluGameClass.HEIGHT/2+20);
        stage.addActor(textButton_Join);
        textButton_Join.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                textButton_Join.setText("Join Lan-Game (Coming soon)");
            }
        });
        //button Host:
        // Create a button with the "default" TextButtonStyle.
        final TextButton textButton_Host = new TextButton("Host Server", textButtonStyle);
        textButton_Host.setPosition(JosijaluGameClass.WIDTH/2-200, JosijaluGameClass.HEIGHT/2-70);
        stage.addActor(textButton_Host);
        textButton_Host.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                textButton_Host.setText("Host Server (Coming soon)");
            }
        });
        //button Quit Game:
        // Create a button with the "default" TextButtonStyle.
        final TextButton textButton_Exit = new TextButton("Quit Game", textButtonStyle);
        textButton_Exit.setPosition(JosijaluGameClass.WIDTH/2-200, JosijaluGameClass.HEIGHT/2-160);
        stage.addActor(textButton_Exit);
        textButton_Exit.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                dispose();
                Gdx.app.exit();
            }
        });
        //here the button code ends

    }

    @Override
    public void update() {
        camera.update();

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        Gdx.gl.glClearColor(0, 0, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        font.draw(spriteBatch, "Welcome to TurfWars", JosijaluGameClass.WIDTH/2-75, JosijaluGameClass.HEIGHT/2+300);
        spriteBatch.end();

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
}