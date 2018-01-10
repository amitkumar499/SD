package vendingMachine.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vendingMachine.enums.Coins;
import vendingMachine.enums.ItemType;
import vendingMachine.implementation.VendingMachineImpl;

public class TestVendingMachine {

	static VendingMachineImpl vm;

	public static void main(String[] args) {
		vm = new VendingMachineImpl();

		selectProduct(ItemType.Coke);
		refund(ItemType.Coke);
		selectnBuy(ItemType.Pepsi);
		reset();
	}

	/*
	 * private static void insertCoins() {
	 * 
	 * System.out.println("-----Adding Coins-------\n");
	 * vm.addCoins(Coins.QUARTER); vm.addCoins(Coins.DIME);
	 * vm.addCoins(Coins.NICKLE); vm.addCoins(Coins.PENNY);
	 * 
	 * System.out.println(vm.getTotalCash()+
	 * "\n Current Balance"+vm.getCurrentBalance()); }
	 */

	private static void selectProduct(ItemType item) {
		System.out.println("\n-----Selecting Product-------\n");

		int price = vm.getItemswithPrice(item);
		System.out.println("Price of Selected Product : " + price);

	}

	private static void refund(ItemType item) {
		System.out.println("\n-----Refund Money-------\n");

		vm.addCoins(Coins.QUARTER);
		System.out.println("Total Coins Left : "+vm.getTotalCash() + "\n Current Balance : " + vm.getCurrentBalance());

		vm.getItemswithPrice(item);
		vm.getRefund();
		System.out.println("Total Coins Left : "+vm.getTotalCash() + "\n Current Balance : " + vm.getCurrentBalance());

	}

	private static void selectnBuy(ItemType item) {
		System.out.println("\n-----Buying Product-------\n");

		vm.addCoins(Coins.QUARTER);
		vm.addCoins(Coins.QUARTER);

		System.out.println("Total Coins Left : "+vm.getTotalCash() + "\n Current Balance : " + vm.getCurrentBalance());

		vm.getItemswithPrice(item);
		Map<ItemType, List<Coins>> map = new HashMap<ItemType, List<Coins>>();
		map = vm.getSelectedProductAndMoney();

		System.out.println("Change Received: " + map.get(item));
		System.out.println("Total Coins Left : "+vm.getTotalCash() + "\n Current Balance : " + vm.getCurrentBalance());

	}

	private static void reset() {
		System.out.println("\n-----Reset-------\n");

		System.out.println(vm.getTotalCash());
		vm.reset();
		System.out.println(vm.getTotalCash());

	}
}
