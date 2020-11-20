package com.dentheripper.trying.View.Screens.MF;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.Screens.Load;

public class Main extends ScreenBase {

    private InputMultiplexer multiplexer;
    private ButtonBase startButton;
    private ButtonBase optionButton;
    private ButtonBase quitButton;
    private ButtonBase credits;
    private ButtonBase achievement;
    private Music bgMusic;
    private Settings settings;
    private final int gameLaunches;

    public Main(Engine engine) {
        super(engine);
        setBG(new Texture(Gdx.files.internal("screenAssets/main.png")), 1000, 1000 * (h/w));
        gameLaunches = data.getInteger("gameLaunches");
    }

    @Override
    public void show() {
        ButtonBase idk = new ButtonBase("Atlas/buttons.txt", "skill_varity", 0, 0, 1, 1);
        startButton = new ButtonBase("Atlas/buttons.txt", "startButton", 640, 200, 300, 600);
        startButton.click("startButtonPressed");
        optionButton = new ButtonBase("Atlas/buttons.txt", "settings", 480, 200, 150, 600);
        optionButton.click("settingsPressed");
        credits = new ButtonBase("Atlas/buttons.txt", "credits", 320, 200, 150, 200);
        credits.click("creditsPressed");
        achievement = new ButtonBase("Atlas/buttons.txt", "achievement", 320, 420, 150, 380);
        achievement.click("achievementPressed");
        quitButton = new ButtonBase("Atlas/buttons.txt", "exit", 10, 200, 300, 600);
        quitButton.click("exitPressed");

        settings = new Settings();

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(startButton.stage);
        multiplexer.addProcessor(optionButton.stage);
        multiplexer.addProcessor(credits.stage);
        multiplexer.addProcessor(achievement.stage);
        multiplexer.addProcessor(quitButton.stage);

        bgMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Zombie.mp3"));
        bgMusic.setVolume(data.getFloat("musicVol"));
        bgMusic.play();
        bgMusic.setLooping(true);

        super.show();
        Gdx.input.setInputProcessor(this.multiplexer);

        stage.addActor(startButton);
        stage.addActor(optionButton);
        stage.addActor(credits);
        stage.addActor(quitButton);
        stage.addActor(achievement);
        stage.addActor(idk);

        settings.close();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        actFinal(delta);
        bgMusic.setVolume(data.getFloat("musicVol"));

        if (startButton.isClicked()) {
            bgMusic.dispose();
            if (gameLaunches == 0) {
                engine.setScreen(new Registration(engine));
            } else {
                engine.setScreen(new Load(engine, "vgm", 0));
            }
        }
        if (quitButton.isClicked()) {
            bgMusic.dispose();
            Gdx.app.exit();
        }
        if (optionButton.isClicked()) {
            stage.addActor(settings);
            settings.show();
            Gdx.input.setInputProcessor(settings.multiplexer);
            optionButton.setClicked(false);
        }
        if (settings.exitButton.isClicked()) {
            settings.close();
            stage.addAction(Actions.removeActor(settings));
            Gdx.input.setInputProcessor(this.multiplexer);
            settings.exitButton.setClicked(false);
        }
    }

    @Override
    protected void actFinal(float delta) {
        startButton.act(delta);
        optionButton.act(delta);
        credits.act(delta);
        achievement.act(delta);
        quitButton.act(delta);
        settings.act(delta);
        super.actFinal(delta);
    }
}
