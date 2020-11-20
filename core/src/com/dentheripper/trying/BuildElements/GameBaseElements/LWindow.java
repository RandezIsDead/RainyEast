package com.dentheripper.trying.BuildElements.GameBaseElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dentheripper.trying.BuildElements.ButtonBase;

import java.util.ArrayList;

public class LWindow extends Actor {

    protected Stage stage;
    public InputMultiplexer multiplexer;

    private Image image;
    protected float w = Gdx.graphics.getWidth();
    protected float h = Gdx.graphics.getHeight();

    protected ArrayList<ButtonBase> buttons = new ArrayList<>();

    protected LWindow() {
        multiplexer = new InputMultiplexer();

        stage = new Stage(new StretchViewport(1000, 1000 * (h / w)));
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        actFinal(parentAlpha);
    }

    protected void setImage(String path) {
        Texture texture = new Texture(Gdx.files.internal(path));
        image = new Image(texture);
        image.setPosition(0, 0);
        image.setSize(1000, 1000 * (h / w));

        stage.addActor(image);
    }

    protected void actFinal(float delta) {
        for (int i = 0; i < buttons.size(); i++) buttons.get(i).act(delta);
        stage.act(delta);
        stage.draw();
    }

    protected void addButton(ButtonBase app) {
        buttons.add(app);
        stage.addActor(app);
        multiplexer.addProcessor(app.stage);
    }

    protected void removeButton(ButtonBase app) {
        buttons.remove(app);
        stage.addAction(Actions.removeActor());
        multiplexer.removeProcessor(app.stage);
    }

    public void close() {
        image.setPosition(1500, image.getY());
        for (int i = 0; i < buttons.size(); i++) buttons.get(i).addToClose();
    }

    public void show() {
        image.setPosition(0, image.getY());
        for (int i = 0; i < buttons.size(); i++) buttons.get(i).open();
    }
}
