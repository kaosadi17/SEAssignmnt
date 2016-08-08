package bankUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import bankFunctions.Account;
import bankFunctions.Bank;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Deposit frame = new Deposit();
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
	public Deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeposit.setBounds(170, 11, 83, 35);
		contentPane.add(lblDeposit);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmount.setBounds(49, 89, 61, 26);
		contentPane.add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(191, 94, 125, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(28, 219, 174, 26);
		contentPane.add(label);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double amount = Double.parseDouble(textField.getText());
				Bank bank = Bank.getInstance();
				Account currentAc = bank.getAccount(Bank.getCurAcNo());
				currentAc.deposit(amount);
				textField.setText("");
				label.setText("Amount Deposited");
				label.setForeground(Color.BLUE);
				
			}
		});
		btnDeposit.setBounds(191, 137, 89, 23);
		contentPane.add(btnDeposit);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new MainMenu();
				
			}
		});
		btnMainMenu.setBounds(285, 227, 110, 23);
		contentPane.add(btnMainMenu);
		
		
	}
}
