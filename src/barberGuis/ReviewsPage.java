package barberGuis;

import java.awt.EventQueue;
import barbers.Barber;
import review.Review;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewsPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private JLabel lblRating;
	
	private JLabel lblReviews;
	private JButton btnBack;
	private JScrollPane scrollPane;
	private DefaultTableModel m;
	private Barber b;
	
	
	
	public ReviewsPage(Barber b) {
		this.b = b; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Display Barber's Rating
		 lblRating = new JLabel("Rating:" + Float.toString(b.getRating())  );
		lblRating.setBounds(43, 19, 387, 16);
		contentPane.add(lblRating);
		
		
		 lblReviews = new JLabel("Reviews:");
		lblReviews.setBounds(172, 47, 61, 16);
		contentPane.add(lblReviews);
		
		 btnBack = new JButton("Back");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		BarberHome homePage = new BarberHome(b);
				homePage.show();
				dispose();
		 	}
		 });
		btnBack.setBounds(153, 237, 117, 29);
		contentPane.add(btnBack);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 75, 387, 155);
		contentPane.add(scrollPane);
		
		
		m = new DefaultTableModel();
		m.setColumnIdentifiers(new Object[]{"Rating", "Reviews"});
		table = new JTable(m);
		scrollPane.setViewportView(table);
		
		this.displayReviews();
		
		
		
		
	}
	
	public void displayReviews() {
		//display the reviews: 
				for(Review r: this.b.getMyReviews()) {
					m.addRow(new Object[] {r.getRating(), r.getReview()});
				}
	}
	
	
}
