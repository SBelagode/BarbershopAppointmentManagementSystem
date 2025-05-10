package barberGuis;

import java.awt.EventQueue;
import barbers.Barber;
import appointments.AppointmentAvailabilityHandler;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyAvailabilityPage extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDay;
	private JTextField textFieldMonth;
	private JTextField textFieldYear;
	private JTextField textFieldCost;
	private JTextField textFieldTime;
	private JLabel lblDay;
	private JLabel lblMonth;
	private JLabel lblYear;
	private JLabel lblCost;
	private JLabel lblTime;
	private JButton btnCancel;
	private JButton btnEnter;
	private AppointmentAvailabilityHandler h;
	private Barber b; 
	
	
	public ModifyAvailabilityPage(AppointmentAvailabilityHandler H, Barber B, boolean createNewAvailability) {
		this.h = H;
		this.b = B;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblDay = new JLabel("Day:");
		lblDay.setBounds(65, 24, 61, 16);
		contentPane.add(lblDay);
		
		 lblMonth = new JLabel("Month: ");
		lblMonth.setBounds(65, 60, 61, 16);
		contentPane.add(lblMonth);
		
		 lblYear = new JLabel("Year");
		lblYear.setBounds(65, 95, 61, 16);
		contentPane.add(lblYear);
		
		 lblCost = new JLabel("Cost: ");
		lblCost.setBounds(65, 123, 61, 16);
		contentPane.add(lblCost);
		
		 lblTime = new JLabel("Time: ");
		lblTime.setBounds(65, 162, 61, 16);
		contentPane.add(lblTime);
		
		textFieldDay = new JTextField();
		textFieldDay.setBounds(156, 19, 130, 26);
		contentPane.add(textFieldDay);
		textFieldDay.setColumns(10);
		
		textFieldMonth = new JTextField();
		textFieldMonth.setBounds(156, 55, 130, 26);
		contentPane.add(textFieldMonth);
		textFieldMonth.setColumns(10);
		
		textFieldYear = new JTextField();
		textFieldYear.setBounds(156, 90, 130, 26);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		
		textFieldCost = new JTextField();
		textFieldCost.setBounds(156, 123, 130, 26);
		contentPane.add(textFieldCost);
		textFieldCost.setColumns(10);
		
		textFieldTime = new JTextField();
		textFieldTime.setBounds(156, 157, 130, 26);
		contentPane.add(textFieldTime);
		textFieldTime.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BarberHome homePage = new BarberHome(b);
				homePage.show();
				dispose();
			}
		});
		btnCancel.setBounds(76, 237, 117, 29);
		contentPane.add(btnCancel);
		
		btnEnter = new JButton("Enter");
		
		//add new 
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//assumes user properly puts in values for each field. Adds availability using handler
				
				//if creating new availability
				if(createNewAvailability) {
					b.addAvailabiliy(textFieldDay.getText(), textFieldMonth.getText(), 
							textFieldYear.getText(), textFieldTime.getText(), 
							Float.parseFloat(textFieldCost.getText()));
					
					
				}
				else {
					h.modifyAvailability(b, textFieldDay.getText(), textFieldMonth.getText(), 
							textFieldYear.getText(), textFieldTime.getText(), 
							Float.parseFloat(textFieldCost.getText()));
				}
				
				//if modifying existing one
				
				
				//go back to barber home page
				BarberHome homePage = new BarberHome(b);
				homePage.show();
				dispose();
			}
		});
		btnEnter.setBounds(218, 237, 117, 29);
		contentPane.add(btnEnter);
	}

}
