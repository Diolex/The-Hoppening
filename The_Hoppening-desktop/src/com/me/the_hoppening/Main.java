package com.me.the_hoppening;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "The_Hoppening";
		cfg.useGL20 = false;
		cfg.width = 1280;
		cfg.height = 720;
		
		//new LwjglApplication(new TheHoppeningGame(), cfg);
		new LwjglApplication(new InputDemo4(), cfg);
	}
}
