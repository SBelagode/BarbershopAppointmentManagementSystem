package clientGuis;

import java.awt.EventQueue;
import main.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import barberGuis.BarberLoginPage;
import clients.Client;
import mainGUI.mainGUI;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextArea header; 
	private JLabel lblUsername; 
	private JLabel lblPassword; 
	private JButton btnBack; 
	private JButton btnCreateNewAccount; 
	private JButton btnLogin; 

	public ClientLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea header = new JTextArea();
		header.setWrapStyleWord(true);
		header.setLineWrap(true);
		header.setText("Type in your username and password. After this, if you want to create a new account, click create account. If you have an existing account, click login. After creating an account, try logging in. ");
		header.setBounds(17, 6, 403, 87);
		contentPane.add(header);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(75, 105, 79, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(75, 146, 79, 16);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(166, 100, 130, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(166, 141, 130, 26);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainGUI m = new mainGUI();
				m.show();
				dispose();
			}
		});
		btnBack.setBounds(17, 220, 117, 29);
		contentPane.add(btnBack);
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewAccountClient createAccountPage = new CreateNewAccountClient();
				
				createAccountPage.show();
			    dispose();
			}
		});
		btnCreateNewAccount.setBounds(149, 220, 166, 29);
		contentPane.add(btnCreateNewAccount);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Client currClient = main.systemAccounts.getClientAccount(username.getText(), password.getText());
				
				//only if login found, we go to client home. Else stay in current login page
				if(currClient!=null) {
					ClientHome homePage = new ClientHome(currClient);
					homePage.show();
					dispose();
				}
				
				
			}
		});
		btnLogin.setBounds(327, 220, 117, 29);
		contentPane.add(btnLogin);
	}
}
