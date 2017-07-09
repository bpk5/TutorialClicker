package com.bartekbpk.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bartekbpk.game.TutorialClickerGame;
import com.bartekbpk.entities.Player;
import com.bartekbpk.ui.IClickCallback;
import com.bartekbpk.ui.PlayerButton;

public class GamePlayScreen extends AbstractScreen {

    private Player player;
    private PlayerButton playerButton;
    private Button resetScoreButton;
    private Label scoreLabel;

    public GamePlayScreen(TutorialClickerGame game) {
        super(game);
    }

    @Override
    protected void initial() {
        initPlayer();
        initPlayerButton();
        initResetScoreButton();
        initScoreLabel();
    }

    private void initResetScoreButton() {
        resetScoreButton = new Button(new Button.ButtonStyle());
        resetScoreButton.setWidth(100);
        resetScoreButton.setHeight(100);
        resetScoreButton.setX(330);
        resetScoreButton.setY(560);
        resetScoreButton.setDebug(true);

        stage.addActor(resetScoreButton);

        resetScoreButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.resetGameScore();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
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
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        scoreLabel.setText("Score: " + game.getPoint());
        stage.act();
    }
}
