package com.bartekbpk.entities;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Player extends Image {

    private final static int WIDTH = 77;
    private final static int HEIGHT = 152;

    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 300;

    public Player() {
        super(new Texture("badlogic.jpg"));

        this.setOrigin(WIDTH / 2, HEIGHT / 2);
        this.setSize(WIDTH, HEIGHT);
        // Starting position
        this.setPosition(STARTING_X, STARTING_Y);
    }

    public void reactOnClick() {
        int moveAmount = MathUtils.random(-130, 130);
        Action moveAction = Actions.sequence(
                Actions.moveBy(moveAmount, 10, 3, Interpolation.circle),
                Actions.moveBy(-moveAmount, -10, 3, Interpolation.exp10In)
        );

        this.addAction(moveAction);
    }
}
