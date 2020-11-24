package com.dentheripper.trying.View.OnScreen.SmartWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Inventory;
import com.dentheripper.trying.GameCore.Item;

public class Chips extends SmartBase {

    private final ExtraWindow extraWindow;
    private final ExtraWindow descriptionWindow;
    private final ExtraWindow exceptionWindow;
    private final ButtonBase ok, notOk, close;
    public Inventory inventory;
    public Inventory inventoryUsing;
    private boolean mustShowDescription = true;

    public Chips() {
        setImage(Assets.assetManager.get(Assets.smartGrid));
        extraWindow = new ExtraWindow();
        extraWindow.setImage(Assets.assetManager.get(Assets.batteryChips), 650, 150, 50, 700);
        inventory = new Inventory(stage,10);
        inventoryUsing = new Inventory(stage,2);
        descriptionWindow = new ExtraWindow();
        descriptionWindow.setImage(Assets.assetManager.get(Assets.descWindow), 450, 50, 200, 900);
        ok = new ButtonBase("Atlas/smart.txt", "use", 460, 140, 180, 70);
        notOk = new ButtonBase("Atlas/smart.txt", "cancel", 460, 60, 180, 70);
        exceptionWindow = new ExtraWindow();
        exceptionWindow.setImage(Assets.assetManager.get(Assets.exception), 450, 50, 200, 900);
        close = new ButtonBase("Atlas/buttons.txt", "errOk", 460, 830, 180, 70);

        stage.addActor(extraWindow);

        if (Assets.data.getInteger("gameLaunches") != 0) {
            inventory.loadInventory();
            inventoryUsing.loadInventory();
        }
    }

    @Override
    protected void actFinal(float delta) {
        super.actFinal(delta);
        for (int i = 0; i < 24; i++) {
            if (inventory.items[i] != null) {
                if (inventory.items[i].button.isClicked()) {
                    if (mustShowDescription) {
                        showDescription();
                    }
                    if (ok.isClicked()) {
                        if (canUseItem()) {
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
        for (int i = 0; i < 7; i++) {
            if (inventoryUsing.items[i] != null) {
                if (inventoryUsing.items[i].button.isClicked()) {
                    inventoryUsing.items[i].button.setClicked(false);
                    removeFromUsing(inventoryUsing.items[i], inventoryUsing.items[i].id);
                }
            }
        }
    }

    private void useItem(Item item, int id) {
        int index = inventoryUsing.getFirstEmptyCell();

        Item rec = new Item(id, index, 2);
        stage.addAction(Actions.removeActor(item.button));
        stage.addAction(Actions.removeActor(item.wearScale));
        multiplexer.removeProcessor(item.button.stage);
        inventory.removeItem(item.index);
        rec.setUsing(true);
        Gdx.input.setInputProcessor(this.multiplexer);

        multiplexer.addProcessor(rec.button.stage);
        stage.addActor(rec.button);
        stage.addActor(rec.wearScale);
        inventoryUsing.addItemNotClose(rec);
        inventory.saveInventory();
        inventoryUsing.saveInventory();
    }

    private void removeFromUsing(Item item, int id) {
        int index = inventory.getFirstEmptyCell();

        if (index != -1) {
            Item rec = new Item(id, index, 0);
            stage.addAction(Actions.removeActor(item.button));
            stage.addAction(Actions.removeActor(item.wearScale));
            multiplexer.removeProcessor(item.button.stage);
            inventoryUsing.removeItem(item.index);
            rec.setUsing(false);
            Gdx.input.setInputProcessor(this.multiplexer);

            multiplexer.addProcessor(rec.button.stage);
            stage.addActor(rec.button);
            stage.addActor(rec.wearScale);
            inventory.addItemNotClose(rec);
            inventory.saveInventory();
            inventoryUsing.saveInventory();
        } else {
            showError();
        }
    }

    private boolean canUseItem() {
        return inventoryUsing.items[inventoryUsing.getFirstEmptyCell()] == null;
    }

    @Override
    public void show() {
        super.show();
        extraWindow.show();
        inventory.show(multiplexer);
        inventoryUsing.show(multiplexer);
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

    private void showDescription() {
        stage.addActor(descriptionWindow);
        stage.addActor(ok);
        stage.addActor(notOk);
    }

    private void closeDescription() {
        stage.addAction(Actions.removeActor(descriptionWindow));
        stage.addAction(Actions.removeActor(notOk));
        stage.addAction(Actions.removeActor(ok));
    }

    private void showError() {
        stage.addActor(exceptionWindow);
        addButton(close);
    }

    private void closeError() {
        stage.addAction(Actions.removeActor(exceptionWindow));
        removeButton(close);
    }

    public void chipsRender(Home home, Passport passport) {
        if (home.chips.isClicked()) {
            home.close();
            show();
            Gdx.input.setInputProcessor(this.multiplexer);
            home.chips.setClicked(false);
        }
        if (back.isClicked()) {
            close();
            home.show();
            Gdx.input.setInputProcessor(home.multiplexer);
            back.setClicked(false);
        }
        if (homeS.isClicked()) {
            close();
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
