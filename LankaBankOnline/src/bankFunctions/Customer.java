package bankFunctions;

public class Customer {
	
	private String firstName;
	private String lastName;
	private String NIC;
	private String pin;
	private Account account;
	
	public Customer(String firstName, String lastName, String NIC, String pin){
		this.firstName = firstName;
		this.lastName = lastName;
		this.NIC = NIC;
		this.pin = pin;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	

}
