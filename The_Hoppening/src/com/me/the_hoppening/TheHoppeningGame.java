package com.me.the_hoppening;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class TheHoppeningGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Animation animation;
	private TextureAtlas bunnyAtlas;
	private float elapsedTime = 0;
	
	
	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		//camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		bunnyAtlas = new TextureAtlas(Gdx.files.internal("data/basedBunny.atlas"));
		animation = new Animation(1/15f, bunnyAtlas.getRegions());
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		//sprite.draw(batch);
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
