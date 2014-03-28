package com.me.the_hoppening.actors;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BunnyActor extends Actor{
	private Animation idleAni;
	private Animation runAni;
	private Animation attackAni;
	private Animation hitAni;
	private Animation deadAni;
	private TextureAtlas textureAtlas;
	private float elapsedTime = 0;
	private boolean mutant = false;
	private boolean isLeft = false;
	public enum State {IDLE, RUN, ATTACK, HIT, DEAD}
	private State state = State.RUN;
	private int health = 5;
	private boolean runRight = false;
	private boolean runLeft = false;
	float actorX = 0;
	float actorY = 0;
	public BunnyActor(){
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/basedBunny.atlas"));
		idleAni = new Animation(1/15f, textureAtlas.getRegions());
		runAni = new Animation(1/15f, textureAtlas.getRegions());
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
		case RUN: //TODO
			frame = runAni.getKeyFrame(elapsedTime, true);
		case ATTACK: //TODO
			frame = attackAni.getKeyFrame(elapsedTime, false);
		case HIT: //TODO
			frame = hitAni.getKeyFrame(elapsedTime, false);
		default:  //TODO DEAD
			frame = deadAni.getKeyFrame(elapsedTime, false);
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

	public boolean handle(Event event) {
		// TODO Auto-generated method stub
		return false;
	}
	public void setState(State state){
		this.state = state; 
	}
}
