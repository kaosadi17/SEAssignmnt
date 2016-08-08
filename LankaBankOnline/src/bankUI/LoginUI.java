package bankUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import bankFunctions.Bank;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frame2 frame = new Frame2();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountNo.setBounds(48, 69, 91, 30);
		contentPane.add(lblAccountNo);
		
		final JLabel lblPinNo = new JLabel("PIN No");
		lblPinNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinNo.setBounds(48, 109, 91, 30);
		contentPane.add(lblPinNo);
		
		final JLabel alert = new JLabel("Invalid Login!!!");
		alert.setForeground(Color.RED);
		alert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alert.setBounds(160, 11, 91, 30);
		contentPane.add(alert);
		alert.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(193, 75, 133, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 116, 133, 23);
		contentPane.add(textField_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String acNo = textField.getText();
				String pin = textField_1.getText();
				Bank bank = Bank.getInstance();
				if(bank.validation(acNo, pin)){
					Bank.setCurAcNo(acNo);
					dispose();
					new MainMenu();
				}
				else{
					textField.setText(null);
					textField_1.setText(null);
					alert.setVisible(true);
					
					
				}
				
			}
		});
		
		btnLogin.setBounds(193, 159, 89, 23);
		contentPane.add(btnLogin);
	}

}
