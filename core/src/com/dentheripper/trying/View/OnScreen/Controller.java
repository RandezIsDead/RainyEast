package com.dentheripper.trying.View.OnScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dentheripper.trying.GameCore.Assets;

public class Controller extends Actor {

    private OrthographicCamera camera;
    private Vector3 touchPos;
    private Preferences data;
    private Texture contrField, cursor;
    private Rectangle contr;
    private Rectangle c;
    public boolean canMove = true;
    private boolean xf = false, xb = false, yf = false, yb = false;
    private boolean xxf = false, xff = false;
    private boolean xxb = false, xbb = false;
    private boolean yyf = false, yff = false;
    private boolean yyb = false, ybb = false;

    public Controller() {
        data = Gdx.app.getPreferences("Rainy_East");

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(1000, 1000 * (h / w));
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        touchPos = new Vector3();

        contrField = Assets.assetManager.get(Assets.controller);
        cursor = new Texture("elements/cursor.png");

        contr = new Rectangle();
        contr.x = 10;
        contr.y = 10;
        contr.width = 150;
        contr.height = 150;

        c = new Rectangle();
        c.x = 45;
        c.y = 45;
        c.width = 80;
        c.height = 80;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.draw(contrField, contr.x, contr.y, contr.width, contr.height);
        batch.draw(cursor, c.x, c.y, c.width, c.height);

        if (canMove) {
            if (Gdx.input.isTouched()) {
                if (Gdx.input.getX() <= Gdx.graphics.getWidth() / 4f && Gdx.input.getY() >= Gdx.graphics.getHeight() / 2f) {
                    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

                    camera.unproject(touchPos);
                    c.x = (int) (touchPos.x - 40);
                    c.y = (int) (touchPos.y - 40);
                } else  {
                    c.x = 45;
                    c.y = 45;
                }
            } else {
                c.x = 45;
                c.y = 45;
            }
        } else {
            c.x = 45;
            c.y = 45;
        }

        if (c.x > 95) c.x = 95;
        if (c.x < 10) c.x = 10;
        if (c.y > 95) c.y = 95;
        if (c.y < 10) c.y = 10;

        if (c.x > 70) setXf(true);
        else setXf(false);
        if (c.x < 35) setXb(true);
        else setXb(false);
        if (c.y > 70) setYf(true);
        else setYf(false);
        if (c.y < 35) setYb(true);
        else setYb(false);

        if (c.x > 70 && c.x <= 80) setXxf(true);
        else setXxf(false);
        if (c.x > 80 && c.x <= 95) setXff(true);
        else setXff(false);
        if (c.x < 35 && c.x >= 25) setXxb(true);
        else setXxb(false);
        if (c.x < 25 && c.x >= 10) setXbb(true);
        else setXbb(false);
        if (c.y > 70 && c.y <= 80) setYyf(true);
        else setYyf(false);
        if (c.y > 80 && c.y <= 95) setYff(true);
        else setYff(false);
        if (c.y < 35 && c.y >= 25) setYyb(true);
        else setYyb(false);
        if (c.y < 25 && c.y >= 10) setYbb(true);
        else setYbb(false);

        data.putBoolean("xf", isXf());
        data.putBoolean("xb", isXb());
        data.putBoolean("yf", isYf());
        data.putBoolean("yb", isYb());
        data.flush();

        data.putBoolean("xxf", isXxf());
        data.putBoolean("xff", isXff());
        data.putBoolean("xxb", isXxb());
        data.putBoolean("xbb", isXbb());
        data.putBoolean("yyf", isYyf());
        data.putBoolean("yff", isYff());
        data.putBoolean("yyb", isYyb());
        data.putBoolean("ybb", isYbb());
        data.flush();
    }

    private boolean isXf() {
        return xf;
    }

    private void setXf(boolean xf) {
        this.xf = xf;
    }

    private boolean isXb() {
        return xb;
    }

    private void setXb(boolean xb) {
        this.xb = xb;
    }

    public boolean isYf() {
        return yf;
    }

    public void setYf(boolean yf) {
        this.yf = yf;
    }

    public boolean isYb() {
        return yb;
    }

    public void setYb(boolean yb) {
        this.yb = yb;
    }

    public boolean isXxf() {
        return xxf;
    }

    public void setXxf(boolean xxf) {
        this.xxf = xxf;
    }

    public boolean isXff() {
        return xff;
    }

    public void setXff(boolean xff) {
        this.xff = xff;
    }

    public boolean isXxb() {
        return xxb;
    }

    public void setXxb(boolean xxb) {
        this.xxb = xxb;
    }

    public boolean isXbb() {
        return xbb;
    }

    public void setXbb(boolean xbb) {
        this.xbb = xbb;
    }

    public boolean isYyf() {
        return yyf;
    }

    public void setYyf(boolean yyf) {
        this.yyf = yyf;
    }

    public boolean isYff() {
        return yff;
    }

    public void setYff(boolean yff) {
        this.yff = yff;
    }

    public boolean isYyb() {
        return yyb;
    }

    public void setYyb(boolean yyb) {
        this.yyb = yyb;
    }

    public boolean isYbb() {
        return ybb;
    }

    public void setYbb(boolean ybb) {
        this.ybb = ybb;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
//        if (!canMove) {
//            contr.x = 10;
//            contr.y = 10;
//            c.x = 45;
//            c.y = 45;
//        }
    }
}