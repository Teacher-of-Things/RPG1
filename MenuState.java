/*
 * MenuState.java
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
import java.awt.Font;

public class MenuState extends State {
	private UIManager uiManager;
	
	public MenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton((int) (handler.getGame().getWidth() / 2 - 64), (int) (handler.getGame().getHeight() / 2 - 32), 128, 64, Assets.btn_start, new ClickListener(){
			@Override
			public void onClick(){
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.setColor(Color.black);
		g.drawString("Welcome to RPG1", (int) (handler.getGame().getWidth() / 2 - 90), (int) (handler.getGame().getHeight() / 3 - 50));
		g.setFont(new Font("TimesRoman", Font.PLAIN, 13));
		g.drawString("(c) 2017 Noah Dunbar", 5, handler.getGame().getHeight() - 13);
	}
	
}
