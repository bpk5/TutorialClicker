package com.bartekbpk.game;

import com.badlogic.gdx.Game;
import com.bartekbpk.screens.SplachScreen;


// TODO: 29.06.17 tutorial 4. 15 minut
public class TutorialClickerGame extends Game {

    public static int licznik = 0;

    public final static String GAME_NAME = "Tutorial Clicker";

	public final static int WIDTH = 480;
    public final static int HEIGHT = 700;

    private  boolean paused; // Flag: true - game stopped, false - game play
	
	@Override
	public void create () {
        // To splachScrean we pass this object.
        this.setScreen(new SplachScreen(this));
	}

    /**
     * -------------------------------
     * getters and setters
     *
     */

    public boolean isPaused() {
        return paused;
    }

    // Setter
    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
