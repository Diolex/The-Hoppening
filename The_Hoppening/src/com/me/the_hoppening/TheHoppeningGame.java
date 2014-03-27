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
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class TheHoppeningGame implements ApplicationListener, GestureListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;


	//private float elapsedTime = 0;
	private Stage stage;
	
	@Override
	public void create() {
	    stage = new Stage();
		camera = new OrthographicCamera(1280, 720);
		Texture.setEnforcePotImages(false);
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		//camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		
		Gdx.input.setInputProcessor(new GestureDetector(this));
	}

	@Override
	public void dispose() {
		batch.dispose();

	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		//sprite.draw(batch);
		//batch.draw(, (-75+Gdx.graphics.getWidth())/2, 0);
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
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
	// TODO Auto-generated method stub
	return false;
	}
	 
	@Override
	public boolean tap(float x, float y, int count, int button) {
	// TODO Auto-generated method stub
	return false;
	}
	 
	@Override
	public boolean longPress(float x, float y) {
	// TODO Auto-generated method stub
	return false;
	}
	 
	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
	// TODO Auto-generated method stub
	return false;
	}
	 
	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
	   // TODO Auto-generated method stub
	   camera.translate(deltaX,0);
	   camera.update();
	   return false;
	}
	 
	@Override
	public boolean zoom(float initialDistance, float distance) {
	// TODO Auto-generated method stub
	return false;
	}
	 
	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
	Vector2 pointer1, Vector2 pointer2) {
	// TODO Auto-generated method stub
	return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
}
