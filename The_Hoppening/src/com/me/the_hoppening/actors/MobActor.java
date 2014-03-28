package com.me.the_hoppening.actors;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Action;

public abstract class MobActor extends Actor{
	protected Animation idleAni;
	protected Animation runAni;
	protected Animation attackAni;
	protected Animation hitAni;
	protected Animation deadAni;
	protected TextureAtlas textureAtlas;
	protected FileHandle atlasPath;
	protected float elapsedTime;
	protected boolean mutant;
	protected boolean isLeft;
	protected enum State {IDLE, RUN, ATTACK, HIT, DEAD}
	protected State state;
	protected int health;
	float actorX;
	float actorY;

	public MobActor(String path){
		elapsedTime = 0;
		mutant = false;
		isLeft = false;
		state = State.IDLE;
		health = 5;
		actorX = 0;
		actorY = 0;
		textureAtlas = new TextureAtlas(Gdx.files.internal(path));
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
		//if(isLeft) frame.flip(true,false);
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
