package aspects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import bankFunctions.Account;


public aspect AccountLog {
	pointcut AccountLogging(Account account) : initialization(Account.new(..)) && target(account) && !within(AccountLog);
	  after(Account account) : AccountLogging(account){
		  String nic = account.getCustomer().getNIC();
		  WriteFile("New Account : Account No : " + account.getAccountNo()  + " Initial Balance : "+ account.getBalance() + " Customer NIC : "+ nic);
		     
	  }
	  
	  public void WriteFile(String Log){
		  try {
			    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/LogFiles/account.txt", true)));
			    out.println(Log);
			    out.close();
			} catch (IOException e) {
				System.out.println(e);
			    //exception handling left as an exercise for the reader
			}
	  }

}
