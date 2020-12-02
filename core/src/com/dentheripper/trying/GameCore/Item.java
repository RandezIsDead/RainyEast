package com.dentheripper.trying.GameCore;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
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
    private String description;
    private int cost;
    private int buff;
    private int statsID;
    public Image wearScale;
    private boolean hasWearScale;
    private int wearScalePercent;

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
        if (isHasWearScale()) {
            button = new ButtonBase("smart/items/items.txt", drawable, x, y, width, height);
            wearScale = new Image(new Texture(Gdx.files.internal("wearScale/10.png")));
            wearScale.setPosition(x, y * (Assets.h / Assets.w));
            wearScale.setSize(width, height / 20 * (Assets.h / Assets.w));
        } else {
            button = new ButtonBase("smart/items/items.txt", drawable, x, y, width, height);
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
            y = 340;
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
            x = 91;
            width = 62;
            height = 105;
        }
        if (index == 1 || index == 6 || index == 11 || index == 16 || index == 21 && getType() == 3) {
            x = 173;
            width = 62;
            height = 105;
        }
        if (index == 2 || index == 7 || index == 12 || index == 17 || index == 22 && getType() == 3) {
            x = 256;
            width = 62;
            height = 105;
        }
        if (index == 3 || index == 8 || index == 13 || index == 18 || index == 23 && getType() == 3) {
            x = 338;
            width = 62;
            height = 105;
        }
        if (index == 4 || index == 9 || index == 14 || index == 19 || index == 24 && getType() == 3) {
            x = 421;
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
            x = 585;
            width = 62;
            height = 105;
        }
        if (index == 1 || index == 3 || index == 5 || index == 7) {
            x = 667;
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
            setDescription("That item will allow \n you to feel more \n intelligence \n\n\n +20 intelligence");
            setStatsID(0);
            setCost(2000);
            setBuff(20);
            setHasWearScale(true);
            setDefaultWearScale();
        }
        if (id == 41) {
            drawable = "armsElite";
            setDescription("Try out our new \n arms and feel \n the truly power \n\n\n +40 strength");
            setStatsID(1);
            setCost(2000);
            setBuff(40);
            setHasWearScale(true);
            setDefaultWearScale();
        }
        if (id == 42) {
            drawable = "heartAug";
            setDescription("Your healing \n on the next \n level now \n\n\n +30 healing");
            setStatsID(6);
            setCost(2000);
            setBuff(30);
            setHasWearScale(true);
            setDefaultWearScale();
        }
        if (id == 43) {
            drawable = "legsElite";
            setDescription("With that you \n can run fast \n like a wind \n\n\n +10 agility");
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    private Texture getWearScaleTexture() {
        Texture texture = new Texture(Gdx.files.internal("wearScale/10.png"));
        int percent = getWearScalePercent();
        if (percent > 90 && percent <= 100) {
            texture = new Texture(Gdx.files.internal("wearScale/10.png"));
        }
        if (percent > 80 && percent <= 90) {
            texture = new Texture(Gdx.files.internal("wearScale/9.png"));
        }
        if (percent > 70 && percent <= 80) {
            texture = new Texture(Gdx.files.internal("wearScale/8.png"));
        }
        if (percent > 60 && percent <= 70) {
            texture = new Texture(Gdx.files.internal("wearScale/7.png"));
        }
        if (percent > 50 && percent <= 60) {
            texture = new Texture(Gdx.files.internal("wearScale/6.png"));
        }
        if (percent > 40 && percent <= 50) {
            texture = new Texture(Gdx.files.internal("wearScale/5.png"));
        }
        if (percent > 30 && percent <= 40) {
            texture = new Texture(Gdx.files.internal("wearScale/4.png"));
        }
        if (percent > 20 && percent <= 30) {
            texture = new Texture(Gdx.files.internal("wearScale/3.png"));
        }
        if (percent > 10 && percent <= 20) {
            texture = new Texture(Gdx.files.internal("wearScale/2.png"));
        }
        if (percent > 0 && percent <= 10) {
            texture = new Texture(Gdx.files.internal("wearScale/1.png"));
        }
        if (percent == 0) {
            texture = new Texture(Gdx.files.internal("wearScale/0.png"));
        }
        return texture;
    }

    public int getWearScalePercent() {
        return wearScalePercent;
    }

    public void setWearScalePercent(int wearScalePercent) {
        this.wearScalePercent = Math.max(wearScalePercent, 0);
        wearScale.setDrawable(new TextureRegionDrawable(getWearScaleTexture()));
    }

    public void setDefaultWearScale() {
        this.wearScalePercent = 100;
    }
}