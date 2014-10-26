package de.potoopirate.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;

import de.potoopirate.components.PositionComponent;

public class MovementSystem extends IteratingSystem {
	private static final Family FAMILY = Family.getFor(PositionComponent.class);
	private ComponentMapper<PositionComponent> positionMapper;
	
	private Array<Entity> entitys;
	
	public MovementSystem() {
		super(FAMILY);
		
		positionMapper = ComponentMapper.getFor(PositionComponent.class);
		entitys = new Array<Entity>();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		entitys.add(entity);
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		for(Entity entity : entitys) {
			PositionComponent position = positionMapper.get(entity);
			position.x += (Math.random() - 0.5) * 20 * deltaTime;
			position.y += (Math.random() - 0.5) * 20 * deltaTime;
		}
	}

}
