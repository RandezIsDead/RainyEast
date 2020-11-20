package com.dentheripper.trying.View.Screens.MF;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.GameBaseElements.ExtraWindow;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.BuildElements.TextFieldBase;
import com.dentheripper.trying.GameCore.Assets;
import com.dentheripper.trying.GameCore.Engine;
import com.dentheripper.trying.View.Screens.Load;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Registration extends ScreenBase {

    private TextFieldBase name;
    private ButtonBase ok;

    public Registration(Engine engine) {
        super(engine);
        setBG(new Texture(Gdx.files.internal("screenAssets/regBG.png")), 1000, 1000 * (h/w));
    }

    @Override
    public void show() {
        ExtraWindow extraWindow = new ExtraWindow();
        ButtonBase label = new ButtonBase("Atlas/buttons.txt", "Enter your name, length up to 16 characters", "skill_varity", 350, 660, 300, 90);
        extraWindow.setImage(new Texture(Gdx.files.internal("smart/map.png")), 200, 200, 600, 600);
        ok = new ButtonBase("Atlas/buttons.txt", "ok", 450, 220, 100, 70);
        name = new TextFieldBase(250, 400, 500, 150);

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(name.stage);
        multiplexer.addProcessor(ok.stage);
        multiplexer.addProcessor(name.stage);

        super.show();
        Gdx.input.setInputProcessor(multiplexer);

        stage.addActor(extraWindow);
        stage.addActor(name);
        stage.addActor(label);
        stage.addActor(ok);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        actFinal(delta);

        if (ok.isClicked() && name.field.getText().length() > 0) {
            data.putString("playerUsername", name.field.getText());
            data.putString("playerID", generateID());
            data.putString("dateOfReg", getDate());
            engine.setScreen(new Load(engine, "vgm", 0));
            int s = 1;
            data.putInteger("gameLaunches", s);
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
        Calendar calendar = new GregorianCalendar();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        String s = day + ":" + month + ":" + year;
        return s;
    }

    @Override
    protected void actFinal(float delta) {
        name.act(delta);
        ok.act(delta);
        super.actFinal(delta);
    }
}
