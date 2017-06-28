package com.gmail.bartek.bpk.screens;

import com.gmail.bartekbpk.TutorialClickerGame;
import com.gmail.bartekbppk.entities.Player;

public class GamePlayScreen extends AbstractScreen {

    private Player player;

    public GamePlayScreen(TutorialClickerGame game) {
        super(game);
        initial();
    }

    private void initial() {
        initPlayer();
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        stage.act();
    }
}
