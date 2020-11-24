package com.dentheripper.trying.BuildElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dentheripper.trying.GameCore.Assets;

import java.util.ArrayList;

public class CheckBoxBase extends Actor {

    public Stage stage;
    public TextButton button;
    public BitmapFont font;
    private boolean checked = false;

    private final ArrayList<Float> xPos = new ArrayList<>();

    public CheckBoxBase(float x, float y, float width, float height) {
        xPos.add(x);

        float w = Assets.w;
        float h = Assets.h;
        stage = new Stage(new StretchViewport(1000, 1000 * (h / w)));
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();
        Skin skin = new Skin();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("Atlas/cbStyle.txt"));
        skin.addRegions(atlas);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = font;
        style.up = skin.getDrawable("off");
        style.checked = skin.getDrawable("on");
        button = new TextButton("", style);
        button.setPosition(x, y * (h / w));
        button.setSize(width, height * (h / w));

        stage.addActor(button);

        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (isChecked()) {
                    setChecked(false);
                    button.setChecked(isChecked());
                } else if (!isChecked()) {
                    setChecked(true);
                    button.setChecked(isChecked());
                }
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        button.draw(batch, parentAlpha);
        stage.draw();
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        button.setChecked(checked);
    }

    public void addToClose() {
        this.move(1500, this.getObjY());
    }

    public void open() {
        this.move(this.xPos.get(0), this.getObjY());
    }

    public float getObjX() {
        return button.getX();
    }

    public float getOriginX() {
        return this.xPos.get(0);
    }

    public float getObjY() {
        return button.getY();
    }

    public void move(float x, float y) {
        button.setPosition(x, y);
    }
}
