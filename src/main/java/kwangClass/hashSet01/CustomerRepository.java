package kwangClass.hashSet01;

import java.util.HashSet;
import java.util.Iterator;

public class CustomerRepository {
	private HashSet<Customer> customerSet= new HashSet<Customer>();
	private Customer customer;
	
	public void addCustomer(String company, String bossName, String companyPhone, String companyAddress) {
		customer = new Customer(company, bossName, companyPhone, companyAddress);
		customerSet.add(customer);
		System.out.println(company+"("+bossName+")을 추가합니다.");
	}
	public HashSet<Customer> allCustomer(){
		Iterator<Customer> it = customerSet.iterator();
		if(it.hasNext()) {
			System.out.println(customerSet.size()+"개의 거래처가 있습니다.");
			return customerSet;
		}
		else {
			System.out.println("입력된 거래처가 없습니다.");
			return null;
		}
	}
	public Customer searchCustomer(String company) {
		Iterator<Customer> it = customerSet.iterator();
		while(it.hasNext()) {
			customer = it.next();
			if(customer.getCustomerCompany().contains(company)) {
				return customer;
			}
		}
		System.out.println("일치하는 거래처가 없습니다.");
		return null;
	}
	public String showAllCustomer() {
		Iterator<Customer> it = customerSet.iterator();
		StringBuilder sb = new StringBuilder("#계약처 목록# \n");
		while(it.hasNext()) {
			customer=it.next();
			sb.append(customer.getCustomerCompany()+"//"+customer.getCustomerName()+"//"+customer.getCustomerPhone()+"\n");
		}
		return sb.toString();
	}
	
}
