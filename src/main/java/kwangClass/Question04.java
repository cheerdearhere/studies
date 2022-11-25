package kwangClass;

import java.util.Scanner;

public class Question04 {
	//variable
	private static int a, b, c, d,e,f,g;
	
	public static void main(String[] args) {
		//variable condition
		System.out.println("다음 변수를 순차적으로 입력하세요.");
		System.out.println("a는 5000이상, 10000이하의 숫자입니다.\n"
				+ "	b는 4000 이상의 숫자가 들어있고, a보다 클 수도 있고, 작을 수도 있습니다.\n"
				+ "	단, b가 a보다 크다면 c는 a와 b의 합이고, b가 a보다 작다면 c는 a와 b의 합에서 -300입니다.\n"
				+ "	d는 a와 b와 c를 합친 수이지만, e는 a와 b와 c를 합친 수에서 세 배보다 작습니다.\n"
				+ "	f는 나머지 a,b,c,d,e를 합친 숫자보다 5000이 더 큽니다. g는 f의 두 배입니다.\n");
		//using scanner/ submit values
		Scanner scanner = new Scanner(System.in);
		System.out.println("a=");
		a=scanner.nextInt();
		System.out.println("b=");
		b=scanner.nextInt();
		System.out.println("c=");
		c=scanner.nextInt();
		System.out.println("d=");
		d=scanner.nextInt();
		System.out.println("e=");
		e=scanner.nextInt();
		System.out.println("f=");
		f=scanner.nextInt();
		System.out.println("g=");
		g=scanner.nextInt();
		System.out.println("결과를 표시합니다.");
		scanner.close();
		
		String message = "";
		int v = 0;
		
		//validate
		if(a<5000||a>10000) {
			message = "a가 ";		
			v +=1;
		}
		if(b<4000) {
			message += "b가 ";
			v +=1;
		}
		int c1 = 0;
		if(b>a) {
			c1=a+b;
		}
		else if(b<a) {
			c1=a+b-300;
		}
		if(c!=c1) {
			message += "c가 ";
			v +=1;
		}
		if(d!=a+b+c) {
			message += "d가 ";
			v +=1;
		}
		if(e>(a+b+c)*3) {
			message += "e가 ";
			v +=1;
		}
		int f1 = a+b+c+d+e+5000;
		if(f!=f1) {
			message += "f가 ";
			v +=1;
		}
		if(g!=f1*2) {
			message += "g가 ";
			v +=1;
		}
		//if all values ​​are different
		if(v==7) {
			message = "모두 ";
		}
		message += "잘못되었습니다. ";
		//if all values are equal
		if(v==0) {
			message = "정답입니다.";
		}
		
		//console message
		System.out.println(message);
	}
}
