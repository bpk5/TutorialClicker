package com.bartekbpk.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


/**
 * Created by Bartlomiej Kulesa on 09.07.17.
 */

public class ResetScoreButton extends Button {
    public ResetScoreButton(final IClickCallback callback) {
        super(new ButtonStyle());
        initial(callback);
    }

    private void initial(final IClickCallback callback) {
        this.setWidth(100);
        this.setHeight(100);
        this.setX(330);
        this.setY(560);
        this.setDebug(true);

        this.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
