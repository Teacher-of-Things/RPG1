/*
 * ImageLoader.java
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
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ImageLoader{
	public static BufferedImage loadImage(String path){
		try{
			return ImageIO.read(ImageLoader.class.getResource(path));
		}catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}

