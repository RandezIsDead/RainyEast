package com.dentheripper.trying.View.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.dentheripper.trying.BuildElements.GameBaseElements.GameScreen;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.Entities.Player;
import com.dentheripper.trying.View.OnScreen.SmartRender;
import com.dentheripper.trying.View.OnScreen.SmartWindows.MusicScr;
import com.dentheripper.trying.View.OnScreen.Windows.ShopWindow;

public class ShopScene extends GameScreen {

    private final Player player;
    private final ShopWindow shopWindow;

    public ShopScene(Engine engine) {
        super(engine);
        setBG(new Texture(Gdx.files.internal("screenAssets/augShop.png")), 1000, 1000*(h/w));
        player = new Player();
        shopWindow = new ShopWindow(0);
        setPlayer(player);
        player.setSpeed(Assets.data.getPrefSpeed());
        player.setX(500);
        player.setY(100*(h/w));
        shopWindow.close();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        shopWindow.actFinal(delta);
        player.setMovable(true);
        player.cameraFreeze(camera, false);

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
        if (player.getY() > 300*(h/w)) {
            useButton.open();
            if (useButton.isClicked() && player.getY() > 300*(h/w)) {
                shopWindow.show();
                Gdx.input.setInputProcessor(shopWindow.multiplexer);
                useButton.setClicked(false);
            }
        }
        if (shopWindow.close.isClicked()) {
            smartRender.chips.inventory.loadInventory();
            smartRender.gameInventory.inventory.loadInventory();
            shopWindow.close();
            Gdx.input.setInputProcessor(this.multiplexer);
            shopWindow.close.setClicked(false);
        }
        if (useButton.isClicked()) {
            useButton.setClicked(false);
        }
        collisionDetector();
    }

    private void collisionDetector() {
        float x = player.getX();
        float y = player.getY();

        if (x <= 0) {
            player.setX(0);
        }
        if (y <= 0) {
            player.setY(0);
        }
        if (x >= 930) {
            player.setX(930);
        }
        if (y >= 850*(h/w)) {
            player.setY(850*(h/w));
        }
    }
}
