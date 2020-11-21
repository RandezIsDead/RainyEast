package com.dentheripper.trying.View.OnScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dentheripper.trying.GameCore.Assets;

public class Bar extends Actor {

    private Texture bar;
    private final Rectangle he;
    private float fullBar;
    private float realBar;
    private final String type;

    public Bar(String type) {
        this.type = type;
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        he = new Rectangle();

        if (type.equals("health")) {
            bar = new Texture(Gdx.files.internal("healthbar/fullHealth.png"));

            he.x = 5;
            he.y = 950 * (h/w);
            he.width = 200;
            he.height = 40 * (h/w);

            setFullBar(Float.parseFloat(Assets.data.getString("maxHP")));
        } else if (type.equals("strength")) {
            bar = new Texture(Gdx.files.internal("StrengthBar/fullStrength.png"));

            he.x = 5;
            he.y = 890 * (h/w);
            he.width = 200;
            he.height = 40 * (h/w);

            setFullBar(Float.parseFloat(Assets.data.getString("maxSP")));
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(bar, he.x, he.y, he.width, he.height);
        if (type.equals("health")) {
            setHealthBar();
        } else if (type.equals("strength")) {
            setStrBar();
        }
    }

    private void setHealthBar() {
        setFullBar(Float.parseFloat(Assets.data.getString("maxHP")));

        float thatFuckingPercent = (realBar * 100) / fullBar;

        if (thatFuckingPercent == 100) {
            bar = new Texture(Gdx.files.internal("healthbar/fullHealth.png"));
        }

        if (thatFuckingPercent < 100 && thatFuckingPercent >= 96.78f) {
            bar = new Texture(Gdx.files.internal("healthbar/96,78.png"));
        }

        if (thatFuckingPercent < 96.78f && thatFuckingPercent >= 93.56f) {
            bar = new Texture(Gdx.files.internal("healthbar/93,56.png"));
        }

        if (thatFuckingPercent < 93.56f && thatFuckingPercent >= 90.34f) {
            bar = new Texture(Gdx.files.internal("healthbar/90,34.png"));
        }

        if (thatFuckingPercent < 90.34f && thatFuckingPercent >= 87.12f) {
            bar = new Texture(Gdx.files.internal("healthbar/87,12.png"));
        }

        if (thatFuckingPercent < 87.12f && thatFuckingPercent >= 83.9f) {
            bar = new Texture(Gdx.files.internal("healthbar/83,90.png"));
        }

        if (thatFuckingPercent < 83.9f && thatFuckingPercent >= 80.68f) {
            bar = new Texture(Gdx.files.internal("healthbar/80,68.png"));
        }

        if (thatFuckingPercent < 80.68f && thatFuckingPercent >= 77.46f) {
            bar = new Texture(Gdx.files.internal("healthbar/77,46.png"));
        }

        if (thatFuckingPercent < 77.46f && thatFuckingPercent >= 74.24f) {
            bar = new Texture(Gdx.files.internal("healthbar/74,24.png"));
        }

        if (thatFuckingPercent < 74.24f && thatFuckingPercent >= 71.02f) {
            bar = new Texture(Gdx.files.internal("healthbar/71,02.png"));
        }

        if (thatFuckingPercent < 71.02f && thatFuckingPercent >= 67.8f) {
            bar = new Texture(Gdx.files.internal("healthbar/67,80.png"));
        }

        if (thatFuckingPercent < 67.8f && thatFuckingPercent >= 64.58f) {
            bar = new Texture(Gdx.files.internal("healthbar/64,58.png"));
        }

        if (thatFuckingPercent < 64.58f && thatFuckingPercent >= 61.36f) {
            bar = new Texture(Gdx.files.internal("healthbar/61,36.png"));
        }

        if (thatFuckingPercent < 61.36f && thatFuckingPercent >= 58.14f) {
            bar = new Texture(Gdx.files.internal("healthbar/58,14.png"));
        }

        if (thatFuckingPercent < 58.14f && thatFuckingPercent >= 54.92f) {
            bar = new Texture(Gdx.files.internal("healthbar/54,92.png"));
        }

        if (thatFuckingPercent < 54.92f && thatFuckingPercent >= 51.7f) {
            bar = new Texture(Gdx.files.internal("healthbar/51,70.png"));
        }

        if (thatFuckingPercent < 51.7f && thatFuckingPercent >= 48.48f) {
            bar = new Texture(Gdx.files.internal("healthbar/48,48.png"));
        }

        if (thatFuckingPercent < 48.48f && thatFuckingPercent >= 45.26f) {
            bar = new Texture(Gdx.files.internal("healthbar/45,26.png"));
        }

        if (thatFuckingPercent < 45.26f && thatFuckingPercent >= 42.04f) {
            bar = new Texture(Gdx.files.internal("healthbar/42,04.png"));
        }

        if (thatFuckingPercent < 42.04f && thatFuckingPercent >= 38.82f) {
            bar = new Texture(Gdx.files.internal("healthbar/38,82.png"));
        }

        if (thatFuckingPercent < 38.82f && thatFuckingPercent >= 35.6f) {
            bar = new Texture(Gdx.files.internal("healthbar/35,60.png"));
        }

        if (thatFuckingPercent < 35.6f && thatFuckingPercent >= 32.38f) {
            bar = new Texture(Gdx.files.internal("healthbar/32,38.png"));
        }

        if (thatFuckingPercent < 32.38f && thatFuckingPercent >= 29.16f) {
            bar = new Texture(Gdx.files.internal("healthbar/29,16.png"));
        }

        if (thatFuckingPercent < 29.16f && thatFuckingPercent >= 25.94f) {
            bar = new Texture(Gdx.files.internal("healthbar/25,94.png"));
        }

        if (thatFuckingPercent < 25.94f && thatFuckingPercent >= 22.72f) {
            bar = new Texture(Gdx.files.internal("healthbar/22,72.png"));
        }

        if (thatFuckingPercent < 22.72f && thatFuckingPercent >= 19.5f) {
            bar = new Texture(Gdx.files.internal("healthbar/19,50.png"));
        }

        if (thatFuckingPercent < 19.5f && thatFuckingPercent >= 16.28f) {
            bar = new Texture(Gdx.files.internal("healthbar/16,28.png"));
        }

        if (thatFuckingPercent < 16.28f && thatFuckingPercent >= 13.06f) {
            bar = new Texture(Gdx.files.internal("healthbar/13,06.png"));
        }

        if (thatFuckingPercent < 13.06f && thatFuckingPercent >= 9.84f) {
            bar = new Texture(Gdx.files.internal("healthbar/9,84.png"));
        }

        if (thatFuckingPercent < 9.84f && thatFuckingPercent >= 6.62f) {
            bar = new Texture(Gdx.files.internal("healthbar/6,62.png"));
        }

        if (thatFuckingPercent < 6.62f && thatFuckingPercent >= 0f) {
            bar = new Texture(Gdx.files.internal("healthbar/_3.40.png"));
        }
    }

    private void setStrBar() {
        setFullBar(Float.parseFloat(Assets.data.getString("maxSP")));

        float thatFuckingPercent = (realBar * 100) / fullBar;

        if (thatFuckingPercent == 100) {
            bar = new Texture(Gdx.files.internal("StrengthBar/fullStrength.png"));
        }

        if (thatFuckingPercent < 100 && thatFuckingPercent >= 96.78f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/96,78.png"));
        }

        if (thatFuckingPercent < 96.78f && thatFuckingPercent >= 93.56f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/93,56.png"));
        }

        if (thatFuckingPercent < 93.56f && thatFuckingPercent >= 90.34f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/90,34.png"));
        }

        if (thatFuckingPercent < 90.34f && thatFuckingPercent >= 87.12f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/87,12.png"));
        }

        if (thatFuckingPercent < 87.12f && thatFuckingPercent >= 83.9f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/83.90.png"));
        }

        if (thatFuckingPercent < 83.9f && thatFuckingPercent >= 80.68f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/80,68.png"));
        }

        if (thatFuckingPercent < 80.68f && thatFuckingPercent >= 77.46f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/77,46.png"));
        }

        if (thatFuckingPercent < 77.46f && thatFuckingPercent >= 74.24f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/74,24.png"));
        }

        if (thatFuckingPercent < 74.24f && thatFuckingPercent >= 71.02f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/71,02.png"));
        }

        if (thatFuckingPercent < 71.02f && thatFuckingPercent >= 67.8f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/67,80.png"));
        }

        if (thatFuckingPercent < 67.8f && thatFuckingPercent >= 64.58f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/64,58.png"));
        }

        if (thatFuckingPercent < 64.58f && thatFuckingPercent >= 61.36f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/61,36.png"));
        }

        if (thatFuckingPercent < 61.36f && thatFuckingPercent >= 58.14f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/58,14.png"));
        }

        if (thatFuckingPercent < 58.14f && thatFuckingPercent >= 54.92f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/54,92.png"));
        }

        if (thatFuckingPercent < 54.92f && thatFuckingPercent >= 51.7f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/51,70.png"));
        }

        if (thatFuckingPercent < 51.7f && thatFuckingPercent >= 48.48f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/48,48.png"));
        }

        if (thatFuckingPercent < 48.48f && thatFuckingPercent >= 45.26f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/45,26.png"));
        }

        if (thatFuckingPercent < 45.26f && thatFuckingPercent >= 42.04f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/42,04.png"));
        }

        if (thatFuckingPercent < 42.04f && thatFuckingPercent >= 38.82f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/38,82.png"));
        }

        if (thatFuckingPercent < 38.82f && thatFuckingPercent >= 35.6f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/35,60.png"));
        }

        if (thatFuckingPercent < 35.6f && thatFuckingPercent >= 32.38f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/32,38.png"));
        }

        if (thatFuckingPercent < 32.38f && thatFuckingPercent >= 29.16f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/29,16.png"));
        }

        if (thatFuckingPercent < 29.16f && thatFuckingPercent >= 25.94f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/25,94.png"));
        }

        if (thatFuckingPercent < 25.94f && thatFuckingPercent >= 22.72f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/22,72.png"));
        }

        if (thatFuckingPercent < 22.72f && thatFuckingPercent >= 19.5f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/19,50.png"));
        }

        if (thatFuckingPercent < 19.5f && thatFuckingPercent >= 16.28f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/16,28.png"));
        }

        if (thatFuckingPercent < 16.28f && thatFuckingPercent >= 13.06f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/13,06.png"));
        }

        if (thatFuckingPercent < 13.06f && thatFuckingPercent >= 9.84f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/9,84.png"));
        }

        if (thatFuckingPercent < 9.84f && thatFuckingPercent >= 6.62f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/6,62.png"));
        }

        if (thatFuckingPercent < 6.62f && thatFuckingPercent >= 0f) {
            bar = new Texture(Gdx.files.internal("StrengthBar/_3.40.png"));
        }
    }

    public void setRealBar(float x) {
        if (getRealBar() < 0) x = 0;
        if (getRealBar() > getFullBar()) x = getFullBar();
        this.realBar = x;
    }

    public float getRealBar() {
        return realBar;
    }

    private void setFullBar(float fullBar) {
        this.fullBar = fullBar;
    }

    public float getFullBar() {
        return fullBar;
    }
}
