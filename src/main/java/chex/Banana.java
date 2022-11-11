package chex;

public class Banana extends Fruit {
	String sub;

	public Banana(String name, String origin, int price, int brix) {
		super(name, origin, price, brix);
		sub = "바나나";  
		
	}
	public void receiptContent() {
		System.out.println("================");
		System.out.println("품목: " + sub);
		System.out.println("생산자: " + name);
		System.out.println("원산지: " + origin);
		System.out.println("가격: " + price);
		System.out.println("당도: " + brix);
		System.out.println("================");
	} 

}