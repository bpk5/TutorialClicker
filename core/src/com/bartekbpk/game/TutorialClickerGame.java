package com.bartekbpk.game;

import com.badlogic.gdx.Game;
import com.bartekbpk.screens.SplachScreen;


// TODO: 29.06.17 tutorial 4. 15 minut
public class TutorialClickerGame extends Game {

    public final static String GAME_NAME = "Tutorial Clicker";

	public final static int WIDTH = 480;
    public final static int HEIGHT = 700;

    private  boolean paused; // Flag: true - game stopped, false - game play

    private int point;
	
	@Override
	public void create () {
        // To splachScrean we pass this object.
        this.setScreen(new SplachScreen(this));
	}

	public void addPoint() {
        point++;
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

    public int getPoint() {
        return point;
    }
}
