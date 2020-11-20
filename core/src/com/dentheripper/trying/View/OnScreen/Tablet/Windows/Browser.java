package com.dentheripper.trying.View.OnScreen.Tablet.Windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.GameCore.Assets;

public class Browser extends SmartBase {

    private ExtraWindow browserWindow;
    private ButtonBase productsB;
    private ButtonBase housingB;
    private ButtonBase moneyB;

    public Browser() {
        setImage(Assets.assetManager.get(Assets.smartUniversal));
        browserWindow = new ExtraWindow();
        browserWindow.setImage(Assets.assetManager.get(Assets.comingSoon), 700, 128, 300 ,763);
    }

    @Override
    public void close() {
        super.close();
        stage.addAction(Actions.removeActor(browserWindow));
    }

    @Override
    public void show() {
        super.show();
        stage.addActor(browserWindow);
    }

    public void browserRender(Home home) {
        if (home.browser.isClicked()) {
            home.close();
            show();
            Gdx.input.setInputProcessor(this.multiplexer);
            home.browser.setClicked(false);
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
