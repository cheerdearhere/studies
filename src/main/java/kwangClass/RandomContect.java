package kwangClass;

import java.util.Random;
import java.util.Scanner;

/*/*
랜덤 클래스 기초 랜덤 클래스로 룰렛을 한 번 만들어보겠습니다.
문자열 배열 혹은 배열을 이용해 '꽝', '100원', '1000원', '10000원', '50000'원을 저장하고, 
이를 같은 확률로 랜덤하게 뽑힐 수 있도록 해주세요.

Random이라는 이름의 프로젝트를 만들고, Main.java 안에 작성하세요.
이번에는 앞서 만든 룰렛 프로그램에 확률을 추가해보죠? 모두 같은 확률이면 재미없으니까요.
꽝은 30%, 100원은 63.9%, 1000원은 5%, 10000원은 1%, 50000원은 0.1%의 확률로 나올 수 있게 프로그램을 바꿔주세요.

입출력은 위와 같습니다.

출력 : 
*******랜덤 룰렛******
당신의 행운에 도전하세요!
룰렛을 돌리겠습니까?

입력 :
yes일 경우 룰렛을 돌린 후 값이 나오게 해주세요.
no일 경우 프로그램을 종료하고, 그 전까지는 계속 반복하게 해주세요.

출력 :
(꽝일 경우) '꽝'입니다. 다시 한 번 도전하세요!
(100원일 경우) 축하드립니다. '100원'입니다!
(1000원일 경우) 축하드려요, '1000원'에 당첨되셨습니다!
(10000원일 경우) 와! '10000원'에 당첨되셨어요!
(50000원일 경우) 당신이 진정한 승리자입니다. '50000원'에 당첨되셨어요.

*/
public class RandomContect {
	static String[] product = new String[] {"꽝", "100원", "1000원", "10000원", "50000원"}; 
	public static void main(String[] args) {
		boolean flag=true;
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		while(flag) {
			System.out.println("*******랜덤 룰렛******\n"
					+ "당신의 행운에 도전하세요!\n"
					+ "룰렛을 돌리겠습니까(y/n)?");
			String res = sc.next();
			if(res.equals("n")) {
				flag=false;
				break;
			}
			randomResult(r.nextInt(1000));
		}
		System.out.println("시스템을 종료합니다.");
		sc.close();
	}
	
//30%, 100원은 63.9%, 1000원은 5%, 10000원은 1%, 50000원은 0.1%
	public static void randomResult(int rate) {
		if(rate<300) 
			System.out.println("\'"+product[0]+"\'입니다. 다시 한번 도전하세요,");
		else if(rate<939)
			System.out.println("축하드립니다. \'"+product[1]+"\'입니다!");
		else if(rate<989)
			System.out.println("축하드려요. \'"+product[2]+"\'에 당첨되셨습니다!");
		else if(rate<999)
			System.out.println("와! \'"+product[3]+"\'에 당첨되셨어요!");
		else if(rate<1000)
			System.out.println("당신이 진정한 승리자 입니다. \'"+product[4]+"\'에 당첨되셨어요.");
		else
			System.out.println("Error: 잘못된 숫자입니다.");
	}

/*	public static void randomResult(int rate) {
		if(rate<20) 
			System.out.println("\'"+product[0]+"\'입니다. 다시 한번 도전하세요,");
		else if(rate<40)
			System.out.println("축하드립니다. \'"+product[1]+"\'입니다!");
		else if(rate<60)
			System.out.println("축하드려요. \'"+product[2]+"\'에 당첨되셨습니다!");
		else if(rate<80)
			System.out.println("와! \'"+product[3]+"\'에 당첨되셨어요!");
		else if(rate<100)
			System.out.println("당신이 진정한 승리자 입니다. \'"+product[4]+"\'에 당첨되셨어요.");
		else
			System.out.println("Error: 잘못된 숫자입니다.");
	}*/
}
