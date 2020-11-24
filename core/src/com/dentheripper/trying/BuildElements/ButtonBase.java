package com.dentheripper.trying.BuildElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dentheripper.trying.GameCore.Assets;

import java.util.ArrayList;

public class ButtonBase extends Actor{

    private Vector2 lastTouch = new Vector2();
    private Vector2 newTouch;

    public Stage stage;
    public TextButton button;
    private final TextButton.TextButtonStyle smartButtonStyle = new TextButton.TextButtonStyle();
    private final Skin skin = new Skin();
    public BitmapFont font = new BitmapFont();
    public FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    private final ArrayList<Float> xPos = new ArrayList<>();
    public float w = Assets.w;
    public float h = Assets.h;

    public ButtonBase(String atlasPath, String drawable, float x, float y, float width, float height) {
        xPos.add(x);

        stage = new Stage(new StretchViewport(1000, 1000 * (h / w)));
        Gdx.input.setInputProcessor(stage);

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(atlasPath));
        skin.addRegions(atlas);
        smartButtonStyle.font = font;
        smartButtonStyle.up = skin.getDrawable(drawable);
        button = new TextButton("", smartButtonStyle);
        button.setPosition(x, y * (h / w));
        button.setSize(width, height * (h / w));

        stage.addActor(button);
    }

    public ButtonBase(String atlasPath, String text, String drawable, float x, float y, float width, float height) {
        xPos.add(x);

        stage = new Stage(new StretchViewport(1000, 1000 * (h/w)));
        Gdx.input.setInputProcessor(stage);

        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\\\/?-+=()*&.;:,{}\\\"´`'<>";
        parameter.size = (int) (w*(h/w) * .020f);
        String FONT_PATH = "Fonts/eww.ttf";
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        font = generator.generateFont(parameter);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(atlasPath));
        skin.addRegions(atlas);

        smartButtonStyle.font = font;
        smartButtonStyle.up = skin.getDrawable(drawable);
        button = new TextButton(text, smartButtonStyle);
        button.setPosition(x, y * (h / w));
        button.setSize(width, height * (h / w));

        stage.addActor(button);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        button.draw(batch, parentAlpha);
        stage.draw();
    }

    public void addToClose() {
        this.moveButton(1500, this.getButtonY());
//        stage.addAction(Actions.removeActor(this));
    }

    public void open() {
        this.moveButton(this.xPos.get(0), this.getButtonY());
//        stage.addActor(this);
    }

    public void click(String drawable) {
        smartButtonStyle.down = skin.getDrawable(drawable);
    }

    public float getButtonX() {
        return button.getX();
    }

    public float getOriginX() {
        return this.xPos.get(0);
    }

    public float getButtonY() {
        return button.getY();
    }

    public void moveButton(float x, float y) {
        button.setPosition(x, y);
    }

    public boolean isClicked() {
        return button.isChecked();
    }

    public void setClicked(boolean clicked) {
        button.setChecked(clicked);
    }

    public void setTouchDragged(boolean set) {
        if (set) {
            button.addListener(new DragListener(){
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    lastTouch.set(x, y);
                    return true;
                }

                @Override
                public void touchDragged(InputEvent event, float x, float y, int pointer) {
                    newTouch = new Vector2(x, y);

                    Vector2 delta = newTouch.cpy().sub(lastTouch.x, lastTouch.y);

                    button.moveBy(delta.x, delta.y);

                }

                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    lastTouch = newTouch;
                }
            });
        }
    }

    public void removeListener() {
        button.removeListener(button.getClickListener());
    }
}
