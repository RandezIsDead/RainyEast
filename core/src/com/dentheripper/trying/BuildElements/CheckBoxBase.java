package com.dentheripper.trying.BuildElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;

public class CheckBoxBase extends Actor {

    public Stage stage;
    private CheckBox checkBox;
    private ArrayList<Float> xPos = new ArrayList<>();

    public CheckBoxBase(float x, float y, float width, float height) {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        xPos.add(x);

        stage = new Stage(new StretchViewport(1000, 1000 * (h / w)));
        Gdx.input.setInputProcessor(stage);

        BitmapFont font;
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\\\/?-+=()*&.;:,{}\\\"´`'<>";
        parameter.size = (int) (Gdx.graphics.getWidth() * .025f);
        String FONT_PATH = "Fonts/eww.ttf";
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        font = generator.generateFont(parameter);

        Skin skin = new Skin();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("Atlas/checkBoxStyle.txt"));
        skin.addRegions(atlas);
        CheckBox.CheckBoxStyle style = new CheckBox.CheckBoxStyle();
        style.font = font;
        style.fontColor = Color.BLUE;
        style.checkboxOff = skin.getDrawable("cbOff");
        style.checkboxOn = skin.getDrawable("cbOn");

        checkBox = new CheckBox("", style);
        checkBox.setPosition(x, y*(h/w));
        checkBox.setSize(width, height*(h/w));
        stage.addActor(checkBox);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        checkBox.draw(batch, parentAlpha);
        stage.draw();
    }

    public void addToClose() {
        this.moveButton(1500, this.getButtonY());
    }

    public void open() {
        this.moveButton(this.xPos.get(0), this.getButtonY());
    }

    public float getButtonX() {
        return checkBox.getX();
    }

    public float getOriginX() {
        return this.xPos.get(0);
    }

    public float getButtonY() {
        return checkBox.getY();
    }

    public void moveButton(float x, float y) {
        checkBox.setPosition(x, y);
    }
}
