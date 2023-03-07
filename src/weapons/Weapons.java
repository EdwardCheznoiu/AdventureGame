package weapons;

public class Weapons {
	
	protected String name; 
	protected int dmg; 
	protected int crit; 
	protected int atackSpeed; 
	protected static int lvlReq; 
	
	public Weapons() {
		
	}
	
	//Constructorul clasei Weapons
	public Weapons(String n, int d, int c, int a, int lrq){
		this.name = n;
		this.dmg = d; 
		this.crit = c; 
		this.atackSpeed =a;
		this.lvlReq = lrq; 
	}
	
	 public String getName() {
	    	return name;
	    }
	    
	    public int getDmg() {
	    	return dmg;
	    }
	    
	    public int getCrit() {
	    	return crit;
	    }
	    
	    public int getAtackSpeed() {
	    	return atackSpeed;
	    }
	    
	    public int getLvlReq() {
	    	return lvlReq;
	    }

}
