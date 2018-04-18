package com.test.myassign;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;



public class Enemy extends GameObject 
{

	public Enemy(int x, int y, PlayerID id) 
	{
		super(x, y, id);
		
	
		
		volX = 5;
		volY= 5;
		
	}


	
	
	@Override
	public void tick() 
	{
		
		x += volX;
		y += volY;
		
		if(y <= 0 || y >= Game.HEIGHT-50) 
		{
			
			volY *= -1;
		}
		
		if(x <= 0 || x >= Game.WIDTH-20) 
		{
			
			volX *= -1;
		}
		
		
	}

	@Override
	public void render(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g; //Implements 2d graphic drawing
		if(id == PlayerID.Enemy) 
		{
			g.setColor(Color.GREEN);//setting the color of enemies
			g2d.draw(getbounds()); //drawing a square for the enemies
			
		}
		
	}

	@Override
	public Rectangle getbounds() 
	{
		
		return new Rectangle(x,y,20,20);
	}



}
