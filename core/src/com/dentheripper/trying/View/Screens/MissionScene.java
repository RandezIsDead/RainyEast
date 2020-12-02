package com.dentheripper.trying.View.Screens;

import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.GameCore.Entity;
import com.dentheripper.trying.View.Entities.Player;

public class MissionScene extends GameScene {

    private final Player player = new Player();

    public MissionScene(Engine engine) {
        super(engine);
        setBG(Assets.assetManager.get(Assets.flat), 4000, 1000 * (h / w), true);
        setPlayer(player);
        player.setSpeed(Assets.data.getPrefSpeed());
        player.setX(470);
        player.setY(100 * (h / w));
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        player.setMovable(1);
        player.cameraFreeze(camera, true);

        if (player.getY() < 120 * (h / w) && player.getX() > 350 && player.getX() < 600) {
            useButton.button.setPosition(useButton.getOriginX(), useButton.getButtonY());
            if (useButton.isClicked()) {
                if (smartRender.musicScr.music != null) {
                    smartRender.musicScr.setPlaying(false);
                    smartRender.musicScr.music.dispose();
                }
                engine.setScreen(new GameScene(engine));
                useButton.setClicked(false);
            }
        } else {
            useButton.button.setPosition(1500, useButton.getButtonY());
        }
        if (useButton.isClicked()) {
            useButton.setClicked(false);
        }
        collisionDetect(player);
    }

    private void collisionDetect(Entity entity) {
        float x = entity.getX();
        float y = entity.getY();

        // Main borders
        if (y >= 786 * (h / w)) {
            entity.setY(786 * (h / w));
        }
        if (x <= 23) {
            entity.setX(23);
        }
        if (x >= 886) {
            entity.setX(886);
        }
        if (y <= 0 * (h / w)) {
            entity.setY(0 * (h / w));
        }
    }
}