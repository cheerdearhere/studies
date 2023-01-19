package kwangClass;

import java.util.ArrayList;
import java.util.Scanner;

public class Question06 {
	public static void main(String[] args) {
		int money = 10000;
		int income=0;
		int price=0;
		int amount=0;
		boolean incomeChance = true;
		ArrayList<Integer> prices = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("현재 금액: "+money+"원 \n 추가된 용돈은 얼마인가요?");
		income = scanner.nextInt();
		System.out.println(income+"원을 받았습니다.");
		money+=income;
		income=0;
		
		System.out.println("상품의 금액을 결정해주세요. \n 떡볶이: ");
		price=scanner.nextInt();
		prices.add(price);
		System.out.println("우동: ");
		price=scanner.nextInt();
		prices.add(price);
		System.out.println("과자: ");
		price=scanner.nextInt();		
		prices.add(price);
		
		price=prices.get(0);
		System.out.println("현재 금액: "+money+"원");
		System.out.println("판매를 시작합니다. \n 떡볶이("+price+"원)를 몇 개 주문하시겠습니까?" );
		amount=scanner.nextInt();
		System.out.println(price+"원짜리 떡볶이 "+amount+"개를 주문합니다.");
		if(money<price*amount) {
			System.out.println("금액이 부족합니다. \n 현재 용돈: "+money+"원");
			if(incomeChance) {
				System.out.println("추가할 용돈은 얼마인가요?");
				income = scanner.nextInt();
				System.out.println(income+"원을 받았습니다.");
				money+=income;
				income=0;
				incomeChance=false;
				System.out.println("현재 금액: "+money+"원");
			}
			if(money<price*amount) {
				System.out.println("떡볶이를 살 돈이 없어 주인에게 쫓겨났습니다.");
				System.exit(0);
			}
		}
		else {
			System.out.println("떡볶이 금액: "+price*amount);
			money-=price*amount;
			System.out.println("남은 용돈: "+money);
		}
		
		price=prices.get(1);
		System.out.println("우동 ("+price+"원)을 몇 개 주문하시겠습니까?");
		amount=scanner.nextInt();
		System.out.println(price+"원짜리 우동 "+amount+"개를 주문합니다.");
		if(money<price*amount) {
			System.out.println("금액이 부족합니다. \n 현재 용돈: "+money+"원");
			if(incomeChance) {
				System.out.println("추가할 용돈은 얼마인가요?");
				income = scanner.nextInt();
				System.out.println(income+"원을 받았습니다.");
				money+=income;
				income=0;
				incomeChance=false;
				System.out.println("현재 금액: "+money+"원");
			}
			if(money<price*amount) {
				System.out.println("우동을 살 돈이 없어 주인에게 쫓겨났습니다.");
				System.exit(0);
			}
		}
		else {
			System.out.println("우동 금액: "+price*amount);
			money-=price*amount;
			System.out.println("남은 용돈: "+money);
		}

		price=prices.get(2);
		System.out.println("과자 ("+price+"원)을 몇 개 주문하시겠습니까?");
		amount=scanner.nextInt();
		System.out.println(price+"원짜리 과자 "+amount+"개를 주문합니다.");
		if(money<price*amount) {
			System.out.println("금액이 부족합니다. \n 현재 용돈: "+money+"원");
			if(incomeChance) {
				System.out.println("추가할 용돈은 얼마인가요?");
				income = scanner.nextInt();
				System.out.println(income+"원을 받았습니다.");
				money+=income;
				income=0;
				incomeChance=false;		
				System.out.println("현재 금액: "+money+"원");
			}
			if(money<price*amount) {
				System.out.println("과자를 살 돈이 없어 주인에게 쫓겨났습니다.");
				System.exit(0);
			}
		}
		else {
			System.out.println("과자 금액: "+price*amount);
			money-=price*amount;
			System.out.println("최종 잔액: "+money);
		}
		scanner.close();
	}
}