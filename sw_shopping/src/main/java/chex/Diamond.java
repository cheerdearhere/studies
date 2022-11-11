package chex;

public class Diamond extends Card{
	String color;
	
	public Diamond(int number) {
		super(number);
		shape="diamond";
		color="red";
	}
	@Override
	public void cardInfo() {
		System.out.println(shape+"모양, "+number+"번 카드의 색은 " + color+" 입니다.");
	}
}
