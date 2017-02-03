/*
 * Player.java
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
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Player extends Creature{
	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	//Attakc Timer
	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	//Inventory
	private Inventory inventory;
	
	public Player(Handler handler, float x, float y){
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 22;
		bounds.y = 30;
		bounds.width = 19;
		bounds.height = 33;
		
		//Animations
		animDown = new Animation(500, Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
		
		inventory = new Inventory(handler);
	}
	
	@Override
	public void tick(){
		//Animations
		animDown.tick();
		animUp.tick();
		animRight.tick();
		animLeft.tick();
		//Movment
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		//Attack
		checkAttacks();
		//Inventory
		inventory.tick();
	}
	
	private void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown)
			return;
		
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2 - arSize / 2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
		}else{
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				return;
			}
		}
	}
	
	@Override
	public void die(){
		System.out.println("You Lose");
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	
	@Override
	public void render(Graphics g){
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		inventory.render(g);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0)
			return animLeft.getCurrentFrame();
		else if(xMove > 0)
			return animRight.getCurrentFrame();
		else if(yMove < 0)
			return animUp.getCurrentFrame();
		else
			return animDown.getCurrentFrame();
	}
	
	public Inventory getInventory(){
		return inventory;
	}

	public void setInventory(Inventory inventory){
		this.inventory = inventory;
	}
}
