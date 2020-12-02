package com.dentheripper.trying.View.OnScreen.Windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Inventory;
import com.dentheripper.trying.GameCore.Item;

import java.util.Random;

public class ShopWindow {

    private final Stage stage;
    public Image image;
    private final Image exceptionWindow;
    private final ButtonBase desc;
    private final int type;
    public InputMultiplexer multiplexer;
    public Inventory inventory;
    public Inventory orders;
    public ButtonBase close;
    public ButtonBase take;
    private final Inventory itemInv;
    private final ButtonBase cost;
    public Image descriptionWindow;
    public ButtonBase ok, notOk, clErr;
    private boolean mustShowDescription = true;
    private int totalCost = 0;

    public ShopWindow(Stage stage, int type) {
        this.stage = stage;
        this.type = type;
        if (type == 0) {
            image = new Image(Assets.assetManager.get(Assets.shop1));
            image.setBounds(50, 100 * (Assets.h / Assets.w), 700, 800 * (Assets.h / Assets.w));
        } else if (type == 1) {
            image = new Image(Assets.assetManager.get(Assets.shop2));
            image.setBounds(50, 100 * (Assets.h / Assets.w), 700, 800 * (Assets.h / Assets.w));
        }
        descriptionWindow = new Image(Assets.assetManager.get(Assets.descWindow));
        descriptionWindow.setBounds(750, 50 * (Assets.h / Assets.w), 200, 900 * (Assets.h / Assets.w));
        ok = new ButtonBase("Atlas/smart.txt", "confirm", 760, 140, 180, 70);
        notOk = new ButtonBase("Atlas/smart.txt", "cancel", 760, 60, 180, 70);
        exceptionWindow = new Image(Assets.assetManager.get(Assets.exception));
        exceptionWindow.setBounds(750, 50 * (Assets.h / Assets.w), 200, 900 * (Assets.h / Assets.w));
        clErr = new ButtonBase("Atlas/buttons.txt", "errOk", 760, 830, 180, 70);
        desc = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 750, 150, 200, 700);

        inventory = new Inventory(stage, multiplexer, 3);
        orders = new Inventory(stage, multiplexer, 4);

        itemInv = new Inventory(stage, multiplexer, 0);
        itemInv.loadInventory();

        close = new ButtonBase("Atlas/smart.txt", "cancel", 250, 105, 100, 65);
        take = new ButtonBase("Atlas/smart.txt", "take", 600, 140, 120, 100);
        cost = new ButtonBase("Atlas/buttons.txt", "Cost:   " + totalCost, "skill_varity", 600, 250, 120, 50);
        cost.button.getLabel().setColor(Color.YELLOW);
        cost.button.getLabel().setAlignment(Align.center);

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(take.stage);
        multiplexer.addProcessor(close.stage);

