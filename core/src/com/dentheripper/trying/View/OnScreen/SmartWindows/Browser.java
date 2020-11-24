package com.dentheripper.trying.View.OnScreen.SmartWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;

public class Browser extends SmartBase {

    private final Image browserWindow;
//    private ButtonBase productsB;
//    private ButtonBase housingB;
//    private ButtonBase moneyB;

    public Browser(Stage stage) {
        super(stage);
        setImage(Assets.assetManager.get(Assets.smartUniversal));
        browserWindow = new Image(Assets.assetManager.get(Assets.comingSoon));
        browserWindow.setBounds(700, 128 * (h / w), 300, 763 * (h / w));
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

    public void browserRender(Home home, Passport passport) {
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
        if (stats.isClicked()) {
            close();
            passport.show();
            Gdx.input.setInputProcessor(passport.multiplexer);
            stats.setClicked(false);
        }
    }
}
