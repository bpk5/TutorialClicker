package com.bartekbpk.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Bartlomiej Kulesa on 10.07.17.
 */

public class ScoreLabel extends Label {
    public ScoreLabel() {
        super("", prepareLabelStyle());
        initial();
    }

    private void initial() {
        this.setX(20);
        this.setY(650);
    }

    private static LabelStyle prepareLabelStyle() {
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = new BitmapFont();
        return labelStyle;
    }
}
