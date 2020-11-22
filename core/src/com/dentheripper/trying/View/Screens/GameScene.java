package com.dentheripper.trying.View.Screens;

import com.dentheripper.trying.BuildElements.GameBaseElements.GameScreen;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.GameCore.Entity;
import com.dentheripper.trying.View.Entities.Player;
import com.dentheripper.trying.View.OnScreen.SmartRender;
import com.dentheripper.trying.View.OnScreen.SmartWindows.MusicScr;

public class GameScene extends GameScreen {

    private final Player player;

    public GameScene(Engine engine) {
        super(engine);
        setBG(Assets.assetManager.get(Assets.gameMap), 8000, 12500 * (h/w));
        player = new Player();
        setPlayer(player);
        player.setSpeed(Assets.data.getPrefSpeed());
        player.setX(Assets.data.getFloat("lastPlayerX"));
        player.setY(Assets.data.getFloat("lastPlayerY"));

//        for (int i = 0; i < 1000; i++) {
//            NPC npc = new NPC();
//            npc.setIS_ENTITY_ANDROID(RandomInt0to1());
//            npc.setX(RandomFloat(100, 10000));
//            npc.setY(RandomFloat(100, 10000));
//            addNPC(npc);
//            data.putInteger("NPC" + i, npc.getIS_ENTITY_ANDROID());
//            data.putFloat("NPC" + i + "PosX", npc.getX());
//            data.putFloat("NPC" + i + "PosY", npc.getY());
//        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        player.setMovable(true);
        player.cameraFreeze(camera, true);

        if (useButton.isClicked() && getUseID() == 0) {
            changeLocation(new ShopScene(engine));
        }
        if (useButton.isClicked() && getUseID() == 3) {
            changeLocation(new FlatScene(engine));
        }
        if (useButton.isClicked()) {
            useButton.setClicked(false);
        }
        collisionDetect(player);
//        for (int i = 0; i < 1000; i++) {
//            collisionDetect(npc.get(i));
//        }
    }

    private void changeLocation(ScreenBase screenBase) {
        if (MusicScr.music != null) {
            SmartRender.musicScr.setPlaying(false);
            MusicScr.music.dispose();
        }
        Assets.data.putFloat("lastPlayerX", player.getX());
        Assets.data.putFloat("lastPlayerY", player.getY());
        engine.setScreen(screenBase);
        useButton.setClicked(false);
    }

