package vendingMachine.enums;

public enum ItemType {

	Coke(25), Pepsi(35), Soda(45);
	
	private int cost;
	
	ItemType(int cost)
	{
		this.cost=cost;
	}
	
	public int getCost()
	{
		return cost;
	}


}
