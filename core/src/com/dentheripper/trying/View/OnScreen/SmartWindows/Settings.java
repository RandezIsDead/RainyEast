package com.dentheripper.trying.View.OnScreen.SmartWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.OnScreen.SmartRender;
import com.dentheripper.trying.View.Screens.MF.Main;

import java.util.ArrayList;

public class Settings extends SmartBase {

    private final ArrayList<ButtonBase> btn = new ArrayList<>();
    private final ExtraWindow settingsWindow;
    private final ButtonBase sound;
    private final ButtonBase game;
    private final ButtonBase exit;

    public Settings() {
        setImage(Assets.assetManager.get(Assets.smartUniversal));
        settingsWindow = new ExtraWindow();
        settingsWindow.setImage(Assets.assetManager.get(Assets.white), 700, 128, 300 ,763);
        sound = new ButtonBase("Atlas/smart.txt", "soundSett", 705, 770, 290, 89);
        game = new ButtonBase("Atlas/smart.txt", "gameSett", 705, 650, 290, 89);
        exit = new ButtonBase("Atlas/smart.txt", "exitSett", 705, 145, 290, 89);

        btn.add(sound);
        btn.add(game);
        btn.add(exit);
    }

    @Override
    public void show() {
        super.show();
        stage.addActor(settingsWindow);
        for (int i = 0; i < btn.size(); i++) {
            stage.addActor(btn.get(i));
            multiplexer.addProcessor(btn.get(i).stage);
        }
    }

    @Override
    public void close() {
        super.close();
        stage.addAction(Actions.removeActor(settingsWindow));
        for (int i = 0; i < btn.size(); i++) {
            stage.addAction(Actions.removeActor(btn.get(i)));
            multiplexer.removeProcessor(btn.get(i).stage);
        }
    }

    public void settingsRender(Home home, Engine engine, Passport passport) {
        if (home.settings.isClicked()) {
            home.close();
            show();
            Gdx.input.setInputProcessor(this.multiplexer);
            home.settings.setClicked(false);
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
        if (sound.isClicked()) {
            System.out.println("Sound");
            sound.setClicked(false);
        }
        if (game.isClicked()) {
            System.out.println("Game");
            game.setClicked(false);
        }
        if (exit.isClicked()) {
            if (MusicScr.music != null) {
                SmartRender.musicScr.setPlaying(false);
                MusicScr.music.dispose();
            }
            engine.setScreen(new Main(engine));
            exit.setClicked(false);
        }
    }
}