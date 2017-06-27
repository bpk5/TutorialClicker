package com.gmail.bartekbpk.com.gmail.bartekbpk.screens;

import com.badlogic.gdx.graphics.Texture;
import com.gmail.bartekbpk.TutorialClickerGame;

/**
 * Ekran powitalny.
 */
public class SplachScreen extends AbstractScreen {

    private Texture splashImg;

    public SplachScreen(TutorialClickerGame game) {
        super(game);
        initial();
    }

    private void initial() {
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
