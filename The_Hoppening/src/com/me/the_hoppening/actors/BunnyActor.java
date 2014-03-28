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
	private Animation idleAni;
	private Animation runAni;
	private Animation attackAni;
	private Animation hitAni;
	private Animation deadAni;
	private TextureAtlas textureAtlas;
	private float elapsedTime = 0;
	private boolean mutant = false;
	private boolean flipIt = false;
	private enum State {IDLE, RUN, ATTACK, HIT, DEAD}
	private State state = State.RUN;
	private int health = 5;
	float actorX = 0;
	float actorY = 0;
	
	public BunnyActor(){
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/basedBunny.atlas"));
		idleAni = new Animation(1/15f, textureAtlas.getRegions());
		runAni = new Animation(1/5f, textureAtlas.getRegions());
		attackAni = new Animation(1/15f, textureAtlas.getRegions());
		hitAni = new Animation(1/15f, textureAtlas.getRegions());
		deadAni = new Animation(1/15f, textureAtlas.getRegions());
		setBounds(actorX,actorY,idleAni.getKeyFrame(elapsedTime,true).getRegionHeight(),
				idleAni.getKeyFrame(elapsedTime,true).getRegionWidth());
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		TextureRegion frame;
		switch (state){
		case IDLE: //TODO
			frame = idleAni.getKeyFrame(elapsedTime, true);
			break;
		case RUN: //TODO
			frame = runAni.getKeyFrame(elapsedTime, true);
			break;
		case ATTACK: //TODO
			frame = attackAni.getKeyFrame(elapsedTime, false);
			break;
		case HIT: //TODO
			frame = hitAni.getKeyFrame(elapsedTime, false);
			break;
		default:  //TODO DEAD
			frame = deadAni.getKeyFrame(elapsedTime, false);
			break;
		}
		//if(isLeft) 
			frame.flip(true,false);
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
