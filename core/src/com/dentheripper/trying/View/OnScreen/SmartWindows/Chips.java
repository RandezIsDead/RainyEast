package com.dentheripper.trying.View.OnScreen.SmartWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Inventory;
import com.dentheripper.trying.GameCore.Item;

public class Chips extends SmartBase {

    private final Image extraWindow;
    private final Image descriptionWindow;
    private final Image exceptionWindow;
    private final ButtonBase ok, notOk, close;
    public Inventory inventory;
    public Inventory inventoryUsing;
    private boolean mustShowDescription = true;

    public Chips(Stage stage) {
        super(stage);
        setImage(Assets.assetManager.get(Assets.smartGrid));
        extraWindow = new Image(Assets.assetManager.get(Assets.batteryChips));
        extraWindow.setBounds(650, 150 * (h / w), 50, 700 * (h / w));
        inventory = new Inventory(stage, multiplexer, 10);
        inventoryUsing = new Inventory(stage, multiplexer, 2);
        descriptionWindow = new Image(Assets.assetManager.get(Assets.descWindow));
        descriptionWindow.setBounds(450, 50 * (h / w), 200, 900 * (h / w));
        ok = new ButtonBase("Atlas/smart.txt", "use", 460, 140, 180, 70);
        notOk = new ButtonBase("Atlas/smart.txt", "cancel", 460, 60, 180, 70);
        exceptionWindow = new Image(Assets.assetManager.get(Assets.exception));
        exceptionWindow.setBounds(450, 50 * (h / w), 200, 900 * (h / w));
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
                            Item rec = inventoryUsing.items[i];
                            inventoryUsing.moveItem(inventory, inventoryUsing, rec, inventoryUsing.getFirstEmptyCell(), 0);
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
                    Item rec = inventoryUsing.items[i];
                    inventoryUsing.moveItem(inventoryUsing, inventory, rec, inventory.getFirstEmptyCell(), 0);
                }
            }
        }
    }

    private boolean canUseItem() {
        return inventoryUsing.items[inventoryUsing.getFirstEmptyCell()] == null;
    }

    @Override
    public void show() {
        super.show();
        stage.addActor(extraWindow);
        inventory.show();
        inventoryUsing.show();
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