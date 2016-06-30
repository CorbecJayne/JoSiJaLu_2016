package com.mygdx.josijalu_game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.josijalu_game.JosijaluGameClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "JoSiJaLu";
		config.useGL30 = true;
		config.width = JosijaluGameClass.WIDTH;
		config.height = JosijaluGameClass.HEIGHT;
		config.resizable = true;
		config.fullscreen = true;
		config.vSyncEnabled = true;

		new LwjglApplication(new JosijaluGameClass(), config);
	}
}