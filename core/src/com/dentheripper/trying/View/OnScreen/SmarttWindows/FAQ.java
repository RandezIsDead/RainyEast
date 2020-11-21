package com.dentheripper.trying.View.OnScreen.SmarttWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.GameCore.Assets;

public class FAQ extends SmartBase {

    private final ExtraWindow extraWindow;

    public FAQ() {
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

    public void faqRender(Home home) {
        if (home.info.isClicked()) {
            home.close();
            show();
            Gdx.input.setInputProcessor(this.multiplexer);
            home.info.setClicked(false);
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