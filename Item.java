/*
 * Item.java
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
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with RPG1.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Item{
	//Handler
	public static Item[] items = new Item[256];
	public static Item woodItem = new Item(Assets.wood, "Wood", 0);
	public static Item rockItem = new Item(Assets.rock, "Rock", 1);
	
	//Class
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	
	protected Rectangle bounds;
	
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	public Item(BufferedImage texture, String name, int id){
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		
		items[id] = this;
	}
	
	public void tick(){
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)){
			pickedUp = true;
			handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}
	
	public void render(Graphics g){
		if(handler == null)
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}
	
	public Item createNew(int x, int y){
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	//Getters Setters
	
	public Handler getHandler(){
		return handler;
	}

	public void setHandler(Handler handler){
		this.handler = handler;
	}

	public BufferedImage getTexture(){
		return texture;
	}

	public void setTexture(BufferedImage texture){
		this.texture = texture;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}

	public void setY(int y){
		this.y = y;
	}

	public int getCount(){
		return count;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getId(){
		return id;
	}
	
	public boolean isPickedUp(){
		return pickedUp;
	}
}

