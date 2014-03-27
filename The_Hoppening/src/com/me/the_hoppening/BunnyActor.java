package com.me.the_hoppening;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BunnyActor extends Actor{
	private Animation animation;
	private TextureAtlas bunnyAtlas;
	float actorX = 0;
	float actorY = 0;
	public boolean started = false;
	private float elapsedTime = 0;
	
	public BunnyActor(){
		bunnyAtlas = new TextureAtlas(Gdx.files.internal("data/basedBunny.atlas"));
		animation = new Animation(1/15f, bunnyAtlas.getRegions());
		setBounds(actorX,actorY,animation.getKeyFrame(elapsedTime,true).getRegionHeight(),
				animation.getKeyFrame(elapsedTime,true).getRegionWidth());
	}
	
	@Override
	public void draw(Batch batch, float alpha){
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapsedTime, true), actorX, actorY);
	}
}
