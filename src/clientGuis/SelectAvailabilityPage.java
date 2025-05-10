package clientGuis;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import appointments.AppointmentAvailability;
import appointments.AppointmentConfirmed;
import appointments.AppointmentConfirmedHandler;
import barbers.Barber;
import clients.Client;
import main.main;

public class SelectAvailabilityPage extends JFrame {

	private JPanel contentPane;
	private JTable availabilityTable;
	private JLabel lblInstructionLabel;
	private JScrollPane scrollPane;
	private JButton btnCancel;
	private JButton btnSelect;
	private DefaultTableModel m;
	private Barber selectedBarber;
	private Client client; 
	
	public SelectAvailabilityPage(Barber barber, Client c, AppointmentConfirmedHandler handler, boolean isModification) {
		this.client = c;
		this.selectedBarber = barber;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInstructionLabel = new JLabel("Select a Time Slot and Click Select");
		lblInstructionLabel.setBounds(60, 37, 328, 16);
		contentPane.add(lblInstructionLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 82, 407, 135);
		contentPane.add(scrollPane);
		
		m = new DefaultTableModel();
		m.setColumnIdentifiers(new Object[]{"Day", "Month", "Year", "Time", "Cost"});
		availabilityTable = new JTable(m);
		scrollPane.setViewportView(availabilityTable);
		
		// Populate table with barber's availability
		for (AppointmentAvailability availability : selectedBarber.getMyAvailability()) {
			m.addRow(new Object[]{
				availability.getDay(),
				availability.getMonth(),
				availability.getYear(),
				availability.getTime(),
				availability.getCost()
			});
		}
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientHome homePage = new ClientHome(client);
				homePage.show();
				dispose();
			}
		});
		btnCancel.setBounds(56, 229, 117, 29);
		contentPane.add(btnCancel);
		
		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(isModification) {
					//replacing old appointment
					int selectedRow = availabilityTable.getSelectedRow();
					if (selectedRow != -1) {
						String day = (String)m.getValueAt(selectedRow, 0);
						String month = (String)m.getValueAt(selectedRow, 1);
						String year = (String)m.getValueAt(selectedRow, 2);
						String time = (String)m.getValueAt(selectedRow, 3);
						float cost = (float)m.getValueAt(selectedRow, 4);
						
						// Create appointment for client and barber 
						//Since handler stores appointment to be replaced, we remove this appoinment first then add
						//the new one
						
						
						handler.removeFromBarber(barber);
						handler.removeFromClient(client.getName());
						
						
						//adds appointment to client and barber, and then removes previous availability. 
						client.addAppointment(day, month, year, time, selectedBarber.getName(), cost);
						selectedBarber.addAppointment(day, month, year, time, client.getName(), cost);
						selectedBarber.removeAppointmentAvailability(day, month, year, time);
						
						//go back to home
						ClientHome homePage = new ClientHome(client);
						homePage.show();
						dispose();
					}
					
				}
				
				else {
				//Creating new appointment
				
				
				int selectedRow = availabilityTable.getSelectedRow();
				if (selectedRow != -1) {
					String day = (String)m.getValueAt(selectedRow, 0);
					String month = (String)m.getValueAt(selectedRow, 1);
					String year = (String)m.getValueAt(selectedRow, 2);
					String time = (String)m.getValueAt(selectedRow, 3);
					float cost = (float)m.getValueAt(selectedRow, 4);
					
					
					//adds appointment to client and barber, and then removes previous availability. 
					client.addAppointment(day, month, year, time, selectedBarber.getName(), cost);
					selectedBarber.addAppointment(day, month, year, time, client.getName(), cost);
					selectedBarber.removeAppointmentAvailability(day, month, year, time);
					
					//go back to home
					ClientHome homePage = new ClientHome(client);
					homePage.show();
					dispose();
					
					
				}
				}
			}
		});
		btnSelect.setBounds(271, 229, 117, 29);
		contentPane.add(btnSelect);
	}
}
