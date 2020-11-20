package com.dentheripper.trying.BuildElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dentheripper.trying.GameCore.Data;
import com.dentheripper.trying.GameCore.Engine;


public class ScreenBase implements Screen {

    public Engine engine;
    protected static Data data = new Data();
    private static SpriteBatch batch = new SpriteBatch();
    protected OrthographicCamera camera;
    protected Stage stage;

    public float w = Gdx.graphics.getWidth();
    public float h = Gdx.graphics.getHeight();

    protected Image bg;

    public ScreenBase(Engine engine) {
        this.engine = engine;
        camera = new OrthographicCamera(1000, 1000 * (h / w));
        stage = new Stage(new StretchViewport(1000, 1000 * (h/w)));
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
