package chex;

import java.util.Scanner;

public class FruitShop {

	public static void main(String[] args) {
		Fruit fruit;
		System.out.println("과일/사과/바나나/수박 중 하나를 입력해주세요.");
		Scanner scanner = new Scanner(System.in);
		String fruitName = scanner.next();
		scanner.close();
		if(fruitName.equals("과일")) {
			fruit = new Fruit("none", "none", 0, 0);
		}
		else if(fruitName.equals("사과")) {
			fruit = new Apple("홍길동", "전북 익산", 1000, 12);
		}
		else if(fruitName.equals("바나나")) {
			fruit = new Banana("이순신", "제주", 3000, 13);
		}
		else if(fruitName.equals("수박")) {
			fruit = new WaterMelon("니콜라스", "필리핀", 13000, 15);
		}
		else {
			fruit = new Fruit("null","null",0,0);
			System.out.println("잘못입력하셨습니다.");
		}
		fruit.receiptContent();
	}

}
