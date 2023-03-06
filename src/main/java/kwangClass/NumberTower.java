package kwangClass;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberTower {
	static FloorCalc floorCalc;
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		String clientResponse = "";
		int select=0;
		int floor=0;
		
		floorLoof:
		while(true) {
			System.out.println("System: 몇 층으로 쌓으시겠습니까?");
			clientResponse=inputScanner.next();
			if(clientResponse.trim()=="") {
				System.out.println("공백은 입력할 수 없습니다.");
				continue floorLoof;
			}
			try {
				floor=Integer.parseInt(clientResponse);
			}
			catch(NumberFormatException e) {
				System.out.println("문자는 입력할 수 없습니다.");
				continue floorLoof;
			}
			if(floor==0) {
				floorCalc = new FloorCalc(floor);
				continue floorLoof;
			}
			floorCalc = new FloorCalc(floor);
			calcLoof:
				while(true) {
					System.out.println("""
							기능을 선택해주세요
								1. 마지막층의 왼쪽
								2. 마지막층의 오른쪽
								3. 모든 층 양끝의 수
								4. 층 다시 정하기
								5. 전체 종료
							""");
					clientResponse = inputScanner.next();
					if(clientResponse.trim()=="") {
						System.out.println("공백은 입력할 수 없습니다.");
						continue calcLoof;
					}
					try {
						select=Integer.parseInt(clientResponse);
					}
					catch(NumberFormatException e) {
						System.out.println("문자는 입력할 수 없습니다.");
						continue calcLoof;
					}
					if(select==1) {
						System.out.println("숫자탑의 제일 아래 왼쪽");
						floorCalc.getFloorL();
						continue calcLoof;
					}
					else if(select==2) {
						System.out.println("숫자탑의 제일 아래 오른쪽");
						floorCalc.getFloorR();
						continue calcLoof;
					}
					else if(select==3) {
						System.out.println("숫자탑의 모든 층 양끝");
						floorCalc.allFloor();
						continue calcLoof;
					}
					else if(select==4) {
						System.out.println("숫자탑을 다시 설정합니다. \n 현재: "+floor);
						continue floorLoof;
					}
					else if(select==5) {
						System.out.println("시스템을 종료합니다.");
						inputScanner.close();
						break floorLoof;
					}
					else {
						System.out.println("잘못입력하셨습니다: "+select);
						continue calcLoof;
					}
				}
		}
	}
}

class FloorCalc{
	private int floor;
	private int floorL;
	private int floorR;
	private ArrayList<int[]> floorList;
	private int[] floorData = new int[3];//0:floor, 1:floorL, 2:floorR
	
	public FloorCalc(int n) {
		this.floor=n;
		if(n<=0) {
			System.out.println("0 이하의 정수는 입력할 수 없습니다.");
			return;
		}
		else {
			floorList= new ArrayList<int[]>();
			int d=2;
			floorL=floorR=1;
			floorData=new int[] {0,1,1};
			floorList.add(floorData);
			//계차수열
			for(int i=0;i<(n-1);i++) {
				floorL+=d;
				d+=4;
				floorR+=d;
				floorData = new int[] {i+1,floorL,floorR};
				floorList.add(floorData);
			}
		}
	}
	
	public void getFloorL() {
		System.out.println(floor+"층 L: "+floorL);
	}
	public void getFloorR() {
		System.out.println(floor+"층 R: "+floorR);
	}
	public void allFloor() {
		StringBuilder sb = new StringBuilder("*총 "+floor+"층* \n");
		for(int i=0;i<floorList.size();i++) { 
			floorData=floorList.get(i);
			sb.append((i+1)+"층 : L-"+floorData[1]+"/R-"+floorData[2]+"\n");
		}
		sb.append("=====complete!====");
		System.out.println(sb);
	}
}