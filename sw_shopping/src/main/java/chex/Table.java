package chex;

public class Table {
	public static void main(String[] args) {
		Card card = new Card(3);
		card.cardInfo();
		Card hart4 = new Hart(4);
		hart4.cardInfo();
		Card dia2 = new Diamond(2);
		dia2.cardInfo();
		Card spade7 = new Spade(7); 
		spade7.cardInfo();
		Card crova10 = new Crova(10);
		crova10.cardInfo();
	}
}
