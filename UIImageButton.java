/*
 * UIImageButton.java
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
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{
	private BufferedImage[] images;
	private ClickListener clicker;
	
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker){
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	
	@Override
	public void tick(){}
	
	@Override
	public void render(Graphics g){
		if(hovering)
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
	}
	
	@Override
	public void onClick(){
		clicker.onClick();
	}
}

