package com.dentheripper.trying.GameCore;

public class Inventory {

    private int INV_SLOTS;
    public Item[] items;
    public int[] id;
    public int[] index;
    private final boolean[] indexes;
    private final int param;

    public Inventory(int param) {
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
                items[i].button.open();
                items[i].openWearScale();
            }
        }
    }

    public void close() {
        for (int i = 0; i < INV_SLOTS; i++) {
            if (items[i] != null) {
                items[i].button.addToClose();
                items[i].closeWearScale();
            }
        }
    }

    public void saveInventory() {
        int[] idw = new int[INV_SLOTS];
        int[] indexw = new int[INV_SLOTS];
        for (int i = 0; i < INV_SLOTS; i++) {
            idw[i] = id[i];
            indexw[i] = index[i];
        }
        Assets.data.saveInv(idw, indexw, param, INV_SLOTS);
    }

    public void loadInventory() {
        int[] idss = new int[INV_SLOTS];
        int[] indxs = new int[INV_SLOTS];
        for (int i = 0; i < INV_SLOTS; i++) {
            idss = Assets.data.loadInvIDs(param, INV_SLOTS);
            indxs = Assets.data.loadInvIndx(param, INV_SLOTS);
        }
        for (int i = 0; i < INV_SLOTS; i++) {
            if (idss[i] != -1) {
                items[i] = new Item(idss[i], indxs[i], param);
                id[i] = idss[i];
                index[i] = indxs[i];
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
            items[i].button.addToClose();
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
            items[index].button.addToClose();
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
