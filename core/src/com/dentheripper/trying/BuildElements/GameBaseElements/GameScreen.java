package com.dentheripper.trying.BuildElements.GameBaseElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.GameCore.Entity;
import com.dentheripper.trying.View.OnScreen.Controller;
import com.dentheripper.trying.View.OnScreen.SmartRender;

import java.util.ArrayList;
import java.util.List;

public class GameScreen extends ScreenBase {

    protected static ButtonBase useButton = new ButtonBase("Atlas/buttons.txt", "useButton", 600, 350, 60, 120);
    protected static ButtonBase smartButton = new ButtonBase("Atlas/buttons.txt", "smartButton", 950, 600, 50, 200);
    protected SmartRender smartRender = new SmartRender(stage);

    private Entity player;
    protected List<Entity> npc = new ArrayList<>();
    protected Controller controller = new Controller();
    private int useID;
    private float time = 0;

    public GameScreen(Engine engine) {
        super(engine);
        smartRender.multiplexSmartScreens(multiplexer);
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(multiplexer);

        stage.addActor(player);
        for (int i = 0; i < npc.size(); i ++) {
            stage.addActor(npc.get(i));
        }
        stage.addActor(controller);
        addObject(smartButton);
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
        System.out.println(player.getX() + "    " + player.getY() * 2);

        if (player.getX() >= 2012 && player.getX() <= 2280 && player.getY() >= 5666*(h/w) && player.getY() <= 5828*(h/w)) {
            addUseButton();
            setUseID(0);// Aug Shop
        } else if (player.getX() >= 2492 && player.getX() <= 2565 && player.getY() >= 5666*(h/w) && player.getY() <= 5828*(h/w)) {
            addUseButton();
            setUseID(1);// Vending machine near augShop
        } else if (player.getX() >= 6300 && player.getY() >= 7990*(h/w)) {
            addUseButton();
            setUseID(2);// C-Tech building
        } else if (player.getY() >= 10800*(h/w)) {
            stage.addActor(useButton);
            multiplexer.addProcessor(useButton.stage);
            setUseID(3);// Apartments
        } else {
            setUseID(-1);
        }

        if (smartButton.isClicked()) {
            Gdx.input.setInputProcessor(smartRender.home.multiplexer);
            smartRender.home.show();
            smartButton.setClicked(false);
        }

        player.HPControl();
        player.SPControl();

        // Augmentation wearScale must decrease
        if (player.isRunning()) {
            time += Gdx.graphics.getDeltaTime();
            if (time > 10) {
                for (int i = 0; i < smartRender.gameInventory.inventoryUsing.items.length; i++) {
                    if (smartRender.gameInventory.inventoryUsing.items[i] != null) {
                        smartRender.gameInventory.inventoryUsing.items[i].setWearScalePercent(smartRender.gameInventory.inventoryUsing.items[i].getWearScalePercent() - 1);
                    }
                }
                time = 0;
            } else {
                System.out.println(time);
            }
        }
    }

    protected void addUseButton() {
        stage.addActor(useButton);
        multiplexer.addProcessor(useButton.stage);
    }

    protected void removeUseButton() {
        stage.addAction(Actions.removeActor(useButton));
        multiplexer.removeProcessor(useButton.stage);
    }

    protected void setPlayer(Entity player) {
        this.player = player;
    }

    protected void addNPC(Entity npcP) {
        npc.add(npcP);
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