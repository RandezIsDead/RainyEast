package com.dentheripper.trying.GameCore;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Inventory {

    private final Stage stage;
    private final InputMultiplexer multiplexer;
    private int INV_SLOTS;
    public Item[] items;
    public int[] id;
    public int[] index;
    private final boolean[] indexes;
    private final int param;

    public Inventory(Stage stage, InputMultiplexer multiplexer, int param) {
        this.stage = stage;
        this.multiplexer = multiplexer;
        this.param = param;
        if (param == 0 || param == 10) INV_SLOTS = 24;
        if (param == 1) INV_SLOTS = 6;
        if (param == 2) INV_SLOTS = 7;
        if (param == 3) INV_SLOTS = 25;
        if (param == 4) INV_SLOTS = 8;
        id = new int[INV_SLOTS];
        index = new int[INV_SLOTS];
        indexes = new boolean[INV_SLOTS];
        items = new Item[INV_SLOTS];
        for (int i = 0; i < INV_SLOTS; i++) {
            indexes[i] = false;
            id[i] = -1;
            index[i] = -1;
        }
    }

    public void show() {
        for (int i = 0; i < INV_SLOTS; i++) {
            if (items[i] != null) {
                stage.addActor(items[i].button);
                multiplexer.addProcessor(items[i].button.stage);
                stage.addActor(items[i].wearScale);
            }
        }
    }

    public void close() {
        for (int i = 0; i < INV_SLOTS; i++) {
            if (items[i] != null) {
                stage.addAction(Actions.removeActor(items[i].button));
                multiplexer.removeProcessor(items[i].button.stage);
                stage.addAction(Actions.removeActor(items[i].wearScale));
            }
        }
    }

    public void saveInventory() {
        int[] idw = new int[INV_SLOTS];
        int[] indexw = new int[INV_SLOTS];
        int[] wearScaleParams = new int[INV_SLOTS];
        for (int i = 0; i < INV_SLOTS; i++) {
            idw[i] = id[i];
            indexw[i] = index[i];
            if (items[i] != null) {
                wearScaleParams[i] = items[i].getWearScalePercent();
            } else {
                wearScaleParams[i] = -1;
            }
        }
        Assets.data.saveInv(idw, indexw, param, INV_SLOTS);
        Assets.data.saveArr(wearScaleParams, "wearScale" + param);
    }

    public void loadInventory() {
        int[] idss = new int[INV_SLOTS];
        int[] indxs = new int[INV_SLOTS];
        int[] wearScale = new int[INV_SLOTS];
        for (int i = 0; i < INV_SLOTS; i++) {
            idss = Assets.data.loadInvIDs(param, INV_SLOTS);
            indxs = Assets.data.loadInvIndx(param, INV_SLOTS);
            wearScale = Assets.data.loadArr("wearScale" + param, INV_SLOTS);
        }
        for (int i = 0; i < INV_SLOTS; i++) {
            if (idss[i] != -1) {
                items[i] = new Item(idss[i], indxs[i], param);
                id[i] = idss[i];
                index[i] = indxs[i];
                if (items[i] != null && wearScale[i] != -1) {
                    items[i].setWearScalePercent(wearScale[i]);
                }
            }
        }
    }

    public int getFirstEmptyCell() {
        for (int i = 0; i < INV_SLOTS; i++) {
            if (items[i] == null && !indexes[i]) return i;
        }
        return -1;
    }

    public Item getItem(int index) {
        return items[index];
    }

    private boolean isFreeSlot(int index) {
        return items[index] == null;
    }

    public void addItem(Item item) {
        int i = getFirstEmptyCell();
        if (i != -1) {
            item.index = i;
            id[i] = item.id;
            index[i] = item.index;
            indexes[i] = true;
            items[i] = item;
            stage.addAction(Actions.removeActor(items[i].button));
            stage.addAction(Actions.removeActor(items[i].wearScale));
        }
    }

    public void addItemNotClose(Item item) {
        int i = getFirstEmptyCell();
        if (i != -1) {
            item.index = i;
            id[i] = item.id;
            index[i] = item.index;
            indexes[i] = true;
            items[i] = item;
        }
    }

    public void addItemAtIndex(Item item, int index) {
        if (isFreeSlot(index)) {
            id[index] = item.id;
            this.index[index] = item.index;
            indexes[index] = true;
            items[index] = item;
            stage.addAction(Actions.removeActor(items[index].button));
            stage.addAction(Actions.removeActor(items[index].wearScale));
        }
    }

    public void addItemAtIndexNotClose(Item item, int index) {
        if (isFreeSlot(index)) {
            id[index] = item.id;
            this.index[index] = item.index;
            indexes[index] = true;
            items[index] = item;
        }
    }

    public void removeItem(int index) {
        if (items[index] != null) {
            this.index[index] = -1;
            indexes[index] = false;
            items[index] = null;
            id[index] = -1;
        }
    }

    public void moveItem(Inventory inventory1, Inventory inventory2, Item item, int index, int type) {
        int wsp = 0;
        if (item.isHasWearScale()) {
            wsp = item.getWearScalePercent();
        }

        if (index != -1) {
            Item rec = new Item(item.id, index, type);
            stage.addAction(Actions.removeActor(item.button));
            if (item.isHasWearScale()) {
                stage.addAction(Actions.removeActor(item.wearScale));
            }
            multiplexer.removeProcessor(item.button.stage);
            inventory1.removeItem(item.index);
            rec.setUsing(true);
            Gdx.input.setInputProcessor(this.multiplexer);

            multiplexer.addProcessor(rec.button.stage);
            stage.addActor(rec.button);
            if (rec.isHasWearScale()) {
                stage.addActor(rec.wearScale);
                rec.setWearScalePercent(wsp);
            }
            inventory2.addItemNotClose(rec);
            inventory1.saveInventory();
            inventory2.saveInventory();
        }
    }

    public boolean isFull() {
        for (int i = 0; i < INV_SLOTS; i++) {
            if (items[i] == null) return false;
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < INV_SLOTS; i++) {
            removeItem(i);
        }
    }
}
