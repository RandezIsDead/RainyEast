package com.dentheripper.trying.BuildElements.GameBaseElements;

import com.badlogic.gdx.Gdx;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.GameCore.Entity;
import com.dentheripper.trying.View.OnScreen.Controller;
import com.dentheripper.trying.View.OnScreen.SmartRender;

public class GameScreen extends ScreenBase {

    protected Controller controller;
    protected ButtonBase useButton;
    protected SmartRender smartRender;

    private Entity player;
    protected ButtonBase smartButton;
    private int useID;
    private float time = 0;

    public GameScreen(Engine engine) {
        super(engine);
        smartRender = new SmartRender(stage);
        smartButton = new ButtonBase("Atlas/buttons.txt", "smartButton", 950, 600, 50, 200);
        useButton = new ButtonBase("Atlas/buttons.txt", "useButton", 600, 350, 60, 120);
        controller = new Controller();
        smartRender.initialize();
    }

    @Override
    public void show() {
        super.show();
        smartRender.multiplexSmartScreens(multiplexer);
        Gdx.input.setInputProcessor(multiplexer);

        stage.addActor(player);
        stage.addActor(controller);
        addObject(smartButton);
        addObject(useButton);
        smartRender.addToStage(stage);
        smartRender.close();

        Assets.data.setPrefSpeed(200);
        player.setMaxHp(100);
        player.setMaxSp(100);
        player.setHp(Assets.data.getPrefHp());
        player.setSp(Assets.data.getPrefSp());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        super.actFinal(delta);
        Assets.data.putString("realHP", Float.toString(player.getHp()));
        Assets.data.putString("realSP", Float.toString(player.getSp()));
        smartRender.renderThis(multiplexer, engine);
//        System.out.println(player.getX() + "    " + player.getY() * 2);

        if (player.getX() >= 2012 && player.getX() <= 2280 && player.getY() >= 5666*(h/w) && player.getY() <= 5828*(h/w)) {
            useButton.button.setPosition(useButton.getOriginX(), useButton.getButtonY());
            setUseID(0);// Aug Shop
        } else if (player.getX() >= 2492 && player.getX() <= 2565 && player.getY() >= 5666*(h/w) && player.getY() <= 5828*(h/w)) {
            useButton.button.setPosition(useButton.getOriginX(), useButton.getButtonY());
            setUseID(1);// Vending machine near augShop
        } else if (player.getX() >= 6300 && player.getY() >= 7990*(h/w)) {
            useButton.button.setPosition(useButton.getOriginX(), useButton.getButtonY());
            setUseID(2);// C-Tech building
        } else if (player.getY() >= 10800 * (h / w)) {
            useButton.setPosition(useButton.getOriginX(), useButton.getButtonY());
            setUseID(3);// Apartments
        } else if (player.getX() >= 2630 && player.getX() <= 2765 && player.getY() >= 5666 * (h / w) && player.getY() <= 5828 * (h / w)) {
            useButton.button.setPosition(useButton.getOriginX(), useButton.getButtonY());
            setUseID(4);// Sell store
        } else {
            useButton.button.setPosition(1500, useButton.getButtonY());
            setUseID(-1);
        }

        if (smartButton.isClicked()) {
            Gdx.input.setInputProcessor(smartRender.home.multiplexer);
            smartRender.home.show();
            smartButton.setClicked(false);
        }

        // Augmentation wearScale must decrease
        if (player.isRunning()) {
            time += Gdx.graphics.getDeltaTime();
            if (time > 10) {
                for (int i = 0; i < smartRender.gameInventory.inventoryUsing.items.length; i++) {
                    if (smartRender.gameInventory.inventoryUsing.items[i] != null) {
                        smartRender.gameInventory.inventoryUsing.items[i].setWearScalePercent(smartRender.gameInventory.inventoryUsing.items[i].getWearScalePercent() - 1);
                        smartRender.gameInventory.inventory.saveInventory();
                        smartRender.gameInventory.inventoryUsing.saveInventory();
                    }
                }
                time = 0;
            }
        }
    }

    protected void setPlayer(Entity player) {
        this.player = player;
    }

    public int getUseID() {
        return useID;
    }

    public void setUseID(int useID) {
        this.useID = useID;
    }
}
//        if (player.getSp() == 0) {
//            long time = System.currentTimeMillis();
//            controller.setCanMove((System.currentTimeMillis() - time) / 1000 > 30);
//        }
//        if (player.getSp() >= 10) {
//            controller.setCanMove(true);
//        }
//        if (player.isRunning()) {
//            player.setSp(player.getSp() - 5*Gdx.graphics.getDeltaTime());
//        } else {
//            player.SPControl();
//        }