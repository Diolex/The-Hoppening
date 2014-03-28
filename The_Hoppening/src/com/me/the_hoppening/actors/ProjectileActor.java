package com.me.the_hoppening.actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class ProjectileActor extends Actor {
	protected TextureAtlas textureAtlas;
	protected TextureRegion stable;
	protected Animation unstable;
	protected 
	
	float actorX;
	float actorY;
	float velocity;
	
	public ProjectileActor(float x, float y, float v){
		actorX = x;
		actorY = y;
	}
	
	@Override void draw(SpriteBatch batch, float alpha){
		batch.draw
	}
}
