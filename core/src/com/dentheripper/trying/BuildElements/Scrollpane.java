package com.dentheripper.trying.BuildElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;

public class Scrollpane extends Actor {

    public Stage stage;
    public ScrollPane scroll;

    public Scrollpane(ArrayList<String> list) {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        stage = new Stage(new StretchViewport(1000, 1000 * (h / w)));
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin();
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("Atlas/scrollPane.txt"));
        skin.addRegions(atlas);
        Table container = new Table();
        Table table = new Table();
        ScrollPane.ScrollPaneStyle style = new ScrollPane.ScrollPaneStyle();
        style.background = skin.getDrawable("bg");
        style.hScroll = skin.getDrawable("hScroll");
        style.vScroll = skin.getDrawable("vScroll");
        style.hScrollKnob = skin.getDrawable("hsKnob");
        style.vScrollKnob = skin.getDrawable("vsKnob");
        container.setFillParent(true);
        scroll = new ScrollPane(table, style);
        scroll.layout();
        scroll.setFillParent(true);

        InputListener stopTouchDown = new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                event.stop();
                return false;
            }
        };

        table.pad(20).defaults().expandY().space(5);

        for (int i = 0; i < list.size(); i++) {

            table.row();

            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\\\/?-+=()*&.;:,{}\\\"´`'<>";
            parameter.size = (int) (w*(h/w) * .020f);
            String FONT_PATH = "Fonts/eww.ttf";
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
            BitmapFont font = generator.generateFont(parameter);

            skin = new Skin();
            TextureAtlas atlass = new TextureAtlas(Gdx.files.internal("Atlas/smart.txt"));
            skin.addRegions(atlass);

            TextButton.TextButtonStyle smartButtonStyle = new TextButton.TextButtonStyle();
            smartButtonStyle.font = font;
            smartButtonStyle.up = skin.getDrawable("ms");
            TextButton button = new TextButton(list.get(i), smartButtonStyle);

            table.add(button);
            button.addListener(new ClickListener() {
                public void clicked (InputEvent event, float x, float y) {
                    System.out.println("click " + x + ", " + y);
                }
            });
        }

//        container.setX(20);
//        container.setY(60*(h/w));
//        container.setSize(430, 880*(h/w));
//        table.setPosition(20, 60*(h/w));
//        table.setSize(430, 880*(h/w));
        container.add(scroll).expandY().fill().colspan(1);
        container.row().space(10).padBottom(10);

        stage.addActor(container);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        stage.draw();
    }
}
