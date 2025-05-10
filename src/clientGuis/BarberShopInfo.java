package clientGuis;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clients.Client;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import main.main;
import review.Review;

public class BarberShopInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblAddress;
	private JLabel lblEmail;
	private JLabel lblRating;
	private JLabel lblPhone;
	private JLabel lblReviews;
	private JButton btnBack;
	private JScrollPane scrollPane;
	private Client c; 
	
	public BarberShopInfo(Client C) {
		this.c = C;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAddress = new JLabel("Address: " + main.barberShop.getAddress());
		lblAddress.setBounds(43, 6, 387, 16);
		contentPane.add(lblAddress);
		
		lblEmail = new JLabel("Email: " + main.barberShop.getEmail());
		lblEmail.setBounds(43, 44, 387, 16);
		contentPane.add(lblEmail);
		
		lblRating = new JLabel("Rating: " + main.barberShop.getRating());
		lblRating.setBounds(43, 65, 387, 16);
		contentPane.add(lblRating);
		
		lblPhone = new JLabel("Phone: " + main.barberShop.getPhone());
		lblPhone.setBounds(43, 25, 387, 16);
		contentPane.add(lblPhone);
		
		lblReviews = new JLabel("Reviews:");
		lblReviews.setBounds(175, 90, 61, 16);
		contentPane.add(lblReviews);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientHome homePage = new ClientHome(c);
				homePage.show();
				dispose();
			}
		});
		btnBack.setBounds(153, 237, 117, 29);
		contentPane.add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 109, 387, 121);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[]{"Rating", "Review"});
		table = new JTable(model);
		
		// Add reviews to table
		for (Review review : main.barberShop.getReviews()) {
			model.addRow(new Object[]{review.getRating(), review.getReview()});
		}
		
		scrollPane.setViewportView(table);
	}
}
