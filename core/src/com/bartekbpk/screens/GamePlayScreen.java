package com.bartekbpk.screens;

import com.bartekbpk.game.TutorialClickerGame;
import com.bartekbpk.entities.Player;

public class GamePlayScreen extends com.bartekbpk.screens.AbstractScreen {

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
