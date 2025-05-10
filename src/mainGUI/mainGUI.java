package mainGUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import barberGuis.BarberLoginPage;
import clientGuis.ClientLoginPage;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnClient; 
	private JButton btnBarber; 
	private JButton btnExit; 

	public mainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClient = new JButton("Client Login");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientLoginPage clientLoginPage = new ClientLoginPage();
				
				clientLoginPage.show();
			    dispose();
			}
		});
		btnClient.setBounds(155, 53, 117, 45);
		contentPane.add(btnClient);
		
		JButton btnBarber = new JButton("Barber Login");
		btnBarber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarberLoginPage barberLoginPage = new BarberLoginPage();
				
				barberLoginPage.show();
			    dispose();
			}
		});
		btnBarber.setBounds(155, 131, 117, 39);
		contentPane.add(btnBarber);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(155, 204, 117, 29);
		contentPane.add(btnExit);
	}
}
