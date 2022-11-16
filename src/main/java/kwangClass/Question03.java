package kwangClass;

import java.util.Scanner;

public class Question03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫 숫자를 적어주세요. ");
		int num1 = scanner.nextInt();
		System.out.println("두번째 숫자를 적어주세요. ");
		int num2 = scanner.nextInt();
		System.out.println(num1+" + "+num2+" = ?");
		int answer = num1+num2; 
		int submit = scanner.nextInt();
		scanner.close();
		if(answer==submit) {
			System.out.println("정답입니다. 다음문제입니다. ");
			System.out.println("Q2. .....");
		}else {
			System.out.println("오답입니다. 정답은 "+answer+" 입니다.");
			System.exit(0);
		}
	}
}
