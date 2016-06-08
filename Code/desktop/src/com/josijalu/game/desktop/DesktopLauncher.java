package com.josijalu.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.josijalu.game.MainMenu;

public class DesktopLauncher {
    public static void main (String[] arg) {
        //creating a window
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "TurfWars";
        config.width = 1680;
        config.height = 1040;
        config.resizable = false;
        config.fullscreen = true;
        config.vSyncEnabled = true;
        new LwjglApplication(new MainMenu(), config);
    }
}