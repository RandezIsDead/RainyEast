package com.dentheripper.trying.BuildElements.GameBaseElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.GameCore.Assets;

import java.util.ArrayList;
import java.util.List;

public class SkillBranchBase extends Actor {

    private final Stage stage;
    public InputMultiplexer multiplexer;
    private Image image;
    private Texture texture;
    private final String type;

    public float w = Assets.w;
    public float h = Assets.h;

    protected List<ButtonBase> skill = new ArrayList<>();
    private final List<Float> xPos = new ArrayList<>();
    private final List<Float> yPos = new ArrayList<>();

    public SkillBranchBase(String type) {
        this.type = type;

        stage = new Stage(new StretchViewport(1000, 1000 * (h / w)));
        multiplexer = new InputMultiplexer();

        switch (type) {
            case "ai":
                setAIBranch();
                break;
            case "arm":
                setArmBranch();
                break;
            case "augment":
                setAugmentBranch();
                break;
            case "dna":
                setDnaBranch();
                break;
            case "eye":
                setEyeBranch();
                break;
            case "heart":
                setHeartBranch();
                break;
            case "intelligence":
                setIntelligenceBranch();
                break;
            case "leg":
                setLegBranch();
                break;
            case "lungs":
                setLungsBranch();
                break;
            case "silence":
                setSilenceBranch();
                break;
        }

        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        stage.draw();
        switch (type) {
            case "ai":
                if (skill.get(0).isClicked()) {
                    System.out.println("aiOpen");
                    skill.get(0).setClicked(false);
                }
                if (skill.get(1).isClicked()) {
                    System.out.println("hack1");
                    skill.get(1).setClicked(false);
                }
                if (skill.get(2).isClicked()) {
                    System.out.println("hack2");
                    skill.get(2).setClicked(false);
                }
                if (skill.get(3).isClicked()) {
                    System.out.println("hack3");
                    skill.get(3).setClicked(false);
                }
                if (skill.get(4).isClicked()) {
                    System.out.println("radius1");
                    skill.get(4).setClicked(false);
                }
                if (skill.get(5).isClicked()) {
                    System.out.println("radius2");
                    skill.get(5).setClicked(false);
                }
                if (skill.get(6).isClicked()) {
                    System.out.println("radius3");
                    skill.get(6).setClicked(false);
                }
                if (skill.get(7).isClicked()) {
                    System.out.println("recognizer");
                    skill.get(7).setClicked(false);
                }
                break;
            case "arm":
                if (skill.get(0).isClicked()) {
                    System.out.println("heartOpen");
                    skill.get(0).setClicked(false);
                }
                if (skill.get(1).isClicked()) {
                    System.out.println("health1");
                    skill.get(1).setClicked(false);
                }
                if (skill.get(2).isClicked()) {
                    System.out.println("health2");
                    skill.get(2).setClicked(false);
                }
                if (skill.get(3).isClicked()) {
                    System.out.println("battery1");
                    skill.get(3).setClicked(false);
                }
                if (skill.get(4).isClicked()) {
                    System.out.println("battery2");
                    skill.get(4).setClicked(false);
                }
                break;
            case "augment":
                if (skill.get(0).isClicked()) {
                    System.out.println("augOpen");
                    skill.get(0).setClicked(false);
                }
                if (skill.get(1).isClicked()) {
                    System.out.println("health1");
                    skill.get(1).setClicked(false);
                }
                if (skill.get(2).isClicked()) {
                    System.out.println("health2");
                    skill.get(2).setClicked(false);
                }
                if (skill.get(3).isClicked()) {
                    System.out.println("battery1");
                    skill.get(3).setClicked(false);
                }
                if (skill.get(4).isClicked()) {
                    System.out.println("battery2");
                    skill.get(4).setClicked(false);
                }
                break;
            case "dna":
                if (skill.get(0).isClicked()) {
                    System.out.println("dnaOpen");
                    skill.get(0).setClicked(false);
                }
                if (skill.get(1).isClicked()) {
                    System.out.println("cloak");
                    skill.get(1).setClicked(false);
                }
                if (skill.get(2).isClicked()) {
                    System.out.println("battery");
                    skill.get(2).setClicked(false);
                }
                if (skill.get(3).isClicked()) {
                    System.out.println("shield1");
                    skill.get(3).setClicked(false);
                }
                if (skill.get(4).isClicked()) {
                    System.out.println("shield2");
                    skill.get(4).setClicked(false);
                }
                break;
            case "eye":
                if (skill.get(0).isClicked()) {
                    System.out.println("eyeOpen");
                    skill.get(0).setClicked(false);
                }
                if (skill.get(1).isClicked()) {
                    System.out.println("eye1");
                    skill.get(1).setClicked(false);
                }
                if (skill.get(2).isClicked()) {
                    System.out.println("eye2");
                    skill.get(2).setClicked(false);
                }
                if (skill.get(3).isClicked()) {
                    System.out.println("battery1");
                    skill.get(3).setClicked(false);
                }
                if (skill.get(4).isClicked()) {
                    System.out.println("battery2");
                    skill.get(4).setClicked(false);
                }
                break;
            case "heart":
                if (skill.get(0).isClicked()) {
                    System.out.println("heartOpen");
                    skill.get(0).setClicked(false);
                }
                if (skill.get(1).isClicked()) {
                    System.out.println("health1");
                    skill.get(1).setClicked(false);
                }
                if (skill.get(2).isClicked()) {
                    System.out.println("health2");
                    skill.get(2).setClicked(false);
                }
                if (skill.get(3).isClicked()) {
                    System.out.println("battery1");
                    skill.get(3).setClicked(false);
                }
                if (skill.get(4).isClicked()) {
                    System.out.println("battery2");
                    skill.get(4).setClicked(false);
                }
                if (skill.get(5).isClicked()) {
                    System.out.println("defibrillator");
                    skill.get(5).setClicked(false);
                }
                break;
            case "intelligence":
                if (skill.get(0).isClicked()) {
                    System.out.println("ai_control");
                    skill.get(0).setClicked(false);
                }
                break;
            case "leg":
                if (skill.get(0).isClicked()) {
                    System.out.println("heartOpen");
                    skill.get(0).setClicked(false);
                }
                if (skill.get(1).isClicked()) {
                    System.out.println("health1");
                    skill.get(1).setClicked(false);
                }
                if (skill.get(2).isClicked()) {
                    System.out.println("health2");
                    skill.get(2).setClicked(false);
                }
                break;
            case "lungs":
                if (skill.get(0).isClicked()) {
                    System.out.println("heartOpen");
                    skill.get(0).setClicked(false);
                }
                if (skill.get(1).isClicked()) {
                    System.out.println("health1");
                    skill.get(1).setClicked(false);
                }
                if (skill.get(2).isClicked()) {
                    System.out.println("health2");
                    skill.get(2).setClicked(false);
                }
                if (skill.get(3).isClicked()) {
                    System.out.println("battery1");
                    skill.get(3).setClicked(false);
                }
                break;
            case "silence":
                if (skill.get(0).isClicked()) {
                    System.out.println("legOpen");
                    skill.get(0).setClicked(false);
                }
                if (skill.get(1).isClicked()) {
                    System.out.println("health1");
                    skill.get(1).setClicked(false);
                }
                if (skill.get(2).isClicked()) {
                    System.out.println("health2");
                    skill.get(2).setClicked(false);
                }
                break;
        }
    }

