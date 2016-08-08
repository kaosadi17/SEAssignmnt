package bankFunctions;

import java.util.ArrayList;
import java.util.Random;

public class Account {
	
	private Customer customer;
	private String accountNo;
	private double balance;
	ArrayList<Transactions> transactions;
	
	

	public Account(Customer customer){
		this.customer = customer;
		this.balance = 5000;
		this.accountNo = getMadeAccountNo();
		this.transactions = new ArrayList<Transactions>();
	}
	public ArrayList<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transactions> transactions) {
		this.transactions = transactions;
	}
	
	
	
	public int getLength(){
		return transactions.size();
	}
	
	public Transactions getTName(int i){
		return this.transactions.get(i);
	}
	
//	public Transactions getTransactions(){
//		for(Transactions t : this.transactions){
//			return t;
//		}
//		return null;
//	}

	
	private String getMadeAccountNo() {
		String acNo = "";
		Random rng = new Random();
		int len = 5;
		for (int c = 0; c < len; c++) {
			acNo += ((Integer)rng.nextInt(10)).toString();
		}
		return acNo;
	}
	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void transfer(Account account, double amount){
		
		double curAmount = account.getBalance();
		if(curAmount < amount){
			System.out.println("Insufficient");
		}
		else{
			this.balance = this.balance - amount;
			double newbalance = account.getBalance() + amount;
			account.setBalance(newbalance);
			Transactions tr = new Transactions("Transfer", amount,this.balance);
			transactions.add(tr);
		}
		
	}
	
	public void deposit(double amount){
		this.balance = this.balance + amount;
		Transactions tr = new Transactions("Deposit", amount,this.balance);
		transactions.add(tr);
	}
	
	public void withdraw(double amount){
		if(this.balance < amount){
			System.out.println("Insufficient");
		}
		else{
		this.balance = this.balance - amount;
		Transactions tr = new Transactions("Withdraw", amount,this.balance);
		transactions.add(tr);
		}
	}
	
	
	
	
	
	
	
	

}
