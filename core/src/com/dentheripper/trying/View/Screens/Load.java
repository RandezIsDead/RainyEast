package com.dentheripper.trying.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.Screens.MF.Registration;

public class Load extends ScreenBase {

    private SpriteBatch batch;
    private Texture texture;
    private final BitmapFont font;
    private final String string;
    private final int param;

    public Load(Engine engine, String str, int param) {
        super(engine);
        this.string = str;
        this.param = param;
        setBG(new Texture(Gdx.files.internal("screenAssets/bg.png")), 1000, 1000 * (h/w));

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\\\/?-+=()*&.;:,{}\\\"´`'<>";
        parameter.size = (int) (Gdx.graphics.getWidth() * .03f);
        String FONT_PATH = "Fonts/eww.ttf";
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        font = generator.generateFont(parameter);
    }

    @Override
    public void show() {
        super.show();
        Assets.load();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (param == 0) {
            load();
        }
    }

    private void load() {
        float a = Assets.assetManager.getProgress() * 100;
        int p = (int) a;
        String x =  Integer.toString(p);

        batch = new SpriteBatch();
        texture = new Texture("screenAssets/bg.png");
        batch.begin();
        batch.draw(texture, 0, 0, w, h);
        font.setColor(Color.WHITE);
        font.draw(batch, x + "%", w - w/2, h - 9.5f*h/10);
        batch.end();

        if(Assets.assetManager.update()){
            if (string.equals("vgm")) {
                engine.setScreen(new GameScene(engine));
            }
            if (string.equals("reg")) {
                engine.setScreen(new Registration(engine));
            }
            Assets.assetManager.finishLoading();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        Assets.dispose();
        texture.dispose();
        batch.dispose();
        font.dispose();
    }
}
