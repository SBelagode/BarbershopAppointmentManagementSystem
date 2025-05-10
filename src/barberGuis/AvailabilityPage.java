package barberGuis;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import appointments.AppointmentAvailability;
import appointments.AppointmentAvailabilityHandler;
import barbers.Barber;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AvailabilityPage extends JFrame {

	private JPanel contentPane;
	private JTable availabilityTable;
	private JLabel lblInstructionLabel;
	private JScrollPane scrollPane;
	private JButton btnCancel;
	private JButton btnModify;
	private DefaultTableModel m;
	private JButton btnDelete;
	private Barber b;
	
	public AvailabilityPage(Barber B) {
		this.b = B; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInstructionLabel = new JLabel("Select a Time Slot to Edit/Delete");
		lblInstructionLabel.setBounds(60, 37, 328, 16);
		contentPane.add(lblInstructionLabel);
		
	    scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 82, 407, 135);
		contentPane.add(scrollPane);
		
		m = new DefaultTableModel();
		m.setColumnIdentifiers(new Object[]{"Day", "Month", "Year", "Time", "Cost"});
		availabilityTable = new JTable(m);
		scrollPane.setViewportView(availabilityTable);
		//fill table with current availability
		showAvailability();
		
		
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarberHome homePage = new BarberHome(b);
				homePage.show();
				dispose();
			}
		});
		btnCancel.setBounds(6, 229, 117, 29);
		contentPane.add(btnCancel);
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = availabilityTable.getSelectedRow();
				
				
				AppointmentAvailabilityHandler handler = new AppointmentAvailabilityHandler(b.getMyAvailability().get(selectedRow).getDay(),
						b.getMyAvailability().get(selectedRow).getMonth(), b.getMyAvailability().get(selectedRow).getYear(),
						b.getMyAvailability().get(selectedRow).getTime(), b.getMyAvailability().get(selectedRow).getCost());
				//now 
				ModifyAvailabilityPage modifyPage = new ModifyAvailabilityPage(handler, b, false);
				modifyPage.show();
				dispose();
				
				
				
			}
			
			
			
		});
		btnModify.setBounds(314, 229, 117, 29);
		contentPane.add(btnModify);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = availabilityTable.getSelectedRow();
				b.removeAppointmentAvailability(b.getMyAvailability().get(selectedRow).getDay(),
						b.getMyAvailability().get(selectedRow).getMonth(), b.getMyAvailability().get(selectedRow).getYear(),
						b.getMyAvailability().get(selectedRow).getTime());
				
				
				//refresh screen
				AvailabilityPage availabilityPage = new AvailabilityPage(b);
				availabilityPage.show();
				dispose();
			}
		});
		btnDelete.setBounds(170, 229, 117, 29);
		contentPane.add(btnDelete);
	}
	
	void showAvailability() {
		for(AppointmentAvailability a: b.getMyAvailability()) {
			m.addRow(new Object[] {a.getDay(), a.getMonth(), a.getYear(), a.getTime(), a.getCost()});
		}
	}
}
