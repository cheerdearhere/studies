package kwangClass.hashSet01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CustomerRepository cr = new CustomerRepository();
		//default data
		cr.addCustomer("naver", "김철수", "000-0000-0000", "서울 목동");
		cr.addCustomer("daum", "이철수", "00-1111-1111", "대전");
		Customer customerNaver = cr.searchCustomer("nav");
		customerNaver.addContract("계약1", "2022-01-01", "아브라카타브라");
		customerNaver.addContract("계약2", "2022-02-02", "아브라카");
		customerNaver.addContract("계약3", "2022-03-03", "아브");

		Scanner inputScanner = new Scanner(System.in);
		String res="";
		int select=0;
		boolean flag = true;
		loof1:
		while(flag) {
			System.out.println("#원하는 메뉴를 선택해주세요.#");
			System.out.println("""
						1. 거래처 관리
						2. 계약 관리
						3. 나가기
					""");
			res=inputScanner.next();
			try {
				select=Integer.parseInt(res);
			}catch(NumberFormatException e) {
				System.out.println("번호 내에서 숫자만 입력해주세요.");
				continue loof1;
			}
			if(select<=0||select>3) {
				System.out.println("1부터 3까지만 입력해주세요.");
				continue loof1;
			}
			else if(select==1) {
				boolean customerFlag=true;
				customerLoof:
				while(customerFlag) {
					System.out.println("##거래처 관리를 선택하셨습니다.##");
					System.out.println("""
							1. 거래처 등록
							2. 거래처 목록 보기
							3. 거래처 찾기
							4. 뒤로 가기
							""");
					res=inputScanner.next();
					try {
						select=Integer.parseInt(res);
					}catch(NumberFormatException e) {
						System.out.println("번호 내에서 숫자만 입력해주세요.");
						continue loof1;
					}
					if(select==1) {
						String[] temp = new String[4];
						System.out.println("###거래처 등록을 선택하셨습니다.###");
						System.out.println("거래처 이름: ");
						res=inputScanner.next();
						if(res.trim()=="") {
							System.out.println("입력값이 없습니다. ");
							continue customerLoof;
						}
						temp[0]=res;
						System.out.println("대표자 이름: ");
						res=inputScanner.next();
						if(res.trim()=="") {
							System.out.println("입력값이 없습니다. ");
							continue customerLoof;
						}
						temp[1]=res;
						System.out.println("대표번호: ");
						res=inputScanner.next();
						if(res.trim()=="") {
							System.out.println("입력값이 없습니다. ");
							continue customerLoof;
						}
						temp[2]=res;
						System.out.println("거래처 주소: ");
						res=inputScanner.next();
						if(res.trim()=="") {
							System.out.println("입력값이 없습니다. ");
							continue customerLoof;
						}
						temp[3]=res;
						cr.addCustomer(temp[0], temp[1], temp[2], temp[3]);
						System.out.println("거래처 정보가 저장되었습니다.");
						continue customerLoof;
					}
					else if(select==2) {
						System.out.println("###거래처 목록을 선택하셨습니다.");
						System.out.println(cr.showAllCustomer());
						continue customerLoof;
					}
					else if(select==3) {
						System.out.println("###거래처 찾기를 선택하셨습니다.");
						customerSearchLoof:
						while(true) {
							System.out.println("거래처 이름을 입력하세요.");
							res=inputScanner.next();
							if(res.trim()=="") {
								System.out.println("입력값이 없습니다. ");
								continue customerSearchLoof;
							}
							Customer customer=cr.searchCustomer(res);
							if(customer==null) break customerLoof;
							System.out.println(customer.showAllContract());
							break customerLoof;
						}
					}
					else if(select==4) {
						System.out.println("뒤로 이동");
						continue loof1;
					}
					else {
						System.out.println("잘못입력하셨습니다.");
						continue customerLoof;
					}
				}
			}
			else if(select==2) {
				System.out.println("##계약 관리를 선택하셨습니다.##");
				contractLoof:
					while(true) {
						System.out.println("거래처 이름을 입력하세요.");
						res=inputScanner.next();
						if(res.trim()=="") {
							System.out.println("입력값이 없습니다. ");
							continue contractLoof;
						}
						Customer customer=cr.searchCustomer(res);
						if(customer==null) break contractLoof;
						System.out.println(customer.showAllContract());
						System.out.println("""
								사용할 기능의 번호를 입력해주세요.
									1. 계약 입력
									2. 계약 검색
									3. 계약 내용 수정
									4. 계약 삭제
									5. 모든 계약 내용 보기
									6. 처음으로
								""");
						res=inputScanner.next();
						try {
							select=Integer.parseInt(res);
						}catch(NumberFormatException e) {
							System.out.println("번호 내에서 숫자만 입력해주세요.");
							continue contractLoof;
						}
						if(select==1) {
							System.out.println("###계약 입력을 선택하셨습니다###");
							contractAddLoof:
							while(true) {
								String[] temp = new String[3];
								System.out.println("계약 이름을 입력하세요");
								res=inputScanner.next();
								if(res.trim()=="") {
									System.out.println("공백을 입력할 수 없습니다.");
									continue contractAddLoof;
								}
								temp[0]=res;
								System.out.println("계약 날짜를 입력하세요");
								res=inputScanner.next();
								if(res.trim()=="") {
									System.out.println("공백을 입력할 수 없습니다.");
									continue contractAddLoof;
								}
								temp[1]=res;
								System.out.println("계약 내용을 입력하세요");
								res=inputScanner.next();
								if(res.trim()=="") {
									System.out.println("공백을 입력할 수 없습니다.");
									continue contractAddLoof;
								}
								temp[2]=res;
								customer.addContract(temp[0], temp[1], temp[2]);
								System.out.println(temp[0]+" 저장 완료");
								continue contractLoof;
							}
						}
						else if(select==2) {
							System.out.println("###계약 검색을 선택하셨습니다### \n 검색할 계약이름을 입력하세요.");
							res=inputScanner.next();
							if(res.trim()=="") {
								System.out.println("공백을 입력할 수 없습니다.");
								continue contractLoof;
							}
							Contract contract=customer.searchContract(res);
							System.out.println(contract.getContractName()+"/"+contract.getContractDate()+"/"+contract.getContractDetails());
							continue contractLoof;
						}
						else if(select==3) {
							System.out.println("###계약 내용 수정을 선택하셨습니다### \n 수정할 계약의 이름을 입력하세요.");
							res=inputScanner.next();
							if(res.trim()=="") {
								System.out.println("공백을 입력할 수 없습니다.");
								continue contractLoof;
							}
							Contract contract=customer.searchContract(res);
							contractModifyLoof:
								while(true) {
									String[] temp = new String[3];
									System.out.println("현재 계약내용: "+contract.getContractName()+"/"+contract.getContractDate()+"/"+contract.getContractDetails());
									System.out.println("변경할 내용을 입력합니다. \n	계약명:");
									res=inputScanner.next();
									if(res.trim()=="") {
										System.out.println("공백을 입력할 수 없습니다.");
										continue contractModifyLoof;
									}
									temp[0]=res;
									System.out.println("	계약일:");
									res=inputScanner.next();
									if(res.trim()=="") {
										System.out.println("공백을 입력할 수 없습니다.");
										continue contractModifyLoof;
									}
									temp[1]=res;
									System.out.println("	계약내용:");
									res=inputScanner.next();
									if(res.trim()=="") {
										System.out.println("공백을 입력할 수 없습니다.");
										continue contractModifyLoof;
									}
									temp[2]=res;
									contract.modifyContract(temp[0], temp[1], temp[2]);	
									continue contractLoof;
								}
						}
						else if(select==4) {
							System.out.println("###계약 삭제를 선택하셨습니다###");
							contractDeleteLoof:
							while(true) {
								System.out.println("	삭제할 계약 이름을 적어주세요: ");
								res=inputScanner.next();
								if(res.trim()=="") {
									System.out.println("공백을 입력할 수 없습니다.");
									continue contractDeleteLoof;
								}
								customer.deleteContract(res);
								continue contractLoof;
							}
						}
						else if(select==5) {
							System.out.println("###모든 계약 내용 보기를 선택하셨습니다###");
							customer.allContractSet();
							System.out.println(customer.showAllContract());
							continue contractLoof;
						}
						else if(select==6) {
							System.out.println("처음으로 돌아갑니다");
							continue loof1;
						}
						else {
							System.out.println("잘못입력하셨습니다.");
							continue contractLoof;
						}
					}
			}
			else {
				System.out.println("3초 후 시스템을 종료합니다.");
				inputScanner.close();
				System.exit(3000);
			}
		}
	}
}
