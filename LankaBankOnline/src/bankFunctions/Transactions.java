package bankFunctions;

import java.util.Calendar;
import java.util.Date;

public class Transactions {
	
	private String type;
	private double amount;
	private double balance;
	private String timestamp;
	
	public Transactions(String type,double amount, double balance){
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.timestamp = formatDate();
		
	}
	public String formatDate(){
		Calendar now = Calendar.getInstance();
		String date = now.get(Calendar.YEAR) + "." +  (now.get(Calendar.MONTH) + 1) + "." +now.get(Calendar.DATE);
		return date;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAmount() {
		return String.valueOf(amount);
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getBalance() {
		return String.valueOf(balance);
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

//	public String getTimestamp() {
//		String s = String.valueOf(timestamp.getTime());
//		return s;
//	}
//
//	public void setTimestamp(Date timestamp) {
//		this.timestamp = timestamp;
//	}




	

	
	
}
