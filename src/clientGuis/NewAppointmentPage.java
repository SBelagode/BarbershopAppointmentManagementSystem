package clientGuis;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import system.BarberShop;
import barbers.Barber;
import clients.Client;

import javax.swing.DefaultListModel;
import main.main;

public class NewAppointmentPage extends JFrame {

	private JPanel contentPane;
	private JLabel lblInstructionLabel;
	private JScrollPane scrollPane;
	private JList listOfBarbers;
	private JButton btnSelect;
	private JButton btnCancel;
	
	
	public NewAppointmentPage(Client c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblInstructionLabel = new JLabel("Click on a Barber and Click Select");
		lblInstructionLabel.setBounds(98, 24, 227, 16);
		contentPane.add(lblInstructionLabel);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 75, 227, 170);
		contentPane.add(scrollPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (Barber barber : main.systemAccounts.getBarbers()) {
			listModel.addElement(barber.getName());
		}
		
		listOfBarbers = new JList(listModel);
		scrollPane.setViewportView(listOfBarbers);
		
		 btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String barberName = listModel.get(listOfBarbers.getSelectedIndex());
				Barber selectedBarber =  main.systemAccounts.getSpecificBarber(barberName);
				if (selectedBarber != null) {
					
					SelectAvailabilityPage availability = new SelectAvailabilityPage(selectedBarber, c, null, false);
					availability.setVisible(true);
					dispose();
				}
			}
		});
		btnSelect.setBounds(327, 216, 117, 29);
		contentPane.add(btnSelect);
		
		 btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClientHome homePage = new ClientHome(c);
				homePage.show();
				dispose();
			}
		});
		btnCancel.setBounds(327, 185, 117, 29);
		contentPane.add(btnCancel);
	}
}
