package barberGuis;

import java.awt.EventQueue;
import main.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import barbers.Barber;
import mainGUI.mainGUI;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BarberHome extends JFrame {

	private JPanel contentPane;
	JButton btnViewAvailability;
	JButton btnUpcomingAppointments;
	JButton btnViewRatings;
	JButton btnDeleteAccount;
	JButton btnLogOut;
	
	Barber b; 
	
	
	

	public BarberHome(Barber B) {
		this.b = B; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnViewAvailability = new JButton("View Availability");
		btnViewAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AvailabilityPage availabilityPage = new AvailabilityPage(b);
				availabilityPage.show();
				dispose();
			}
		});
		btnViewAvailability.setBounds(67, 21, 292, 29);
		contentPane.add(btnViewAvailability);
		
		 btnUpcomingAppointments = new JButton("View Upcoming Appointments");
		 btnUpcomingAppointments.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		UpcomingAppointmentsBarber appointmentsPage = new UpcomingAppointmentsBarber(b);
		 		appointmentsPage.show();
				dispose();
		 	}
		 });
		btnUpcomingAppointments.setBounds(67, 58, 292, 29);
		contentPane.add(btnUpcomingAppointments);
		
		btnViewRatings = new JButton("View Ratings");
		btnViewRatings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewsPage reviews = new ReviewsPage(b);
				reviews.show();
				dispose();
			}
		});
		btnViewRatings.setBounds(67, 99, 292, 29);
		contentPane.add(btnViewRatings);
		
		btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				main.systemAccounts.getBarbers().remove(b);
				
				mainGUI main = new mainGUI();
				main.show();
				dispose();
			}
		});
		btnDeleteAccount.setBounds(67, 140, 292, 29);
		contentPane.add(btnDeleteAccount);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainGUI main = new mainGUI();
				main.show();
				dispose();
				
			}
		});
		btnLogOut.setBounds(67, 218, 292, 29);
		contentPane.add(btnLogOut);
		
		JButton btnAddAvailability = new JButton("Add Availability");
		btnAddAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//tells this page that we're creating new availability, not modifying existing one
				ModifyAvailabilityPage addAvailability = new ModifyAvailabilityPage(null, b, true);
				addAvailability.show();
				dispose();
			}
		});
		btnAddAvailability.setBounds(67, 181, 292, 29);
		contentPane.add(btnAddAvailability);
	}
}
