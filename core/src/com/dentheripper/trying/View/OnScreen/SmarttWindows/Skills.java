package com.dentheripper.trying.View.OnScreen.SmarttWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.BuildElements.GameBaseElements.SkillBranchBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;

import java.util.ArrayList;

public class Skills extends SmartBase {

    private final ExtraWindow extraWindow;

    private static final SkillBranchBase intelligenceBranch = new SkillBranchBase("intelligence");
    private static final SkillBranchBase eyeBranch = new SkillBranchBase("eye");
    private static final SkillBranchBase heartBranch = new SkillBranchBase("heart");
    private static final SkillBranchBase aiBranch = new SkillBranchBase("ai");
    private static final SkillBranchBase lungsBranch = new SkillBranchBase("lungs");
    private static final SkillBranchBase dnaBranch = new SkillBranchBase("dna");
    private static final SkillBranchBase armBranch = new SkillBranchBase("arm");
    private static final SkillBranchBase legBranch = new SkillBranchBase("leg");
    private static final SkillBranchBase silenceBranch = new SkillBranchBase( "silence");
    private static final SkillBranchBase augmentBranch = new SkillBranchBase("augment");

    private static final ButtonBase head = new ButtonBase("Atlas/buttons.txt", "skill_varity", 540, 750, 60, 120);
    private static final ButtonBase chest = new ButtonBase("Atlas/buttons.txt", "skill_varity", 540, 555, 60, 140);
    private static final ButtonBase armLeft = new ButtonBase("Atlas/buttons.txt", "skill_varity", 493, 440, 40, 250);
    private static final ButtonBase armRight = new ButtonBase("Atlas/buttons.txt", "skill_varity", 605, 440, 40, 250);
    private static final ButtonBase legLeft = new ButtonBase("Atlas/buttons.txt", "skill_varity", 527, 128, 40, 300);
    private static final ButtonBase legRight = new ButtonBase("Atlas/buttons.txt", "skill_varity", 570, 128, 40, 300);

    private static final ButtonBase intelligence = new ButtonBase("smart/skillAtlas/skills.txt", "intellegence", 610, 770, 40, 80);
    private static final ButtonBase eye = new ButtonBase("smart/skillAtlas/skills.txt", "eye", 455, 750, 40, 80);
    private static final ButtonBase ai = new ButtonBase("smart/skillAtlas/skills.txt", "ai", 500, 800, 40, 80);
    private static final ButtonBase heart = new ButtonBase("smart/skillAtlas/skills.txt", "heartRate", 570, 600, 40, 80);
    private static final ButtonBase dna = new ButtonBase("smart/skillAtlas/skills.txt", "dna", 525, 620, 40, 80);
    private static final ButtonBase lungs = new ButtonBase("smart/skillAtlas/skills.txt", "lungs", 535, 510, 40, 80);
    private static final ButtonBase technology = new ButtonBase("smart/skillAtlas/skills.txt", "technology", 655, 579, 40, 80);
    private static final ButtonBase fist = new ButtonBase("smart/skillAtlas/skills.txt", "fist", 655, 480, 40, 80);
    private static final ButtonBase leg = new ButtonBase("smart/skillAtlas/skills.txt", "leg", 620, 270, 40, 80);
    private static final ButtonBase silence = new ButtonBase("smart/skillAtlas/skills.txt", "silence", 620, 140, 40, 80);

    private final ArrayList<SkillBranchBase> branches = new ArrayList<>();

    public Skills() {
        setImage(Assets.assetManager.get(Assets.smartUniversal));
        extraWindow = new ExtraWindow();
        extraWindow.setImage(Assets.assetManager.get(Assets.tabletSkill), 450, 128, 250, 760);

        stage.addActor(extraWindow);

        addButton(head);               branches.add(intelligenceBranch);
        addButton(chest);              branches.add(eyeBranch);
        addButton(armLeft);            branches.add(heartBranch);
        addButton(armRight);           branches.add(aiBranch);
        addButton(legLeft);            branches.add(lungsBranch);
        addButton(legRight);           branches.add(dnaBranch);
        addButton(leg);                branches.add(armBranch);
        addButton(eye);                branches.add(legBranch);
        addButton(ai);                 branches.add(augmentBranch);
        addButton(intelligence);       branches.add(silenceBranch);
        addButton(heart);
        addButton(dna);
        addButton(lungs);
        addButton(technology);
        addButton(fist);
        addButton(silence);
    }

    @Override
    public void close() {
        super.close();
        for (int i = 0; i < branches.size(); i++) stage.addAction(Actions.removeActor(branches.get(i)));
        for (int i = 0; i < buttons.size(); i++) stage.addAction(Actions.removeActor(buttons.get(i)));
        extraWindow.close();
    }

