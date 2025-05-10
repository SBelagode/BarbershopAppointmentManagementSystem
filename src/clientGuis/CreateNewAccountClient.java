package clientGuis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clients.Client;
import main.main;
import system.AccountData;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateNewAccountClient extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldNumber;
	private JTextField textFieldEmail;
	private JTextField textFieldCreditCard;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton btnCancel;
	private JButton btnCreate;
	private JLabel lblName;
	private JLabel lblNumber;
	private JLabel lblEmail;
	private JLabel lblCreditCard;
	private JLabel lblUsername;
	private JLabel lblPassword;
	
	
	
	
	public CreateNewAccountClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(189, 16, 130, 26);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setBounds(189, 54, 130, 26);
		contentPane.add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(189, 92, 130, 26);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldCreditCard = new JTextField();
		textFieldCreditCard.setBounds(189, 130, 130, 26);
		contentPane.add(textFieldCreditCard);
		textFieldCreditCard.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(189, 168, 130, 26);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(189, 206, 130, 26);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		 btnCancel = new JButton("Cancel");
		 btnCancel.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
ClientLoginPage clientLoginPage = new ClientLoginPage();
				
				clientLoginPage.show();
			    dispose();
		 	}
		 });
		btnCancel.setBounds(83, 244, 117, 29);
		contentPane.add(btnCancel);
		
		 btnCreate = new JButton("Create");
		 
		 //adding client to system
		 btnCreate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		main.systemAccounts.addClient(new Client(
					textFieldUsername.getText(),
					textFieldPassword.getText(),
		 			textFieldName.getText(),
					textFieldNumber.getText(),
					textFieldEmail.getText(),
		 			textFieldCreditCard.getText()
				));
		 		
		 		ClientLoginPage loginPage = new ClientLoginPage();
		 		loginPage.show();
				dispose();
		 	}
		 });
		btnCreate.setBounds(239, 244, 117, 29);
		contentPane.add(btnCreate);
		
		 lblName = new JLabel("Name:");
		lblName.setBounds(83, 21, 61, 16);
		contentPane.add(lblName);
		
		 lblNumber = new JLabel("Number:");
		lblNumber.setBounds(83, 59, 61, 16);
		contentPane.add(lblNumber);
		
		 lblEmail = new JLabel("Email:");
		lblEmail.setBounds(83, 97, 61, 16);
		contentPane.add(lblEmail);
		
		 lblCreditCard = new JLabel("Credit Card:");
		lblCreditCard.setBounds(83, 135, 94, 16);
		contentPane.add(lblCreditCard);
		
		 lblUsername = new JLabel("Username:");
		lblUsername.setBounds(83, 173, 94, 16);
		contentPane.add(lblUsername);
		
		 lblPassword = new JLabel("Password:");
		lblPassword.setBounds(83, 211, 94, 16);
		contentPane.add(lblPassword);
		
		
		
		
		
		
	}

}
