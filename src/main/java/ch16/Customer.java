package ch16;

public class Customer {
	//customer information
	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int sd;
	//bonus
	int bonusPoint;//적립할 포인트
	double bonusRatio;//적립비율

	public Customer(int customerID, String customerName, String customerGrade) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerGrade = customerGrade;
		bonusRatio = 0.01;
	}
	
	public void customerInfo() {
		System.out.println(customerName+"("+customerID+")님의 등급은 "+customerGrade+"이며, 보너스 포인트는 "+bonusPoint+"점 입니다.");
	}
	public int buyProduct(int price) {
		bonusPoint += price*bonusRatio;
		return price;
	}
}