    private void collisionDetect(Entity entity) {
        float x = entity.getX();
        float y = entity.getY();

        // Main borders
        if (y >= 11110*(h/w)) {
            entity.setY(11110*(h/w));
        }
        if (x <= 1626) {
            entity.setX(1626);
        }
        if (x >= 6440) {
            entity.setX(6440);
        }
        if (y <= 1108*(h/w)) {
            entity.setY(1108*(h/w));
        }
        if ((x < 3760 || x > 4172) && y >= 8340*(h/w) && y < 8362*(h/w)) {
            entity.setY(8340*(h/w));
        }

        // Middle vertical borders
        if (x <= 3760 && y > 8365*(h/w)) {
            entity.setX(3760);
        }
        if (x >= 4172 && y > 8365*(h/w)) {
            entity.setX(4172);
        }

        // Middle horizontal borders
        if (x <= 3903 && y >= 10020*(h/w)) {
            entity.setY(10020*(h/w));
        }
        if (x >= 4023 && y >= 10020*(h/w)) {
            entity.setY(10020*(h/w));
        }

        // Upper vertical borders
        if (x <= 3920 && y > 10045*(h/w)) {
            entity.setX(3920);
        }
        if (x >= 4005 && y > 10045*(h/w)) {
            entity.setX(4005);
        }

        // Left upper sector
        if (x >= 1913 && x <= 1950 && y >= 5828*(h/w) && y <= 7856*(h/w)) {
            entity.setX(1913);
        }
        if (x <= 3759 && x >= 3700 && y >= 5828*(h/w) && y <= 7856*(h/w)) {
            entity.setX(3759);
        }
        if (x >= 1925 && x <= 3740 && y >= 5828*(h/w) && y <= 5858*(h/w)) {
            entity.setY(5828*(h/w));
        }
        if (x >= 1925 && x <= 3740 && y <= 7856*(h/w) && y >= 7800*(h/w)) {
            entity.setY(7856*(h/w));
        }

        // Right upper sector
        if (x >= 4172 && x <= 4200 && y >= 5828*(h/w) && y <= 7856*(h/w)) {
            entity.setX(4172);
        }
        if (x <= 6160 && x >= 6110 && y >= 5828*(h/w) && y <= 7856*(h/w)) {
            entity.setX(6160);
        }
        if (x >= 4150 && x <= 6140 && y >= 5828*(h/w) && y <= 5858*(h/w)) {
            entity.setY(5828*(h/w));
        }
        if (x >= 4150 && x <= 6140 && y <= 7856*(h/w) && y >= 7800*(h/w)) {
            entity.setY(7856*(h/w));
        }

        // Left middle sector
        if (x >= 1913 && x <= 1950 && y >= 3250*(h/w) && y <= 5332*(h/w)) {
            entity.setX(1913);
        }
        if (x <= 3759 && x >= 3700 && y >= 3250*(h/w) && y <= 5332*(h/w)) {
            entity.setX(3759);
        }
        if (x >= 1925 && x <= 3740 && y >= 3250*(h/w) && y <= 3280*(h/w)) {
            entity.setY(3250*(h/w));
        }
        if (x >= 1925 && x <= 3740 && y <= 5332*(h/w) && y >= 5282*(h/w)) {
            entity.setY(5332*(h/w));
        }

        // Right middle sector
        if (x >= 4172 && x <= 4200 && y >= 3250*(h/w) && y <= 5332*(h/w)) {
            entity.setX(4172);
        }
        if (x <= 6160 && x >= 6110 && y >= 3250*(h/w) && y <= 5332*(h/w)) {
            entity.setX(6160);
        }
        if (x >= 4150 && x <= 6140 && y >= 3250*(h/w) && y <= 3280*(h/w)) {
            entity.setY(3250*(h/w));
        }
        if (x >= 4150 && x <= 6140 && y <= 5332*(h/w) && y >= 5282*(h/w)) {
            entity.setY(5332*(h/w));
        }

        // Left lower sector
        if (x >= 1913 && x <= 1950 && y >= 1624*(h/w) && y <= 2745*(h/w)) {
            entity.setX(1913);
        }
        if (x <= 3759 && x >= 3700 && y >= 1624*(h/w) && y <= 2745*(h/w)) {
            entity.setX(3759);
        }
        if (x >= 1925 && x <= 3740 && y >= 1624*(h/w) && y <= 1654*(h/w)) {
            entity.setY(1624*(h/w));
        }
        if (x >= 1925 && x <= 3740 && y <= 2745*(h/w) && y >= 2700*(h/w)) {
            entity.setY(2745*(h/w));
        }

        // Right lower sector
        if (x >= 4172 && x <= 4200 && y >= 1624*(h/w) && y <= 2745*(h/w)) {
            entity.setX(4172);
        }
        if (x <= 6160 && x >= 6110 && y >= 1624*(h/w) && y <= 2745*(h/w)) {
            entity.setX(6160);
        }
        if (x >= 4150 && x <= 6140 && y >= 1624*(h/w) && y <= 1654*(h/w)) {
            entity.setY(1624*(h/w));
        }
        if (x >= 4150 && x <= 6140 && y <= 2745*(h/w) && y >= 2700*(h/w)) {
            entity.setY(2745*(h/w));
        }
    }

    public int RandomInt0to1() {
        float a = (float) Math.random();
        if(a < 0.5)
            return 0;
        else
            return 1;
    }

    public float RandomFloat(int min, int max) {
        return (float) ((Math.random() * (max - min)) + min);
    }
}
