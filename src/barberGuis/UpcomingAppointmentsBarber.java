package barberGuis;

import java.awt.EventQueue;
import barbers.Barber;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import appointments.AppointmentAvailability;
import appointments.AppointmentConfirmed;
import appointments.AppointmentConfirmedHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpcomingAppointmentsBarber extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnBack;
	private JButton btnCancel;
	private JButton btnMarkCompleted;
	private DefaultTableModel m;
	private Barber B;
	
	
	
	public UpcomingAppointmentsBarber(Barber b) {
		this.B = b;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 42, 423, 195);
		contentPane.add(scrollPane);
		
		
		
		m = new DefaultTableModel();
		m.setColumnIdentifiers(new Object[]{"Client", "Day", "Month", "Year", "Time", "Cost"});
		table = new JTable(m);
		scrollPane.setViewportView(table);
		
		showAppointments();
		
		
		
		
		
		 btnBack = new JButton("Back");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		BarberHome homePage = new BarberHome(b);
				homePage.show();
				dispose();
		 	}
		 });
		btnBack.setBounds(16, 237, 117, 29);
		contentPane.add(btnBack);
		
		 btnCancel = new JButton("Cancel Appoinment");
		 btnCancel.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		//using handler, cancel appointments for the client and barber
		 		int selectedRow = table.getSelectedRow();
		 		AppointmentConfirmedHandler h = new AppointmentConfirmedHandler(B.getMyAppointments().get(selectedRow).getDay(),
						B.getMyAppointments().get(selectedRow).getMonth(), B.getMyAppointments().get(selectedRow).getYear(),
						B.getMyAppointments().get(selectedRow).getTime());
		 		
		 		h.removeFromClient(B.getMyAppointments().get(selectedRow).getClientName());
		 		h.removeFromBarber(B);
		 		
		 		//refresh screen by showing new appointments page
		 		UpcomingAppointmentsBarber appointmentsPage = new UpcomingAppointmentsBarber(B);
		 		appointmentsPage.show();
				dispose();
		 		
		 	}
		 });
		 btnCancel.setBounds(145, 237, 147, 29);
		contentPane.add(btnCancel);
		
		btnMarkCompleted = new JButton("Mark Completed");
		btnMarkCompleted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				//using handler, cancel appointments for the client and barber. Then add marked appointment
				// to client's past appointments
				int selectedRow = table.getSelectedRow();
		 		AppointmentConfirmedHandler h = new AppointmentConfirmedHandler(B.getMyAppointments().get(selectedRow).getDay(),
						B.getMyAppointments().get(selectedRow).getMonth(), B.getMyAppointments().get(selectedRow).getYear(),
						B.getMyAppointments().get(selectedRow).getTime());
		 		
		 		
		 		h.addAppointmentToPast(B.getMyAppointments().get(selectedRow).getClientName());
		 		h.removeFromClient(B.getMyAppointments().get(selectedRow).getClientName());
		 		h.removeFromBarber(B);
				
				//refresh screen by showing new appointments page
		 		UpcomingAppointmentsBarber appointmentsPage = new UpcomingAppointmentsBarber(B);
		 		appointmentsPage.show();
				dispose();
			}
		});
		btnMarkCompleted.setBounds(288, 237, 141, 29);
		contentPane.add(btnMarkCompleted);
	}
	
	void showAppointments() {
		for(AppointmentConfirmed a: B.getMyAppointments()) {
			m.addRow(new Object[] {a.getClientName(), a.getDay(), a.getMonth(), a.getYear(),a.getCost(),  a.getCost()});
		}
	}

}
