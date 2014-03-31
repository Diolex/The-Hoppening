package com.me.the_hoppening.actors;


import java.util.Iterator;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;


public class BirdActor extends MobActor {
	private boolean isLeft;
	public BirdActor(){
		super("data/basedbird.atlas");		
		isLeft = true;	
		idleAniR = new Animation(1/10f,
				(textureAtlas.findRegion("right/fly0")),
				(textureAtlas.findRegion("right/fly1")),
				(textureAtlas.findRegion("right/fly2")),
				(textureAtlas.findRegion("right/fly3")));
		runAniR = new Animation(1/15f, textureAtlas.getRegions());
		attackAniR = new Animation(1/15f, textureAtlas.getRegions());
		hitAniR = new Animation(1/15f, textureAtlas.getRegions());
		deadAniR = new Animation(1/15f, textureAtlas.getRegions());
		
		idleAniL = new Animation(1/10f,
				(textureAtlas.findRegion("left/fly0")),
				(textureAtlas.findRegion("left/fly1")),
				(textureAtlas.findRegion("left/fly2")),
				(textureAtlas.findRegion("left/fly3")));
		runAniL = new Animation(1/15f, textureAtlas.getRegions());
		attackAniL = new Animation(1/15f, textureAtlas.getRegions());
		hitAniL = new Animation(1/15f, textureAtlas.getRegions());
		deadAniL = new Animation(1/15f, textureAtlas.getRegions());

		setBounds(actorX,actorY,idleAniR.getKeyFrame(elapsedTime,true).getRegionHeight(),
				idleAniR.getKeyFrame(elapsedTime,true).getRegionWidth());	
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		if(isLeft)
			batch.draw(idleAniL.getKeyFrame(elapsedTime,true), actorX, actorY);
		else
			batch.draw(idleAniR.getKeyFrame(elapsedTime,true), actorX, actorY);
	}
	
	@Override
	public void act(float delta){
		elapsedTime += delta;
		float velX = 125f;
		if(isLeft && actorX > 0)
			actorX -= delta*velX;
		else if(isLeft && actorX <= 0)
			isLeft = !isLeft;
		else if(!isLeft && actorX <440)
			actorX += delta*velX;
		else
			isLeft = !isLeft;
		setX(actorX);

		for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
	        iter.next().act(delta);
	    }
	}
}
