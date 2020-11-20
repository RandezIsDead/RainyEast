package com.dentheripper.trying.View.OnScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dentheripper.trying.GameCore.Data;

public class StrengthBar extends Actor {

    private Texture strength;
    private Rectangle he;
    private float fullStrength;
    private float realStrength;

    public StrengthBar() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        strength = new Texture(Gdx.files.internal("StrengthBar/fullStrength.png"));

        he = new Rectangle();
        he.x = 5;
        he.y = 890 * (h/w);
        he.width = 200;
        he.height = 40 * (h/w);

        setFullStrength(Float.parseFloat(new Data().getString("maxSP")));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(strength, he.x, he.y, he.width, he.height);
        setFullStrength(Float.parseFloat(new Data().getString("maxSP")));

        float thatFuckingPercent = (realStrength * 100) / fullStrength;

        if (thatFuckingPercent == 100) {
            strength = new Texture(Gdx.files.internal("StrengthBar/fullStrength.png"));
        }

        if (thatFuckingPercent < 100 && thatFuckingPercent >= 96.78f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/96,78.png"));
        }

        if (thatFuckingPercent < 96.78f && thatFuckingPercent >= 93.56f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/93,56.png"));
        }

        if (thatFuckingPercent < 93.56f && thatFuckingPercent >= 90.34f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/90,34.png"));
        }

        if (thatFuckingPercent < 90.34f && thatFuckingPercent >= 87.12f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/87,12.png"));
        }

        if (thatFuckingPercent < 87.12f && thatFuckingPercent >= 83.9f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/83.90.png"));
        }

        if (thatFuckingPercent < 83.9f && thatFuckingPercent >= 80.68f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/80,68.png"));
        }

        if (thatFuckingPercent < 80.68f && thatFuckingPercent >= 77.46f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/77,46.png"));
        }

        if (thatFuckingPercent < 77.46f && thatFuckingPercent >= 74.24f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/74,24.png"));
        }

        if (thatFuckingPercent < 74.24f && thatFuckingPercent >= 71.02f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/71,02.png"));
        }

        if (thatFuckingPercent < 71.02f && thatFuckingPercent >= 67.8f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/67,80.png"));
        }

        if (thatFuckingPercent < 67.8f && thatFuckingPercent >= 64.58f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/64,58.png"));
        }

        if (thatFuckingPercent < 64.58f && thatFuckingPercent >= 61.36f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/61,36.png"));
        }

        if (thatFuckingPercent < 61.36f && thatFuckingPercent >= 58.14f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/58,14.png"));
        }

        if (thatFuckingPercent < 58.14f && thatFuckingPercent >= 54.92f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/54,92.png"));
        }

        if (thatFuckingPercent < 54.92f && thatFuckingPercent >= 51.7f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/51,70.png"));
        }

        if (thatFuckingPercent < 51.7f && thatFuckingPercent >= 48.48f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/48,48.png"));
        }

        if (thatFuckingPercent < 48.48f && thatFuckingPercent >= 45.26f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/45,26.png"));
        }

        if (thatFuckingPercent < 45.26f && thatFuckingPercent >= 42.04f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/42,04.png"));
        }

        if (thatFuckingPercent < 42.04f && thatFuckingPercent >= 38.82f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/38,82.png"));
        }

        if (thatFuckingPercent < 38.82f && thatFuckingPercent >= 35.6f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/35,60.png"));
        }

        if (thatFuckingPercent < 35.6f && thatFuckingPercent >= 32.38f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/32,38.png"));
        }

        if (thatFuckingPercent < 32.38f && thatFuckingPercent >= 29.16f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/29,16.png"));
        }

        if (thatFuckingPercent < 29.16f && thatFuckingPercent >= 25.94f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/25,94.png"));
        }

        if (thatFuckingPercent < 25.94f && thatFuckingPercent >= 22.72f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/22,72.png"));
        }

        if (thatFuckingPercent < 22.72f && thatFuckingPercent >= 19.5f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/19,50.png"));
        }

        if (thatFuckingPercent < 19.5f && thatFuckingPercent >= 16.28f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/16,28.png"));
        }

        if (thatFuckingPercent < 16.28f && thatFuckingPercent >= 13.06f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/13,06.png"));
        }

        if (thatFuckingPercent < 13.06f && thatFuckingPercent >= 9.84f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/9,84.png"));
        }

        if (thatFuckingPercent < 9.84f && thatFuckingPercent >= 6.62f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/6,62.png"));
        }

        if (thatFuckingPercent < 6.62f && thatFuckingPercent >= 0f) {
            strength = new Texture(Gdx.files.internal("StrengthBar/_3.40.png"));
        }
    }

    public void setRealStrength(float x) {
        if (getRealStrength() < 0) x = 0;
        if (getRealStrength() > getFullStrength()) x = getFullStrength();
        this.realStrength = x;
    }

    public float getRealStrength() {
        return realStrength;
    }

    private void setFullStrength(float fullStrength) {
        this.fullStrength = fullStrength;
    }

    public float getFullStrength() {
        return fullStrength;
    }
}