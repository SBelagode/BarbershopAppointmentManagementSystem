package barberGuis;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import barbers.Barber;
import clients.Client;
import main.main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateNewAccountBarber extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldExperienceLevel;
	private JTextField textFieldSpecialization;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JButton btnCancel;
	private JButton btnCreate;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblExperienceLevel;
	private JLabel lblSpecialization;
	private JLabel lblUsername;
	private JLabel lblPassword;
	
	
	
	
	public CreateNewAccountBarber() {
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
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(189, 54, 130, 26);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldExperienceLevel = new JTextField();
		textFieldExperienceLevel.setBounds(189, 92, 130, 26);
		contentPane.add(textFieldExperienceLevel);
		textFieldExperienceLevel.setColumns(10);
		
		textFieldSpecialization = new JTextField();
		textFieldSpecialization.setBounds(189, 130, 130, 26);
		contentPane.add(textFieldSpecialization);
		textFieldSpecialization.setColumns(10);
		
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
		 		BarberLoginPage barberLoginPage = new BarberLoginPage();
				
				barberLoginPage.show();
			    dispose();
		 	}
		 });
		btnCancel.setBounds(83, 244, 117, 29);
		contentPane.add(btnCancel);
		
		 btnCreate = new JButton("Create");
		 btnCreate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		main.systemAccounts.addBarber(new Barber(textFieldUsername.getText(), textFieldPassword.getText(),
		 				textFieldName.getText(), textFieldAddress.getText(), textFieldExperienceLevel.getText(),
		 				textFieldSpecialization.getText()));
		 		
		 		BarberLoginPage barberLoginPage = new BarberLoginPage();
				
				barberLoginPage.show();
			    dispose();
		 	}
		 });
		btnCreate.setBounds(239, 244, 117, 29);
		contentPane.add(btnCreate);
		
		 lblName = new JLabel("Name:");
		lblName.setBounds(83, 21, 61, 16);
		contentPane.add(lblName);
		
		lblAddress = new JLabel("Email:");
		lblAddress.setBounds(83, 59, 61, 16);
		contentPane.add(lblAddress);
		
		lblExperienceLevel = new JLabel("Experience Level:");
		lblExperienceLevel.setBounds(80, 97, 108, 16);
		contentPane.add(lblExperienceLevel);
		
		lblSpecialization = new JLabel("Specialization:");
		lblSpecialization.setBounds(83, 135, 94, 16);
		contentPane.add(lblSpecialization);
		
		 lblUsername = new JLabel("Username:");
		lblUsername.setBounds(83, 173, 94, 16);
		contentPane.add(lblUsername);
		
		 lblPassword = new JLabel("Password:");
		lblPassword.setBounds(83, 211, 94, 16);
		contentPane.add(lblPassword);
		
		
		
	}

}
