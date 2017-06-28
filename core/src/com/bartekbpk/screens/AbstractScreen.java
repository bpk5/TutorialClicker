package com.bartekbpk.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.bartekbpk.game.TutorialClickerGame;

/**
 * Po tej klasie dziedziczą wszystkie screeny.
 * Kod do zaimplementowania w innych projektach.
 */
public abstract class AbstractScreen implements Screen {

    protected TutorialClickerGame game;

    protected Stage stage; // Scena dla aktorów.
    private OrthographicCamera camera;

    protected SpriteBatch spriteBatch;

    public AbstractScreen(TutorialClickerGame game) {
        this.game = game;
        createCamera();
        // Viewport - sprawdz w internecie, dopasowanie do ekranu, są rózne metody.
        stage = new Stage(new StretchViewport(TutorialClickerGame.WIDTH, TutorialClickerGame.HEIGHT));
        spriteBatch = new SpriteBatch();
        // Input będzie pobierany z stage (sceny dla aktorów).
        Gdx.input.setInputProcessor(stage);
    }

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, TutorialClickerGame.WIDTH, TutorialClickerGame.HEIGHT);
        camera.update();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void show() {

    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    // Aplikacja była w tle i wróciła.
    @Override
    public void resume() {
        // Flagę pause ustawiam na false.
        game.setPaused(false);
    }

    // Aplikacja byłą zatrzymana.
    @Override
    public void pause() {
        // Flagę pause ustawiam na true.
        game.setPaused(true);
    }

    @Override
    public void hide() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void dispose() {
        game.dispose();
    }
}