    @Override
    public void show() {
        super.show();
        for (int i = 0; i < buttons.size(); i++) stage.addActor(buttons.get(i));
        for (int i = 6; i < buttons.size(); i++) buttons.get(i).addToClose();
        for (int i = 0; i < branches.size(); i++) stage.addActor(branches.get(i));
        for (int i = 0; i < branches.size(); i++) branches.get(i).close();
        eyeBranch.open();
        head.open();
        chest.open();
        armLeft.open();
        armRight.open();
        legLeft.open();
        legRight.open();
        extraWindow.show();
    }

    public void skillsRender(Home home) {
        if (home.skill.isClicked()) {
            home.close();
            show();
            Gdx.input.setInputProcessor(this.multiplexer);
            home.skill.setClicked(false);
        }
        if (back.isClicked()) {
            close();
            home.show();
            Gdx.input.setInputProcessor(home.multiplexer);
            back.setClicked(false);
        }
        bodyRender();
        headBranches();
        chestBranches();
        armBranches();
        legBranches();
    }

    private void bodyRender() {
        if (head.isClicked()) {
            eye.open();
            ai.open();
            intelligence.open();
            heart.addToClose();
            lungs.addToClose();
            dna.addToClose();
            technology.addToClose();
            fist.addToClose();
            leg.addToClose();
            silence.addToClose();
            head.addToClose();
            chest.open();
            armLeft.open();
            armRight.open();
            legLeft.open();
            legRight.open();
            head.setClicked(false);
        }
        if (chest.isClicked()) {
            eye.addToClose();
            ai.addToClose();
            intelligence.addToClose();
            heart.open();
            lungs.open();
            dna.open();
            technology.addToClose();
            fist.addToClose();
            leg.addToClose();
            silence.addToClose();
            head.open();
            chest.addToClose();
            armLeft.open();
            armRight.open();
            legLeft.open();
            legRight.open();
            chest.setClicked(false);
        }
        if (armLeft.isClicked() || armRight.isClicked()) {
            intelligence.addToClose();
            eye.addToClose();
            ai.addToClose();
            heart.addToClose();
            dna.addToClose();
            lungs.addToClose();
            technology.open();
            fist.open();
            leg.addToClose();
            silence.addToClose();
            head.open();
            chest.open();
            armLeft.addToClose();
            armRight.addToClose();
            legLeft.open();
            legRight.open();
            armLeft.setClicked(false);
            armRight.setClicked(false);
        }
        if (legLeft.isClicked() || legRight.isClicked()) {
            intelligence.addToClose();
            eye.addToClose();
            ai.addToClose();
            heart.addToClose();
            dna.addToClose();
            lungs.addToClose();
            technology.addToClose();
            fist.addToClose();
            leg.open();
            silence.open();
            head.open();
            chest.open();
            armLeft.open();
            armRight.open();
            legLeft.addToClose();
            legRight.addToClose();
            legLeft.setClicked(false);
            legRight.setClicked(false);
        }
    }

    private void headBranches() {
        if (intelligence.isClicked()) {
            System.out.println("intel");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            intelligenceBranch.open();
            intelligence.setClicked(false);
        }
        if (ai.isClicked()) {
            System.out.println("ai");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            aiBranch.open();
            ai.setClicked(false);
        }
        if (eye.isClicked()) {
            System.out.println("eye");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            eyeBranch.open();
            eye.setClicked(false);
        }
    }

    private void chestBranches() {
        if (heart.isClicked()) {
            System.out.println("heart");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            heartBranch.open();
            heart.setClicked(false);
        }
        if (lungs.isClicked()) {
            System.out.println("lungs");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            lungsBranch.open();
            lungs.setClicked(false);
        }
        if (dna.isClicked()) {
            System.out.println("lungs");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            dnaBranch.open();
            dna.setClicked(false);
        }
    }

    private void armBranches() {
        if (fist.isClicked()) {
            System.out.println("fist");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            armBranch.open();
            fist.setClicked(false);
        }
        if (technology.isClicked()) {
            System.out.println("tech");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            augmentBranch.open();
            technology.setClicked(false);
        }
    }

    private void legBranches() {
        if (leg.isClicked()) {
            System.out.println("leg");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            legBranch.open();
            leg.setClicked(false);
        }
        if (silence.isClicked()) {
            System.out.println("silence");
            for (int i = 0; i < branches.size(); i++) {
                branches.get(i).close();
            }
            silenceBranch.open();
            silence.setClicked(false);
        }
    }
}
