package items;

public class Items {
	protected String name; 
	protected int value; 
	
	
	public Items() {
		
	}
	
	public Items(String s, int v) {
		this.name = s;
		this.value = v;
	}
	
	public int getHealing() {
		return (Integer) null;
	}

	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setValue(int v) {
		value = v;
	}

}
