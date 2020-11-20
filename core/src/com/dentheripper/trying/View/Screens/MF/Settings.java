package com.dentheripper.trying.View.Screens.MF;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.BuildElements.SliderBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;

public class Settings extends ScreenBase {

    public ButtonBase exitButton;
    public SliderBase musicVol;
    public SliderBase sfxVol;
//    public CheckBoxBase muteMusic;
//    public CheckBoxBase muteSfx;
    // MISC - Show enemy levels, Show FPS;
    public Settings(Engine engine) {
        super(engine);
        setBG(new Texture("screenAssets/settings.png"), 1000, 1000 * (h/w));
    }

    @Override
    public void show() {
        exitButton = new ButtonBase("Atlas/buttons.txt", "cl", 850, 780, 100, 160);
        musicVol = new SliderBase(100, 400, 343, 200);
        sfxVol = new SliderBase(100, 230, 343, 200);
//        muteMusic = new CheckBoxBase(300, 100, 10, 20);
//        muteSfx = new CheckBoxBase(300, 10, 10, 20);

        super.show();
        Gdx.input.setInputProcessor(this.multiplexer);

        addObject(exitButton);
        addObject(musicVol);
        addObject(sfxVol);

        musicVol.slider.setValue(Assets.data.getFloat("musicVol"));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        actFinal(delta);
        Assets.data.putFloat("musicVol", musicVol.getPos());
        Assets.data.putFloat("sfxVol", sfxVol.getPos());
        if (exitButton.isClicked()) {
            engine.setScreen(new Main(engine));
            exitButton.setClicked(false);
        }
    }
}
