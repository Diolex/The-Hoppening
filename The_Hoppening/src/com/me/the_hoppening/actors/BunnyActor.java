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
	private State state = State.DEAD_R;
	private int health = 5;
	private boolean runRight = false;
	private boolean runLeft = false;
	float actorX = 0;
	float actorY = 0;
	public BunnyActor(){
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/basedBunny.atlas"));
		idleAniR = new Animation(1/6f,
				(textureAtlas.findRegion("right/idle0")),
				(textureAtlas.findRegion("right/idle1")),
				(textureAtlas.findRegion("right/idle2")),
				(textureAtlas.findRegion("right/idle3")),
				(textureAtlas.findRegion("right/idle4")),
				(textureAtlas.findRegion("right/idle5")));
		runAniR = new Animation(1/10f,
				(textureAtlas.findRegion("right/run0")),
				(textureAtlas.findRegion("right/run1")),
				(textureAtlas.findRegion("right/run2")),
				(textureAtlas.findRegion("right/run3")));
		attackAniR = new Animation(1/6f,
				(textureAtlas.findRegion("right/attack0")),
				(textureAtlas.findRegion("right/attack1")),
				(textureAtlas.findRegion("right/attack2")));
		hitAniR = new Animation(1/10f,
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("right/hit0")));
		deadAniR = new Animation(1/10f,
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("left/hit0")));
		
		idleAniL = new Animation(1/6f,
				(textureAtlas.findRegion("left/idle0")),
				(textureAtlas.findRegion("left/idle1")),
				(textureAtlas.findRegion("left/idle2")),
				(textureAtlas.findRegion("left/idle3")),
				(textureAtlas.findRegion("left/idle4")),
				(textureAtlas.findRegion("left/idle5")));
		runAniL = new Animation(1/10f,
				(textureAtlas.findRegion("left/run0")),
				(textureAtlas.findRegion("left/run1")),
				(textureAtlas.findRegion("left/run2")),
				(textureAtlas.findRegion("left/run3")));
		attackAniL = new Animation(1/6,
				(textureAtlas.findRegion("left/attack0")),
				(textureAtlas.findRegion("left/attack1")),
				(textureAtlas.findRegion("left/attack2")));
		hitAniL = new Animation(1/10f,
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("left/hit0")));
		deadAniL = new Animation(1/10f,
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("left/hit0")),
				(textureAtlas.findRegion("right/hit0")),
				(textureAtlas.findRegion("right/hit0")));
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
	public State getState(){
		return state;
	}

	public boolean handle(Event event) {
		// TODO Auto-generated method stub
		return false;
	}
	public void setState(State state){
		this.state = state; 
	}
}
