package com.dentheripper.trying.GameCore;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Entity extends Actor {

    //    Visual part of Entity
    public Rectangle me;
    private Animation<TextureRegion> standAnimation, runAnim, runAnimRev;
    private float stateTime;

    private boolean dead = false;
    private boolean running = false;

    //    Entity variable
    private float hp;
    private float maxHp;
    private float sp;
    private float maxSp;
    private int damage;
    private int healing;
    private int defence;
    private int intelligence;
    private int strength;
    private int agility;
    private int maxJump;

    public float w = Gdx.graphics.getWidth();
    public float h = Gdx.graphics.getHeight();

    //    Logical variable
    private float speed;
    private boolean xf;
    private boolean xb;
    private boolean yf;
    private boolean yb;

    private float x = 4000;
    private float y = 7800*(h/w);

    protected Entity() {
        me = new Rectangle();
        me.setX(getX());
        me.setY(getY());
        me.setSize(70, 150 * (h/w));

        stateTime = 0f;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        me.setX(getX());
        me.setY(getY());

        if (!xf && !xb && !yf && !yb) {
            stateTime += Gdx.graphics.getDeltaTime();
            TextureRegion currentFrame = standAnimation.getKeyFrame(stateTime, true);
            batch.draw(currentFrame, me.getX(), me.getY(), me.width, me.height);
            setRunning(false);
        }
        if (xf || (xf && yf) || (xf && yb)) {
            stateTime += Gdx.graphics.getDeltaTime();
            TextureRegion currentFrameRun = runAnim.getKeyFrame(stateTime, true);
            batch.draw(currentFrameRun, me.getX(), me.getY(), me.width, me.height);
            setRunning(true);
        }
        if (xb || (xb && yf) || (xb && yb)) {
            stateTime += Gdx.graphics.getDeltaTime();
            TextureRegion currentFrameRunRev = runAnimRev.getKeyFrame(stateTime, true);
            batch.draw(currentFrameRunRev, me.getX(), me.getY(), me.width, me.height);
            setRunning(true);
        }
        if (yf && !xb && !xf) {
            stateTime += Gdx.graphics.getDeltaTime();
            TextureRegion currentFrameRunRev = runAnimRev.getKeyFrame(stateTime, true);
            batch.draw(currentFrameRunRev, me.getX(), me.getY(), me.width, me.height);
            setRunning(true);
        }
        if (yb && !xb && !xf) {
            stateTime += Gdx.graphics.getDeltaTime();
            TextureRegion currentFrameRun = runAnim.getKeyFrame(stateTime, true);
            batch.draw(currentFrameRun, me.getX(), me.getY(), me.width, me.height);
            setRunning(true);
        }
        update();
    }

    protected void animStand(String path, int cols, int rows) {
        Texture stand = new Texture(Gdx.files.internal(path));
        TextureRegion[][] tmp = TextureRegion.split(stand, stand.getWidth()/ cols, stand.getHeight()/ rows); // #10
        TextureRegion[] standFrames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                standFrames[index++] = tmp[i][j];
            }
        }
        standAnimation = new Animation<>(0.4f, standFrames);
    }

    protected void animRunRight(String path, int cols, int rows) {
        Texture run = new Texture(Gdx.files.internal(path));
        TextureRegion[][] tmpr = TextureRegion.split(run, run.getWidth()/ cols, run.getHeight()/ rows); // #10
        TextureRegion[] runFrames = new TextureRegion[cols * rows];
        int indexR = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                runFrames[indexR++] = tmpr[i][j];
            }
        }
        runAnim = new Animation<>(0.08f, runFrames);
    }

    protected void animRunLeft(String path, int cols, int rows) {
        Texture runRev = new Texture(Gdx.files.internal(path));
        TextureRegion[][] tmprr = TextureRegion.split(runRev, runRev.getWidth()/ cols, runRev.getHeight()/ rows); // #10
        TextureRegion[] runRevFrames = new TextureRegion[cols * rows];
        int indexRR = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                runRevFrames[indexRR++] = tmprr[i][j];
            }
        }
        runAnimRev = new Animation<>(0.08f, runRevFrames);
    }

    public void setMovable(int canMoveCode) {
        if (canMoveCode == 0) {
            xf = Assets.data.getBoolean("xf");
            xb = Assets.data.getBoolean("xb");
            yf = Assets.data.getBoolean("yf");
            yb = Assets.data.getBoolean("yb");

            boolean xxf = Assets.data.getBoolean("xxf");
            boolean xxb = Assets.data.getBoolean("xxb");
            boolean yyf = Assets.data.getBoolean("yyf");
            boolean yyb = Assets.data.getBoolean("yyb");
            boolean xff = Assets.data.getBoolean("xff");
            boolean xbb = Assets.data.getBoolean("xbb");
            boolean yff = Assets.data.getBoolean("yff");
            boolean ybb = Assets.data.getBoolean("ybb");

            if (xxf) setX(getX() + getSpeed() * Gdx.graphics.getDeltaTime() / 2);
            if (xff) setX(getX() + getSpeed() * Gdx.graphics.getDeltaTime());
            if (xxb) setX(getX() - getSpeed() * Gdx.graphics.getDeltaTime() / 2);
            if (xbb) setX(getX() - getSpeed() * Gdx.graphics.getDeltaTime());
            if (yyf) setY(getY() + getSpeed() * Gdx.graphics.getDeltaTime() / 2);
            if (yff) setY(getY() + getSpeed() * Gdx.graphics.getDeltaTime());
            if (yyb) setY(getY() - getSpeed() * Gdx.graphics.getDeltaTime() / 2);
            if (ybb) setY(getY() - getSpeed() * Gdx.graphics.getDeltaTime());
        } else if (canMoveCode == 1) {
            xf = Assets.data.getBoolean("xf");
            xb = Assets.data.getBoolean("xb");
            yf = Assets.data.getBoolean("yf");
            yb = Assets.data.getBoolean("yb");

            boolean xxf = Assets.data.getBoolean("xxf");
            boolean xxb = Assets.data.getBoolean("xxb");
            boolean xff = Assets.data.getBoolean("xff");
            boolean xbb = Assets.data.getBoolean("xbb");

            if (xxf) setX(getX() + getSpeed() * Gdx.graphics.getDeltaTime() / 2);
            if (xff) setX(getX() + getSpeed() * Gdx.graphics.getDeltaTime());
            if (xxb) setX(getX() - getSpeed() * Gdx.graphics.getDeltaTime() / 2);
            if (xbb) setX(getX() - getSpeed() * Gdx.graphics.getDeltaTime());
        } else {
            Assets.data.putBoolean("xf", false);
            Assets.data.putBoolean("xb", false);
            Assets.data.putBoolean("yf", false);
            Assets.data.putBoolean("yb", false);

            Assets.data.putBoolean("xxf", false);
            Assets.data.putBoolean("xxb", false);
            Assets.data.putBoolean("yyf", false);
            Assets.data.putBoolean("yyb", false);
            Assets.data.putBoolean("xff", false);
            Assets.data.putBoolean("xbb", false);
            Assets.data.putBoolean("yff", false);
            Assets.data.putBoolean("ybb", false);
        }
    }

    public void moveRight(boolean xf) {
        if (xf) {
            setX(getX() + getSpeed()*Gdx.graphics.getDeltaTime());
        }
    }

    public void moveLeft(boolean xb) {
        if (xb) {
            setX(getX() - getSpeed()*Gdx.graphics.getDeltaTime());
        }
    }

    public void moveUp(boolean yf) {
        if (yf) {
            setY(getY() + getSpeed()*Gdx.graphics.getDeltaTime());
        }
    }

    public void moveDown(boolean yb) {
        if (yb) {
            setY(getY() - getSpeed()*Gdx.graphics.getDeltaTime());
        }
    }

    public void evade() {
        if (xf) {
            setX(getX()+100);
        }
        if (xb) {
            setX(getX()-100);
        }
        if (yf) {
            setY(getY()+100);
        }
        if (yb) {
            setY(getY()-100);
        }
    }

    public void cameraFreeze(OrthographicCamera camera, boolean freeze) {
        if (freeze) {
            if (camera.position.x < getX() + 35 * (h/w)) {
                camera.position.set(getX() + 75 * (h/w), camera.position.y,0);
            }
            if (camera.position.x > (getX() + 35 * (h/w))) {
                camera.position.set(getX() + 75 * (h/w), camera.position.y,0);
            }
            if (camera.position.y < getY() + 35 * (h/w)) {
                camera.position.set(camera.position.x, getY() + 75 * (h/w),0);
            }
            if (camera.position.y > (getY() + 35 * (h/w))) {
                camera.position.set(camera.position.x, getY() + 75 * (h/w),0);
            }
        }
        else {
            if (camera.position.x < getX() + 35 * (h/w)) {
                camera.position.set(camera.position.x, camera.position.y,0);
            }
            if (camera.position.x > (getX() + 35 * (h/w))) {
                camera.position.set(camera.position.x, camera.position.y,0);
            }
            if (camera.position.y < getY() + 35 * (h/w)) {
                camera.position.set(camera.position.x, camera.position.y,0);
            }
            if (camera.position.y > (getY() + 35 * (h/w))) {
                camera.position.set(camera.position.x, camera.position.y,0);
            }
        }
    }

    private void update() {
        if (hp > maxHp) hp = maxHp;
        if (hp <= 0) {
            hp = 0;
        }
        if (sp > maxSp) sp = maxSp;
        if (sp <= 0) {
            sp = 0;
        }
    }

    public void HPControl() {
        setHp(getHp() + 5*Gdx.graphics.getDeltaTime());
    }

    public void SPControl() {
        setSp(getSp() + 5*Gdx.graphics.getDeltaTime());
    }

    public void hit(int damage) {
        this.damage = damage;
    }

    public void heal(int healing) {
        this.healing = healing;
    }

    public void applyDamage() {
//        if (hasShield) {
//            if (damage == 0) {
//                hasShield = false;
//            }
//            if (defence - damage < 0) {
//                damage = Math.abs(defence - damage);
//                defence = 0;
//                hp -= damage;
//                damage = 0;
//                if (hp <= 0) {
//                    hp = 0;
//                    dead = true;
//                }
//            } else if (defence - damage == 0) {
//                defence = 0;
//            } else {
//                defence -= damage;
//                damage = 0;
//            }
//        } else {
//            hp -= damage;
//            damage = 0;
//            if (hp <= 0) {
//                hp = 0;
//                dead = true;
//            }
//        }
    }

    public void applyHeal() {
        hp += healing;
        healing = 0;
        if (hp > maxHp) hp = maxHp;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        if (hp < 0) hp = 0;
        if (hp > getMaxHp()) hp = getMaxHp();
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public float getMaxHp() {
        return maxHp;
    }

    public float getSp() {
        return sp;
    }

    public void setSp(float sp) {
        if (sp < 0) sp = 0;
        if (sp > getMaxSp()) sp = getMaxSp();
        this.sp = sp;
    }

    public float getMaxSp() {
        return maxSp;
    }

    public void setMaxSp(int maxSp) {
        this.maxSp = maxSp;
    }

    public boolean isDead() { return dead; }

    public void setDead(boolean dead) { this.dead = dead; }

    public int getDefence() {
        return defence;
    }

    public boolean healthBelow(int percentage) {
        return hp <= (int) ((percentage / 100f) * maxHp);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(int maxJump) {
        this.maxJump = maxJump;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    private float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    private boolean isXf() {
        return xf;
    }

    private boolean isXb() {
        return xb;
    }

    public boolean isYf() {
        return yf;
    }

    public boolean isYb() {
        return yb;
    }
}
