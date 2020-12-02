package com.dentheripper.trying.View.OnScreen.SmartWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Inventory;
import com.dentheripper.trying.GameCore.Item;

public class GameInventory extends SmartBase {

    private final Image extraWindow;
    private final Image descriptionWindow;
    private final Image exceptionWindow;
    private final ButtonBase ok, notOk, close;
    public Inventory inventory;
    public Inventory inventoryUsing;
    private final ButtonBase desc;
    private boolean mustShowDescription = true;

    public GameInventory(Stage stage) {
        super(stage);
        setImage(Assets.assetManager.get(Assets.smartGrid));
        extraWindow = new Image(Assets.assetManager.get(Assets.invExt));
        extraWindow.setBounds(450, 128 * (h / w), 250, 760 * (h / w));
        inventory = new Inventory(stage, multiplexer, 0);
        inventoryUsing = new Inventory(stage, multiplexer, 1);
        descriptionWindow = new Image(Assets.assetManager.get(Assets.descWindow));
        descriptionWindow.setBounds(250, 50 * (h / w), 200, 900 * (h / w));
        ok = new ButtonBase("Atlas/smart.txt", "use", 260, 140, 180, 70);
        notOk = new ButtonBase("Atlas/smart.txt", "cancel", 260, 60, 180, 70);
        exceptionWindow = new Image(Assets.assetManager.get(Assets.exception));
        exceptionWindow.setBounds(250, 50 * (h / w), 200, 900 * (h / w));
        close = new ButtonBase("Atlas/buttons.txt", "errOk", 260, 830, 180, 70);
        desc = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 250, 180, 200, 700);
        desc.button.getLabel().setColor(Color.WHITE);
        desc.button.getLabel().setAlignment(Align.center);
        desc.button.getLabel().setFontScale(1.2f);

        stage.addActor(extraWindow);

