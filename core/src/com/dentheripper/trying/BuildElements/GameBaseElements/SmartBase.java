package com.dentheripper.trying.BuildElements.GameBaseElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dentheripper.trying.BuildElements.ButtonBase;

import java.util.ArrayList;

public class SmartBase extends Actor {

    protected Stage stage;
    public InputMultiplexer multiplexer;

    private Image image;
    protected float w = Gdx.graphics.getWidth();
    protected float h = Gdx.graphics.getHeight();

    protected ArrayList<ButtonBase> buttons = new ArrayList<>();
    public ButtonBase back;
    public ButtonBase homeS;
    public ButtonBase stats;

    protected SmartBase(Stage stage) {
        this.stage = stage;
        back = new ButtonBase("Atlas/smart.txt", "backSmart", 890, 40, 75, 70);
        homeS = new ButtonBase("Atlas/smart.txt", "homeSmart", 813, 40, 75, 70);
        stats = new ButtonBase("Atlas/smart.txt", "stats", 735, 40, 75, 70);
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(back.stage);
        multiplexer.addProcessor(homeS.stage);
        multiplexer.addProcessor(stats.stage);

        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        actFinal(parentAlpha);
    }

    protected void setImage(Texture texture) {
        image = new Image(texture);
        image.setPosition(700, 10 * (h / w));
        image.setSize(300, 980 * (h / w));

        stage.addActor(image);
        stage.addActor(back);
        stage.addActor(homeS);
        stage.addActor(stats);
    }

    protected void actFinal(float delta) {
        for (int i = 0; i < buttons.size(); i++) buttons.get(i).act(delta);
        back.act(delta);
        homeS.act(delta);
        stats.act(delta);
    }

    protected void addButton(ButtonBase app) {
        buttons.add(app);
        stage.addActor(app);
        multiplexer.addProcessor(app.stage);
    }

    protected void removeButton(ButtonBase btn) {
        buttons.remove(btn);
        stage.addAction(Actions.removeActor(btn));
        multiplexer.removeProcessor(btn.stage);
    }

    public void close() {
        stage.addAction(Actions.removeActor(image));
        stage.addAction(Actions.removeActor(back));
        stage.addAction(Actions.removeActor(homeS));
        stage.addAction(Actions.removeActor(stats));
        multiplexer.removeProcessor(back.stage);
        multiplexer.removeProcessor(homeS.stage);
        multiplexer.removeProcessor(stats.stage);
        for (int i = 0; i < buttons.size(); i++) {
            stage.addAction(Actions.removeActor(buttons.get(i)));
            multiplexer.removeProcessor(buttons.get(i).stage);
        }
    }

    public void show() {
        stage.addActor(image);
        stage.addActor(back);
        stage.addActor(homeS);
        stage.addActor(stats);
        multiplexer.addProcessor(back.stage);
        multiplexer.addProcessor(homeS.stage);
        multiplexer.addProcessor(stats.stage);
        for (int i = 0; i < buttons.size(); i++) {
            stage.addActor(buttons.get(i));
            multiplexer.addProcessor(buttons.get(i).stage);
        }
    }
}