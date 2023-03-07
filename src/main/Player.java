package main;
import armors.Armors;
import armors.NoArmor;
import enemies.Enemies;
import items.Items;
import weapons.Fists;
import weapons.Weapons;


public class Player {
	private static int level = 1; 
	private static int lp = 0; 
	private static int baseDmg = 2;
	private static int str = 5; 
	private static int wis = 5;
	private static int phisicalDmg = baseDmg + str/3;
	private static int magicalDmg = baseDmg + wis/3;
	private static Inventory i = new Inventory();
	private Weapons curentWeapon = new Fists();
	private Armors curentArmor = new NoArmor(); 
	private static int exp = 0; 
	private static int lvlThreshold = 5; 
	private static int mp = 5;   
	private static int hp = 10; 
	private static int maxHp = 10;
	private static int basePhisRes = 2;
	private static int baseMagicalRes = 2;
   // public static boolean inFight = false; 
    private boolean firstLvlUp = false;
	public static int attacked;
    
	
	
	public void playerAttack(Enemies e, UI ui, MainGame game) {
		SoundEffects playerAttack = new SoundEffects();
		playerAttack.setFile("C:/Users/Eddula/eclipse-workspace/AdeventureGame/Sounds/PlayerAttack.wav");
		playerAttack.playOnce();
		attacked = 1;
		int curentEnemyHp = 0;
		int dmgdeatl = 0;
		int playerDMG = 0;
		int critDMG = 0;
		
		//Verific arma folosita si calculez daunele aplicate
		if(curentWeapon.getClass() == Weapons.class)
	       playerDMG = new java.util.Random().nextInt(curentWeapon.getDmg() + phisicalDmg);
		else 
			playerDMG = new java.util.Random().nextInt(curentWeapon.getDmg());
		
		if(playerDMG < e.getRes())
			dmgdeatl = 0;
		else
		dmgdeatl = playerDMG - e.getRes();
		critDMG = (curentWeapon.getCrit() / 100) * dmgdeatl; 
		dmgdeatl += critDMG; 
		
		curentEnemyHp = e.getHp() - dmgdeatl;
		e.setHp(curentEnemyHp);
		updateStatusUi(ui);
		ui.mainTextArea.setText("Ai povocat " + dmgdeatl + " daune" + "\n\nHP: " + e.getHp() + " | DMG:  " + e.getLvl() * 3 + " | Rezistenta: " + e.getRes() +"\n\n Ce vei face?");
		if(e.getHp() > 0) {
		    ui.choice1.setText(">");
		    ui.choice2.setText("");
		    ui.choice3.setText("");
		    ui.choice4.setText("");	
		    game.nextPosition1 = "AtackGiantRat";
			game.nextPosition2 = ""; 
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("Ai invins " + e.getName() + "\n Ai castigat " + e.getExp() +" puncte de experienta");
			exp += e.getExp();
			checkExp(ui);
			updateStatusUi(ui);
			ui.choice1.setText("Paraseste lupta");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			game.nextPosition1 = "runFrom1stGiantRat";
			game.nextPosition2 = ""; 
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	
	// Memorez armele gasite in doi vectori de tip Weapons si Armors, vectori ce se regasesc in clasa inventar
	
	public void addWeap(Weapons a, int index, UI ui) {
		  Inventory.w[index] = a; 
	}
	
	public void addArm(Armors a, int index) {
		Inventory.a[index] = a; 
	}
	
	public void addItems(Items its, int index) {
		Inventory.it[index] = its; 
	}
	
	

	//Ii atribui arma selectata din inventar catre obiectul curentWeapon (arma curenta)
	public void asignWeapon(UI ui) {
		int i = Inventory.indexOfWClicked;
		if(Inventory.w[i].getLvlReq()<= level) {
			curentWeapon = Inventory.w[i];
			ui.weaponNameLabel.setText("" + curentWeapon.getName());
			updateStatusUi(ui);
		}
		else {
			ui.mainTextPanel.setVisible(true);
			ui.mainTextArea.setText("Nivelul tau este prea mic");
 
		}
	}
	
	
	public void asignArmor(UI ui) {
		int i = Inventory.indexOfWClicked;
		curentArmor = Inventory.a[i];
		ui.armorNameLabel.setText("" + curentArmor.getName());
		updateStatusUi(ui);
	}
	

	/*Verific daca am adunat suficienta experienta pentru a creste nivelul, daca da
	atunci atributele jucatorului cresc, creste si pragul necesar pentru a trece la nivelul urmator, se actualizeaza interfata cu noile date*/ 
	public void checkExp(UI ui) {
		CountDown c = new CountDown();
		c.closeTab(ui.lvlUpMsgPanel);
		if(exp >= lvlThreshold) {
			if(!firstLvlUp) {
			exp = 0; 
			level++;
			lvlThreshold += 5; 
			lp += 5;
			baseDmg++;
			basePhisRes++;
			ui.lvlLabel.setText("Nivel: " + level);
			ui.expLabel.setText("Exp: " + exp + " / " + lvlThreshold);
			ui.lvlUpMsgPanel.setVisible(true);
			ui.secondTextArea.setText("Felicitari, ai atins nivelul urmator! \n\n Apasa 'Status' pentru a te upgrada");	
			firstLvlUp = true;
			}
			else {
				exp = 0; 
				level++;
				lvlThreshold += 5; 
				lp += 5;
				baseDmg++;
				basePhisRes++;
				ui.lvlLabel.setText("Nivel: " + level);
				ui.expLabel.setText("Exp: " + exp + " / " + lvlThreshold);
				ui.lvlUpMsgPanel.setVisible(true);
				ui.lvlMsg.setText("Felicitari, ai atins nivelul urmator!");
				
			}
		}
	}
	
	public void updateStatusUi(UI ui) {
		ui.lvlsNrLabel.setText("" + level);
		ui.lpNrLabel.setText("" + lp);
		ui.expsNrLabel.setText("" + exp);
		ui.statusHpNrLabel.setText("" + hp);
	    ui.statusMpNrLabel.setText("" + mp);
	    ui.statusStrNrLabel.setText("" + str);
	    ui.statusWisNrLabel.setText("" + wis);
	    ui.statusWNrLabel.setText("" + curentWeapon.getName());
	    ui.statusANrLabel.setText("" + curentArmor.getName());
	    ui.statusPhAtNrLabel.setText("" + phisicalDmg);
	    ui.statusMagAtNrLabel.setText("" + magicalDmg);
	}
	

	public void hpUpgrade(UI ui) {
		CountDown c = new CountDown();
		c.closeTab(ui.statusTextArea);
		if(lp >= 1) {
				maxHp++;
				hp++;
				lp--;
				ui.statusTTextArea.setText("Viata ta a crescut cu 1! Ai " + maxHp +" puncte de viata");
				ui.statusTextArea.setVisible(true);
				ui.hpNumberLabel.setText("" + hp);
				updateStatusUi(ui);
			 
			}
		
		else {
			ui.statusTTextArea.setText("Nu ai suficiente puncte de invatare! (LP)");
			ui.statusTextArea.setVisible(true);
		}	
	}
	
	
	public void mpUpgrade(UI ui) {
		CountDown c = new CountDown();
		c.closeTab(ui.statusTextArea);
		if(lp >= 1) {
				mp++;
				lp--;
				ui.statusTTextArea.setText("Mana ta a crescut cu 1! Ai " + mp +" puncte de mana");
				ui.statusTextArea.setVisible(true);
				ui.mpNumberLabel.setText("" + mp);
				updateStatusUi(ui);
			}
		
		else {
			ui.statusTTextArea.setText("Nu ai suficiente puncte de invatare! (LP)");
			ui.statusTextArea.setVisible(true);
		}	
	}
	
	public void strUpgrade(UI ui) {
		CountDown c = new CountDown();
		c.closeTab(ui.statusTextArea);
		if(lp >= 1) {
				str++;
				lp--;
				ui.statusTTextArea.setText("Puterea ta a crescut cu 1! Ai " + str + " puncte de forta");
				ui.statusTextArea.setVisible(true);
				updateStatusUi(ui);
			}
		
		else {
			ui.statusTTextArea.setText("Nu ai suficiente puncte de invatare! (LP)");
			ui.statusTextArea.setVisible(true);
		}	
	}
	
	public void wisUpgrade(UI ui) {
		CountDown c = new CountDown();
		if(lp >= 1) {
				wis++;
				lp--;
				ui.statusTTextArea.setText("Inteligenta ta a crescut cu 1! Ai " + wis + " puncte de inteligenta");
				ui.statusTextArea.setVisible(true);
				updateStatusUi(ui);
				c.closeTab(ui.statusTextArea);
			}
		
		else {
			ui.statusTTextArea.setText("Nu ai suficiente puncte de invatare! (LP)");
			ui.statusTextArea.setVisible(true);
			c.closeTab(ui.statusTextArea);
		}	
	}
	
	
	public void potionUsed(UI ui) {
		System.out.print(Inventory.indexOfWClicked);
		int i = Inventory.indexOfWClicked;
		int newHp = Inventory.it[i].getHealing();
		if(hp < maxHp) {
		if(newHp + hp > maxHp) {
			hp = maxHp;
			Player.i.deleteItem(ui);
		}
		else {
			hp += newHp;
			Player.i.deleteItem(ui);
		}
		updateHpMp(ui);
	  }
	}
	
	
	public void updateHpMp(UI ui) {
		ui.hpNumberLabel.setText("" + hp);
		ui.mpNumberLabel.setText("" + mp);
	}
	
	
	public int getLVL() {
		return level;
	}
	
	public int getLP() {
		return lp;
	}
	
	public int getBaseDMG() {
		return baseDmg;
	}
	
	public int getBasePhisRes() {
		return basePhisRes;
	}
	
	public int getSTR() {
		return str;
	}
	
	public int getWIS() {
		return wis;
	}
	
	public int getPhisDMG() {
		return phisicalDmg;
	}
	
	public int getMagicalDMG() {
		return magicalDmg;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getMp() {
		return mp;
	}
	
	public int getExp() {
		return exp;
	}
	
	public int getlvlThreshold() {
		return lvlThreshold;
	}
	
	public String getWeaponName() {
		return curentWeapon.getName();
	}
	
	public String getArmorName() {
		return curentArmor.getName();
	}
	
	public Inventory getInventory() {
		return i;
	}
	
	public void setHp(int g) {
		hp = g;
	}
	
	public void setMp(int g) {
		mp = g;
	}
	
	public void setSTR(int g) {
		str = g;
	}
	
	public void setWIS(int g) {
		wis = g;
	}
}
