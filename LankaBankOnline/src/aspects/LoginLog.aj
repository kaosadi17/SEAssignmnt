package aspects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import bankFunctions.Account;
import bankFunctions.Bank;

public aspect LoginLog {
	
	public pointcut login() : execution (* Bank.setCurAcNo(..));
	after()  :login(){
		Bank bank = Bank.getInstance();
    	String acNo = Bank.getCurAcNo();
    	System.out.println(acNo);
    	if(acNo != null){
    		Account account = bank.getAccount(acNo);
        	String nic = account.getCustomer().getNIC();
        	WriteFile("New Login : Account No : " + acNo + " Customer NIC : "+ nic );
    	}
    	
	}
	
	public void WriteFile(String Log){
		  try {
			    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/LogFiles/Login.txt", true)));
			    out.println(Log);
			    out.close();
			} catch (IOException e) {
				System.out.println(e);
			    //exception handling left as an exercise for the reader
			}
	  }



}
