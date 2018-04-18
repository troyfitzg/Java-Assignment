package com.test.myassign;

import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class GameObject {
	
	int x, y;
	PlayerID id;
	int volX , volY;
	
	public GameObject(int x, int y, PlayerID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getbounds(); //Method to get bounds for collision detection
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public void setID(PlayerID id) {
		this.id = id;
	}
	public PlayerID getId() {
		return id;
	}
	public void setVolX(int volX) {
		this.volX = volX;
	}
	public void setVolY(int volY) {
		this.volY = volY;
	}
	
	public int getVolX() {
		return volX;
	}
	public int getVolY() {
		return volY;
	}
	
	
	
	
}
