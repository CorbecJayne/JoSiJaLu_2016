package com.josijalu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MainMenuScreen implements Screen {

    final MainMenu game;
    OrthographicCamera camera;
    private Stage stage;
    private Skin skin;


    public MainMenuScreen(final MainMenu gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.width, game.height);

        //following things are just for a few buttons
        //(copied from: http://www.sadafnoor.com/blog/how-to-create-simple-menu-in-libgdx/)
        //and changed it a little for more than one button
        stage = new Stage();
        skin = new Skin();
        Gdx.input.setInputProcessor(stage);
        game.font.getScaleX();
        game.font.getScaleY();
        skin.add("default", game.font);
        Pixmap pixmap = new Pixmap(400, 70, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));
        // Configure a TextButtonStyle and name it "default".
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
        textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
        //button Singleplayer:
        // Create a button with the "default" TextButtonStyle.
        final TextButton textButton = new TextButton("Singleplayer", textButtonStyle);
        textButton.setPosition(game.width/2-200, game.height/2+110);
        stage.addActor(textButton);
        textButton.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                textButton.setText("Loading...");
                game.setScreen(new JoSiJaLu(game));
                dispose();
            }
        });
        //button Join:
        // Create a button with the "default" TextButtonStyle.
        final TextButton textButton_Join = new TextButton("Join Lan-Game", textButtonStyle);
        textButton_Join.setPosition(game.width/2-200, game.height/2+20);
        stage.addActor(textButton_Join);
        textButton_Join.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                textButton_Join.setText("Join Lan-Game (Coming soon)");
            }
        });
        //button Host:
        // Create a button with the "default" TextButtonStyle.
        final TextButton textButton_Host = new TextButton("Host Server", textButtonStyle);
        textButton_Host.setPosition(game.width/2-200, game.height/2-70);
        stage.addActor(textButton_Host);
        textButton_Host.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                textButton_Host.setText("Host Server (Coming soon)");
            }
        });
        //button Quit Game:
        // Create a button with the "default" TextButtonStyle.
        final TextButton textButton_Exit = new TextButton("Quit Game", textButtonStyle);
        textButton_Exit.setPosition(game.width/2-200, game.height/2-160);
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
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to TurfWars", game.width/2-75, game.height/2+300);
        game.batch.end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
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

    @Override
    public void dispose() {

    }


}