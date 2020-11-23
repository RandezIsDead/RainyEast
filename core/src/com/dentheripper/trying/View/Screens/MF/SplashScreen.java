package com.dentheripper.trying.View.Screens.MF;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.GameCore.Inventory;

public class SplashScreen extends ScreenBase {

    private float x = 0;

    public SplashScreen(Engine engine) {
        super(engine);
        setBG(new Texture(Gdx.files.internal("screenAssets/splash.png")), 1000, 1000 * (h/w));
        Assets.data.putBoolean("mainMusicRestart", true);
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
        if (Assets.data.getInteger("gameLaunches") == 0) {
            Inventory inventory = new Inventory(stage,0);
            Inventory chips = new Inventory(stage,10);
            Inventory invUsing = new Inventory(stage,1);
            Inventory invChipsUsing = new Inventory(stage,2);
            inventory.saveInventory();
            chips.saveInventory();
            invChipsUsing.saveInventory();
            invUsing.saveInventory();

            Assets.data.putString("intelligence", Integer.valueOf(10).toString());
            Assets.data.putString("maxHP", Integer.valueOf(100).toString());
            Assets.data.putString("maxSP", Integer.valueOf(100).toString());
            Assets.data.putString("realHP", Integer.valueOf(100).toString());
            Assets.data.putString("realSP", Integer.valueOf(100).toString());
            Assets.data.putString("healing", Integer.valueOf(10).toString());
            Assets.data.putString("strength", Integer.valueOf(10).toString());
            Assets.data.putString("damage", Integer.valueOf(10).toString());
            Assets.data.putString("defence", Integer.valueOf(10).toString());
            Assets.data.putString("agility", Integer.valueOf(10).toString());
            Assets.data.putString("skOp", Integer.valueOf(0).toString());
            Assets.data.putString("luck", Integer.valueOf(10).toString());

            Assets.data.putFloat("playerSpeed", 200);
            Assets.data.putInteger("money", 100000);
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
