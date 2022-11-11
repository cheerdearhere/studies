package chex;

public class Hart extends Card{
	String color;
	
	public Hart(int number) {
		super(number);
		shape="hart";
		color="red";
	}
	@Override
	public void cardInfo() {
		System.out.println(shape+"모양, "+number+"번 카드의 색은 " + color+" 입니다.");
	}
}
