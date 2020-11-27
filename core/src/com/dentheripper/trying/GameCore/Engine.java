package com.dentheripper.trying.GameCore;

import com.badlogic.gdx.Game;
import com.dentheripper.trying.View.Screens.MF.SplashScreen;

public class Engine extends Game {
	@Override
	public void create () {
		setScreen(new SplashScreen(this));
	}
}
