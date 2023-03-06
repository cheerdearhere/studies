package kwangClass.hashSet01;

public class Contract {
	private String contractName;
	private String contractDate;
	private String contractDetails;
	//constructor
	public Contract(String contractName, String contractDate, String contractDetails) {
		super();
		this.contractName = contractName;
		this.contractDate = contractDate;
		this.contractDetails = contractDetails;
	}
	//getter setter
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public String getContractDetails() {
		return contractDetails;
	}
	public void setConstractDetails(String contractDetails) {
		this.contractDetails = contractDetails;
	}
	//custom method
	public boolean equalsContract(String contractTitle) {
		if(contractName.equals(contractTitle))return true;
		else return false;
	}
	public boolean similarContract(String contractTitle) {
		if(contractName.contains(contractTitle))return true;
		else return false;
	}
	public void modifyContract(String contractName, String contractDate, String contractDetails) {
		this.contractName = contractName;
		this.contractDate = contractDate;
		this.contractDetails = contractDetails;
	}
}
