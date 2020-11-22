package com.dentheripper.trying.View.Screens;

import com.dentheripper.trying.BuildElements.GameBaseElements.GameScreen;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.GameCore.Entity;
import com.dentheripper.trying.View.Entities.Player;
import com.dentheripper.trying.View.OnScreen.SmartRender;
import com.dentheripper.trying.View.OnScreen.SmartWindows.MusicScr;

public class FlatScene extends GameScreen {

    private final Player player;

    public FlatScene(Engine engine) {
        super(engine);
        setBG(Assets.assetManager.get(Assets.flat), 1000, 1000 * (h/w));
        player = new Player();
        setPlayer(player);
        player.setSpeed(Assets.data.getPrefSpeed());
        player.setX(470);
        player.setY(30*(h/w));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        player.setMovable(true);
        player.cameraFreeze(camera, true);

        if (player.getY() < 120*(h/w) && player.getX() > 350 && player.getX() < 600) {
            useButton.open();
            if (useButton.isClicked()) {
                if (MusicScr.music != null) {
                    SmartRender.musicScr.setPlaying(false);
                    MusicScr.music.dispose();
                }
                engine.setScreen(new GameScene(engine));
                useButton.setClicked(false);
            }
        }
        if (player.getY() >= 718*(h/w) && player.getX() > 700 && player.getX() < 863) {
            useButton.open();
            if (useButton.isClicked()) {
                sleep();
            }
        }
        if (useButton.isClicked()) {
            useButton.setClicked(false);
        }
        collisionDetect(player);
    }

    private void sleep() {

    }

    private void collisionDetect(Entity entity) {
        float x = entity.getX();
        float y = entity.getY();

        // Main borders
        if (y >= 786*(h/w)) {
            entity.setY(786*(h/w));
        }
        if (x <= 23) {
            entity.setX(23);
        }
        if (x >= 886) {
            entity.setX(886);
        }
        if (y <= 0*(h/w)) {
            entity.setY(0*(h/w));
        }
    }
}
