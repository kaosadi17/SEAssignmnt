package bankUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import bankFunctions.Account;
import bankFunctions.Bank;
import bankFunctions.Transactions;

public class AccountHistory extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccountHistory frame = new AccountHistory();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AccountHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		 JButton btnMainMenu = new JButton("Main Menu");
			btnMainMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					new MainMenu();
				}
			});
			btnMainMenu.setBounds(307, 227, 117, 23);
		Bank bank = Bank.getInstance();
		Account currentAc = bank.getAccount(Bank.getCurAcNo());
		ArrayList<Transactions> transactions = currentAc.getTransactions();
		if(transactions.size() > 0){
		String[][] data = new String[transactions.size()][4];
		System.out.println(transactions.size());
		for(int i = 0; i< transactions.size(); i++){
			data[i][0] = transactions.get(i).formatDate();
			data[i][1] = transactions.get(i).getType();
			data[i][2] = transactions.get(i).getAmount();
			data[i][3] = transactions.get(i).getBalance();
		}
		String[] columns = new String[] { "Date", "Type", "Amount", "Blanace"};
		JTable table = new JTable(data, columns);
		this.add(btnMainMenu);
		this.add(new JScrollPane(table));
		this.setTitle("Account History");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
        
       
		
        
		
		}
		else{
			JLabel lb2 = new JLabel("No Transactions!!");
			lb2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lb2.setForeground(Color.RED);
			lb2.setBounds(128, 11, 163, 20);
			contentPane.add(lb2);
		}
		
		JButton btnMainMenu1 = new JButton("Main Menu");
		btnMainMenu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new MainMenu();
			}
		});
		btnMainMenu1.setBounds(307, 227, 117, 23);
		contentPane.add(btnMainMenu1);
	}

}
