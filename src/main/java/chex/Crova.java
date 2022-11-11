package chex;

public class Crova extends Card{
	String color; 
	
	public Crova(int number) {
		super(number);  
		shape="crova"; 
		color="black";
	}
	
	@Override
	public void cardInfo() {
		System.out.println(shape+"모양, "+number+"번 카드의 색은 " + color+" 입니다.");
	}
}
