package com.dentheripper.trying.GameCore;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.dentheripper.trying.BuildElements.ButtonBase;

public class Item {

    public ButtonBase button;
    public int id;
    public int index;
    public String drawable;
    public int type = 0;
    private float x;
    private float y;
    private float width;
    private float height;
    private boolean isUsing = false;
    private int cost;
    private int buff;
    private int statsID;
    private boolean hasWearScale;
    private int wearScalePercent;
    private float textScale = 1;

    public Item(int id, int index, int type) {
        this.id = id;
        this.index = index;
        setType(type);

        if (getType() == 0 || getType() == 10) itemGameInv();
        if (getType() == 1) itemInvUsing();
        if (getType() == 2) itemChipUsing();
        if (getType() == 3) itemShop();
        if (getType() == 4) itemOrders();
        setItem(id, x, y, width, height);
    }

    private void setItem(int id, float x, float y, float width, float height) {
        initializeItem(id);
        String path = "smart/items/items.txt";
        if (isHasWearScale()) {
            button = new ButtonBase(path, "----------", drawable, x, y, width, height);
            button.button.getLabel().setAlignment(Align.bottom);
            button.button.getLabel().setColor(Color.GREEN);
            button.button.getLabel().setFontScaleX(textScale);
        } else {
            button = new ButtonBase(path,  drawable, x, y, width, height);
        }
    }

    private void itemGameInv() {
        if (index >= 0 && index <= 3) {
            y = 773;
        }
        if (index >= 4 && index <= 7) {
            y = 655;
        }
        if (index >= 8 && index <= 11) {
            y = 535;
        }
        if (index >= 12 && index <= 15) {
            y = 418;
        }
        if (index >= 16 && index <= 19) {
            y = 299;
        }
        if (index >= 20 && index <= 23) {
            y = 185;
        }
        if (index == 0 || index == 4 || index == 8 || index == 12 || index == 16 || index == 20) {
            x = 712;
            width = 61;
            height = 105;
        }
        if (index == 1 || index == 5 || index == 9 || index == 13 || index == 17 || index == 21) {
            x = 784;
            width = 61;
            height = 105;
        }
        if (index == 2 || index == 6 || index == 10 || index == 14 || index == 18 || index == 22) {
            x = 856;
            width = 61;
            height = 105;
        }
        if (index == 3 || index == 7 || index == 11 || index == 15 || index == 19 || index == 23) {
            x = 928;
            width = 61;
            height = 105;
        }
    }

    private void itemInvUsing() {
        if (index == 0 && getType() == 1) {
            x = 461;
            y = 774;
            width = 39;
            height = 80;
        }
        if (index == 1 && getType() == 1) {
            x = 647;
            y = 690;
            width = 39;
            height = 80;
        }
        if (index == 2 && getType() == 1) {
            x = 475;
            y = 598;
            width = 39;
            height = 80;
        }
        if (index == 3 && getType() == 1) {
            x = 468;
            y = 343;
            width = 39;
            height = 80;
        }
        if (index == 4 && getType() == 1) {
            x = 647;
            y = 264;
            width = 39;
            height = 80;
        }
        if (index == 5 && getType() == 1) {
            x = 647;
            y = 154;
            width = 39;
            height = 80;
        }
        textScale = 0.65f;
    }

    private void itemChipUsing() {
        if (index == 0 && getType() == 2) {
            x = 655;
            y = 160;
            width = 40;
            height = 80;
        }
        if (index == 1 && getType() == 2) {
            x = 655;
            y = 260;
            width = 40;
            height = 80;
        }
        if (index == 2 && getType() == 2) {
            x = 655;
            y = 355;
            width = 40;
            height = 80;
        }
        if (index == 3 && getType() == 2) {
            x = 655;
            y = 450;
            width = 40;
            height = 80;
        }
        if (index == 4 && getType() == 2) {
            x = 655;
            y = 545;
            width = 40;
            height = 80;
        }
        if (index == 5 && getType() == 2) {
            x = 655;
            y = 640;
            width = 40;
            height = 80;
        }
        if (index == 6 && getType() == 2) {
            x = 655;
            y = 735;
            width = 40;
            height = 80;
        }
        textScale = 0.65f;
    }

