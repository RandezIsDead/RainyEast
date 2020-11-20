package com.dentheripper.trying.BuildElements.GameBaseElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dentheripper.trying.BuildElements.ButtonBase;

import java.util.ArrayList;
import java.util.List;

public class SkillBranchBase extends Actor {

    private Stage stage;
    public InputMultiplexer multiplexer;
    private Image image;

    protected float w = Gdx.graphics.getWidth();
    protected float h = Gdx.graphics.getHeight();

    protected List<ButtonBase> skill = new ArrayList<>();
    private List<Float> xPos = new ArrayList<>();
    private List<Float> yPos = new ArrayList<>();

    protected SkillBranchBase(Texture texture) {
        multiplexer = new InputMultiplexer();
        stage = new Stage(new StretchViewport(1000, 1000 * (h / w)));
        Gdx.input.setInputProcessor(multiplexer);

        image = new Image(texture);
        image.setSize(300 ,763 * (h / w));
        image.setPosition(700, 128 * (h / w));

        stage.addActor(image);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        stage.draw();
    }

    protected void addSkill(String drawable, float x, float y) {
        ButtonBase buttonBase = new ButtonBase("smart/skillAtlas/skills.txt", drawable, x, y, (float) 50, (float) 80);
        skill.add(buttonBase);
        multiplexer.addProcessor(buttonBase.stage);
        stage.addActor(buttonBase);
        xPos.add(x);
        yPos.add(y);
    }

    public void open() {
        image.setPosition(700, 128 * (h/w));
        for (int i = 0; i < skill.size(); i ++) {
            skill.get(i).moveButton( xPos.get(i), yPos.get(i) * (h/w));
        }
    }

    public void close() {
        image.setPosition(1500, 128 * (h/w));
        for (int i = 0; i < skill.size(); i ++) {
            skill.get(i).moveButton( 1500, yPos.get(i) * (h/w));
        }
    }
}
