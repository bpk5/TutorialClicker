package com.bartekbpk.game;

import com.badlogic.gdx.Game;
import com.bartekbpk.screens.SplachScreen;

public class TutorialClickerGame extends Game {

    public final static String GAME_NAME = "Tutorial Clicker";

	public final static int WIDTH = 480;
    public final static int HEIGHT = 700;

    private  boolean paused; // Flaga czy gra jest zapałzowana.
	
	@Override
	public void create () {
        // Do splachScrean przekazujemy ten obiekt.
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
