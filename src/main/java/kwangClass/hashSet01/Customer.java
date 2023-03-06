package kwangClass.hashSet01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Customer {
	//instance
	private String customerCompany;
	private String customerName;
	private String customerPhone;
	private String customerAddress;
	private Set<Contract> contractSet;
	//constructor
	public Customer(String customerCompany, String customerName, String customerPhone, String customerAddress) {
		super();
		this.customerCompany = customerCompany;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		contractSet= new HashSet<Contract>();
	}
	//method
	public void addContract(String contractTitle,String contractDate,String contractDetails) {
		Contract contract = new Contract(contractTitle, contractDate, contractDetails);
		contractSet.add(contract);
	}
	public Contract searchContract(String contractTitle) {
		Iterator<Contract> it=contractSet.iterator();
		while(it.hasNext()) {
			Contract contract = it.next();
			if(contract.similarContract(contractTitle)) {
				return contract;
			};
		}
		System.out.println("계약을 찾을 수 없습니다.");
		return null;
	}
	public void deleteContract(String contractTitle) {
		Iterator<Contract> it=contractSet.iterator();
		while(it.hasNext()) {
			Contract contract = it.next();
			if(contract.similarContract(contractTitle)) {
				contractSet.remove(contract);
				System.out.println("계약 "+contract.getContractName()+"(이)가 삭제되었습니다.");
			};
		}
		System.out.println("계약을 찾을 수 없습니다.");
	}
	public HashSet<Contract> allContractSet(){
		Iterator<Contract> it=contractSet.iterator();
		if(!it.hasNext()) {
			System.out.println("입력된 계약이 없습니다.");
			return null;
		}
		System.out.println(contractSet.size()+"개의 계약이 있습니다.");
		return (HashSet<Contract>)contractSet;
	}
	//getter/setter
	public String getCustomerCompany() {
		return customerCompany;
	}
	public void setCustomerCompany(String customerCompany) {
		this.customerCompany = customerCompany;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}	
	public String showAllContract() {
		Iterator<Contract> it = contractSet.iterator();
		StringBuilder sb = new StringBuilder("##"+customerCompany+" 계약 목록# \n");
		while(it.hasNext()) {
			Contract contract=it.next();
			sb.append(contract.getContractName()+"//"+contract.getContractDate()+"//"+contract.getContractDetails()+"\n");
		}
		return sb.toString();
	}

}
