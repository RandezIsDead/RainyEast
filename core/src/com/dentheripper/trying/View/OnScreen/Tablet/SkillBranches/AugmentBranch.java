package com.dentheripper.trying.View.OnScreen.Tablet.SkillBranches;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.dentheripper.trying.BuildElements.GameBaseElements.SkillBranchBase;
import com.dentheripper.trying.GameCore.Assets;

public class AugmentBranch extends SkillBranchBase {

    public AugmentBranch() {
        super(Assets.assetManager.get(Assets.branch2));
        addSkill("technology", 726, 480);
        addSkill("durability", 795, 480);
        addSkill("durability", 864, 480);
        addSkill("time1", 795, 286);
        addSkill("time2", 864, 286);
        addSkill("knife", 795, 686);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

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
    }
}
