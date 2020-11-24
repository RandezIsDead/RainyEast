package com.dentheripper.trying.View.Screens.MF;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.BuildElements.TextFieldBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.Screens.Load;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Registration extends ScreenBase {

    private TextFieldBase name;
    private ButtonBase ok;

    public Registration(Engine engine) {
        super(engine);
        setBG(new Texture(Gdx.files.internal("screenAssets/aiStage/black.png")), 1000, 1000 * (h/w));
    }

    @Override
    public void show() {
        ButtonBase label = new ButtonBase("Atlas/buttons.txt", "Enter your name, length up to 16 characters", "skill_varity", 350, 660, 300, 90);
        ok = new ButtonBase("Atlas/buttons.txt", "ok", 450, 220, 100, 70);
        name = new TextFieldBase(250, 400, 500, 150);

        super.show();
        Gdx.input.setInputProcessor(multiplexer);

        addObject(name);
        addObject(ok);
        addObject(label);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        actFinal(delta);

        if (ok.isClicked() && name.field.getText().length() > 0) {
            Assets.data.putString("playerUsername", name.field.getText());
            Assets.data.putString("playerID", generateID());
            Assets.data.putString("dateOfReg", getDate());
            engine.setScreen(new Load(engine, "vgm", 0));
            int s = 1;
            Assets.data.putInteger("gameLaunches", s);
            ok.setClicked(false);
        }
    }

    private String generateID() {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder((10000000 + rnd.nextInt(90000000)) + "-");
        for (int i = 0; i < 9; i++)
            sb.append(chars[rnd.nextInt(chars.length)]);

        return sb.toString();
    }

    private String getDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        return day + ":" + month + ":" + year;
    }
}
