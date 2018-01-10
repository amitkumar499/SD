package vendingMachine.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingMachine.enums.Coins;
import vendingMachine.enums.ItemType;
import vendingMachine.model.VendingMachine;

public class VendingMachineImpl implements VendingMachine {

	Map<ItemType, Integer> itemInventory = new HashMap<ItemType, Integer>();
	Map<Coins, Integer> totalCash = new HashMap<Coins, Integer>();
	int currentBalance;
	ItemType currentProduct;
	int totalSale;

	public VendingMachineImpl() {
		for (Coins c : Coins.values()) {
			totalCash.put(c, 10);
		}
		for (ItemType item : ItemType.values()) {
			itemInventory.put(item, 10);
		}
	}

	public void addCoins(Coins coin) {
		currentBalance = currentBalance + coin.getValue();
		totalCash.put(coin, totalCash.get(coin) + 1);
	}

	public int getItemswithPrice(ItemType item) {

		if (itemInventory.get(item) > 0) {
			currentProduct = item;
			return item.getCost();
		} else {
			System.out.println("Item Sold out");
			return 0;
		}

	}

	public List<Coins> getRefund() {
		List<Coins> refund = getChange(currentBalance);
		updateTotalCash(refund);
		currentBalance = 0;
		currentProduct = null;
		return refund;

	}

	public void reset() {
		itemInventory.clear();
		totalCash.clear();
		currentBalance = 0;
		currentProduct = null;
		totalSale = 0;
	}

	public Map<ItemType, List<Coins>> getSelectedProductAndMoney() {

		Map<ItemType, List<Coins>> map = new HashMap<ItemType, List<Coins>>();
		ItemType item = getItem();
		totalSale = totalSale + currentProduct.getCost();
		List<Coins> change = collectChange();

		map.put(item, change);
		return map;

	}

	public ItemType getItem() {

		return currentProduct;

	}

	public List<Coins> collectChange() {
		int changeAmount = currentBalance - currentProduct.getCost();
		List<Coins> change = getChange(changeAmount);
		updateTotalCash(change);
		currentBalance = 0;
		currentProduct = null;
		return change;
	}

	public List<Coins> getChange(int amount) {
		List<Coins> changes = Collections.EMPTY_LIST;
		if (amount > 0) {
			changes = new ArrayList<Coins>();
			long balance = amount;
			while (balance > 0) {
				if (balance >= Coins.QUARTER.getValue() && totalCash.get(Coins.QUARTER) > 0) {
					changes.add(Coins.QUARTER);
					balance = balance - Coins.QUARTER.getValue();
					continue;
				} else if (balance >= Coins.DIME.getValue() && totalCash.get(Coins.DIME) > 0) {
					changes.add(Coins.DIME);
					balance = balance - Coins.DIME.getValue();
					continue;
				} else if (balance >= Coins.NICKLE.getValue() && totalCash.get(Coins.NICKLE) > 0) {
					changes.add(Coins.NICKLE);
					balance = balance - Coins.NICKLE.getValue();
					continue;
				} else if (balance >= Coins.PENNY.getValue() && totalCash.get(Coins.PENNY) > 0) {
					changes.add(Coins.PENNY);
					balance = balance - Coins.PENNY.getValue();
					continue;
				} else {
					System.out.println("NotSufficientChange, Please try another product");
				}
			}
		}
		return changes;

	}

	private void updateTotalCash(List<Coins> change) {
		for (Coins c : change) {
			totalCash.put(c, totalCash.get(c) - 1);
		}
	}

	public Map<Coins, Integer> getTotalCash() {
		return totalCash;
	}
	
	public int getCurrentBalance(){
		return currentBalance;
	}
}
