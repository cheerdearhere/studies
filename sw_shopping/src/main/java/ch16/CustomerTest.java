package ch16;

import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {
		int price=10000;
		
		Customer customerLee = new Customer(10010, "이순신", "SILVER");
		customerLee.bonusPoint=1000;
		System.out.println(customerLee.buyProduct(price));
		
		Customer customerKim = new VIPCustomer(10020, "김유신", "VIP");
		customerKim.bonusPoint=10000;
		System.out.println(customerKim.buyProduct(price));
		
		customerLee.customerInfo();
		customerKim.customerInfo();
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
	}

}
