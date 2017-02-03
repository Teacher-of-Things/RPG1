/*
 * Inventory.java
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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.util.ArrayList;

public class Inventory{
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	public Inventory(Handler handler){
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
	}
	
	public void tick(){
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;
	}
	
	public void render(Graphics g){
		if(!active)
			return;
		
		int invc = 20;
		g.setFont(new Font("TimesRoman", Font.PLAIN, 18)); 
		g.setColor(Color.white);
		g.drawString("--Inventory--", 5, invc);
		for(Item i : inventoryItems){
			invc += 15;
			g.drawString(i.getName() + " " + i.getCount(), 18, invc);
		}
		if(invc == 20){
			invc += 15;
			g.drawString("Empty", 18, invc);
		}
	}
	
	//Inventory Methods
	
	public void addItem(Item item){
		for(Item i : inventoryItems){
			if(i.getId() == item.getId()){
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
	}
	
	//Getters Setters
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}

