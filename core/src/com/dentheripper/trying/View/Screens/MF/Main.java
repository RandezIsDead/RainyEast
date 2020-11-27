package com.dentheripper.trying.View.Screens.MF;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.Screens.Load;

public class Main extends ScreenBase {

    private final ButtonBase startButton;
    private final ButtonBase optionButton;
    private final ButtonBase quitButton;
    private final ButtonBase credits;
    private final ButtonBase achievement;
    private final ButtonBase idk;
    private final Music bgMusic;
    private final int gameLaunches;

    public Main(Engine engine) {
        super(engine);
        setBG(new Texture("screenAssets/main.png"), 1000, 1000 * (h / w));
        gameLaunches = Assets.data.getInteger("gameLaunches");

        idk = new ButtonBase("Atlas/buttons.txt", "skill_varity", 0, 0, 1, 1);
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

        bgMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Zombie.mp3"));
    }

    @Override
    public void show() {
        bgMusic.play();
        bgMusic.setLooping(true);

        super.show();
        Gdx.input.setInputProcessor(this.multiplexer);

        addObject(startButton);
        addObject(optionButton);
        addObject(credits);
        addObject(achievement);
        addObject(quitButton);
        addObject(idk);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        actFinal(delta);
        if (Assets.data.getBoolean("musicMuteIsChecked")) {
            bgMusic.setVolume(0);
        } else {
            bgMusic.setVolume(Assets.data.getFloat("musicVol"));
        }

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
            bgMusic.dispose();
            engine.setScreen(new Settings(engine));
            optionButton.setClicked(false);
        }
    }
}
