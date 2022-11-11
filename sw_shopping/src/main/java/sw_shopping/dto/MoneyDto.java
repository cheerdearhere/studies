package sw_shopping.dto;

public class MoneyDto {
	private int custno;
	private String custname;
	private String grade;
	private int money;
	public MoneyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MoneyDto(int custno, String custname, String grade, int money) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.money = money;
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
