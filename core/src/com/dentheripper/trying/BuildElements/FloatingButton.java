package com.dentheripper.trying.BuildElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class FloatingButton extends Actor {

    public Stage stage;
    private Image image;
    private boolean clicked = false;

    public FloatingButton(String path, float x, float y, float width, float height) {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        stage = new Stage(new StretchViewport(1000, 1000 * (h / w)));
        Gdx.input.setInputProcessor(stage);

        image = new Image(new Texture(Gdx.files.internal(path)));
        image.setPosition(x, y);
        image.setSize(width, height);

        stage.addActor(image);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        image.draw(batch, parentAlpha);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        image.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                setClicked(true);
                System.out.println("Truuu");
            }
        });
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
