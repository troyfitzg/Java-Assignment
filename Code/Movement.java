package com.test.myassign;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Movement extends KeyAdapter 
{
	
	public Movement(Handler handler) 
	{
		
	}
	
	
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		
		for(int i = 0; i < Handler.object.size(); i++) 
		{
			GameObject tempObject = Handler.object.get(i);
			
			if(tempObject.getId() == PlayerID.Player1) 
			{
				
				//key events for player // Adds velocity to the object
				if(key == KeyEvent.VK_LEFT) tempObject.setVolX(-7);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVolX(+7);
				if(key == KeyEvent.VK_UP) tempObject.setVolY(-7);
				if(key == KeyEvent.VK_DOWN) tempObject.setVolY(+7);
			}
		
		}
		
		
	}
	
	public void keyReleased(KeyEvent event) {
		int key = event.getKeyCode();
		
		for(int i = 0; i < Handler.object.size(); i++) {
			GameObject tempObject = Handler.object.get(i);
			
			if(tempObject.getId() == PlayerID.Player1) {
				//key events for player 1
				
				if(key == KeyEvent.VK_UP) tempObject.setVolY(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVolY(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVolX(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVolX(0);
	
			}
			

			
		}
	
		if(key == KeyEvent.VK_ESCAPE) 
		{
			System.exit(1);
		}
	}
	

	
}

