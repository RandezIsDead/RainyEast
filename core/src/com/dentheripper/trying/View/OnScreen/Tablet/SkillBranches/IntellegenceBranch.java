package com.dentheripper.trying.View.OnScreen.Tablet.SkillBranches;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.dentheripper.trying.BuildElements.GameBaseElements.SkillBranchBase;
import com.dentheripper.trying.GameCore.Assets;

public class IntellegenceBranch extends SkillBranchBase {

    public IntellegenceBranch() {
        super(Assets.assetManager.get(Assets.branch2));
        addSkill("intellegence", 726, 480);
        addSkill("dialogue", 795, 480);
        addSkill("dialoguec", 864, 480);
        addSkill("logic", 795, 286);
        addSkill("emotion", 864, 286);
        addSkill("bit_heart", 795, 686);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (skill.get(0).isClicked()) {
            System.out.println("ai_control");
            skill.get(0).setClicked(false);
        }
    }
}
