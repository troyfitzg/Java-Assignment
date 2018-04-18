package com.test.myassign;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;



public class GameOver 
{

	public void tick() 
	{
		
	}
	
	public void render(Graphics g)
	{
		Font fnt = new Font("arial",1,50);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Game Over", 325, 190);
		
			
		}
	}

