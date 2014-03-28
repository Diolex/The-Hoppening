package com.me.the_hoppening;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.me.the_hoppening.actors.BunnyActor;
import com.me.the_hoppening.actors.BunnyActor.State;


public class TheHoppeningGame implements ApplicationListener, GestureListener {
	private ParallaxCamera camera;
	private OrthoCamController controller;
	private SpriteBatch batch;
	private TextureAtlas bgAtlas;
	private TextureRegion[] layers;

	//private float elapsedTime = 0;
	private Stage stage;
	private BunnyActor bunny;

	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		
		stage = new Stage();		
		BunnyActor bunny = new BunnyActor();
		stage.addActor(bunny);

		bgAtlas = new TextureAtlas(Gdx.files.internal("data/basedbackground.atlas"));
		layers = new TextureRegion[3];
		layers[2] = bgAtlas.findRegion("g1");
		layers[1] = bgAtlas.findRegion("g2");
		layers[0] = bgAtlas.findRegion("g3");
		
		camera = new ParallaxCamera(480, 320);
		

		
		batch = new SpriteBatch();
		
		
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
		layers[0].getTexture().dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		/*if(Gdx.input.getX() > 240 && (bunny.getState() != State.ATTACK_L && bunny.getState() != State.ATTACK_R)  ){
			bunny.addAction(Actions.moveBy(20, 0));
			bunny.setState(State.RUN_R);
		}
		else if (Gdx.input.getX() < 240 
				&& (bunny.getState() != State.ATTACK_L && bunny.getState() != State.ATTACK_R) ){
			bunny.addAction(Actions.moveBy(-20, 0));
			bunny.setState(State.RUN_L);
		}*/
		
		//batch.disableBlending();
		batch.begin();
		batch.draw(layers[0], 0, 320-(int)layers[0].getRegionHeight());
		batch.end();
		
		batch.begin();
		batch.draw(layers[1], 0, 320-((int)layers[0].getRegionHeight()+layers[1].getRegionHeight()));
		batch.end();
		
		batch.begin();
		batch.draw(layers[2], 0, 0);
		batch.end();
		//batch.enableBlending();
		
		stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	    
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
		if(Math.abs(velocityX) < Math.abs(velocityY)){
			if(velocityY > 20){
				if( (bunny.getState() == State.ATTACK_L || bunny.getState() == State.RUN_L ) || (bunny.getState() == State.HIT_L || bunny.getState() == State.IDLE_L ))
					bunny.setState(State.ATTACK_L);
				if( (bunny.getState() == State.ATTACK_R || bunny.getState() == State.RUN_R ) || (bunny.getState() == State.HIT_R || bunny.getState() == State.IDLE_R ))
					bunny.setState(State.ATTACK_R);
			}
		}
		return true;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
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
	

}