    private void itemShop() {
        if (index >= 0 && index <= 4 && getType() == 3) {
            y = 709;
        }
        if (index >= 5 && index <= 9 && getType() == 3) {
            y = 580;
        }
        if (index >= 10 && index <= 14 && getType() == 3) {
            y = 446;
        }
        if (index >= 15 && index <= 19 && getType() == 3) {
            y = 312;
        }
        if (index >= 20 && index <= 24 && getType() == 3) {
            y = 180;
        }
        if (index == 0 || index == 5 || index == 10 || index == 15 || index == 20 && getType() == 3) {
            x = 191;
            width = 62;
            height = 105;
        }
        if (index == 1 || index == 6 || index == 11 || index == 16 || index == 21 && getType() == 3) {
            x = 273;
            width = 62;
            height = 105;
        }
        if (index == 2 || index == 7 || index == 12 || index == 17 || index == 22 && getType() == 3) {
            x = 356;
            width = 62;
            height = 105;
        }
        if (index == 3 || index == 8 || index == 13 || index == 18 || index == 23 && getType() == 3) {
            x = 438;
            width = 62;
            height = 105;
        }
        if (index == 4 || index == 9 || index == 14 || index == 19 || index == 24 && getType() == 3) {
            x = 521;
            width = 62;
            height = 105;
        }
    }

    private void itemOrders() {
        if (index == 0 || index == 1) {
            y = 710;
        }
        if (index == 2 || index == 3) {
            y = 576;
        }
        if (index == 4 || index == 5) {
            y = 444;
        }
        if (index == 6 || index == 7) {
            y = 310;
        }
        if (index == 0 || index == 2 || index == 4 || index == 6) {
            x = 685;
            width = 62;
            height = 105;
        }
        if (index == 1 || index == 3 || index == 5 || index == 7) {
            x = 767;
            width = 62;
            height = 105;
        }
    }

    /* type
        0-19 - energy and other drinks
        20-39 - heal and blue blood
        40-79 - augments
        80-89 - weapon(swords)
        90-99 - weapon(guns)
        100-139 - electronics
        140-179 - chips
        180-199 - suit
     */

    private void initializeItem(int id) {
        if (id == 0) {
            drawable = "energy1";
            setCost(50);
        }
        if (id == 1) {
            drawable = "energy2";
            setCost(50);
        }
        if (id == 2) {
            drawable = "energy3";
            setCost(50);
        }
        if (id == 3) {
            drawable = "energy4";
            setCost(50);
        }
        if (id == 4) {
            drawable = "energy5";
            setCost(50);
        }
        if (id == 5) {
            drawable = "energy6";
            setCost(50);
        }
        if (id == 10) {
            drawable = "beer1";
            setCost(100);
        }
        if (id == 10) {
            drawable = "beer2";
            setCost(100);
        }
        if (id == 20) {
            drawable = "heal1";
            setCost(50);
        }
        if (id == 30) {
            drawable = "blueBlood";
            setCost(200);
        }
        if (id == 40) {
            drawable = "brainAug";
            setStatsID(0);
            setCost(2000);
            setBuff(20);
            setHasWearScale(true);
            setDefaultWearScale();
        }
        if (id == 41) {
            drawable = "armsElite";
            setStatsID(1);
            setCost(2000);
            setBuff(40);
            setHasWearScale(true);
            setDefaultWearScale();
        }
        if (id == 42) {
            drawable = "heartAug";
            setStatsID(6);
            setCost(2000);
            setBuff(30);
            setHasWearScale(true);
            setDefaultWearScale();
        }
        if (id == 43) {
            drawable = "legsElite";
            setStatsID(7);
            setCost(2000);
            setBuff(10);
            setHasWearScale(true);
            setDefaultWearScale();
        }
        if (id == 100) {
            drawable = "cpu";
            setCost(5000);
        }
        if (id == 101) {
            drawable = "coil";
            setCost(100);
        }
        if (id == 102) {
            drawable = "diod";
            setCost(100);
        }
        if (id == 103) {
            drawable = "microcircuit";
            setCost(500);
        }
        if (id == 104) {
            drawable = "setOfWires";
            setCost(50);
        }
        if (id == 105) {
            drawable = "transistor";
            setCost(100);
        }
        if (id == 106) {
            drawable = "transistor2";
            setCost(100);
        }
        if (id == 140) {
            drawable = "highJump";
            setCost(1000);
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getBuff() {
        return buff;
    }

    public void setBuff(int buff) {
        this.buff = buff;
    }

    public int getStatsID() {
        return statsID;
    }

    public void setStatsID(int statsID) {
        this.statsID = statsID;
    }

    public boolean isUsing() {
        return isUsing;
    }

    public void setUsing(boolean using) {
        isUsing = using;
    }

    public boolean isHasWearScale() {
        return hasWearScale;
    }

    public void setHasWearScale(boolean hasWearScale) {
        this.hasWearScale = hasWearScale;
    }

    public int getWearScalePercent() {
        return wearScalePercent;
    }

    public void setWearScalePercent(int wearScalePercent) {
        this.wearScalePercent = wearScalePercent;
        char x = '-';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wearScalePercent/10; i++) {
            sb.append(x);
        }
        button.button.getLabel().setText(sb.toString());
    }

    public void setDefaultWearScale() {
        this.wearScalePercent = 100;
    }
}