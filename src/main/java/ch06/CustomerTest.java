package ch06;

import java.util.ArrayList;

public class CustomerTest {
	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		Customer customerLee = new Customer(10010,"이순신");
		Customer customerKim = new GoldCustomer(10020,"김유신");
		Customer customerA = new Customer(10030,"김순신");
		Customer customerB = new GoldCustomer(10040,"박순신");
		Customer customerC = new GoldCustomer(10050,"나순신");
		Customer customerD = new VIPCustomer(10060,"조순신");
		
		customerList.add(customerLee);
		customerList.add(customerKim);
		customerList.add(customerA);
		customerList.add(customerB);
		customerList.add(customerC);
		customerList.add(customerD);
		
		for(Customer c:customerList) {
			System.out.println(c.showCustomerInfo());
		}
		
		int price = 10000;
		for(Customer c:customerList) {
			int cost = c.calPrice(price);
			System.out.println(c.getCustomerName()+"("+c.getCustomerID()+")님이 " + cost+"원 지불하셨습니다.");
			System.out.println(c.getCustomerName()+"("+c.getCustomerID()+")님의 현재 포인트는 "+c.bonusPoint+"점 입니다.");
		}
		if(customerD instanceof GoldCustomer) {
			VIPCustomer vc = (VIPCustomer)customerD; 
			System.out.println(vc.showCustomerInfo());
		}
	}
}