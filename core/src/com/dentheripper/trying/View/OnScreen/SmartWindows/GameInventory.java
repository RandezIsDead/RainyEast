package com.dentheripper.trying.View.OnScreen.SmartWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Inventory;
import com.dentheripper.trying.GameCore.Item;

public class GameInventory extends SmartBase {

    private final ExtraWindow extraWindow;
    private final ExtraWindow descriptionWindow;
    private final ExtraWindow exceptionWindow;
    private final ButtonBase ok, notOk, close;
    public Inventory inventory;
    public Inventory inventoryUsing;
    private boolean mustShowDescription = true;

    public GameInventory() {
        setImage(Assets.assetManager.get(Assets.smartGrid));
        extraWindow = new ExtraWindow();
        extraWindow.setImage(Assets.assetManager.get(Assets.invExt), 450, 128, 250, 760);
        inventory = new Inventory(stage,0);
        inventoryUsing = new Inventory(stage,1);
        descriptionWindow = new ExtraWindow();
        descriptionWindow.setImage(Assets.assetManager.get(Assets.descWindow), 250, 50, 200, 900);
        ok = new ButtonBase("Atlas/smart.txt", "use", 260, 140, 180, 70);
        notOk = new ButtonBase("Atlas/smart.txt", "cancel", 260, 60, 180, 70);
        exceptionWindow = new ExtraWindow();
        exceptionWindow.setImage(Assets.assetManager.get(Assets.exception), 250, 50, 200, 900);
        close = new ButtonBase("Atlas/buttons.txt", "errOk", 260, 830, 180, 70);

        stage.addActor(extraWindow);

        if (Gdx.app.getPreferences("Rainy_East").getInteger("gameLaunches") != 0) {
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
                        showDescription();
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
                    removeFromUsing(inventoryUsing.items[i], inventoryUsing.items[i].id);
                }
            }
        }
    }

    private void useItem(Item item, int id) {
        int index = setIndexById(id);

        Item rec = new Item(id, index, 1);
        stage.addAction(Actions.removeActor(item.button));
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
        inventoryUsing.addItemAtIndexNotClose(rec, index);
        inventory.saveInventory();
        inventoryUsing.saveInventory();
    }

    private void removeFromUsing(Item item, int id) {
        int index = inventory.getFirstEmptyCell();

        if (index != -1) {
            Item rec = new Item(id, index, 0);
            stage.addAction(Actions.removeActor(item.button));
            multiplexer.removeProcessor(item.button.stage);
            inventoryUsing.removeItem(item.index);
            rec.setUsing(false);
            Gdx.input.setInputProcessor(this.multiplexer);

            if (rec.getStatsID() == 0) Assets.data.putString("intelligence", Integer.valueOf(Integer.parseInt(Assets.data.getString("intelligence")) - rec.getBuff()).toString());
            if (rec.getStatsID() == 1) Assets.data.putString("strength", Integer.valueOf(Integer.parseInt(Assets.data.getString("strength")) - rec.getBuff()).toString());
            if (rec.getStatsID() == 6) Assets.data.putString("healing", Integer.valueOf(Integer.parseInt(Assets.data.getString("healing")) - rec.getBuff()).toString());
            if (rec.getStatsID() == 7) Assets.data.putString("agility", Integer.valueOf(Integer.parseInt(Assets.data.getString("agility")) - rec.getBuff()).toString());

            multiplexer.addProcessor(rec.button.stage);
            stage.addActor(rec.button);
            inventory.addItemNotClose(rec);
            inventory.saveInventory();
            inventoryUsing.saveInventory();
        } else {
            showError();
        }
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
        extraWindow.close();
        inventory.close(multiplexer);
        inventoryUsing.close(multiplexer);
        closeDescription();
        closeError();
    }

    @Override
    public void show() {
        super.show();
        extraWindow.show();
        inventory.show(multiplexer);
        inventoryUsing.show(multiplexer);
        removeButton(ok);
        removeButton(notOk);
    }

    private void showDescription() {
        stage.addActor(descriptionWindow);
        addButton(ok);
        addButton(notOk);
    }

    private void closeDescription() {
        stage.addAction(Actions.removeActor(descriptionWindow));
        removeButton(ok);
        removeButton(notOk);
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
