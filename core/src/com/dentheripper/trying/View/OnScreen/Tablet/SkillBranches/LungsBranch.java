package com.dentheripper.trying.View.OnScreen.Tablet.SkillBranches;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.dentheripper.trying.BuildElements.GameBaseElements.SkillBranchBase;
import com.dentheripper.trying.GameCore.Assets;

public class LungsBranch extends SkillBranchBase {

    public LungsBranch() {
        super(Assets.assetManager.get(Assets.branch1));
        addSkill("lungs", 726, 473);
        addSkill("volume1", 795, 624);
        addSkill("volume2", 878, 624);
        addSkill("gas1", 795, 326);
        addSkill("gas2", 878, 326);
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
    }
}
