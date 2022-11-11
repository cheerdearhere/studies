package ch16;

public class GoldCustomer extends Customer {
	double saleRatio;//할인 비율
	public GoldCustomer(int customerID, String customerName, String customerGrade) {
		super(customerID, customerName, customerGrade);
		saleRatio = 0.1;
		bonusRatio = 0.02;
	}
	@Override
	public int buyProduct(int price) {
		bonusPoint += price*bonusRatio;
		price -= (int)(price*saleRatio);
		return price;
	}

}
