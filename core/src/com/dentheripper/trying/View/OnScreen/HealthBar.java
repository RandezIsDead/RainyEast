package com.dentheripper.trying.View.OnScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dentheripper.trying.GameCore.Data;

public class HealthBar extends Actor {

    private Texture health;
    private Rectangle he;
    private float fullHealth;
    private float realHealth;

    public HealthBar() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        health = new Texture(Gdx.files.internal("healthbar/fullHealth.png"));

        he = new Rectangle();
        he.x = 5;
        he.y = 950 * (h/w);
        he.width = 200;
        he.height = 40 * (h/w);

        setFullHealth(Float.parseFloat(new Data().getString("maxHP")));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(health, he.x, he.y, he.width, he.height);
        setFullHealth(Float.parseFloat(new Data().getString("maxHP")));

        float thatFuckingPercent = (realHealth * 100) / fullHealth;

        if (thatFuckingPercent == 100) {
            health = new Texture(Gdx.files.internal("healthbar/fullHealth.png"));
        }

        if (thatFuckingPercent < 100 && thatFuckingPercent >= 96.78f) {
            health = new Texture(Gdx.files.internal("healthbar/96,78.png"));
        }

        if (thatFuckingPercent < 96.78f && thatFuckingPercent >= 93.56f) {
            health = new Texture(Gdx.files.internal("healthbar/93,56.png"));
        }

        if (thatFuckingPercent < 93.56f && thatFuckingPercent >= 90.34f) {
            health = new Texture(Gdx.files.internal("healthbar/90,34.png"));
        }

        if (thatFuckingPercent < 90.34f && thatFuckingPercent >= 87.12f) {
            health = new Texture(Gdx.files.internal("healthbar/87,12.png"));
        }

        if (thatFuckingPercent < 87.12f && thatFuckingPercent >= 83.9f) {
            health = new Texture(Gdx.files.internal("healthbar/83,90.png"));
        }

        if (thatFuckingPercent < 83.9f && thatFuckingPercent >= 80.68f) {
            health = new Texture(Gdx.files.internal("healthbar/80,68.png"));
        }

        if (thatFuckingPercent < 80.68f && thatFuckingPercent >= 77.46f) {
            health = new Texture(Gdx.files.internal("healthbar/77,46.png"));
        }

        if (thatFuckingPercent < 77.46f && thatFuckingPercent >= 74.24f) {
            health = new Texture(Gdx.files.internal("healthbar/74,24.png"));
        }

        if (thatFuckingPercent < 74.24f && thatFuckingPercent >= 71.02f) {
            health = new Texture(Gdx.files.internal("healthbar/71,02.png"));
        }

        if (thatFuckingPercent < 71.02f && thatFuckingPercent >= 67.8f) {
            health = new Texture(Gdx.files.internal("healthbar/67,80.png"));
        }

        if (thatFuckingPercent < 67.8f && thatFuckingPercent >= 64.58f) {
            health = new Texture(Gdx.files.internal("healthbar/64,58.png"));
        }

        if (thatFuckingPercent < 64.58f && thatFuckingPercent >= 61.36f) {
            health = new Texture(Gdx.files.internal("healthbar/61,36.png"));
        }

        if (thatFuckingPercent < 61.36f && thatFuckingPercent >= 58.14f) {
            health = new Texture(Gdx.files.internal("healthbar/58,14.png"));
        }

        if (thatFuckingPercent < 58.14f && thatFuckingPercent >= 54.92f) {
            health = new Texture(Gdx.files.internal("healthbar/54,92.png"));
        }

        if (thatFuckingPercent < 54.92f && thatFuckingPercent >= 51.7f) {
            health = new Texture(Gdx.files.internal("healthbar/51,70.png"));
        }

        if (thatFuckingPercent < 51.7f && thatFuckingPercent >= 48.48f) {
            health = new Texture(Gdx.files.internal("healthbar/48,48.png"));
        }

        if (thatFuckingPercent < 48.48f && thatFuckingPercent >= 45.26f) {
            health = new Texture(Gdx.files.internal("healthbar/45,26.png"));
        }

        if (thatFuckingPercent < 45.26f && thatFuckingPercent >= 42.04f) {
            health = new Texture(Gdx.files.internal("healthbar/42,04.png"));
        }

        if (thatFuckingPercent < 42.04f && thatFuckingPercent >= 38.82f) {
            health = new Texture(Gdx.files.internal("healthbar/38,82.png"));
        }

        if (thatFuckingPercent < 38.82f && thatFuckingPercent >= 35.6f) {
            health = new Texture(Gdx.files.internal("healthbar/35,60.png"));
        }

        if (thatFuckingPercent < 35.6f && thatFuckingPercent >= 32.38f) {
            health = new Texture(Gdx.files.internal("healthbar/32,38.png"));
        }

        if (thatFuckingPercent < 32.38f && thatFuckingPercent >= 29.16f) {
            health = new Texture(Gdx.files.internal("healthbar/29,16.png"));
        }

        if (thatFuckingPercent < 29.16f && thatFuckingPercent >= 25.94f) {
            health = new Texture(Gdx.files.internal("healthbar/25,94.png"));
        }

        if (thatFuckingPercent < 25.94f && thatFuckingPercent >= 22.72f) {
            health = new Texture(Gdx.files.internal("healthbar/22,72.png"));
        }

        if (thatFuckingPercent < 22.72f && thatFuckingPercent >= 19.5f) {
            health = new Texture(Gdx.files.internal("healthbar/19,50.png"));
        }

        if (thatFuckingPercent < 19.5f && thatFuckingPercent >= 16.28f) {
            health = new Texture(Gdx.files.internal("healthbar/16,28.png"));
        }

        if (thatFuckingPercent < 16.28f && thatFuckingPercent >= 13.06f) {
            health = new Texture(Gdx.files.internal("healthbar/13,06.png"));
        }

        if (thatFuckingPercent < 13.06f && thatFuckingPercent >= 9.84f) {
            health = new Texture(Gdx.files.internal("healthbar/9,84.png"));
        }

        if (thatFuckingPercent < 9.84f && thatFuckingPercent >= 6.62f) {
            health = new Texture(Gdx.files.internal("healthbar/6,62.png"));
        }

        if (thatFuckingPercent < 6.62f && thatFuckingPercent >= 0f) {
            health = new Texture(Gdx.files.internal("healthbar/_3.40.png"));
        }
    }

    public void setRealHealth(float x) {
        if (getRealHealth() < 0) x = 0;
        if (getRealHealth() > getFullHealth()) x = getFullHealth();
        this.realHealth = x;
    }

    public float getRealHealth() {
        return realHealth;
    }

    private void setFullHealth(float fullHealth) {
        this.fullHealth = fullHealth;
    }

    public float getFullHealth() {
        return fullHealth;
    }
}
