package ch15;

public class CustomerTest {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.buy();
		customer.sell();
		customer.order();
		customer.hello();
		
		Buy buyer = customer;//up casting
		buyer.buy();
		buyer.order();
		//buyer.sell(); 
		Sell seller = customer;
		seller.sell();
		seller.order();
		//seller.buy();
	}
}
