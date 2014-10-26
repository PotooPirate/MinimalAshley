package de.potoopirate;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import de.potoopirate.entitys.Rect;
import de.potoopirate.systems.MovementSystem;
import de.potoopirate.systems.RenderingSystem;

public class MinimalAshley extends ApplicationAdapter {
	private Engine engine;
	
	@Override
	public void create () {
		engine = new Engine();
		engine.addSystem(new RenderingSystem(new ShapeRenderer()));
		engine.addSystem(new MovementSystem());
		
		for(int x = 0; x < 20; x++) {
			for(int y = 0; y < 20; y++) {
				engine.addEntity(new Rect(x*50,y*50,25,25));
			}
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		engine.update(Gdx.graphics.getDeltaTime());
	}
}
