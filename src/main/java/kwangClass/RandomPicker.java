package kwangClass;

import java.util.ArrayList;
import java.util.Scanner;

public class RandomPicker {

	public static void main(String[] args) {
		boolean storeLoof=true;
		boolean userLoof=true;
		boolean pickLoof=true;
		String responsYN;
		int income = 0;
		
		int itemNum=1;
		String itemName;
		int itemValue;
		int itemRate;
		String itemInfo;
		ArrayList<PickStore> itemList = new ArrayList<PickStore>();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("판매 물품을 정합니다.");
		while(storeLoof) {
			System.out.println("no: "+itemNum);
			System.out.println("물품명: ");
			itemName=scanner.nextLine();
			System.out.println("물품 원가: ");
			itemValue=scanner.nextInt();
			System.out.println("확률(양수): ");
			itemRate=scanner.nextInt();
			System.out.println("물품 설명: ");
			itemInfo=scanner.nextLine();
			
			PickStore item = new PickStore(itemNum,itemName,itemValue,itemRate,itemInfo);
			itemList.add(itemNum,item);
			System.out.println(item.getItemNum()+"번("+item.getItemName()+") 등록완료\n"
					+ "더 등록하시겠습니까?(y/n)");
			responsYN= scanner.nextLine();
			if(responsYN.equals("Y")||responsYN.equals("y")) {
				itemNum+=1;
				System.out.println("추가 정보를 입력하세요.");
			}else if(responsYN.equals("N")||responsYN.equals("n")) {
				System.out.println("뽑기 물품 등록을 종료합니다. "+itemList.size()+"개 등록");
				int rateSum=0;
				for(PickStore itemdata:itemList) {
					rateSum+=itemdata.getItemRate();
				}
				for(PickStore itemdata:itemList) {
					itemdata.setItemRate((int)(itemdata.getItemRate()/rateSum));
					System.out.println(itemdata.getItemName()+"/rate: "+itemdata.getItemRate());
				}
				storeLoof=false;
			}else {
				System.out.println("잘못입력하셨습니다. "+itemList.size()+"개 등록 중");
			}
		}
		
		int userNum=0;
		String userName;
		int userTicket=0;
		int userAccount=0;
		int cost=0;
		int set1000=0;//+50
		int set100=0;//+15
		int set10=0;//+1
		ArrayList<UserData> userList=new ArrayList<UserData>();
		
		System.out.println("뽑기권 구매");
		while(userLoof) {
			System.out.println((userNum+1)+"번째 손님이 오셨습니다.\n guest name: ");
			userName=scanner.nextLine();
			if(userName.trim().isEmpty()) {
				System.out.println("데이터가 없습니다.");
				userName=scanner.nextLine();
			}
			System.out.println("이곳에서 사용할 금액을 입력하세요.");
			userAccount=scanner.nextInt();
			System.out.println("계좌에 등록된 금액으로 뽑기권을 몇개 구매하시겠습니까? \n(개당 1,000원/ 10개 구입시 1개 추가/ 100개 구입시 1개 추가/ 1000개 구입시 200개 추가");
			userTicket=scanner.nextInt();
			if(userTicket<0||(""+userTicket).contains(".")) {
				System.out.println("0보다 큰 자연수를 입력하셔야 합니다.");
				userTicket=scanner.nextInt();
			}else if(userAccount<(userTicket*1000)) {
				System.out.println("잔액이 부족합니다.");
				continue;
			}
			
			cost=1000*userTicket;
			income+=cost;
			userAccount-=cost;
			
			if(userTicket>1000) {
				set1000 = userTicket/1000;
				userTicket-=set1000*1000;
			}
			if(userTicket>100) {
				set100=userTicket/100;
				userTicket-=set100*100;
			}
			if(userTicket>10) {
				set10=userTicket/10;
				userTicket-=set10*10;
			}
			userTicket +=((set10*15)+(set100*115)+(set1000*1200));
			
			UserData user=new UserData(userNum,userName,userAccount,null);
			user.setUserTicket(userTicket);
			userList.add(user);
			System.out.println(cost+"원을 사용해 뽑기권 "+userTicket+"개를 구매했습니다.\n잔액: "+userAccount);
			System.out.println("더 구매하실 분이 있습니까?(y/n)");
			responsYN=scanner.nextLine();
			if(responsYN.equals("Y")||responsYN.equals("y")) {
				userNum+=1;
			}else if(responsYN.equals("N")||responsYN.equals("n")) {
				System.out.println("뽑기권 구매를 종료합니다. "+userList.size()+"명 구매함");
				userLoof=false;
			}else {
				System.out.println("잘못입력하셨습니다.  "+userList.size()+"명 구매함");
			}
		}
		//random picking 
		ArrayList<PickStore> pickedList = new ArrayList<PickStore>();
		int execiteNum=0;
		while(pickLoof) {
			System.out.println("현재 뽑기권 소유 현황");
			for(UserData user:userList) {
				System.out.println((user.getUserNum()+1)+". 이름: "+user.getUserName()+"/"+user.getUserTicket()+"개 \n");
			}
			System.out.println("뽑기를 진행하실 회원님의 번호를 입력해주세요.");
			execiteNum=scanner.nextInt();
			if(execiteNum<1||(""+execiteNum).contains(".")) {
				System.out.println("1보다 큰 자연수를 입력하셔야 합니다.");
				userTicket=scanner.nextInt();
			}else if(execiteNum>userList.size()) {
				System.out.println("회원수보다 많은 수를 입력하셨습니다. 다시 입력해주세요.");
				userTicket=scanner.nextInt();
			}
			
			
			System.out.println("더 뽑으실 분 있습니까?(y/n)");
			responsYN=scanner.nextLine();
			if(responsYN.equals("Y")||responsYN.equals("y")) {
				System.out.println(userList.size()+"명 진행 중");
			}else if(responsYN.equals("N")||responsYN.equals("n")) {
				System.out.println("뽑기를 종료합니다. "+userList.size()+"명 진행.");
				pickLoof=false;
			}else {
				System.out.println("잘못입력하셨습니다.  "+userList.size()+"명 진행.");
			}
		}
		
		scanner.close();
		System.out.println("영업종료\n오늘매출: "+income);
	}

}
class UserData{
	protected String userName;
	protected int userNum;
	protected int userAccount;
	int userTicket=0;
	protected ArrayList<PickStore> pickedItem = new ArrayList<PickStore>();
	
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData(int userNum, String userName, int userAccount, ArrayList<PickStore> pickedItem) {
		super();
		this.userName = userName;
		this.userNum = userNum;
		this.userAccount = userAccount;
		this.pickedItem = pickedItem;
	}
	public String getUserName() {
		return userName;
	}
	public int getUserNum() {
		return userNum;
	}
	public int getUserTicket() {
		return userTicket;
	}
	public void setUserTicket(int userTicket) {
		this.userTicket=userTicket;
	}
	public int getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}
	public ArrayList<PickStore> getPickedItem() {
		return pickedItem;
	}
	public void setPickedItem(ArrayList<PickStore> pickedItem) {
		this.pickedItem = pickedItem;
	}	
}
class PickStore{
	protected String itemName;
	protected int itemNum;
	protected int itemRate;
	protected int itemValue;
	protected String itemInfo;
	
	public PickStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PickStore(int itemNum, String itemName, int itemRate, int itemValue, String itemInfo) {
		super();
		this.itemName = itemName;
		this.itemNum = itemNum;
		this.itemRate = itemRate;
		this.itemValue = itemValue;
		this.itemInfo = itemInfo;
	}
	public int getItemRate() {
		return itemRate;
	}
	public void setItemRate(int itemRate) {
		this.itemRate = itemRate;
	}
	public int getItemValue() {
		return itemValue;
	}
	public void setItemValue(int itemValue) {
		this.itemValue = itemValue;
	}
	public String getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
	public String getItemName() {
		return itemName;
	}
	public int getItemNum() {
		return itemNum;
	}
	
}
