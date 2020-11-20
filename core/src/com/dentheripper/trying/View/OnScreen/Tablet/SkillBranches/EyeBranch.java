package com.dentheripper.trying.View.OnScreen.Tablet.SkillBranches;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.dentheripper.trying.BuildElements.GameBaseElements.SkillBranchBase;
import com.dentheripper.trying.GameCore.Assets;

public class EyeBranch extends SkillBranchBase {

    public EyeBranch() {
        super(Assets.assetManager.get(Assets.branch1));
        addSkill("eye", 726, 473);
        addSkill("eyeq", 795, 624);
        addSkill("eye_base", 878, 624);
        addSkill("battery1", 795, 326);
        addSkill("battery2", 878, 326);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

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
    }
}
