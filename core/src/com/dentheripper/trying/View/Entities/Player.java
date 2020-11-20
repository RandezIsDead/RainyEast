package com.dentheripper.trying.View.Entities;

import com.dentheripper.trying.GameCore.Entity;

public class Player extends Entity {

    public Player() {
        super.animStand("playerAssets/zeroMovement/playerStand.png", 1, 2);
        super.animRunRight("playerAssets/zeroMovement/playerRun.png", 1, 9);
        super.animRunLeft("playerAssets/zeroMovement/playerRunRev.png", 1, 9);
    }
}
