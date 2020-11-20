package com.dentheripper.trying.View.OnScreen.Tablet.SkillBranches;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.dentheripper.trying.BuildElements.GameBaseElements.SkillBranchBase;
import com.dentheripper.trying.GameCore.Assets;

public class DnaBranch extends SkillBranchBase {

    public DnaBranch() {
        super(Assets.assetManager.get(Assets.branch1));
        addSkill("dna", 726, 473);
        addSkill("cloaking", 795, 624);
        addSkill("battery", 878, 624);
        addSkill("shield1", 795, 326);
        addSkill("shield2", 878, 326);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

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
    }
}
