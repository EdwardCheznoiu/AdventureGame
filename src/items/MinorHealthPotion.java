package items;

public class MinorHealthPotion extends Items{
	public int healing;
	
	public MinorHealthPotion() {
		name = "Potiune de viata l";
		value = 20;
		healing = 5;
	}
	
	@Override
	public int getHealing() {
		return healing;
	}
}
