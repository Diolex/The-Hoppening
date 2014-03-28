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
	protected Animation idleAniR;
	protected Animation runAniR;
	protected Animation attackAniR;
	protected Animation hitAniR;
	protected Animation deadAniR;
	protected Animation idleAniL;
	protected Animation runAniL;
	protected Animation attackAniL;
	protected Animation hitAniL;
	protected Animation deadAniL;
	protected TextureAtlas textureAtlas;
	protected FileHandle atlasPath;
	protected float elapsedTime;
	protected boolean mutant;
	protected boolean isLeft;
	protected enum State {IDLE_R, RUN_R, ATTACK_R, HIT_R, DEAD_R,
		IDLE_L, RUN_L, ATTACK_L, HIT_L, DEAD_L,}
	protected State state;
	protected int health;
	float actorX;
	float actorY;

	public MobActor(String path){
		elapsedTime = 0;
		mutant = false;
		isLeft = false;
		state = State.IDLE_L;
		health = 5;
		actorX = 0;
		actorY = 0;
		textureAtlas = new TextureAtlas(Gdx.files.internal(path));
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
			frame = attackAniR.getKeyFrame(elapsedTime, true);
			break;
		case ATTACK_L: 
			frame = attackAniL.getKeyFrame(elapsedTime, true);
			break;
		case HIT_R: 
			frame = hitAniR.getKeyFrame(elapsedTime, true);
			break;
		case HIT_L: 
			frame = hitAniL.getKeyFrame(elapsedTime, true);
			break;
		case DEAD_R: 
			frame = deadAniR.getKeyFrame(elapsedTime, true);
			break;
		default:  
			frame = deadAniL.getKeyFrame(elapsedTime, true);
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
