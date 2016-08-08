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

import bankFunctions.Bank;
import bankFunctions.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterUI frame = new RegisterUI();
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
	public RegisterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegister.setForeground(new Color(0, 0, 0));
		lblRegister.setBounds(135, 11, 73, 26);
		contentPane.add(lblRegister);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(40, 66, 85, 20);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(40, 97, 85, 20);
		contentPane.add(lblLastName);
		
		JLabel lblNic = new JLabel("NIC");
		lblNic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNic.setBounds(40, 128, 85, 20);
		contentPane.add(lblNic);
		
		JLabel lblPinNo = new JLabel("PIN No");
		lblPinNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinNo.setBounds(40, 159, 85, 20);
		contentPane.add(lblPinNo);
		
		textField = new JTextField();
		textField.setBounds(196, 68, 151, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(196, 99, 151, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(196, 130, 151, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(196, 161, 151, 26);
		contentPane.add(textField_3);
		
		final JLabel alert = new JLabel("Fill all the Details!!!");
		alert.setForeground(Color.RED);
		alert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alert.setBounds(40, 220, 189, 30);
		contentPane.add(alert);
		alert.setVisible(false);
		
		final JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fname = textField.getText();
				String lname = textField_1.getText();
				String nic = textField_2.getText();
				String pin = textField_3.getText();
				if(fname.equals("") || lname.equals("") || nic.equals("") || pin.equals("")){
					alert.setVisible(true);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
				}
				else{
					alert.setVisible(false);
					Bank bank = Bank.getInstance();
					String acNo = Main.makeAccount(fname, lname, nic, pin, bank);
					System.out.println("Newly Created Account No : " + acNo);
					dispose();
					new LoginUI();
					
				}
			}
		});
		btnRegister.setBounds(196, 198, 89, 23);
		contentPane.add(btnRegister);
		
		
	}
}
