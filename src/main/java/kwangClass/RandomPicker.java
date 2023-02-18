package kwangClass;

import java.util.ArrayList;
import java.util.Scanner;

public class RandomPicker {
	public static boolean isNumeric(String s) {
		return s.chars().allMatch(Character::isDigit);
	}
	public static void main(String[] args) {
		boolean storeLoof=true;
		boolean userLoof=true;
		boolean pickLoof=true;
		String responsYN;
		int income = 0;
		int rateSum=0;
		
		int itemNum=0;
		String itemName;
		int itemValue;
		int itemRate;
		String itemInfo;
		ArrayList<PickStore> itemList = new ArrayList<PickStore>();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("뽑기 물품을 입력합니다(최대 10개).");
		while(storeLoof) {
			System.out.println("no: "+(itemNum));
			System.out.println("물품명: ");
			responsYN=scanner.next();
			itemName=responsYN;
			System.out.println("물품 원가: ");
			responsYN=scanner.next();
			if(!isNumeric(responsYN)) {
				System.out.println("숫자를 입력해주세요");
				responsYN=scanner.next();
			}
			itemValue=Integer.parseInt(responsYN);
			System.out.println("확률(양수): ");
			responsYN=scanner.next();
			if(!isNumeric(responsYN)) {
				System.out.println("자연수를 입력해주세요");
				responsYN=scanner.next();
			}
			itemRate=Integer.parseInt(responsYN);
			System.out.println("물품 설명: ");
			itemInfo=scanner.next();
			
			PickStore item = new PickStore(itemNum,itemName,itemValue,itemRate,itemInfo);
			itemList.add(item);
			System.out.println(item.getItemNum()+"번("+item.getItemName()+") 등록완료");
			if(itemNum==9) {//0~9: 10개
				System.out.println("뽑기 물품 등록을 종료합니다. "+itemList.size()+"개 등록");
				for(PickStore itemdata:itemList) {
					rateSum+=itemdata.getItemRate();
				}
				for(PickStore itemdata:itemList) {
					System.out.println(itemdata.getItemName()+"/rate: "+itemdata.getItemRate()+"/"+rateSum);
				}
				storeLoof=false;
			}
			System.out.println("더 등록하시겠습니까?(y/n)");
			responsYN= scanner.next();
			if(responsYN.equals("Y")||responsYN.equals("y")) {
				itemNum+=1;
				System.out.println("추가 정보를 입력하세요.");
			}else if(responsYN.equals("N")||responsYN.equals("n")) {
				System.out.println("뽑기 물품 등록을 종료합니다. "+itemList.size()+"개 등록");
				for(PickStore itemdata:itemList) {
					rateSum+=itemdata.getItemRate();
				}
				for(PickStore itemdata:itemList) {
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
			userName=scanner.next();
			if(userName.trim().isEmpty()) {
				System.out.println("데이터가 없습니다.");
				userName=scanner.next();
			}
			System.out.println("이곳에서 사용할 금액을 입력하세요.");
			responsYN=scanner.next();
			if(!isNumeric(responsYN)) {
				System.out.println("숫자를 입력해주세요");
				responsYN=scanner.next();
			}
			userAccount=Integer.parseInt(responsYN);
			System.out.println("계좌에 등록된 금액으로 뽑기권을 몇개 구매하시겠습니까? \n(개당 1,000원/ 10개 구입시 1개 추가/ 100개 구입시 1개 추가/ 1000개 구입시 200개 추가");
			responsYN=scanner.next();
			if(!isNumeric(responsYN)) {
				System.out.println("숫자를 입력해주세요");
				responsYN=scanner.next();
			}
			userTicket=Integer.parseInt(responsYN);
			if(userAccount<(userTicket*1000)) {
				System.out.println("잔액이 부족합니다. 다시 진행해주세요");
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
			responsYN=scanner.next();
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
		double randomBox;
		int runTimes;
		int range1=itemList.get(0).getItemRate();
		int range2=0, range3=0, range4=0, range5=0, range6=0, range7=0, range8=0, range9=0, range10=0;
		if(itemList.size()>=2) {
			range2=range1+itemList.get(1).getItemRate();
		}
		if(itemList.size()>=3) {
			range3=range2+itemList.get(2).getItemRate();
		}
		if(itemList.size()>=4) {
			range4=range3+itemList.get(3).getItemRate();
		}
		if(itemList.size()>=5) {
			range5=range4+itemList.get(4).getItemRate();
		}
		if(itemList.size()>=6) {
			range6=range5+itemList.get(5).getItemRate();
		}
		if(itemList.size()>=7) {
			range7=range6+itemList.get(6).getItemRate();
		}
		if(itemList.size()>=8) {
			range8=range7+itemList.get(7).getItemRate();
		}
		if(itemList.size()>=9) {
			range9=range8+itemList.get(8).getItemRate();
		}
		if(itemList.size()>=10) {
			range10=range9+itemList.get(9).getItemRate();
		}
		String resultSet="당첨결과: ";
		System.out.println(rateSum+"//"+range1+"/"+range2+"/"+range3+"/"+range4+"/"+range5+"/"+range6+"/"+range7+"/"+range8+"/"+range9+"/"+range10);
		while(pickLoof) {
			System.out.println("현재 뽑기권 소유 현황");
			for(UserData user:userList) {
				System.out.println((user.getUserNum()+1)+". 이름: "+user.getUserName()+"/"+user.getUserTicket()+"개");
			}
			System.out.println("뽑기를 진행하실 회원님의 번호를 입력해주세요.");
			responsYN=scanner.next();
			if(!isNumeric(responsYN)) {
				System.out.println("숫자를 입력해주세요");
				responsYN=scanner.next();
			}
			userNum=Integer.parseInt(responsYN);
			if(userNum>userList.size()) {
				System.out.println("회원수보다 많은 수를 입력하셨습니다. 다시 입력해주세요.");
				continue;
			}
			
			UserData user=userList.get(userNum-1);
			userTicket=user.userTicket;
			System.out.println("몇번 수행하시겠습니까?(뽑기권:"+userTicket+"개)");
			responsYN=scanner.next();
			if(!isNumeric(responsYN)) {
				System.out.println("숫자를 입력해주세요");
				responsYN=scanner.next();
			}
			runTimes=Integer.parseInt(responsYN);
			if(runTimes>userTicket) {
				System.out.println("가지고 있는 뽑기권보다 많은 수를 입력하셨습니다. 처음으로 이동합니다.");
				continue;
			}
			System.out.println(userNum+"번 회원님의 뽑기를 "+runTimes+"번 수행합니다.");
			int j=0;
			for(int i=0;i<runTimes;i++) {
				j=i+1;
				randomBox=(int)(Math.random()*(rateSum-1+1)+1);
				resultSet+="@"+j+"결과("+randomBox+")=>";
				if(1<=randomBox&&randomBox<=range1) {
					PickStore pickedItem=itemList.get(0);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}else if(randomBox<=range2&&range2!=0) {
					PickStore pickedItem=itemList.get(1);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}else if(randomBox<=range3&&range3!=0){
					PickStore pickedItem=itemList.get(2);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}else if(randomBox<=range4&&range4!=0){
					PickStore pickedItem=itemList.get(3);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}else if(randomBox<=range5&&range5!=0){
					PickStore pickedItem=itemList.get(4);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}else if(randomBox<=range6&&range6!=0){
					PickStore pickedItem=itemList.get(5);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}else if(randomBox<=range7&&range7!=0){
					PickStore pickedItem=itemList.get(6);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}else if(randomBox<=range8&&range8!=0){
					PickStore pickedItem=itemList.get(7);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}else if(randomBox<=range9&&range9!=0){
					PickStore pickedItem=itemList.get(8);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}else if(randomBox<=range10&&range10!=0){
					PickStore pickedItem=itemList.get(9);
					pickedList.add(pickedItem);
					resultSet+=pickedItem.getItemName()+"//";
				}
				if((j%5)==0) {
					resultSet+="\n";
				}
			}
			System.out.println(resultSet);
			user.setPickedItem(pickedList);
			userTicket-=runTimes;
			user.setUserTicket(userTicket);
			System.out.println("남은 뽑기권: "+userTicket);
			System.out.println("더 뽑으실 분 있습니까?(y/n)");
			responsYN=scanner.next();
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
		System.out.println("#######영업종료#######\n오늘매출: "+income+"원");
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
	public PickStore(int itemNum, String itemName, int itemValue, int itemRate, String itemInfo) {
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
