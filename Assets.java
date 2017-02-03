/*
 * Assets.java
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

import java.awt.image.BufferedImage;

public class Assets{
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, grass, stone, tree, rock;
	public static BufferedImage wood;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] zombie_down, zombie_up, zombie_left, zombie_right;
	public static BufferedImage[] btn_start;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/sheet.png"));
		
		wood = sheet.crop(width, height, width, height);
		
		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width*6, height*4, width*2, height);
		btn_start[1] = sheet.crop(width*6, height*5, width*2, height);
		
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_right = new BufferedImage[2];
		player_left = new BufferedImage[2];
		
		player_down[0] = sheet.crop(width*4, 0, width, height);
		player_down[1] = sheet.crop(width*5, 0, width, height);
		player_up[0] = sheet.crop(width*6, 0, width, height);
		player_up[1] = sheet.crop(width*7, 0, width, height);
		player_right[0] = sheet.crop(width*4, height, width, height);
		player_right[1] = sheet.crop(width*5, height, width, height);
		player_left[0] = sheet.crop(width*6, height, width, height);
		player_left[1] = sheet.crop(width*7, height, width, height);
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(width*2, 0, width, height);
		stone = sheet.crop(width*3, 0, width, height);
		tree = sheet.crop(0, 0, width, height*2);
		rock = sheet.crop(0, height*2, width, height);
	}
}

