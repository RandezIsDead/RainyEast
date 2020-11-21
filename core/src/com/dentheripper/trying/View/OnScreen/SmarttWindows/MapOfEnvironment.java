package com.dentheripper.trying.View.OnScreen.SmarttWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;

public class MapOfEnvironment extends SmartBase {

    private ExtraWindow extraWindow;

    public MapOfEnvironment() {
        setImage(Assets.assetManager.get(Assets.smartUniversal));
        extraWindow = new ExtraWindow();
        extraWindow.setImage(Assets.assetManager.get(Assets.comingSoon), 700, 128, 300 ,763);
    }

    @Override
    public void close() {
        super.close();
        stage.addAction(Actions.removeActor(extraWindow));
    }

    @Override
    public void show() {
        super.show();
        stage.addActor(extraWindow);
    }

    public void moenvRender(Home home) {
        if (home.map.isClicked()) {
            home.close();
            show();
            Gdx.input.setInputProcessor(this.multiplexer);
            home.map.setClicked(false);
        }
        if (back.isClicked()) {
            close();
            home.show();
            Gdx.input.setInputProcessor(home.multiplexer);
            back.setClicked(false);
        }
        if (homeS.isClicked()) {
            close();
            home.show();
            Gdx.input.setInputProcessor(home.multiplexer);
            homeS.setClicked(false);
        }
    }
}
