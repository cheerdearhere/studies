package chex;

public class Apple extends Fruit {
	String sub;

	public Apple(String name, String origin, int price, int brix) {
		super(name, origin, price, brix);
		sub = "사과";
		
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
