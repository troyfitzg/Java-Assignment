package com.test.myassign;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
	
	
	
	
	public static final int WIDTH = 900, HEIGHT = 650 ; //Setting Dimensions of Window
	private Thread thread;
	private boolean running = false;
	
	private Random r;
	private Handler handler; 
	private LifeBar lifeb;
	private GameOver gameover;
	
	
	public enum STATE {
		
		Game,
		GameOver
	};
	
	public static STATE gameState = STATE.Game; //Setting the initial 
	
	public Game() {
		
		handler = new Handler(); //Calls handler class
		
		
		this.addKeyListener(new Movement(handler)); //Adds movement from the Movement class handler
		
		
		new GUI(WIDTH,HEIGHT, "Dodgeball Game", this); //Creates Interface for Game to run in
		
		lifeb = new LifeBar();//Implements LifeBar class
		gameover = new GameOver();
		r= new Random();//Creating a random variable 
		
		if(gameState == STATE.Game)
		{
		handler.addObject(new Player(WIDTH/2-40, HEIGHT/2, PlayerID.Player1,handler)); //Adds player to a certain position on screen 
		
		//Adds in enemies to positions on screen
			for(int i = 0; i<8; i++)
			{ 
				handler.addObject(new Enemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), PlayerID.Enemy));
			}
		}
		
		
	
	}
	
	//Checks if the game is open and makes it run
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	//Checks if game is closed and stops everything running
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//While the program is running this chunk of code is constantly checked in ticks to render all objects in real time
	public void run() 
	{
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while(running) 
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) 
			{
				tick();
				delta--;
			}
			if(running)
				render();
			if(System.currentTimeMillis() - timer > 1000) 
			{
				timer += 1000;
			}
		}
		stop();
	} 
			
	private void tick() 
	{
		
		handler.tick();
		
		//Checks what state the game is in and acts accordingly 
		if(gameState == STATE.Game) 
		{
			
			lifeb.tick();//Adds in life bar update
			
			if(LifeBar.LIFE <=0) 
			{
				LifeBar.LIFE = 100;
				gameState = STATE.GameOver;
			}
		}
		else if(gameState == STATE.GameOver) 
		{
			gameover.tick(); //If state is in game over make the "gameover" state appear
		}
	}
		 
	//Used to render on screen
	private void render() 
	{
		BufferStrategy bs = this.getBufferStrategy(); //Organizes all renders on screen
		if(bs == null) 
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();//Creating a graphic variable
		
		g.setColor(Color.darkGray); //Set background color
		g.fillRect(0, 0, WIDTH, HEIGHT); //Fill GUI background
		
		handler.render(g); //Renders background
		
		if(gameState == STATE.Game)
		{
			lifeb.render(g);
		}
		else if (gameState == STATE.GameOver) 
		{
	
			gameover.render(g);
		}
		g.dispose();
		bs.show();
	}
	
	
	//Stops player from moving out of bounds
	public static int bounds(int var,int min , int max) {
		
		if(var>=max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}

	

				


}
