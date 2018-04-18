package com.test.myassign;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Player extends GameObject {

	 Handler handler; //Calling handler class
	 
	//Player method for x,y and id
	public Player(int x, int y, PlayerID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	

	@Override
	public Rectangle getbounds() {	
	
	return new Rectangle(x,y,30,30); //Gets the bounds of the player square
		
	}
	

	//Updates Values every "tick"
	public void tick() {

		x += volX; //Updates location from original point with movement
		y += volY;
		
		x = Game.bounds(x,0, Game.WIDTH - 32);//Sets bounds for player to stop laer
		y = Game.bounds(y,0, Game.HEIGHT - 60);
		
		collision();
		
	}
	
	private void collision()
	{
		
		for(int i = 0 ;i <Handler.object.size(); i++) {
			
			GameObject tempObject = Handler.object.get(i);
		
			if(tempObject.getId() == PlayerID.Enemy)
			{
				if(getbounds().intersects(tempObject.getbounds())) {
					LifeBar.LIFE -=2;
				}
			
		
		
			}
		}
	}
 
  

//Render the characters color and sizes on screen
	public void render(Graphics g) {
		
		if(id == PlayerID.Player1) {
			
			g.setColor(Color.white);//Sets color of player
			g.fillRect(x, y, 30, 30); //Renders size and location of player
		}

	}
}


