package com.dentheripper.trying.BuildElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dentheripper.trying.GameCore.Engine;

import java.util.ArrayList;


public class ScreenBase implements Screen {

    public Engine engine;
    private static final SpriteBatch batch = new SpriteBatch();
    protected OrthographicCamera camera;
    protected Stage stage;
    protected InputMultiplexer multiplexer;

    protected ArrayList<ButtonBase> buttons = new ArrayList<>();
    protected ArrayList<CheckBoxBase> checkBoxes = new ArrayList<>();
    protected ArrayList<SliderBase> sliders = new ArrayList<>();
    protected ArrayList<TextFieldBase> fields = new ArrayList<>();

    public float w = Gdx.graphics.getWidth();
    public float h = Gdx.graphics.getHeight();

    protected Image bg;

    public ScreenBase(Engine engine) {
        this.engine = engine;
        camera = new OrthographicCamera(1000, 1000 * (h / w));
        stage = new Stage(new StretchViewport(1000, 1000 * (h/w)));
        multiplexer = new InputMultiplexer();
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();

    }

    @Override
    public void show() {
        stage.getViewport().setCamera(camera);
        Gdx.input.setInputProcessor(stage);
        stage.addActor(bg);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
    }

    protected void actFinal(float delta) {
        for (int i = 0; i < buttons.size(); i++) buttons.get(i).act(delta);
        for (int i = 0; i < fields.size(); i++) fields.get(i).act(delta);
        for (int i = 0; i < sliders.size(); i++) sliders.get(i).act(delta);
        for (int i = 0; i < checkBoxes.size(); i++) checkBoxes.get(i).act(delta);
        stage.act(delta);
        stage.draw();
    }

    protected void setBG(Texture texture, float width, float height) {
        bg = new Image(texture);
        bg.setPosition(0,0);
        bg.setSize(width, height);
    }

    protected void draw(Texture texture, float x, float y, float width, float height) {
        batch.draw(texture, x, y, width, height);
    }

    protected void addObject(ButtonBase btn) {
        buttons.add(btn);
        stage.addActor(btn);
        multiplexer.addProcessor(btn.stage);
    }

    protected void addObject(SliderBase slider) {
        sliders.add(slider);
        stage.addActor(slider);
        multiplexer.addProcessor(slider.stage);
    }

    protected void addObject(CheckBoxBase cbb) {
        checkBoxes.add(cbb);
        stage.addActor(cbb);
        multiplexer.addProcessor(cbb.stage);
    }

    protected void addObject(TextFieldBase tfb) {
        fields.add(tfb);
        stage.addActor(tfb);
        multiplexer.addProcessor(tfb.stage);
    }

    protected void removeObject(ButtonBase app) {
        buttons.remove(app);
        stage.addAction(Actions.removeActor());
        multiplexer.removeProcessor(app.stage);
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        engine.dispose();
        stage.dispose();
        batch.dispose();
    }
}
