package com.dentheripper.trying.View.Screens.MF;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.CheckBoxBase;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.BuildElements.SliderBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;

public class Settings extends ScreenBase {

    public ButtonBase exitButton;
    public SliderBase musicVol;
    public SliderBase sfxVol;
    public CheckBoxBase muteMusic;
    public CheckBoxBase muteSfx;
    public CheckBoxBase showFPS;
    public ButtonBase saveData;
    public ButtonBase loadData;

    // MISC - Show enemy levels, Show FPS;
    public Settings(Engine engine) {
        super(engine);
        setBG(new Texture("screenAssets/settings.png"), 1000, 1000 * (h / w));

        exitButton = new ButtonBase("Atlas/buttons.txt", "cl", 850, 780, 100, 160);
        musicVol = new SliderBase(100, 400, 343, 200);
        sfxVol = new SliderBase(100, 230, 343, 200);
        muteMusic = new CheckBoxBase(366, 180, 39, 70);
        muteSfx = new CheckBoxBase(306, 100, 40, 70);
        showFPS = new CheckBoxBase(730, 550, 40, 70);
        saveData = new ButtonBase("Atlas/buttons.txt", "skill_varity", 620, 320, 170, 80);
        loadData = new ButtonBase("Atlas/buttons.txt", "skill_varity", 620, 110, 170, 80);
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this.multiplexer);

        addObject(exitButton);
        addObject(musicVol);
        addObject(sfxVol);
        addObject(muteSfx);
        addObject(muteMusic);
        addObject(showFPS);
        addObject(saveData);
        addObject(loadData);

        musicVol.slider.setValue(Assets.data.getFloat("musicVol"));
        muteSfx.setChecked(Assets.data.getBoolean("sfxMuteIsChecked"));
        muteMusic.setChecked(Assets.data.getBoolean("musicMuteIsChecked"));
        showFPS.setChecked(Assets.data.getBoolean("showFPS"));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        actFinal(delta);
        Assets.data.putFloat("musicVol", musicVol.getPos());
        Assets.data.putFloat("sfxVol", sfxVol.getPos());
        Assets.data.putBoolean("musicMuteIsChecked", muteMusic.isChecked());
        Assets.data.putBoolean("sfxMuteIsChecked", muteSfx.isChecked());
        Assets.data.putBoolean("showFPS", showFPS.isChecked());

        if (saveData.isClicked()) {
            engine.setScreen(new SaveLoadData(engine));
            saveData.button.setChecked(false);
        }
        if (loadData.isClicked()) {
            engine.setScreen(new SaveLoadData(engine));
            loadData.button.setChecked(false);
        }
        if (exitButton.isClicked()) {
            engine.setScreen(new Main(engine));
            exitButton.setClicked(false);
        }
    }
}
