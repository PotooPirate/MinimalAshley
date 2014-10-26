package de.potoopirate.components;

import com.badlogic.ashley.core.Component;

public class SizeComponent extends Component {
	public float width;
	public float height;
	
	public SizeComponent(float width, float height) {
		this.width = width;
		this.height = height;
	}
}
