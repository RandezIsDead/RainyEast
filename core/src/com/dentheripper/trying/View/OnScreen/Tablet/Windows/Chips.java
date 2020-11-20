package com.dentheripper.trying.View.OnScreen.Tablet.Windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Inventory;
import com.dentheripper.trying.GameCore.Item;

public class Chips extends SmartBase {

    private ExtraWindow extraWindow;
    private ExtraWindow descriptionWindow;
    private ExtraWindow exceptionWindow;
    private ButtonBase ok, notOk, close;
    public Inventory inventory;
    public Inventory inventoryUsing;

    public Chips() {
        setImage(Assets.assetManager.get(Assets.smartGrid));
        extraWindow = new ExtraWindow();
        extraWindow.setImage(Assets.assetManager.get(Assets.batteryChips), 650, 150, 50, 700);
        inventory = new Inventory(10);
        inventoryUsing = new Inventory(2);
        descriptionWindow = new ExtraWindow();
        descriptionWindow.setImage(Assets.assetManager.get(Assets.descWindow), 450, 50, 200, 900);
        ok = new ButtonBase("Atlas/smart.txt", "use", 460, 140, 180, 70);
        notOk = new ButtonBase("Atlas/smart.txt", "cancel", 460, 60, 180, 70);
        exceptionWindow = new ExtraWindow();
        exceptionWindow.setImage(Assets.assetManager.get(Assets.exception), 250, 50, 200, 900);
        close = new ButtonBase("Atlas/buttons.txt", "errOk", 260, 830, 180, 70);

        multiplexer.addProcessor(ok.stage);
        multiplexer.addProcessor(notOk.stage);
        multiplexer.addProcessor(close.stage);

        stage.addActor(ok);
        stage.addActor(descriptionWindow);
        stage.addActor(notOk);
        stage.addActor(exceptionWindow);
        stage.addActor(close);

        if (Gdx.app.getPreferences("Rainy_East").getInteger("gameLaunches") != 0) {
            inventory.loadInventory();
            inventoryUsing.loadInventory();
        }

        for (int i = 0; i < 24; i++) {
            if (inventory.items[i] != null) {
                multiplexer.addProcessor(inventory.items[i].button.stage);
                stage.addActor(inventory.items[i].button);
            }
        }
        for (int i = 0; i < 7; i++) {
            if (inventoryUsing.items[i] != null) {
                multiplexer.addProcessor(inventoryUsing.items[i].button.stage);
                stage.addActor(inventoryUsing.items[i].button);
            }
        }
    }

    @Override
    protected void actFinal(float delta) {
        super.actFinal(delta);
        stage.addActor(extraWindow);
        for (int i = 0; i < 24; i++) {
            if (inventory.items[i] != null) {
                checkItem(inventory.items[i].index, inventory.items[i].id);
            }
        }
        for (int i = 0; i < 7; i++) {
            if (inventoryUsing.items[i] != null) {
                deCheckItem(inventoryUsing.items[i].index, inventoryUsing.items[i].id);
            }
        }
    }

    private void checkItem(int index, int id) {
        if (inventory.items[index] != null) {
            if (inventory.items[index].button.isClicked() && inventory.items[index].id == id) {
                showDescription();
                if (ok.isClicked() && inventory.items[index].id == id && inventory.items[index].index == index) {
                    if (inventoryUsing.items[6] != null) {
                        closeDescription();
                        showError();
                        multiplexer.removeProcessor(ok.stage);
                        multiplexer.removeProcessor(notOk.stage);
                    } else {
                        useItem(inventory.items[index], id);
                        closeDescription();
                    }
                    ok.setClicked(false);
                }
                if (notOk.isClicked()) {
                    closeDescription();
                    notOk.setClicked(false);
                    inventory.items[index].button.setClicked(false);
                }
                if (close.isClicked()) {
                    closeError();
                    multiplexer.addProcessor(ok.stage);
                    multiplexer.addProcessor(notOk.stage);
                    close.setClicked(false);
                }
            }
        }
    }

    private void deCheckItem(int index, int id) {
        if (inventoryUsing.items[index] != null) {
            if (inventoryUsing.items[index].button.isClicked() && inventoryUsing.items[index].id == id) {
                inventoryUsing.items[index].button.setClicked(false);
                removeFromUsing(inventoryUsing.items[index], id);
            }
        }
    }

    private void useItem(Item item, int id) {
        int index = inventoryUsing.getFirstEmptyCell();

        Item rec = new Item(id, index, 2);
        stage.addAction(Actions.removeActor(item.button));
        multiplexer.removeProcessor(item.button.stage);
        inventory.removeItem(item.index);
        rec.setUsing(true);
        Gdx.input.setInputProcessor(this.multiplexer);

        multiplexer.addProcessor(rec.button.stage);
        stage.addActor(rec.button);
        inventoryUsing.addItemNotClose(rec);
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

            multiplexer.addProcessor(rec.button.stage);
            stage.addActor(rec.button);
            inventory.addItemNotClose(rec);
            inventory.saveInventory();
            inventoryUsing.saveInventory();
        } else {
            showError();
        }
    }

    @Override
    public void show() {
        super.show();
        extraWindow.show();
        inventory.show();
        inventoryUsing.show();
    }

    @Override
    public void close() {
        super.close();
        extraWindow.close();
        inventory.close();
        inventoryUsing.close();
        descriptionWindow.close();
        ok.addToClose();
        notOk.addToClose();
        exceptionWindow.close();
        close.addToClose();
        closeDescription();
        closeError();
    }

    private void showDescription() {
        descriptionWindow.show();
        ok.open();
        notOk.open();
    }

    private void closeDescription() {
        descriptionWindow.close();
        ok.addToClose();
        notOk.addToClose();
    }

    private void showError() {
        exceptionWindow.show();
        close.open();
        closeDescription();
    }

    private void closeError() {
        exceptionWindow.close();
        close.addToClose();
    }

    public void chipsRender(Home home) {
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
    }
}
