package kwangClass;

import java.util.ArrayList;

public class NumberTower {

	public static void main(String[] args) {
		FloorCalc test1 = new FloorCalc(1);
		test1.getFloorL();
		test1.getFloorR();
		test1.allFloor();
		
		FloorCalc test2 = new FloorCalc(2);
		test2.getFloorL();
		test2.getFloorR();
		test2.allFloor();

		FloorCalc test3 = new FloorCalc(3);
		test3.getFloorL();
		test3.getFloorR();
		test3.allFloor();
		
		FloorCalc test4 = new FloorCalc(4);
		test4.getFloorL();
		test4.getFloorR();
		test4.allFloor();
		
		FloorCalc test20 = new FloorCalc(20);
		test20.getFloorL();
		test20.getFloorR();
		test20.allFloor();
	}
}

class FloorCalc{
	private int floor;
	private int floorL;
	private int floorR;
	private ArrayList<int[]> floorList = new ArrayList<int[]>();
	private int[] floorData = new int[3];//0:floor, 1:floorL, 2:floorR
	
	public FloorCalc(int n) {
		this.floor=n;
		if(n<=0)System.out.println("0 이하의 정수는 입력할 수 없습니다.");
		else {
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