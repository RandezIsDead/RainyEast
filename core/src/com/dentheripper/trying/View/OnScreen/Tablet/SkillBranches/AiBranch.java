package com.dentheripper.trying.View.OnScreen.Tablet.SkillBranches;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.dentheripper.trying.BuildElements.GameBaseElements.SkillBranchBase;
import com.dentheripper.trying.GameCore.Assets;

public class AiBranch  extends SkillBranchBase {


    public AiBranch() {
        super(Assets.assetManager.get(Assets.branch3));
        addSkill("ai", 726, 490);
        addSkill("hack1", 795, 490);
        addSkill("hack2", 864, 490);
        addSkill("hack3", 864, 610);
        addSkill("radius1", 795, 296);
        addSkill("radius2", 864, 296);
        addSkill("radius3", 864, 175);
        addSkill("recognizer", 795, 696);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

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
    }
}
