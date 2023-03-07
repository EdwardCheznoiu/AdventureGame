package enemies;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.CountDown;
import main.UI;

public class Enemies {
	protected String name; 
	protected int hp; 
	protected int lvl; 
	protected int res; 
	protected int exp; 
	protected boolean isAlive = true;
	UI ui = new UI();
	CountDown c = new CountDown();
	public Enemies() {
		
	}
	
	public Enemies(String n, int h, int lv, int re, int ex) {
		this.name = n; 
		this.hp = h; 
		this.lvl = lv; 
		this.res = re;
		this.exp = ex;
	}
	
 
	public String getName() {
		return name; 
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getLvl() {
		return lvl;
	}
	
	public int getRes() {
		return res;
	}
	
	public int getExp() {
		return exp;
	}
	
	public void setName(String n) {
		name = n; 
	}
	
	public void setHp(int h) {
		hp = h;
	}
	
	public void setlvl(int h) {
		lvl = h;
	}
	
	public void setRes(int h) {
		res = h;
	}
	
	public void setExp(int h) {
		exp = h;
	}
	
	public void enemyAttack() {
		
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(boolean b) {
		isAlive = b;
	}
	
 
	
}
