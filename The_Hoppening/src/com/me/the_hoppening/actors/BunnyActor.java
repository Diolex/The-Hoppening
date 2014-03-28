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
	private Animation animation;
	private TextureAtlas bunnyAtlas;
	private float elapsedTime = 0;
	private boolean mutant = false;
	private boolean isLeft = false;
	private enum State {IDLE, RUN, ATTACK, HIT, DEAD}
	private State state = State.RUN;
	private int health = 5;
	
	public boolean started = false;
	float actorX = 0;
	float actorY = 0;
	
	public BunnyActor(){
		bunnyAtlas = new TextureAtlas(Gdx.files.internal("data/basedBunny.atlas"));
		animation = new Animation(1/15f, bunnyAtlas.getRegions());
		setBounds(actorX,actorY,animation.getKeyFrame(elapsedTime,true).getRegionHeight(),
				animation.getKeyFrame(elapsedTime,true).getRegionWidth());
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		TextureRegion frame;
		switch (state){
		case IDLE: //TODO
			frame = animation.getKeyFrame(elapsedTime, true);
		case RUN:
			frame = animation.getKeyFrame(elapsedTime, true);
		case ATTACK: //TODO
			frame = animation.getKeyFrame(elapsedTime, true);
		case HIT: //TODO
			frame = animation.getKeyFrame(elapsedTime, true);
		default:  //TODO DEAD
			frame = animation.getKeyFrame(elapsedTime, false);
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
