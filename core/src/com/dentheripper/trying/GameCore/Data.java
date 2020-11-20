package com.dentheripper.trying.GameCore;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Data {

    public Preferences data;

    public Data() {
        data = Gdx.app.getPreferences("Rainy_East");
    }

    public boolean getBoolean(String key) {
        return data.getBoolean(key);
    }

    public void putBoolean(String key, boolean value) {
        data.putBoolean(key, value);
        flush();
    }

    public float getFloat(String key) {
        return data.getFloat(key);
    }

    public void putFloat(String key, float value) {
        data.putFloat(key, value);
        flush();
    }

    public int getInteger(String key) {
        return data.getInteger(key);
    }

    public void putInteger(String key, int value) {
        data.putInteger(key, value);
        flush();
    }

    public String getString(String key) {
        return data.getString(key);
    }

    public void putString(String key, String value) {
        data.putString(key, value);
        flush();
    }

    public float getPrefX() {
        return data.getFloat("playerX");
    }

    public float getPrefY() {
        return data.getFloat("playerY");
    }

    public void setPrefX(float x) {
        data.putFloat("playerX", x);
        flush();
    }

    public void setPrefY(float y) {
        data.putFloat("playerY", y);
        flush();
    }

    public void setPrefSpeed(float speed) {
        data.putFloat("playerSpeed", speed);
        flush();
    }

    public float getPrefSpeed() {
        return data.getFloat("playerSpeed");
    }

    public float getPrefHp() {
        return Float.parseFloat(data.getString("realHP"));
    }

    public float getPrefSp() {
        return Float.parseFloat(data.getString("realSP"));
    }

    public void setPrefHp(float hp) {
        data.putFloat("realHP", hp);
        flush();
    }

    public void setPrefSp(float sp) {
        data.putFloat("realSP", sp);
        flush();
    }

    public void saveInv(int[] listOfIds, int[] listOfIndexes, int param, int numSlots) {
        for (int x = 0; x < numSlots; x++){
            data.putInteger(param + "invIDs" + x, listOfIds[x]);
            data.putInteger(param + "invIndexes" + x, listOfIndexes[x]);
        }
        flush();
    }

    public int[] loadInvIDs(int param, int numSlots) {
        int[] arr = new int[numSlots];
        for (int x = 0; x < numSlots; x++){
            arr[x] = data.getInteger(param + "invIDs" + x);
        }
        return arr;
    }

    public int[] loadInvIndx(int param, int numSlots) {
        int[] arr = new int[numSlots];
        for (int x = 0; x < numSlots; x++){
            arr[x] = data.getInteger(param + "invIndexes" + x);
        }
        return arr;
    }

    public void savePlayerInfo() {
        // TODO
    }

    public void flush() {
        data.flush();
    }
}
