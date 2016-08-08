package aspects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import bankFunctions.Transactions;

public aspect TransactionLog {
	pointcut TransactionLogging(Transactions transactions) : initialization(Transactions.new(..)) && target(transactions) && !within(TransactionLog);
	  after(Transactions transactions) : TransactionLogging(transactions){
		  
		   WriteFile("New Transaction : Transaction Type : " + transactions.getType() + " Amount : "+ transactions.getAmount()+ " Balance : "+ transactions.getBalance());
		     
	  }
	  
	  public void WriteFile(String Log){
		  try {
			    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/LogFiles/transactions.txt", true)));
			    out.println(Log);
			    out.close();
			} catch (IOException e) {
				System.out.println(e);
			    //exception handling left as an exercise for the reader
			}
	  }

}
