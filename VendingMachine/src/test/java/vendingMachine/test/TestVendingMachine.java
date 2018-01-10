package vendingMachine.test;

import java.util.List;

import vendingMachine.enums.Coins;
import vendingMachine.enums.ItemType;
import vendingMachine.implementation.VendingMachineImpl;

public class TestVendingMachine {

	static VendingMachineImpl vm;

	public static void main(String[] args) {
		vm = new VendingMachineImpl();

		//insertCoins();
		buyProduct(ItemType.Coke);
		refund(ItemType.Coke);
	}

	/*private static void insertCoins() {

		System.out.println("-----Adding Coins-------\n");
		vm.addCoins(Coins.QUARTER);
		vm.addCoins(Coins.DIME);
		vm.addCoins(Coins.NICKLE);
		vm.addCoins(Coins.PENNY);

		System.out.println(vm.getTotalCash()+ "\n Current Balance"+vm.getCurrentBalance());
	}*/
	
	private static void buyProduct(ItemType item) {
		System.out.println("\n-----Buying Product-------\n");

		int price=vm.getItemswithPrice(item);
		System.out.println(vm.getTotalCash()+ "\n Current Balance"+vm.getCurrentBalance());

	}
	
	private static void refund(ItemType item) {
		System.out.println("\n-----Buying Product-------\n");
		

		vm.addCoins(Coins.QUARTER);
		System.out.println(vm.getTotalCash()+ "\n Current Balance"+vm.getCurrentBalance());

		int price=vm.getItemswithPrice(item);
		vm.getRefund();
		//vm.collectChange();
		System.out.println(vm.getTotalCash()+ "\n Current Balance"+vm.getCurrentBalance());

	}
	
}
