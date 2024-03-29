package com.dentheripper.trying.BuildElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dentheripper.trying.GameCore.Assets;

import java.util.ArrayList;

public class SliderBase extends Actor implements Disposable {

    public Stage stage;
    public Skin skin;
    public Slider slider;
    private final ArrayList<Float> xPos = new ArrayList<>();

    public SliderBase(float x, float y, float width, float height) {
        float w = Assets.w;
        float h = Assets.h;
        xPos.add(x);

        stage = new Stage(new StretchViewport(1000, 1000 * (h / w)));
        Gdx.input.setInputProcessor(stage);

        skin = new Skin();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("Atlas/sliderStyle.txt"));
        skin.addRegions(atlas);
        Slider.SliderStyle sliderStyle = new Slider.SliderStyle();
        sliderStyle.background = skin.getDrawable("slider");
        sliderStyle.knob = skin.getDrawable("forSlider");

        slider = new Slider(0, 1, 0.01f, false, sliderStyle);
        slider.setPosition(x, y*(h/w));
        slider.setSize(width, height*(h/w));

        stage.addActor(slider);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        slider.draw(batch, parentAlpha);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }


    public float getPos() {
        return slider.getValue();
    }

    public void addToClose() {
        this.moveButton(1500, this.getButtonY());
    }

    public void open() {
        this.moveButton(this.xPos.get(0), this.getButtonY());
    }

    public float getButtonX() {
        return slider.getX();
    }

    public float getOriginX() {
        return this.xPos.get(0);
    }

    public float getButtonY() {
        return slider.getY();
    }

    public void moveButton(float x, float y) {
        slider.setPosition(x, y);
    }
}
