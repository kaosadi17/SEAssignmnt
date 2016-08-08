package bankUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import bankFunctions.Bank;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAccountHistory = new JButton("Account History");
		btnAccountHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AccountHistory();
				
			}
		});
		btnAccountHistory.setBounds(228, 11, 156, 48);
		contentPane.add(btnAccountHistory);
		
		JButton btnProfileUpdate = new JButton("Profile Update");
		btnProfileUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ProfileUpdate();
			}
		});
		btnProfileUpdate.setBounds(228, 87, 156, 48);
		contentPane.add(btnProfileUpdate);
		
		JButton button = new JButton("Contact Bank");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ContactUI();
			}
		});
		button.setBounds(228, 164, 156, 48);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Account Inquiry");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AccountInqUI();
				
			}
		});
		button_1.setBounds(31, 237, 136, 48);
		contentPane.add(button_1);
		
		JButton btnTransferMoney = new JButton("Transfer Money");
		btnTransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new TransferUI();
			}
		});
		btnTransferMoney.setBounds(31, 164, 136, 48);
		contentPane.add(btnTransferMoney);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bank.setCurAcNo(null);
				dispose();
				new LoginUI();
			}
		});
		btnLogOut.setBounds(228, 237, 156, 48);
		contentPane.add(btnLogOut);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Deposit();
			}
		});
		btnDeposit.setBounds(31, 11, 136, 48);
		contentPane.add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Withdraw();
			}
		});
		btnWithdraw.setBounds(31, 87, 136, 48);
		contentPane.add(btnWithdraw);
	}
}
