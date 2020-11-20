package com.dentheripper.trying.View.Screens.MF;

import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.CheckBoxBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.LWindow;
import com.dentheripper.trying.BuildElements.SliderBase;
import com.dentheripper.trying.GameCore.Data;

public class Settings extends LWindow {

    private Data data;
    public ButtonBase exitButton;
    public SliderBase musicVol;
    public SliderBase sfxVol;
//    public CheckBoxBase muteMusic;
//    public CheckBoxBase muteSfx;
    // MISC - Show enemy levels, Show FPS;
    public Settings() {
        setImage("screenAssets/settings.png");
        data = new Data();
        exitButton = new ButtonBase("Atlas/buttons.txt", "cl", 850, 780, 100, 160);
        musicVol = new SliderBase(100, 400, 343, 200);
        sfxVol = new SliderBase(100, 230, 343, 200);
//        muteMusic = new CheckBoxBase(300, 100, 10, 20);
//        muteSfx = new CheckBoxBase(300, 10, 10, 20);
        addButton(exitButton);
        multiplexer.addProcessor(musicVol.stage);
        multiplexer.addProcessor(sfxVol.stage);
//        multiplexer.addProcessor(muteMusic.stage);
//        multiplexer.addProcessor(muteSfx.stage);
        stage.addActor(musicVol);
        stage.addActor(sfxVol);
//        stage.addActor(muteMusic);
//        stage.addActor(muteSfx);
        musicVol.slider.setValue(data.getFloat("musicVol"));
    }

    @Override
    protected void actFinal(float delta) {
        data.putFloat("musicVol", musicVol.getPos());
        data.putFloat("sfxVol", sfxVol.getPos());
        super.actFinal(delta);
    }

    @Override
    public void close() {
        super.close();
        for (int i = 0; i < buttons.size(); i++) buttons.get(i).addToClose();
        musicVol.addToClose();
        sfxVol.addToClose();
//        muteMusic.addToClose();
//        muteSfx.addToClose();
    }

    @Override
    public void show() {
        super.show();
        for (int i = 6; i < buttons.size(); i++) buttons.get(i).addToClose();
        musicVol.open();
        sfxVol.open();
//        muteSfx.open();
//        muteMusic.open();
    }
}
