package com.dentheripper.trying.GameCore;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.dentheripper.trying.View.Screens.MF.SplashScreen;

public class Engine extends Game {
	@Override
	public void create () {
		setScreen(new SplashScreen(this));

		if (Gdx.input.isKeyPressed(Input.Keys.BACK)){
			System.out.println("Treeeeee");
		}
	}
}
