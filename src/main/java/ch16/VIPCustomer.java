package ch16;

public class VIPCustomer extends Customer {

	private int agentID;//전담 상담원
	double saleRatio;//할인 비율

	public VIPCustomer(int customerID, String customerName, String customerGrade) {
		super(customerID, customerName, customerGrade);
		bonusRatio = 0.05;
		saleRatio = 0.1;
		agentID = (int)(Math.random()*100+1);
	}
	
	@Override
	public void customerInfo() {
		System.out.println(customerName+"("+customerID+")님의 등급은 "+customerGrade+"이며, 보너스 포인트는 "+bonusPoint+"점 입니다. 담당 상담원 번호는 "+agentID+"이며, 할인률은 "+saleRatio*100+"% 입니다.");
	}
	@Override
	public int buyProduct(int price) {
		bonusPoint += price*bonusRatio;
		price -= (int)(price*saleRatio);
		return price;
	}
}
