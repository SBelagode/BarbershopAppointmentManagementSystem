package clientGuis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clients.Client;
import main.main;
import mainGUI.mainGUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import clientGuis.NewAppointmentPage;
import clientGuis.BarberShopInfo;
import clientGuis.UpcomingAppointments;
import clientGuis.PastAppointments;
import clientGuis.FavoriteBarbersPage;
import clientGuis.ClientLoginPage;

public class ClientHome extends JFrame {

	private JPanel contentPane;
	private JButton btnScheduleNewAppointment;
	private JButton btnGetInfo;
	private JButton btnUpcomingAppointments;
	private JButton btnPastAppointments;
	private JButton btnFavoriteBarbers;
	private JButton btnLogOut;
	private Client currentClient;
	private JButton btnDelete;
	
	
	
	
	

	public ClientHome(Client c) {
		this.currentClient = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnScheduleNewAppointment = new JButton("New Appointment");
		btnScheduleNewAppointment.setBounds(67, 21, 292, 29);
		btnScheduleNewAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAppointmentPage newAppointment = new NewAppointmentPage(currentClient);
				newAppointment.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnScheduleNewAppointment);
		
		btnGetInfo = new JButton("Get Information");
		btnGetInfo.setBounds(67, 181, 292, 29);
		btnGetInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarberShopInfo info = new BarberShopInfo(c);
				info.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnGetInfo);
		
		btnUpcomingAppointments = new JButton("Upcoming Appointments");
		btnUpcomingAppointments.setBounds(67, 58, 292, 29);
		btnUpcomingAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpcomingAppointments upcoming = new UpcomingAppointments(currentClient);
				upcoming.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnUpcomingAppointments);
		
		btnPastAppointments = new JButton("Past Appointments");
		btnPastAppointments.setBounds(67, 99, 292, 29);
		btnPastAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PastAppointments past = new PastAppointments(currentClient);
				past.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnPastAppointments);
		
		btnFavoriteBarbers = new JButton("Favorite Barbers");
		btnFavoriteBarbers.setBounds(67, 140, 292, 29);
		btnFavoriteBarbers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FavoriteBarbersPage favorites = new FavoriteBarbersPage(currentClient);
				favorites.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnFavoriteBarbers);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(67, 218, 292, 29);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainGUI main = new mainGUI();
				main.show();
				dispose();
			}
		});
		contentPane.add(btnLogOut);
		
		btnDelete = new JButton("Delete Account");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.systemAccounts.getClients().remove(currentClient);
				
				mainGUI main = new mainGUI();
				main.show();
				dispose();
			}
		});
		btnDelete.setBounds(67, 243, 292, 29);
		contentPane.add(btnDelete);
	}

}
