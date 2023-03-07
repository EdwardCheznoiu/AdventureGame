package armors;

public class Armors {
	
	protected String name; 
	protected int phisRes;
	protected int magRes;
	protected int hp;
	
	public Armors() {
		
	}
	
    public Armors (String n, int pR, int mR, int h) {
		this.name = n ; 
		this.phisRes = pR;
		this.magRes = mR; 
		this.hp = h;
	}
    
    public String getName() {
    	return name;
    }
    
    public int getPhisRes() {
    	return phisRes;
    }
    
    public int getMagRes() {
    	return magRes;
    }
    
    public int getHp() {
    	return hp;
    }

}
