package com.test.myassign;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	static LinkedList<GameObject> object = new LinkedList<GameObject>(); //Creates a list to hold all game objects added in 

	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick(); //Runs the tick method with the temp object
		}
	}
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void clearEnemys()
	{
		for(int i= 0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			
			if(tempObject.getId() ==  PlayerID.Player1)
			{
				object.clear();
				
				
			}
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

}
