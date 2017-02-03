/*
 * ItemManager.java
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

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager{
	private Handler handler;
	private ArrayList<Item> items;
	
	public ItemManager(Handler handler){
		this.handler = handler;
		items = new ArrayList<Item>();
	}
	
	public void tick(){
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item i = it.next();
			i.tick();
			if(i.isPickedUp())
				it.remove();
		}
	}
	
	public void render(Graphics g){
		for(Item i : items)
			i.render(g);
	}
	
	public void addItem(Item i){
		i.setHandler(handler);
		items.add(i);
	}
	
	//Getters Setters

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}

