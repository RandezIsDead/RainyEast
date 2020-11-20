package com.dentheripper.trying.View.OnScreen.Tablet.Windows;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Align;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.SmartBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Data;

public class Home extends SmartBase {

    private Data data;
//    private ButtonBase weather;
    private ButtonBase money;
    private ButtonBase hp;
    private ButtonBase sp;
    ButtonBase browser;
    ButtonBase settings;
    ButtonBase map;
    ButtonBase skill;
    ButtonBase music;
    ButtonBase info;
    ButtonBase chips;
    ButtonBase inv;
    ButtonBase chat;
    ButtonBase weapon;

    public Home() {
        setImage(Assets.assetManager.get(Assets.smartphone));
        data = new Data();

        money = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 853, 753, 130, 30);
        hp = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 853, 720, 130, 30);
        sp = new ButtonBase("Atlas/buttons.txt", "", "skill_varity", 853, 687, 130, 30);

        money.button.getLabel().setAlignment(Align.right);
        money.button.getLabel().setColor(Color.GREEN);
        hp.button.getLabel().setAlignment(Align.right);
        hp.button.getLabel().setColor(Color.RED);
        sp.button.getLabel().setAlignment(Align.right);
        sp.button.getLabel().setColor(Color.BLUE);
        browser = new ButtonBase("Atlas/smart.txt", "chrome", 856, 205, 66, 110);
        map = new ButtonBase("Atlas/smart.txt", "moenv", 700, 333, 66, 110);
        info = new ButtonBase("Atlas/smart.txt", "faq", 935, 205, 66, 110);
        chips = new ButtonBase("Atlas/smart.txt", "chips", 856, 333, 66, 110);
        music = new ButtonBase("Atlas/smart.txt", "music_button", 935, 333, 66, 110);
        weapon = new ButtonBase("Atlas/smart.txt", "weapon", 778, 205, 66, 110);
        skill = new ButtonBase("Atlas/smart.txt", "skills", 778, 333, 66, 110);
        settings = new ButtonBase("Atlas/smart.txt", "settings", 700, 205, 66, 110);
        inv = new ButtonBase("Atlas/smart.txt", "inv", 700, 460, 66, 110);
        chat = new ButtonBase("Atlas/smart.txt", "chat", 778, 460, 66, 110);

        addButton(money);
        addButton(hp);
        addButton(sp);
        addButton(browser);
        addButton(map);
        addButton(info);
        addButton(chips);
        addButton(music);
        addButton(weapon);
        addButton(skill);
        addButton(settings);
        addButton(inv);
        addButton(chat);
    }

    public void smartphoneRender(InputMultiplexer multiplexer) {
        if (back.isClicked()) {
            close();
            Gdx.input.setInputProcessor(multiplexer);
            back.setClicked(false);
        }
        money.button.setText("Money: " + new Data().getInteger("money"));
        hp.button.setText("HP: " + Math.round(Float.parseFloat(data.getString("realHP"))) + "/" + data.getString("maxHP"));
        sp.button.setText("SP: " + Math.round(Float.parseFloat(data.getString("realSP"))) + "/" + data.getString("maxSP"));
    }
}
