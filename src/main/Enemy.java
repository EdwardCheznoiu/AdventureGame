package main;

public class Enemy {
	private String name; 
	private int hp; 
	private int lvl; 
	private int res; 
	private int exp; 
	
	
	//Constructorul default pentru clasa Enemy
	public Enemy() {
		
	}
	
	
	//Constructorul de initializare pentru clasa Enemy
    public Enemy(String n, int h, int l, int r, int e) {
		name = n;
		hp = h; 
		lvl = l;
		res = r; 
		exp = e;
		
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
	
	/*Metoda de atac pentru inamic care ia ca argumente doua obiecte, un obiect de tip Player si un obiect de tip UI, 
	obiecte folosite pentru a putea modifica datele jucatorului (obiectul pl) si pentru a le putea afisa pe ecran (obiectul ui)*/
	public void enemyAttack(Player pl, UI ui) {
		int enemyDMG = new java.util.Random().nextInt(lvl*10);
		int dmgdeatl = enemyDMG - (pl.getBasePhisRes());
		ui.mainTextArea.setText("Inamicul " +"'" + name + "A provocat" + dmgdeatl + " daune");
		pl.setHp(pl.getHp() - dmgdeatl);
		
		ui.choice1.setText("Ataca");
		ui.choice2.setText("Paraseste lupta");
		ui.choice3.setText("");
		ui.choice4.setText("");
	}
	
}