        if (type == 0) {
            for (int i = 0; i < 25; i++) {
                Random random = new Random();
                inventory.addItem(new Item(random.nextInt((43 - 40) + 1) + 40, inventory.getFirstEmptyCell(), 3));
            }
        } else if (type == 1) {
            for (int i = 0; i < 25; i++) {
                if (itemInv.items.length > i) {
                    if (itemInv.items[i] != null) {
                        inventory.addItem(new Item(itemInv.id[i], inventory.getFirstEmptyCell(), 3));
                    }
                }
            }
        }
    }

    public void actFinal() {
        cost.button.setText("Cost:  " + totalCost);
        if (type == 0) {
            for (int i = 0; i < 25; i++) {
                if (inventory.items[i] != null) {
                    if (inventory.items[i].button.isClicked()) {
                        if (mustShowDescription && inventory.items[i].getDescription() != null) {
                            showDescription(inventory.items[i].getDescription());
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
            for (int i = 0; i < 8; i++) {
                if (orders.items[i] != null) {
                    if (orders.items[orders.items[i].index].button.isClicked()) {
                        orders.items[orders.items[i].index].button.setClicked(false);
                        deUseItem(orders.items[orders.items[i].index], orders.items[i].id);
                    }
                }
            }
            if (take.isClicked()) {
                for (int i = 0; i < 8; i++) {
                    if (orders.id[i] != -1) {
                        if (Assets.data.getInteger("money") >= getTotalCost()) {
                            Item rec = new Item(orders.id[i], orders.index[i], 4);
                            stage.addAction(Actions.removeActor(orders.items[i].button));
                            stage.addAction(Actions.removeActor(orders.items[i].wearScale));
                            multiplexer.removeProcessor(orders.items[i].button.stage);
                            orders.removeItem(orders.items[i].index);
                            Gdx.input.setInputProcessor(this.multiplexer);

                            itemInv.addItemNotClose(rec);
                            itemInv.saveInventory();
                            Assets.data.putInteger("money", Assets.data.getInteger("money") - getTotalCost());
                            setTotalCost(0);
                        }
                    }
                }
                take.setClicked(false);
            }
        } else if (type == 1) {
            for (int i = 0; i < 25; i++) {
                if (inventory.items[i] != null) {
                    if (inventory.items[i].button.isClicked()) {
                        if (mustShowDescription && inventory.items[i].getDescription() != null) {
                            showDescription(inventory.items[i].getDescription());
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
            for (int i = 0; i < 8; i++) {
                if (orders.items[i] != null) {
                    if (orders.items[orders.items[i].index].button.isClicked()) {
                        orders.items[orders.items[i].index].button.setClicked(false);
                        deUseItem(orders.items[orders.items[i].index], orders.items[i].id);
                    }
                }
            }
            if (take.isClicked()) {
                for (int i = 0; i < 8; i++) {
                    if (orders.id[i] != -1) {
                        if (Assets.data.getInteger("money") >= getTotalCost()) {
                            Item rec = new Item(orders.id[i], orders.index[i], 4);
                            stage.addAction(Actions.removeActor(orders.items[i].button));
                            stage.addAction(Actions.removeActor(orders.items[i].wearScale));
                            multiplexer.removeProcessor(orders.items[i].button.stage);
                            orders.removeItem(orders.items[i].index);
                            Gdx.input.setInputProcessor(this.multiplexer);

                            int index = -1;
                            for (int z = 0; z < itemInv.items.length; z++) {
                                if (itemInv.items[z] != null) {
                                    if (itemInv.items[z].id == rec.id) {
                                        index = itemInv.items[z].index;
                                    }
                                }
                            }
                            itemInv.removeItem(index);
                            itemInv.saveInventory();
                            Assets.data.putInteger("money", Assets.data.getInteger("money") + getTotalCost());
                            setTotalCost(0);
                        }
                    }
                }
                take.setClicked(false);
            }
        }
    }

    private void checkItem(int index, int id) {
        if (inventory.items[index] != null) {
            if (inventory.items[index].button.isClicked() && inventory.items[index].id == id) {
                inventory.items[index].button.setClicked(false);
                useItem(inventory.items[index], id);
            }
        }
    }

    private boolean canUseItem() {
        return orders.items[orders.getFirstEmptyCell()] == null;
    }

    private void showDescription(String s) {
        stage.addActor(descriptionWindow);
        stage.addActor(ok);
        stage.addActor(notOk);
        multiplexer.addProcessor(ok.stage);
        multiplexer.addProcessor(notOk.stage);
        stage.addActor(desc);
        desc.button.getLabel().setText(s);
        desc.button.getLabel().setColor(Color.WHITE);
    }

    private void closeDescription() {
        stage.addAction(Actions.removeActor(descriptionWindow));
        stage.addAction(Actions.removeActor(ok));
        stage.addAction(Actions.removeActor(notOk));
        multiplexer.removeProcessor(ok.stage);
        multiplexer.removeProcessor(notOk.stage);
        stage.addAction(Actions.removeActor(desc));
    }

    private void showError() {
        stage.addActor(exceptionWindow);
        stage.addActor(clErr);
        multiplexer.addProcessor(clErr.stage);
    }

    private void closeError() {
        stage.addAction(Actions.removeActor(exceptionWindow));
        stage.addAction(Actions.removeActor(clErr));
        multiplexer.removeProcessor(clErr.stage);
    }

    private void useItem(Item item, int id) {
        int index = orders.getFirstEmptyCell();

        if (index != -1) {
            Item rec = new Item(id, index, 4);
            stage.addAction(Actions.removeActor(item.button));
            stage.addAction(Actions.removeActor(item.wearScale));
            multiplexer.removeProcessor(item.button.stage);
            inventory.removeItem(item.index);
            rec.setUsing(true);
            Gdx.input.setInputProcessor(this.multiplexer);

            multiplexer.addProcessor(rec.button.stage);
            stage.addActor(rec.button);
            stage.addActor(rec.wearScale);
            orders.addItemNotClose(rec);
            if (type == 0) {
                setTotalCost(getTotalCost() + rec.getCost());
            } else if (type == 1) {
                if (rec.isHasWearScale()) {
                    setTotalCost(getTotalCost() + rec.getCost() * 90 / 100 * (rec.getWearScalePercent() / 100));
                } else {
                    setTotalCost(getTotalCost() + rec.getCost() * 90 / 100);
                }
            }
        }
    }

    private void deUseItem(Item item, int id) {
        int index = inventory.getFirstEmptyCell();

        Item rec = new Item(id, index, 3);
        stage.addAction(Actions.removeActor(item.button));
        stage.addAction(Actions.removeActor(item.wearScale));
        multiplexer.removeProcessor(item.button.stage);
        orders.removeItem(item.index);
        rec.setUsing(false);
        Gdx.input.setInputProcessor(this.multiplexer);

        multiplexer.addProcessor(rec.button.stage);
        stage.addActor(rec.button);
        stage.addActor(rec.wearScale);
        inventory.addItemNotClose(rec);
        if (type == 0) {
            setTotalCost(getTotalCost() - rec.getCost());
        } else if (type == 1) {
            if (rec.isHasWearScale()) {
                setTotalCost(getTotalCost() - rec.getCost() / 10000 * 90 * rec.getWearScalePercent());
            } else {
                setTotalCost(getTotalCost() - rec.getCost() * 90 / 100);
            }
        }
    }

    public void show() {
        stage.addActor(image);
        inventory.show();
        orders.show();
        stage.addActor(take);
        stage.addActor(close);
        stage.addActor(cost);
    }

    public void close() {
        stage.addAction(Actions.removeActor(image));
        inventory.close();
        orders.close();
        stage.addAction(Actions.removeActor(take));
        stage.addAction(Actions.removeActor(cost));
        stage.addAction(Actions.removeActor(close));
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
