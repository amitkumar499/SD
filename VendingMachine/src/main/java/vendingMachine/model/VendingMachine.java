package vendingMachine.model;

import java.util.List;
import java.util.Map;

import vendingMachine.enums.Coins;
import vendingMachine.enums.ItemType;

public interface VendingMachine {

	public void addCoins(Coins coin);
	public int getItemswithPrice(ItemType item) throws Exception;
	public List<Coins> getRefund();
	public Map<ItemType,List<Coins>> getSelectedProductAndMoney();

	public void reset();
}
