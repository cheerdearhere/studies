package kwangClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 1. 입력받을 숫자의 갯수 입력
 * 2. 입력받을 때마다 수를 합하고 중간 합을 출력
 * 3. 새로 받을때마다 이전의 중간합에 추가하고 결과 출력
 * 4. 마지막에 입력한 값들과 결과 식을 출력
*/
public class Question08 {
	public static void main(String[] args) {
		int i = 0;
		int st= 1;
		String res = "";
		Scanner scanner = new Scanner(System.in);
		firstLoof: 
			while(true) {
				System.out.println("몇개의 숫자를 입력 받으시겠습니까? ");
				res = scanner.next();
				if(!integerValid(res)) continue firstLoof;
				i=Integer.parseInt(res);
				
				NumberSum ns = new NumberSum();
				numberLoof: 
					while(true) {
						if(i==0) {
							if(ns==null||ns.getSum()==0) {
								System.out.println("0개를 선택하셨습니다. 다시 시작합니다.");
								break numberLoof;
							}
							System.out.println(
									"**************************************** \n"
									+"당신이 입력한 숫자: "+ns.getList().toString()+"\n"
									+"입력한 숫자의 합: "+ns.getSum()+"\n"
									+"+++++시스템을 종료합니다+++++"
									);
							scanner.close();
							break firstLoof;
						}
						System.out.println(st+". 입력할 숫자(남은 자리"+i+"개): ");
						res=scanner.next();
						if(!integerValid(res)) continue numberLoof;
						int num = Integer.parseInt(res);
						int temp = ns.getSum();
						ns.insertNum(num);
						if(i!=1)
							System.out.println("중간 결과: "+temp+" + "+num+" = "+ns.getSum());
						i--;
						st++;
					}
			}
		
	}
	public static boolean integerValid(String str) {
		try {
			int numberCheck = Integer.parseInt(str);
			if(numberCheck<0) {
				System.out.println("0보다 작은 수는 입력할 수 없습니다.");
				return false;
			}
			return true;
		}
		catch(NumberFormatException ne) {
			System.out.println("숫자만 입력할 수 있습니다.");
			return false;
		}
	}
}

class NumberSum{
	private int num;
	private int sum;
	private List<Integer> numList;
//	constructor
	public NumberSum() {
		sum=0;
		numList= new ArrayList<Integer>();
	}
//	method
	public void insertNum(int num) {
		this.num=num;
		numList.add(num);
		sum+=num;
	}
	public int getCorrentNum() {
		return num;
	}
	public int getSum() {
		return sum;
	}
	public List<Integer> getList(){
		return numList;
	}
}
