package clientGuis;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clients.Client;
import main.main;
import appointments.AppointmentConfirmed;
import appointments.AppointmentConfirmedHandler;
import barbers.Barber;
import javax.swing.JTextArea;

public class UpcomingAppointments extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnBack;
	private JButton btnCancel;
	private Client currentClient;
	private DefaultTableModel model; 
	private JButton btnModify;
	private JTextArea txtInstructions;
	public UpcomingAppointments(Client client) {
		this.currentClient = client;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 42, 360, 195);
		contentPane.add(scrollPane);
		
		 model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"Day", "Month", "Year", "Time", "Barber", "Cost"});
		table = new JTable(model);
		
		// Populate table with upcoming appointments
		for (AppointmentConfirmed appointment : currentClient.getMyUpcomingAppointments()) {
			model.addRow(new Object[]{
				appointment.getDay(),
				appointment.getMonth(),
				appointment.getYear(),
				appointment.getTime(),
				appointment.getBarberName(),
				appointment.getCost()
			});
		}
		
		scrollPane.setViewportView(table);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientHome homePage = new ClientHome(client);
				homePage.show();
				dispose();
			}
		});
		btnBack.setBounds(6, 237, 117, 29);
		contentPane.add(btnBack);
		
		btnCancel = new JButton("Cancel Appointment");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String day = (String)model.getValueAt(selectedRow, 0);
					String month = (String)model.getValueAt(selectedRow, 1);
					String year = (String)model.getValueAt(selectedRow, 2);
					String time = (String)model.getValueAt(selectedRow, 3);
					
					
					//use handler to delete appointment from both the barber and client.  
					
					AppointmentConfirmedHandler handler = new AppointmentConfirmedHandler(day, month, year, time);
					handler.removeFromClient(currentClient.getName());
					handler.removeFromBarber(currentClient.getMyUpcomingAppointments().get(selectedRow).getBarberName());
					
					
					
					model.removeRow(selectedRow);
				}
				
				ClientHome homePage = new ClientHome(client);
				homePage.show();
				dispose();
			}
		});
		btnCancel.setBounds(119, 237, 165, 29);
		contentPane.add(btnCancel);
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				
				
				String day = (String)model.getValueAt(selectedRow, 0);
				String month = (String)model.getValueAt(selectedRow, 1);
				String year = (String)model.getValueAt(selectedRow, 2);
				String time = (String)model.getValueAt(selectedRow, 3);
				//create appoinment handler to pass into availability page
				AppointmentConfirmedHandler handler = new AppointmentConfirmedHandler(day, month, year, time);
				
				String barberUsername = currentClient.getMyUpcomingAppointments().get(selectedRow).getBarberName();
				Barber selectedBarber = main.systemAccounts.getSpecificBarber(barberUsername);  
				
				SelectAvailabilityPage availability = new SelectAvailabilityPage(selectedBarber, currentClient, handler, true);
				availability.setVisible(true);
				dispose();
			}
		});
		btnModify.setBounds(287, 237, 117, 29);
		contentPane.add(btnModify);
		
		txtInstructions = new JTextArea();
		txtInstructions.setWrapStyleWord(true);
		txtInstructions.setLineWrap(true);
		txtInstructions.setText("Note: Cancelling/Modifying will delete the original appointment for both you and barber. Be Considerate");
		txtInstructions.setBounds(5, 6, 360, 37);
		contentPane.add(txtInstructions);
	}
	
	void showAppointments() {
		for(AppointmentConfirmed a: currentClient.getMyPastAppointments()) {
			model.addRow(new Object[] {a.getDay(), a.getMonth(), a.getYear(),a.getTime(),a.getBarberName(),   a.getCost()});
		}
	}
}
