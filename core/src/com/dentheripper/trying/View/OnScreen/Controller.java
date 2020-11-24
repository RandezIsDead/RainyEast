package com.dentheripper.trying.View.OnScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dentheripper.trying.GameCore.Assets;

public class Controller extends Actor {

    private final OrthographicCamera camera;
    private final Vector3 touchPos;
    private final Texture contrField;
    private final Texture cursor;
    private final Rectangle contr;
    private final Rectangle c;
    public boolean canMove = true;
    private boolean xf = false, xb = false, yf = false, yb = false;
    private boolean xxf = false, xff = false;
    private boolean xxb = false, xbb = false;
    private boolean yyf = false, yff = false;
    private boolean yyb = false, ybb = false;

    public Controller() {
        float w = Assets.w;
        float h = Assets.h;

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

        setXf(c.x > 70);
        setXb(c.x < 35);
        setYf(c.y > 70);
        setYb(c.y < 35);

        setXxf(c.x > 70 && c.x <= 80);
        setXff(c.x > 80 && c.x <= 95);
        setXxb(c.x < 35 && c.x >= 25);
        setXbb(c.x < 25 && c.x >= 10);
        setYyf(c.y > 70 && c.y <= 80);
        setYff(c.y > 80 && c.y <= 95);
        setYyb(c.y < 35 && c.y >= 25);
        setYbb(c.y < 25 && c.y >= 10);

        Assets.data.putBoolean("xf", isXf());
        Assets.data.putBoolean("xb", isXb());
        Assets.data.putBoolean("yf", isYf());
        Assets.data.putBoolean("yb", isYb());
        Assets.data.flush();

        Assets.data.putBoolean("xxf", isXxf());
        Assets.data.putBoolean("xff", isXff());
        Assets.data.putBoolean("xxb", isXxb());
        Assets.data.putBoolean("xbb", isXbb());
        Assets.data.putBoolean("yyf", isYyf());
        Assets.data.putBoolean("yff", isYff());
        Assets.data.putBoolean("yyb", isYyb());
        Assets.data.putBoolean("ybb", isYbb());
        Assets.data.flush();
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