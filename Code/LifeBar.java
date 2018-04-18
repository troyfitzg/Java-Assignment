package com.test.myassign;

import java.awt.Color;
import java.awt.Graphics;



public class LifeBar {

	
	static int LIFE = 100; //Sets life points to 100

	public void tick() {
		
		LIFE= Game.bounds(LIFE,0,100); //Keeps life between 0 and 100
		
	}
	
	//Adding empty and full life meters
	public void render(Graphics g) {
		
		g.setColor(Color.GRAY);
		g.fillRect(670, 15, 200, 40);
		g.setColor(Color.CYAN);
		g.fillRect(670, 15, LIFE * 2, 40);
	}
}
