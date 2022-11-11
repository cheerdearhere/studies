package chex;

public class Fruit {
	protected String name;
	protected String origin;
	protected int price;
	protected int brix;
	public Fruit(String name, String origin, int price, int brix) {
		super();
		this.name = name;
		this.origin = origin;
		this.price = price;
		this.brix = brix;
	}
	public void receiptContent() {
		System.out.println("================");
		System.out.println("과일을 선택해주세요.");
		System.out.println("================");
	}
	
}
