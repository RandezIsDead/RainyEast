package com.dentheripper.trying.BuildElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.security.Key;
import java.util.ArrayList;


public class TextFieldBase extends Actor {

    public Stage stage;
    public TextField field;
    private boolean clicked = false;
    private ArrayList<Float> xPos = new ArrayList<>();

    public TextFieldBase(float x, float y, float width, float height) {
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
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("Atlas/textField.txt"));
        skin.addRegions(atlas);
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.background = skin.getDrawable("tfBG");
        style.cursor = skin.getDrawable("cursor");
        style.selection = skin.getDrawable("selection");
        style.font = font;
        style.fontColor = Color.WHITE;

        field = new TextField("", style);
        field.setPosition(x, y * (h / w));
        field.setSize(width, height * (h / w));
        field.setAlignment(Align.center);

        stage.addActor(field);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        field.draw(batch, parentAlpha);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        field.setTextFieldListener(new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char c) {}
        });
    }

    public void addToClose() {
        this.moveButton(1500, this.getButtonY());
    }

    public void open() {
        this.moveButton(this.xPos.get(0), this.getButtonY());
    }

    public float getButtonX() {
        return field.getX();
    }

    public float getOriginX() {
        return this.xPos.get(0);
    }

    public float getButtonY() {
        return field.getY();
    }

    public void moveButton(float x, float y) {
        field.setPosition(x, y);
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
