package com.dentheripper.trying.View.Screens.MF;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.GameCore.Inventory;

public class SplashScreen extends ScreenBase {

    private float x = 0;

    public SplashScreen(Engine engine) {
        super(engine);
        setBG(new Texture(Gdx.files.internal("screenAssets/splash.png")), 1000, 1000 * (h/w));
        firstLaunchInitialize();
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        actFinal(delta);
        x = x + Gdx.graphics.getDeltaTime();
        if (x >= 2) engine.setScreen(new Main(engine));
    }

    private void firstLaunchInitialize() {
        if (data.getInteger("gameLaunches") == 0) {
            Inventory inventory = new Inventory(0);
            Inventory chips = new Inventory(10);
            Inventory invUsing = new Inventory(1);
            Inventory invChipsUsing = new Inventory(2);
            inventory.saveInventory();
            chips.saveInventory();
            invChipsUsing.saveInventory();
            invUsing.saveInventory();

            data.putString("intelligence", Integer.valueOf(10).toString());
            data.putString("maxHP", Integer.valueOf(100).toString());
            data.putString("maxSP", Integer.valueOf(100).toString());
            data.putString("realHP", Integer.valueOf(100).toString());
            data.putString("realSP", Integer.valueOf(100).toString());
            data.putString("healing", Integer.valueOf(10).toString());
            data.putString("strength", Integer.valueOf(10).toString());
            data.putString("damage", Integer.valueOf(10).toString());
            data.putString("defence", Integer.valueOf(10).toString());
            data.putString("agility", Integer.valueOf(10).toString());
            data.putString("skOp", Integer.valueOf(0).toString());
            data.putString("luck", Integer.valueOf(10).toString());

            data.putFloat("playerSpeed", 200);
            data.putInteger("money", 1000000);

            for (int i = 0; i < 100; i++) {
                data.putString("NPC" + i, "NPC" + i);
                data.putInteger("NPC" + i + "0to1", RandomInt0to1());
                data.putFloat("NPC" + i + "posX", RandomFloat(100, 10000));
                data.putFloat("NPC" + i + "posY", RandomFloat(100, 10000));
            }
        }
    }

    public int RandomInt0to1() {
        float a = (float) Math.random();
        if(a < 0.65)
            return 0;
        else
            return 1;
    }

    public float RandomFloat(float min, float max) {
        return (float) ((Math.random() * (max - min)) + min);
    }
}