package com.bartekbpk.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.bartekbpk.screens.SplachScreen;


// TODO: 29.06.17 tutorial 6
public class TutorialClickerGame extends Game {

    public final static String GAME_PREFS = "com.bartekbpk.game.prefs";
    public final static String GAME_SCORE = "com.bartekbpk.game.prefs.score";

    public final static String GAME_NAME = "Tutorial Clicker";

	public final static int WIDTH = 480;
    public final static int HEIGHT = 700;

    private  boolean paused; // Flag: true - game stopped, false - game play

    private Preferences prefs;

    private int point;
	
	@Override
	public void create () {
        initial();
        // To splachScrean we pass this object.
        this.setScreen(new SplachScreen(this));
	}

    private void initial() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        loadScore();
    }

    private void loadScore() {
        point = prefs.getInteger(GAME_SCORE);
    }

    public void addPoint() {
        point++;
        updateSavedScoreInPrefs();
    }

    public void resetGameScore() {
        point = 0;
        updateSavedScoreInPrefs();
    }

    private void updateSavedScoreInPrefs() {
        prefs.putInteger(GAME_SCORE, point);
        prefs.flush();
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
