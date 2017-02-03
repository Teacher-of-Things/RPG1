/*
 * UIManager.java
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
import java.awt.event.MouseEvent;

public class UIManager{
	private Handler handler;
	private ArrayList<UIObject> objects;
	
	public UIManager(Handler handler){
		this.handler = handler;
		objects = new ArrayList<UIObject>();
	}
	
	public void tick(){
		for(UIObject o : objects)
			o.tick();
	}
	
	public void render(Graphics g){
		for(UIObject o : objects)
			o.render(g);
	}
	
	public void onMouseMove(MouseEvent e){
		for(UIObject o : objects)
			o.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e){
		for(UIObject o : objects)
			o.onMouseRelease(e);
	}
	
	public void addObject(UIObject o){
		objects.add(o);
	}
	
	public void removeObject(UIObject o){
		objects.remove(o);
	}
	
	public Handler getHandler(){
		return handler;
	}

	public void setHandler(Handler handler){
		this.handler = handler;
	}

	public ArrayList<UIObject> getObjects(){
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects){
		this.objects = objects;
	}
}

