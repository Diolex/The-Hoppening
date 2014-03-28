package com.me.the_hoppening.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class CarrotActor extends MobActor {
	public CarrotActor(){
		super("data/carrot.atlas");		
				
		idleAni = new Animation(1/15f, textureAtlas.getRegions());
		runAni = new Animation(1/15f, textureAtlas.getRegions());
		attackAni = new Animation(1/15f, textureAtlas.getRegions());
		hitAni = new Animation(1/15f, textureAtlas.getRegions());
		deadAni = new Animation(1/15f, textureAtlas.getRegions());
		//setBounds(actorX,actorY,animation.getKeyFrame(elapsedTime,true).getRegionHeight(),
		//		animation.getKeyFrame(elapsedTime,true).getRegionWidth());	
	}
}
