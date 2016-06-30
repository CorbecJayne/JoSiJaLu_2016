package com.mygdx.josijalu_game.screen;

/**
 * Created by User on 26.06.2016.
 */
public class ScreenManager {

    private static Screen currentScreen;

    public static void setScreen(Screen screen) {
        if (currentScreen != null)
            currentScreen.dispose();
        currentScreen = screen;
        currentScreen.create();
    }

    public static Screen getCurrentScreen() {
        return currentScreen;
    }

}
