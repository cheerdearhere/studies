package kwangClass;

import java.util.ArrayList;
import java.util.Scanner;

public class Question07 {	
	public static void main(String[] args) {
		ArrayList<String> menuList = new ArrayList<String>();
		ArrayList<String> priceList = new ArrayList<String>();
		ArrayList<String> orderList = new ArrayList<String>();
		boolean storeClose = true;
		String customerMessage="";
		String orderBoard="";
		int cost=0;
		int num=0;
		int n=1;
		
		menuList.add("타코야키");
		priceList.add("2000");
		menuList.add("해물찜");
		priceList.add("7000");
		menuList.add("튀김요리");
		priceList.add("5000");
		menuList.add("자동차기름");
		priceList.add("12000");
		menuList.add("종료.");
		priceList.add("-10");
		
		customerMessage="#######메뉴를 선택해주세요####### \n";
		for(int i=0;i<menuList.size();i++) {
			num=i+1;
			customerMessage+=num+"."+menuList.get(i);
			if(menuList.get(i).equals("종료.")) break;
			customerMessage+=" : "+priceList.get(i)+"원 \n";
		}
				
		Scanner scanner = new Scanner(System.in);
		while(storeClose) {
			System.out.println(customerMessage);
			num=scanner.nextInt();
			if(num>5||num<=0) {
				System.out.println("메뉴의 번호를 확인하시고 입력해주세요. \n\n");
				try {
					Thread.sleep(1500);
				}catch(Exception e) {
					e.printStackTrace();
				}
				continue;
			};
			orderList.add(num+"");
			cost+=Integer.parseInt(priceList.get(num-1));
			orderBoard=n+"번째 customer: "+num+"\n";
			switch(num) {
				case 1:
					orderBoard+=n+"번째 손님은 나쵸칩을 주문하셔서 현재 누적금액 "+cost+"원 입니다.\n\n";
					n+=1;
					break;
				case 2:
					orderBoard+=n+"번째 손님은 치킨버거 세트를 주문하셔서 현재 누적금액 "+cost+"원 입니다.\n\n";
					n+=1;
					break;
				case 3:
					orderBoard+=n+"번째 손님은 3종 튀김을 주문하셔서 현재 누적금액 "+cost+"원 입니다.\n\n";
					n+=1;
					break;
				case 4:
					orderBoard+=n+"번째 손님은 휘발유 주문하셔서 현재 누적금액 "+cost+"원 입니다.\n\n";
					n+=1;
					break;
				case 5:
					orderBoard+=n+"번째 손님이 종료를 누르셔서 프로그램을 종료합니다. "
							+ "\n오늘의 매출은 "+cost+"원 입니다.";
					storeClose=false;
					scanner.close();
					break;
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
			}
			System.out.println(orderBoard);
		}

	}
}
