package kwangClass;

import java.util.Scanner;

public class Question02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("세 사람의 이름을 적어주세요.");
		String human1 = scanner.next();
		System.out.println("친구1: "+ human1);
		String human2 = scanner.next();
		System.out.println("친구2: "+ human2);
		String human3 = scanner.next();
		System.out.println("3명 이름: " +human1+"/"+human2+"/"+human3);
		System.out.println("셋의 집은 각각 몇 km씩 떨어져있습니까?");
		int distance = scanner.nextInt();
		System.out.println("세 친구("+human1+", "+human2+", "+human3+")가 있다. \n 셋의 집은 각각 10km마다 떨어져 있는 거리에 존재한다. \n 세 명의 집을 차례대로 방문하려면 몇 km를 걸어가야하는가? \n 답: ");
		int result = scanner.nextInt();
		int answer = distance*3;
		if(result==answer) {
			System.out.println("정답입니다. ");
		}
		else {
			System.out.println("오답입니다. 정답은 "+answer+"km 입니다. ");
		}
	}
}
