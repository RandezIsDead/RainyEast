package com.dentheripper.trying.View.OnScreen.Windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Inventory;
import com.dentheripper.trying.GameCore.Item;

import java.util.Random;

public class ShopWindow extends ExtraWindow {

    public InputMultiplexer multiplexer;
    public Inventory inventory;
    public Inventory orders;
    public ButtonBase close;
    public ButtonBase take;
    private Inventory itemInv;
    private ButtonBase cost;

    private int totalCost = 0;

    public ShopWindow(int type) {
        if (type == 0) {
            setImage(Assets.assetManager.get(Assets.shop1), 150, 100, 700, 800);
        }
        inventory = new Inventory(3);
        orders = new Inventory(4);

        itemInv = new Inventory(0);
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

        for (int i = 0; i < 25; i++) {
            if (inventory.items[i] != null) {
                multiplexer.addProcessor(inventory.items[i].button.stage);
                stage.addActor(inventory.items[i].button);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (orders.items[i] != null) {
                multiplexer.addProcessor(orders.items[i].button.stage);
                stage.addActor(orders.items[i].button);
            }
        }

        stage.addActor(close);
        stage.addActor(take);
        stage.addActor(cost);
    }

    @Override
    public void actFinal(float delta) {
        super.actFinal(delta);
        cost.button.setText("Cost:  " + totalCost);
        for (int i = 0; i < 25; i++) {
            if (inventory.items[i] != null) {
                checkItem(inventory.items[i].index, inventory.items[i].id);
            }
        }
        for (int i = 0; i < 8; i++) {
            if (orders.items[i] != null) {
                deCheckItem(orders.items[i].index, orders.items[i].id);
            }
        }
        if (take.isClicked()) {
            for (int i = 0; i < 8; i++) {
                if (orders.id[i] != -1) {
                    if (Assets.data.getInteger("money") >= getTotalCost()) {
                        Item rec = new Item(orders.id[i], orders.index[i], 4);
                        stage.addAction(Actions.removeActor(orders.items[i].button));
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

    private void deCheckItem(int index, int id) {
        if (orders.items[index] != null) {
            if (orders.items[index].button.isClicked() && orders.items[index].id == id) {
                orders.items[index].button.setClicked(false);
                deUseItem(orders.items[index], id);
            }
        }
    }

    private void useItem(Item item, int id) {
        int index = orders.getFirstEmptyCell();

        if (index != -1) {
            Item rec = new Item(id, index, 4);
            stage.addAction(Actions.removeActor(item.button));
            multiplexer.removeProcessor(item.button.stage);
            inventory.removeItem(item.index);
            rec.setUsing(true);
            Gdx.input.setInputProcessor(this.multiplexer);

            multiplexer.addProcessor(rec.button.stage);
            stage.addActor(rec.button);
            orders.addItemNotClose(rec);
            setTotalCost(getTotalCost() + rec.getCost());
        }
    }

    private void deUseItem(Item item, int id) {
        int index = inventory.getFirstEmptyCell();

        Item rec = new Item(id, index, 3);
        stage.addAction(Actions.removeActor(item.button));
        multiplexer.removeProcessor(item.button.stage);
        orders.removeItem(item.index);
        rec.setUsing(false);
        Gdx.input.setInputProcessor(this.multiplexer);

        multiplexer.addProcessor(rec.button.stage);
        stage.addActor(rec.button);
        inventory.addItemNotClose(rec);
        setTotalCost(getTotalCost() - rec.getCost());
    }

    @Override
    public void show() {
        super.show();
        inventory.show();
        orders.show();
        take.open();
        close.open();
        cost.open();
    }

    @Override
    public void close() {
        super.close();
        inventory.close();
        orders.close();
        take.addToClose();
        close.addToClose();
        cost.addToClose();
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