    private void setAIBranch() {
        texture = Assets.assetManager.get(Assets.branch3);
        setImage();
        addSkill("ai", 726, 490);
        addSkill("hack1", 795, 490);
        addSkill("hack2", 864, 490);
        addSkill("hack3", 864, 610);
        addSkill("radius1", 795, 296);
        addSkill("radius2", 864, 296);
        addSkill("radius3", 864, 175);
        addSkill("recognizer", 795, 696);
    }

    private void setArmBranch() {
        texture = Assets.assetManager.get(Assets.branch1);
        setImage();
        addSkill("fist", 726, 473);
        addSkill("power", 795, 624);
        addSkill("eye_base", 878, 624);
        addSkill("battery1", 795, 326);
        addSkill("battery2", 878, 326);
    }

    private void setAugmentBranch() {
        texture = Assets.assetManager.get(Assets.branch2);
        setImage();
        addSkill("technology", 726, 480);
        addSkill("durability", 795, 480);
        addSkill("durability", 864, 480);
        addSkill("time1", 795, 286);
        addSkill("time2", 864, 286);
        addSkill("knife", 795, 686);
    }

    private void setDnaBranch() {
        texture = Assets.assetManager.get(Assets.branch1);
        setImage();
        addSkill("dna", 726, 473);
        addSkill("cloaking", 795, 624);
        addSkill("battery", 878, 624);
        addSkill("shield1", 795, 326);
        addSkill("shield2", 878, 326);
    }

