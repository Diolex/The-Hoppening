package com.me.the_hoppening.actors;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ProjectileActor extends Actor {
	protected TextureAtlas textureAtlas;
	protected TextureRegion stable;
	protected Animation unstable;
	protected boolean isStable;
	
	float actorX;
	float actorY;
	float velX;
	float velY;
	float elapsedTime;
	
	public ProjectileActor(float x, float y, float vx, float vy){
		textureAtlas = new TextureAtlas(Gdx.files.internal("data/basedprojectile.atlas"));
		stable = new TextureRegion(textureAtlas.findRegion("grenade/stable0"));
		unstable = new Animation(1/10f,
				(textureAtlas.findRegion("grenade/unstable0")),
				(textureAtlas.findRegion("grenade/unstable1")),
				(textureAtlas.findRegion("grenade/unstable2")),
				(textureAtlas.findRegion("grenade/unstable3")),
				(textureAtlas.findRegion("grenade/unstable4")),
				(textureAtlas.findRegion("grenade/unstable5")));
		isStable = true;
		actorX = x;
		actorY = y;
		velX = vx;
		velY = vy;
		elapsedTime = 0;
		setBounds(actorX, actorY, stable.getRegionHeight(), stable.getRegionWidth());
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha){
		if(isStable)
			batch.draw(stable, actorX, actorY);
		else
			batch.draw(unstable.getKeyFrame(elapsedTime,true), actorX, actorY);
	}
	
	@Override
	public void act(float delta){
		actorX += delta*velX;
		actorY += delta*velY;
		setX(actorX);
		setY(actorY);
		for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
	        iter.next().act(delta);
	    }
	}
	
	
}
