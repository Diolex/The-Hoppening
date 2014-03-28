package com.me.the_hoppening.actors;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Action;

public class BunnyActor extends Actor{
	private Animation idleAniR;
	private Animation runAniR;
	private Animation attackAniR;
	private Animation hitAniR;
	private Animation deadAniR;
	private Animation idleAniL;
	private Animation runAniL;
	private Animation attackAniL;
	private Animation hitAniL;
	private Animation deadAniL;
	private TextureAtlas textureAtlas;
	private float elapsedTime = 0;
	private boolean mutant = false;
	private enum State {IDLE_R, RUN_R, ATTACK_R, HIT_R, DEAD_R,
						IDLE_L, RUN_L, ATTACK_L, HIT_L, DEAD_L,}
	private State state = State.RUN_R;
	private int health = 5;
	float actorX = 0;
	float actorY = 0;
	
	public BunnyActor(){
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/basedBunny.atlas"));
		idleAniR = new Animation(1/15f,
				(textureAtlas.findRegions("idle0")));
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
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		TextureRegion frame;
		switch (state){
		case IDLE_R: 
			frame = idleAniR.getKeyFrame(elapsedTime, true);
			break;
		case IDLE_L: 
			frame = idleAniL.getKeyFrame(elapsedTime, true);
			break;
		case RUN_R: 
			frame = runAniR.getKeyFrame(elapsedTime, true);
			break;
		case RUN_L: 
			frame = runAniL.getKeyFrame(elapsedTime, true);
			break;
		case ATTACK_R: 
			frame = attackAniR.getKeyFrame(elapsedTime, false);
			break;
		case ATTACK_L: 
			frame = attackAniL.getKeyFrame(elapsedTime, false);
			break;
		case HIT_R: 
			frame = hitAniR.getKeyFrame(elapsedTime, false);
			break;
		case HIT_L: 
			frame = hitAniL.getKeyFrame(elapsedTime, false);
			break;
		case DEAD_R: 
			frame = deadAniR.getKeyFrame(elapsedTime, false);
			break;
		default:  
			frame = deadAniL.getKeyFrame(elapsedTime, false);
			break;
		}

		batch.draw(frame, actorX, actorY);
	}
	
	@Override
	public void act(float delta){
		elapsedTime += delta;
		for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
	        iter.next().act(delta);
	    }
	}
	
	public int getHealth(){
		return health;
	}
}
