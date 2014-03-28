package com.me.the_hoppening.actors;


import com.badlogic.gdx.graphics.g2d.Animation;


public class BirdActor extends MobActor {
	public BirdActor(){
		super("data/bird.atlas");		
				
		idleAniR = new Animation(1/15f, textureAtlas.getRegions());
		runAniR = new Animation(1/15f, textureAtlas.getRegions());
		attackAniR = new Animation(1/15f, textureAtlas.getRegions());
		hitAniR = new Animation(1/15f, textureAtlas.getRegions());
		deadAniR = new Animation(1/15f, textureAtlas.getRegions());
		
		idleAniL = new Animation(1/15f, textureAtlas.getRegions());
		runAniL = new Animation(1/15f, textureAtlas.getRegions());
		attackAniL = new Animation(1/15f, textureAtlas.getRegions());
		hitAniL = new Animation(1/15f, textureAtlas.getRegions());
		deadAniL = new Animation(1/15f, textureAtlas.getRegions());

		setBounds(actorX,actorY,idleAniR.getKeyFrame(elapsedTime,true).getRegionHeight(),
				idleAniR.getKeyFrame(elapsedTime,true).getRegionWidth());	
	}
}
