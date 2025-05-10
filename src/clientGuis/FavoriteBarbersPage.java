package clientGuis;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;

import clients.Client;
import barbers.Barber;
import main.main;

public class FavoriteBarbersPage extends JFrame {
	private JPanel contentPane;
	private JLabel lblInstructionLabel;
	private JScrollPane scrollPane;
	private JList listOfBarbers;
	private JButton btnSelect;
	private JButton btnCancel;
	private Client currentClient;
	
	
	public FavoriteBarbersPage(Client client) {
		this.currentClient = client;
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
		for (Barber barber : currentClient.getMyFavoriteBarbers()) {
			listModel.addElement(barber.getName());
		}
		
		listOfBarbers = new JList(listModel);
		scrollPane.setViewportView(listOfBarbers);
		
		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = listOfBarbers.getSelectedIndex();
				Barber selectedBarber = currentClient.getMyFavoriteBarbers().get(selectedIndex);
				
				if (selectedBarber != null) {
					dispose();
					SelectAvailabilityPage availability = new SelectAvailabilityPage(selectedBarber, client, null, false);
					availability.setVisible(true);
				}
			}
		});
		btnSelect.setBounds(327, 216, 117, 29);
		contentPane.add(btnSelect);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientHome homePage = new ClientHome(client);
				homePage.show();
				dispose();
			}
		});
		btnCancel.setBounds(327, 185, 117, 29);
		contentPane.add(btnCancel);
	}
}
