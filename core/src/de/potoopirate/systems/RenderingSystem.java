package de.potoopirate.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;

import de.potoopirate.components.PositionComponent;
import de.potoopirate.components.SizeComponent;

public class RenderingSystem extends IteratingSystem {
	private static final Family FAMILY = Family.getFor(PositionComponent.class, SizeComponent.class);
	ComponentMapper<PositionComponent> positionMapper;
	ComponentMapper<SizeComponent> sizeMapper;	
	
	private ShapeRenderer shapeDrawer;
	private Array<Entity> renderList;
	
	public RenderingSystem(ShapeRenderer shapeDrawer) {
		super(FAMILY);
		
		positionMapper = ComponentMapper.getFor(PositionComponent.class);
		sizeMapper = ComponentMapper.getFor(SizeComponent.class);
		this.shapeDrawer = shapeDrawer;
		
		this.renderList = new Array<Entity>();
	}
	
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		shapeDrawer.begin(ShapeType.Line);
		for(Entity entity : renderList) {
			shapeDrawer.setColor((float)Math.random(),(float)Math.random(),(float)Math.random(),1.0f);
			PositionComponent position = positionMapper.get(entity);
			SizeComponent size = sizeMapper.get(entity);
			shapeDrawer.rect(position.x, position.y, size.width, size.height);
		}
		shapeDrawer.end();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		renderList.add(entity);
	}

}
