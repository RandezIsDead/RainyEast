package com.dentheripper.trying.View.Screens.MF;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.dentheripper.trying.BuildElements.ButtonBase;
import com.dentheripper.trying.BuildElements.ScreenBase;
import com.dentheripper.trying.GameCore.Engine;

public class SaveLoadData extends ScreenBase {

    private final ButtonBase exitButton;

    public SaveLoadData(Engine engine) {
        super(engine);
        setBG(new Texture("screenAssets/saveLoadDataScr.png"), 1000, 1000 * (h / w));
        exitButton = new ButtonBase("Atlas/buttons.txt", "cl", 850, 780, 100, 160);
    }

    @Override
    public void show() {
        super.show();
        Gdx.input.setInputProcessor(this.multiplexer);
        addObject(exitButton);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        actFinal(delta);
        if (exitButton.isClicked()) {
            engine.setScreen(new Settings(engine));
            exitButton.setClicked(false);
        }
    }
}
