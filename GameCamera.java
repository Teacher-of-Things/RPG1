/*
 * GameCamera.java
 * 
 * Copyright 2017  Noah Dunbar
 * 
 * This file is part of RPG1.
 * 
 * RPG1 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * RPG1 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with RPG1.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */


public class GameCamera{
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace(){
		if(xOffset < 0)
			xOffset = 0;
		else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth())
			xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		if(yOffset < 0)
			yOffset = 0;
		else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight())
			yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
	}
	
	public void centerOnEntity(Entity e){
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt){
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	public float getxOffset(){
		return xOffset;
	}
	
	public void setxOffset(float xOffset){
		this.xOffset = xOffset;
	}
	
	public float getyOffset(){
		return yOffset;
	}
	
	public void setyOffset(float yOffset){
		this.yOffset = yOffset;
	}
}

