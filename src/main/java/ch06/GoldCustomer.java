package ch06;

public class GoldCustomer extends Customer {
	double saleRatio;
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		bonusRatio = 0.02;
		saleRatio = 0.1;
		customerGrade="Gold";
	}
	@Override
	public int calPrice(int price) {
		bonusPoint += price*bonusRatio;
		price -= (int)(price*saleRatio);
		return price;
	}
	@Override
	public String showCustomerInfo() {
		return customerName +"("+ customerID + ")님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint +  "점 입니다." 
				+" 할인률은 " + saleRatio + "입니다. ";
	}
	
}