    private void setEyeBranch() {
        texture = Assets.assetManager.get(Assets.branch1);
        setImage();
        addSkill("eye", 726, 473);
        addSkill("eyeq", 795, 624);
        addSkill("eye_base", 878, 624);
        addSkill("battery1", 795, 326);
        addSkill("battery2", 878, 326);
    }

    private void setHeartBranch() {
        texture = Assets.assetManager.get(Assets.branch2);
        setImage();
        addSkill("heartRate", 726, 480);
        addSkill("health1", 795, 480);
        addSkill("health2", 864, 480);
        addSkill("battery2", 795, 286);
        addSkill("time2", 864, 286);
        addSkill("cardio", 795, 686);
    }

    private void setIntelligenceBranch() {
        texture = Assets.assetManager.get(Assets.branch2);
        setImage();
        addSkill("intellegence", 726, 480);
        addSkill("dialogue", 795, 480);
        addSkill("dialoguec", 864, 480);
        addSkill("logic", 795, 286);
        addSkill("emotion", 864, 286);
        addSkill("bit_heart", 795, 686);
    }

    private void setLegBranch() {
        texture = Assets.assetManager.get(Assets.branch2);
        setImage();
        addSkill("leg", 726, 480);
        addSkill("fall", 795, 480);
        addSkill("fall2", 864, 480);
        addSkill("time1", 795, 286);
        addSkill("time2", 864, 286);
        addSkill("fastRun", 795, 686);
    }

    private void setLungsBranch() {
        texture = Assets.assetManager.get(Assets.branch1);
        setImage();
        addSkill("lungs", 726, 473);
        addSkill("volume1", 795, 624);
        addSkill("volume2", 878, 624);
        addSkill("gas1", 795, 326);
        addSkill("gas2", 878, 326);
    }

    private void setSilenceBranch() {
        texture = Assets.assetManager.get(Assets.branch4);
        setImage();
        addSkill("silence", 828, 768);
        addSkill("silence", 828, 643);
        addSkill("silence", 828, 530);
    }

    private void setImage() {
        image = new Image(texture);
        image.setSize(300 ,763 * (h / w));
        image.setPosition(700, 128 * (h / w));
        stage.addActor(image);
    }

    protected void addSkill(String drawable, float x, float y) {
        ButtonBase buttonBase = new ButtonBase("smart/skillAtlas/skills.txt", drawable, x, y, (float) 50, (float) 80);
        skill.add(buttonBase);
        multiplexer.addProcessor(buttonBase.stage);
        stage.addActor(buttonBase);
        xPos.add(x);
        yPos.add(y);
    }

    public void open() {
        image.setPosition(700, 128 * (h/w));
        for (int i = 0; i < skill.size(); i ++) {
            skill.get(i).moveButton( xPos.get(i), yPos.get(i) * (h/w));
        }
    }

    public void close() {
        image.setPosition(1500, 128 * (h/w));
        for (int i = 0; i < skill.size(); i ++) {
            skill.get(i).moveButton( 1500, yPos.get(i) * (h/w));
        }
    }
}
