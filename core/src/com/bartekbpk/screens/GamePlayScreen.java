package com.bartekbpk.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.bartekbpk.game.TutorialClickerGame;
import com.bartekbpk.entities.Player;

public class GamePlayScreen extends AbstractScreen {

    private Player player;
    private Button playerButton;
    private Label scoreLabel;

    public GamePlayScreen(TutorialClickerGame game) {
        super(game);
    }

    @Override
    protected void initial() {
        initPlayer();
        initPlauerButton();
        initScoreLabel();
    }

    private void initScoreLabel() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = new BitmapFont();
        scoreLabel = new Label("", style);
        scoreLabel.setX(20);
        scoreLabel.setY(650);
        stage.addActor(scoreLabel);

    }

    private void initPlauerButton() {
        playerButton = new Button(new Button.ButtonStyle());
        playerButton.setWidth(460);
        playerButton.setHeight(360);
        playerButton.setX(10);
        playerButton.setY(170);
        playerButton.setDebug(true); // If button is transparent, appears frames.

        stage.addActor(playerButton);

        playerButton.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                //System.out.println("click");
                player.reactOnClick();
                game.addPoint();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
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
