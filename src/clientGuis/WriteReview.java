package clientGuis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import clients.Client;
import appointments.AppointmentConfirmed;
import barbers.Barber;
import main.main;

public class WriteReview extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldRating;
	private JTextArea textAreaReview;
	private AppointmentConfirmed appointment;
	private Client client;
	
	public WriteReview(AppointmentConfirmed appointment, Client currClient, boolean ratingBarber) {
		this.appointment = appointment;
		this.client = currClient;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRating = new JLabel("Rating (1-5): ");
		lblRating.setBounds(66, 52, 61, 16);
		contentPane.add(lblRating);
		
		JLabel lblReview = new JLabel("Review:");
		lblReview.setBounds(66, 93, 61, 16);
		contentPane.add(lblReview);
		
		textAreaReview = new JTextArea();
		textAreaReview.setBounds(162, 93, 266, 116);
		contentPane.add(textAreaReview);
		
		txtFieldRating = new JTextField();
		txtFieldRating.setBounds(162, 47, 130, 26);
		contentPane.add(txtFieldRating);
		txtFieldRating.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientHome homePage = new ClientHome(client);
				homePage.show();
				dispose();
			}
		});
		btnCancel.setBounds(50, 226, 117, 29);
		contentPane.add(btnCancel);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int rating = Integer.parseInt(txtFieldRating.getText());
					if (rating >= 1 && rating <= 5) {
						String review = textAreaReview.getText();
						
						// Add review to barber
						
						
						if(ratingBarber) {
							Barber barber = main.systemAccounts.getSpecificBarber(appointment.getBarberName());
							if (barber != null) {
								barber.addReview(rating, review);
							}
						}
						else {
							// Add review to barbershop
							main.barberShop.addReview(rating, review);
						}
						
						
						
						
						
						
						ClientHome homePage = new ClientHome(client);
						homePage.show();
						dispose();
					}
				} catch (NumberFormatException ex) {
					// Invalid rating format
					ClientHome homePage = new ClientHome(client);
					homePage.show();
					dispose();
				}
			}
		});
		btnEnter.setBounds(311, 226, 117, 29);
		contentPane.add(btnEnter);
	}
}
