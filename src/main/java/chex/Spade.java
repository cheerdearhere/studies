package chex;

public class Spade extends Card{
	String color;
	
	public Spade(int number) {
		super(number);
		shape="spade";
		color="black";
	}
	@Override
	public void cardInfo() {
		System.out.println(shape+" 모양, "+number+"번 카드의 색은 " + color+" 입니다.");
	}
}
