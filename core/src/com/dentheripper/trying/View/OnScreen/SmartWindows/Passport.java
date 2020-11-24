package com.dentheripper.trying.View.OnScreen.SmartWindows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;

import java.util.ArrayList;

public class Passport extends SmartBase {

    private final ArrayList<ButtonBase> btn = new ArrayList<>();
    private final Image pass;
    private static final ButtonBase name = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 795, 820, 150, 20);
    private static final ButtonBase datePass = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 795, 770, 150, 20);
    private static final ButtonBase id = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 725, 685, 250, 20);

    private static final ButtonBase intelligence = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 555, 130, 30);
    private static final ButtonBase strength = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 515, 130, 30);
    private static final ButtonBase maxHP = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 475, 130, 30);
    private static final ButtonBase maxSP = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 435, 130, 30);
    private static final ButtonBase damage = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 395, 130, 30);
    private static final ButtonBase defence = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 355, 130, 30);
    private static final ButtonBase healing = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 315, 130, 30);
    private static final ButtonBase agility = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 275, 130, 30);
    private static final ButtonBase skOpened = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 235, 130, 30);
    private static final ButtonBase luck = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 710, 195, 130, 30);

    public Passport(Stage stage) {
        super(stage);
        setImage(Assets.assetManager.get(Assets.smartUniversal));
        pass = new Image(Assets.assetManager.get(Assets.smartPass));
        pass.setBounds(700, 128 * (h / w), 300, 763 * (h / w));

        name.button.getLabel().setText("Name: " + Assets.data.getString("playerUsername"));
        datePass.button.getLabel().setText("Date: " + Assets.data.getString("dateOfReg"));
        id.button.getLabel().setText("ID: " + Assets.data.getString("playerID"));

        name.button.getLabel().setAlignment(Align.left);
        datePass.button.getLabel().setAlignment(Align.left);
        id.button.getLabel().setAlignment(Align.center);

        btn.add(intelligence);
        btn.add(strength);
        btn.add(maxHP);
        btn.add(maxSP);
        btn.add(damage);
        btn.add(defence);
        btn.add(healing);
        btn.add(agility);
        btn.add(skOpened);
        btn.add(luck);

        for (int i = 0; i < btn.size(); i++) {
            btn.get(i).button.getLabel().setAlignment(Align.left);
        }

        stage.addActor(pass);
        stage.addActor(name);
        stage.addActor(datePass);
        stage.addActor(id);
        for (int i = 0; i < btn.size(); i++) {
            stage.addActor(btn.get(i));
        }
    }

    @Override
    public void show() {
        super.show();
        stage.addActor(pass);
        stage.addActor(name);
        stage.addActor(datePass);
        stage.addActor(id);
        for (int i = 0; i < btn.size(); i++) {
            stage.addActor(btn.get(i));
        }
    }

    @Override
    public void close() {
        super.close();
        stage.addAction(Actions.removeActor(pass));
        stage.addAction(Actions.removeActor(name));
        stage.addAction(Actions.removeActor(datePass));
        stage.addAction(Actions.removeActor(id));
        for (int i = 0; i < btn.size(); i++) {
            stage.addAction(Actions.removeActor(btn.get(i)));
        }
    }

    public void statsRender(Home home) {
        if (home.stats.isClicked()) {
            home.close();
            show();
            Gdx.input.setInputProcessor(this.multiplexer);
            home.stats.setClicked(false);
        }
        if (back.isClicked()) {
            close();
            home.show();
            Gdx.input.setInputProcessor(home.multiplexer);
            back.setClicked(false);
        }
        if (homeS.isClicked()) {
            close();
            home.show();
            Gdx.input.setInputProcessor(home.multiplexer);
            homeS.setClicked(false);
        }
        intelligence.button.setText("Intelligence: " + Assets.data.getString("intelligence"));
        strength.button.setText("Strength: " + Assets.data.getString("strength"));
        maxHP.button.setText("MaxHP: " + Assets.data.getString("maxHP"));
        maxSP.button.setText("MaxSP: " + Assets.data.getString("maxSP"));
        damage.button.setText("Damage: " + Assets.data.getString("damage"));
        defence.button.setText("Defence: " + Assets.data.getString("defence"));
        healing.button.setText("Healing: " + Assets.data.getString("healing"));
        agility.button.setText("Agility: " + Assets.data.getString("agility"));
        skOpened.button.setText("Skills Opened: " + Assets.data.getString("skOp"));
        luck.button.setText("Luck: " + Assets.data.getString("luck") + "%");
    }
}
