package com.bartekbpk.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.bartekbpk.game.TutorialClickerGame;

/**
 * Ekran powitalny.
 */
public class SplachScreen extends com.bartekbpk.screens.AbstractScreen {

    private Texture splashImg;

    public SplachScreen(final TutorialClickerGame game) {
        super(game);

        // Timer - uruchamia metodę run po 1 s.
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new com.bartekbpk.screens.GamePlayScreen(game));
            }
        }, 1);
    }

    @Override
    protected void initial() {
        // TODO: 27.06.17 implement better assets loading when game graws
        splashImg = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        spriteBatch.draw(splashImg, 0, 0);
        spriteBatch.end();
    }
}
