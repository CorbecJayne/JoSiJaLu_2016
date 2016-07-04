package com.mygdx.josijalu_game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;


/**
 * Created by Yuanren on 04/07/2016.
 */
public class SoundManager {
// Er mag es irgendwie nicht wenn ich den "shot" deklariere...
//    public static Sound shot = Gdx.audio.newSound(Gdx.files.internal("assets/sound/magic_shot_3.wav"));
    public static Sound gameOver = Gdx.audio.newSound(Gdx.files.internal("assets/sound/game_start.wav"));
    public static Sound gameStart = Gdx.audio.newSound(Gdx.files.internal("assets/sound/game_start_2.wav"));
    public static Sound hit = Gdx.audio.newSound(Gdx.files.internal("assets/sound/fire_hit.wav"));
    public static Sound pigLaugh = Gdx.audio.newSound(Gdx.files.internal("assets/sound/pig_laugh.mp3"));

    public static Music ambientNoise = Gdx.audio.newMusic(Gdx.files.internal("assets/sound/ambient_noise.wav"));

// ...bzw. wenn ich backgroundMusic deklariere.
//    public static Music backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/music/in-game_music.mp3"));
// es scheint am encoding dieser Dateien zu liegen?




}
