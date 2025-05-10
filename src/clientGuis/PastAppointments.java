package clientGuis;

import java.awt.EventQueue;
import main.main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clients.Client;
import appointments.AppointmentConfirmed;
import barbers.Barber;
import review.Review;
import clientGuis.WriteReview;

public class PastAppointments extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnBack;
	private JButton btnReview;
	private Client currentClient;
	private DefaultTableModel model;
	private JButton btnReviewWholeBarberShop;
	private JButton btnAddFavorite;
	public PastAppointments(Client client) {
		this.currentClient = client;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 42, 360, 195);
		contentPane.add(scrollPane);
		
		 model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"Day", "Month", "Year", "Time", "Barber", "Cost"});
		table = new JTable(model);
		
		// Populate table with past appointments
		
		
		scrollPane.setViewportView(table);
		
		showAppointments();
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientHome homePage = new ClientHome(client);
				homePage.show();
				dispose();
			}
		});
		btnBack.setBounds(0, 237, 117, 29);
		contentPane.add(btnBack);
		
		btnReview = new JButton("Review Specific Barber");
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					AppointmentConfirmed appointment = currentClient.getMyPastAppointments().get(selectedRow);
					WriteReview reviewPage = new WriteReview(appointment, currentClient, true);
					reviewPage.setVisible(true);
				}
				dispose();
			}
		});
		btnReview.setBounds(107, 237, 183, 29);
		contentPane.add(btnReview);
		
		btnReviewWholeBarberShop = new JButton("Review BarberShop");
		btnReviewWholeBarberShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteReview reviewPage = new WriteReview(null, currentClient, false);
				reviewPage.setVisible(true);
				dispose();
			}
		});
		btnReviewWholeBarberShop.setBounds(297, 237, 147, 29);
		contentPane.add(btnReviewWholeBarberShop);
		
		btnAddFavorite = new JButton("Favorite the Barber");
		btnAddFavorite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//select barber
				int selectedRow = table.getSelectedRow();
				String barberName = currentClient.getMyPastAppointments().get(selectedRow).getBarberName();
				Barber specificBarber = main.systemAccounts.getSpecificBarber(barberName);
				if(currentClient.getMyFavoriteBarbers().contains(specificBarber)) {
					//do not add
				}
				else {
					//add to favorite barbers
					currentClient.getMyFavoriteBarbers().add(specificBarber);
				}
			}
		});
		btnAddFavorite.setBounds(282, 6, 147, 29);
		contentPane.add(btnAddFavorite);
	}
	
	void showAppointments() {
		for(AppointmentConfirmed a: currentClient.getMyPastAppointments()) {
			model.addRow(new Object[] {a.getDay(), a.getMonth(), a.getYear(),a.getTime(),a.getBarberName(),   a.getCost()});
		}
	}

}
