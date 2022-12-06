package kwangClass;

import java.util.Scanner;

public class Question05 {
	public static void main(String[] agrs) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("다음 세 가지 중 원하는 항목의 번호를 입력하세요. \n 1.감자, 2.옥수수 3.고구마 4.수박");
		int category=0;
		int size=0;
		int prize=0;
		int amount=0;
		
		category = scanner.nextInt();
		if(category==1) {
			System.out.println("감자를 선택하셨습니다. ");
			System.out.println("원하시는 호(size)의 번호를 입력해주세요. \n  (가격은 kg기준입니다.) \n 1.S:1000원 2.M:2000원 3.L:3000원 ");
			size = scanner.nextInt();
			if(size==1) {
				prize=1000;
				System.out.println("감자 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else if(size==2) {
				prize=2000;
				System.out.println("감자 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else if(size==3) {
				prize=3000;
				System.out.println("감자 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else {
				System.out.println("호(size)를 잘못입력하셨습니다. ");
				System.exit(0);
			}
		}
		else if(category==2) {
			System.out.println("옥수수를 선택하셨습니다. ");
			System.out.println("원하시는 호(size)의 번호를 입력해주세요. \n  (가격은 kg기준입니다.) \n 1.S:4000원 2.M:5000원 3.L:6000원 ");
			size = scanner.nextInt();
			if(size==1) {
				prize=4000;
				System.out.println("옥수수 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else if(size==2) {
				prize=5000;
				System.out.println("옥수수 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else if(size==3) {
				prize=6000;
				System.out.println("옥수수 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else {
				System.out.println("호(size)를 잘못입력하셨습니다. ");
				System.exit(0);
			}
		}
		else if(category==3) {
			System.out.println("고구마를 선택하셨습니다. ");
			System.out.println("원하시는 호(size)의 번호를 입력해주세요. \n  (가격은 kg기준입니다.) \n 1.S:7000원 2.M:8000원 3.L:9000원 ");
			size = scanner.nextInt();
			if(size==1) {
				prize=7000;
				System.out.println("고구마 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else if(size==2) {
				prize=8000;
				System.out.println("고구마 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else if(size==3) {
				prize=9000;
				System.out.println("고구마 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else {
				System.out.println("호(size)를 잘못입력하셨습니다. ");
				System.exit(0);
			}
		}
		else if(category==4) {
			System.out.println("수박을 선택하셨습니다. ");
			System.out.println("원하시는 호(size)의 번호를 입력해주세요. \n  (가격은 kg기준입니다.) \n 1.S:10000원 2.M:12000원 3.L:15000원 ");
			size = scanner.nextInt();
			if(size==1) {
				prize=10000;
				System.out.println("수박 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else if(size==2) {
				prize=12000;
				System.out.println("수박 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else if(size==3) {
				prize=15000;
				System.out.println("수박 "+prize+"원 짜리를 선택하셨습니다.");
			}
			else {
				System.out.println("호(size)를 잘못입력하셨습니다. ");
				System.exit(0);
			}
		}
		else {
			System.out.println("잘못입력하셨습니다.");
			System.exit(0);
		}
		System.out.println("구매하실 수량을 입력해주세요.");
		amount = scanner.nextInt();
		scanner.close();
		if(category==0||size==0||amount==0) {
			System.out.println("잘못 입력하셨습니다. 다시 확인하시고 진행해주세요."
					+ "\n 품목: "+category+" 호: "+size+" 수량: "+amount);
			System.exit(1000);
		}
		else {
			System.out.println("총액: "+prize*amount+"원");
		}
	
	}
}
