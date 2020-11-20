package com.dentheripper.trying.ListModels;

import com.dentheripper.trying.View.Entities.NPC;

public class NPCModel {

    private NPC npc;
    private String npcName;
    private String npcID;
    private final int IS_NPC_ANDROID;
    private int npcMoney;
    private float posX;
    private float posY;

    public NPCModel(NPC npc, String npcName, int IS_NPC_ANDROID, float posX, float posY) {
        this.npc = npc;
        this.npcName = npcName;
        this.IS_NPC_ANDROID = IS_NPC_ANDROID;
        this.posX = posX;
        this.posY = posY;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }

    public String getNpcName() {
        return npcName;
    }

    public String getNpcID() {
        return npcID;
    }

    public void setNpcID(String npcID) {
        this.npcID = npcID;
    }

    public int getNpcMoney() {
        return npcMoney;
    }

    public void setNpcMoney(int npcMoney) {
        this.npcMoney = npcMoney;
    }

    public int getIS_NPC_ANDROID() {
        return IS_NPC_ANDROID;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
}
