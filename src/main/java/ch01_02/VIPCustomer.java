package ch01_02;

public class VIPCustomer extends Customer {
/*	super class의 속성은 따로 선언하지 않아도됨
 	단, private는 해당 클래스 외에는 사용할 수 없으므로 
 	protected로 접근제어자를 설정해 상속관계에서 사용하도록 지정
 	protected int customerID; 
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;*/
	
	private int agentID;
	double saleRatio;
	
	public VIPCustomer() {
		bonusRatio = 0.05;
		saleRatio = 0.1;
		customerGrade="VIP";
	}
	
	public int getAgentID() {
		return agentID;
	}
	
	@Override
	public String showCustomerInfo() {
		return customerName +"("+ customerID + ")님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint +  "점 입니다." 
				+" 담당 상담원 번호는 " + agentID + "이며, 할인률은 " + saleRatio + "입니다. ";
	}
	
}
