package chex;

public class Card {
	protected String shape;
	protected int number;
	public Card(int number) {
		this.number=number;
	}
	public void cardInfo() {
		System.out.println("카드 기본형입니다. 카드 종류를 입력해주세요.");
	}
}
