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
    public InputMultiplexer multiplexer;
    public Inventory inventory;
    public Inventory orders;
    public ButtonBase close;
    public ButtonBase take;
    private final Inventory itemInv;
    private final ButtonBase cost;

    private int totalCost = 0;

    public ShopWindow(Stage stage, int type) {
        this.stage = stage;
        if (type == 0) {
            image = new Image(Assets.assetManager.get(Assets.shop1));
            image.setBounds(150, 100 * (Assets.h / Assets.w), 700, 800 * (Assets.h / Assets.w));
        }
        inventory = new Inventory(stage, 3);
        orders = new Inventory(stage, 4);

        itemInv = new Inventory(stage, 0);
        itemInv.loadInventory();

        close = new ButtonBase("Atlas/smart.txt", "cancel", 350, 105, 100, 65);
        take = new ButtonBase("Atlas/smart.txt", "take", 700, 140, 120, 100);
        cost = new ButtonBase("Atlas/buttons.txt", "Cost:   " + totalCost, "skill_varity", 700, 250, 120, 50);
        cost.button.getLabel().setColor(Color.YELLOW);
        cost.button.getLabel().setAlignment(Align.center);

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(take.stage);
        multiplexer.addProcessor(close.stage);

        for (int i = 0; i < 25; i++) {
            Random random = new Random();
            inventory.addItem(new Item(random.nextInt((43 - 40) + 1) + 40, inventory.getFirstEmptyCell(), 3));
        }
    }

    public void actFinal() {
        cost.button.setText("Cost:  " + totalCost);
        for (int i = 0; i < 25; i++) {
            if (inventory.items[i] != null) {
                checkItem(inventory.items[i].index, inventory.items[i].id);
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
                        Assets.data.putInteger("money",  Assets.data.getInteger("money") - getTotalCost());
                        setTotalCost(0);
                    }
                }
            }
            take.setClicked(false);
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
            setTotalCost(getTotalCost() + rec.getCost());
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
        setTotalCost(getTotalCost() - rec.getCost());
    }

    public void show() {
        stage.addActor(image);
        inventory.show(multiplexer);
        orders.show(multiplexer);
        stage.addActor(take);
        stage.addActor(close);
        stage.addActor(cost);
    }

    public void close() {
        stage.addAction(Actions.removeActor(image));
        inventory.close(multiplexer);
        orders.close(multiplexer);
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
