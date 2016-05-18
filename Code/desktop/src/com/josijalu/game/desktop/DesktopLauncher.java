package com.josijalu.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.josijalu.game.JoSiJaLu;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//creating a window
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "TurfWars";
		config.width = 800;
		config.height = 800;
		config.resizable = false;
		new LwjglApplication(new JoSiJaLu(), config);
	}
}
