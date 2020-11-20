package com.dentheripper.trying.GameCore;

public class Shop {

    private int type;
    private float x;
    private float y;
    private float width;
    private float height;

    public void setShop(int type, float x, float y, float width, float height) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean checkCollision(float x, float y) {
        return x >= this.x - 20 && y >= this.y - 20 && x <= this.x + this.width + 20 && y <= this.y + this.height + 20;
    }

    public int getType() {
        return type;
    }
}
