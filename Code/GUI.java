package com.test.myassign;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GUI extends Canvas {
	
	public GUI (int width, int height , String title, Game game) {
		JFrame frame = new JFrame(title);
		
		//Creating Frame
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Shuts down everything when frame is closed
		frame.setResizable(false); //Stops User from resizing frame
		frame.setLocationRelativeTo(null); //Start screen in center
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
		
		
		
	}	
	

}