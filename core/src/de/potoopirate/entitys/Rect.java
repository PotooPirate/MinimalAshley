package de.potoopirate.entitys;

import com.badlogic.ashley.core.Entity;

import de.potoopirate.components.PositionComponent;
import de.potoopirate.components.SizeComponent;

public class Rect extends Entity {
	public Rect(float x, float y, float width, float height) {
		add(new PositionComponent(x,y));
		add(new SizeComponent(width, height));
	}
}