        if (Assets.data.getInteger("gameLaunches") != 0) {
            inventory.loadInventory();
            inventoryUsing.loadInventory();
        }
    }

    @Override
    protected void actFinal(float delta) {
        super.actFinal(delta);
        for (int i = 0; i < inventory.items.length; i++) {
            if (inventory.items[i] != null) {
                if (inventory.items[i].button.isClicked()) {
                    if (mustShowDescription) {
                        showDescription(inventory.items[i].getDescription());
                    }
                    if (ok.isClicked()) {
                        if (canUseItem(inventory.items[i].id)) {
                            mustShowDescription = true;
                            useItem(inventory.items[i], inventory.items[i].id);
                        } else {
                            showError();
                            mustShowDescription = false;
                        }
                        closeDescription();
                        ok.setClicked(false);
                    }
                    if (notOk.isClicked()) {
                        closeDescription();
                        notOk.setClicked(false);
                        inventory.items[i].button.setClicked(false);
                    }
                    if (close.isClicked()) {
                        mustShowDescription = true;
                        closeError();
                        close.setClicked(false);
                    }
                }
            }
        }
        for (int i = 0; i < inventoryUsing.items.length; i++) {
            if (inventoryUsing.items[i] != null) {
                if (inventoryUsing.items[i].button.isClicked()) {
                    inventoryUsing.items[i].button.setClicked(false);
                    Item rec = inventoryUsing.items[i];
                    if (rec.getStatsID() == 0)
                        Assets.data.putString("intelligence", Integer.valueOf(Integer.parseInt(Assets.data.getString("intelligence")) - rec.getBuff()).toString());
                    if (rec.getStatsID() == 1)
                        Assets.data.putString("strength", Integer.valueOf(Integer.parseInt(Assets.data.getString("strength")) - rec.getBuff()).toString());
                    if (rec.getStatsID() == 6)
                        Assets.data.putString("healing", Integer.valueOf(Integer.parseInt(Assets.data.getString("healing")) - rec.getBuff()).toString());
                    if (rec.getStatsID() == 7)
                        Assets.data.putString("agility", Integer.valueOf(Integer.parseInt(Assets.data.getString("agility")) - rec.getBuff()).toString());
                    inventoryUsing.moveItem(inventoryUsing, inventory, rec, inventory.getFirstEmptyCell(), 0);
                }
            }
        }
    }

    private void useItem(Item item, int id) {
        int index = setIndexById(id);
        int wsp = item.getWearScalePercent();

        Item rec = new Item(id, index, 1);
        stage.addAction(Actions.removeActor(item.button));
        stage.addAction(Actions.removeActor(item.wearScale));
        multiplexer.removeProcessor(item.button.stage);
        inventory.removeItem(item.index);
        rec.setUsing(true);
        Gdx.input.setInputProcessor(this.multiplexer);

        if (rec.getStatsID() == 0) Assets.data.putString("intelligence", Integer.valueOf(Integer.parseInt(Assets.data.getString("intelligence")) + rec.getBuff()).toString());
        if (rec.getStatsID() == 1) Assets.data.putString("strength", Integer.valueOf(Integer.parseInt(Assets.data.getString("strength")) + rec.getBuff()).toString());
        if (rec.getStatsID() == 6) Assets.data.putString("healing", Integer.valueOf(Integer.parseInt(Assets.data.getString("healing")) + rec.getBuff()).toString());
        if (rec.getStatsID() == 7) Assets.data.putString("agility", Integer.valueOf(Integer.parseInt(Assets.data.getString("agility")) + rec.getBuff()).toString());

        multiplexer.addProcessor(rec.button.stage);
        stage.addActor(rec.button);
        stage.addActor(rec.wearScale);
        inventoryUsing.addItemAtIndexNotClose(rec, index);
        rec.setWearScalePercent(wsp);
        inventory.saveInventory();
        inventoryUsing.saveInventory();
    }

    private boolean canUseItem(int id) {
        int index = setIndexById(id);
        return inventoryUsing.items[index] == null;
    }

    private int setIndexById(int id) {
        int index = -1;
        if (id == 40) index = 0;
        if (id == 41) index = 1;
        if (id == 42) index = 2;
        if (id == 43) index = 3;
        if (id == 0) index = 4;

        return index;
    }

    @Override
    public void close() {
        super.close();
        for (int i = 0; i < inventory.items.length; i++) {
            if (inventory.items[i] != null) {
                inventory.items[i].button.setClicked(false);
            }
        }
        mustShowDescription = true;
        stage.addAction(Actions.removeActor(extraWindow));
        inventory.close();
        inventoryUsing.close();
        closeDescription();
        closeError();
    }

    @Override
    public void show() {
        super.show();
        stage.addActor(extraWindow);
        inventory.show();
        inventoryUsing.show();
        removeButton(ok);
        removeButton(notOk);
    }

    private void showDescription(String s) {
        stage.addActor(descriptionWindow);
        addButton(ok);
        addButton(notOk);
        stage.addActor(desc);
        desc.button.getLabel().setText(s);
    }

    private void closeDescription() {
        stage.addAction(Actions.removeActor(descriptionWindow));
        removeButton(ok);
        removeButton(notOk);
        multiplexer.removeProcessor(ok.stage);
        multiplexer.removeProcessor(notOk.stage);
        stage.addAction(Actions.removeActor(desc));
    }

    private void showError() {
        stage.addActor(exceptionWindow);
        addButton(close);
    }

    private void closeError() {
        stage.addAction(Actions.removeActor(exceptionWindow));
        removeButton(close);
    }

    public void invRender(Home home, Passport passport) {
        if (home.inv.isClicked()) {
            home.close();
            show();
            Gdx.input.setInputProcessor(this.multiplexer);
            home.inv.setClicked(false);
        }
        if (back.isClicked()) {
            close();
            Gdx.input.setInputProcessor(home.multiplexer);
            home.show();
            back.setClicked(false);
        }
        if (homeS.isClicked()) {
            close();
            closeDescription();
            closeError();
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