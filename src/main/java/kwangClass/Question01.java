package kwangClass;

import java.util.Scanner;

public class Question01 {

	public static void main(String[] args) {
		int month;
		int date;
		String name;
		int age;
		String aim;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("월을 입력해주세요. ");
		month = scanner.nextInt();
		if(month<1||month>12) {
			System.out.println("잘못입력하셨습니다. ");
			System.exit(0);
		}
		System.out.println("날짜를 입력해주세요. ");
		date = scanner.nextInt();
		if(date<0||date>31) {
			System.out.println("날짜 범위를 넘어섰습니다.다시 시작하세요. ");
			System.exit(0);
		}
		System.out.println("이름을 적어주세요.");
		name = scanner.next();
		System.out.println("나이를 적어주세요");
		age = scanner.nextInt();
		if(age<0||age>100){
			System.out.println("입력값을 확인해주세요. ");
			System.exit(0);
		}
		System.out.println("목표 입력해주세요. ");
		aim=scanner.next();
		if(aim.equals("")||aim==null) {
			System.out.println("입력값이 없습니다. ");
			System.exit(0);
		}
		scanner.close();
		System.out.println("오늘의 날짜는 "+month+"월 "+date+"일 입니다. \n 제 이름은 "+name+"이고, \n 제 나이는 "+age+"세이고, \n 제 목표는 "+aim+"입니다.");
	}

}
