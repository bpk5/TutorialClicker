package com.bartekbpk.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.bartekbpk.game.TutorialClickerGame;
import com.bartekbpk.entities.Player;
import com.bartekbpk.ui.IClickCallback;
import com.bartekbpk.ui.PlayerButton;
import com.bartekbpk.ui.ResetScoreButton;

public class GamePlayScreen extends AbstractScreen {

    private Texture bgTexture;
    private Player player;
    private PlayerButton playerButton;
    private ResetScoreButton resetScoreButton;
    private Label scoreLabel;

    public GamePlayScreen(TutorialClickerGame game) {
        super(game);
    }

    @Override
    protected void initial() {
        bgTexture = new Texture("background.jpg");
        initPlayer();
        initPlayerButton();
        initResetScoreButton();
        initScoreLabel();
    }

    private void initResetScoreButton() {
        resetScoreButton = new ResetScoreButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.resetGameScore();
            }
        });

        stage.addActor(resetScoreButton);
    }

    private void initScoreLabel() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = new BitmapFont();
        scoreLabel = new Label("", style);
        scoreLabel.setX(20);
        scoreLabel.setY(650);
        stage.addActor(scoreLabel);

    }

    private void initPlayerButton() {
        playerButton = new PlayerButton(new IClickCallback() {
            @Override
            public void onClick() {
                player.reactOnClick();
                game.addPoint();
            }
        });

        stage.addActor(playerButton);
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
        spriteBatch.draw(bgTexture, 0, -100);
        spriteBatch.end();

        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        scoreLabel.setText("Score: " + game.getPoint());
        stage.act();
    }
}
