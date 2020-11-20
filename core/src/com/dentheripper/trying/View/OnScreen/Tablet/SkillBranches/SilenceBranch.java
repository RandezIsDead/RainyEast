package com.dentheripper.trying.View.OnScreen.Tablet.SkillBranches;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.dentheripper.trying.BuildElements.GameBaseElements.SkillBranchBase;
import com.dentheripper.trying.GameCore.Assets;

public class SilenceBranch extends SkillBranchBase {

    public SilenceBranch() {
        super(Assets.assetManager.get(Assets.branch4));
        addSkill("silence", 828, 768);
        addSkill("silence", 828, 643);
        addSkill("silence", 828, 530);
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
    }
}
