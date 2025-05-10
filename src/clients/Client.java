package clients;

import java.util.ArrayList;

import appointments.AppointmentConfirmed;
import barbers.Barber;
import system.BarberShop;
import system.AccountData;

public class Client {
	/***
	 * 
	 * verify login class, uis, appointment editor.
	 * 
	 * Create Account: Register by providing name, phone number, email, and credit card number.
● Get Info: Displays the barbershop's address, phone number, email, and the rating of the barber shop, as
well as all the reviews that customers have left.
● Schedule New Appointment: Prompts client to choose a barber, view available time slots, and pay via
credit card.
● View Upcoming Appointments: Access the list of future appointments, including information about how
much each appointment costs, what time/day,
● Modify Appointment: Edit appointment details (e.g., reschedule by choosing a different time slot if
available).
● Delete Appointment: Cancel existing appointments.
● View Favorite Barbers: Access an aggregated list of favorite or highly rated barbers.
● View Past Appointments: Review history of previous appointments, where clients can select a specific
past appointment to rate it. (implemented with Client UI)
● Rate Appointment: Leave a 1–5 star rating and an optional comment after each completed appointment.
● Leave Barber Shop Rating: Allows customers to rate the barber shop out of 5, and leave feedback for the
barber shop as a whole.
● Delete Account: Remove client account from the system.
	 * 
	 * 
	 * 
	 */
	
	
	private String username; 
	private String password; 
	
	
	private String name; 
	private String number; 
	private String email; 
	private String creditCard;
	private ArrayList<AppointmentConfirmed> myUpcomingAppointments;
	
	private ArrayList<AppointmentConfirmed> myPastAppointments;
	private ArrayList<Barber> myFavoriteBarbers; 
	

	public Client(String Username, String Password, String Name, String Number, String Email, String CreditCard) {
		super();
		this.username = Username; 
		this.password = Password;
		this.name = Name;
		this.number = Number;
		this.email = Email;
		this.creditCard = CreditCard;
		this.myUpcomingAppointments = new ArrayList<AppointmentConfirmed>();
		this.myPastAppointments = new ArrayList<AppointmentConfirmed>();
		this.myFavoriteBarbers = new ArrayList<Barber>();

	}
	
	 //getters and setters
	
	
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	} 
	public ArrayList<AppointmentConfirmed> getMyUpcomingAppointments() {
		return myUpcomingAppointments;
	}
	//no setter for myAppointments because don't want to be able to change that. 

	public ArrayList<AppointmentConfirmed> getMyPastAppointments() {
		return myPastAppointments;
	}

	public ArrayList<Barber> getMyFavoriteBarbers() {
		return myFavoriteBarbers;
	}
	
	
	
	
	
	
	
	//add an appointment
	public void addAppointment(String Day, String Month, String Year, String Time, String barber, float cost ) {
		this.myUpcomingAppointments.add(new AppointmentConfirmed(Day, Month, Year, Time, barber, this.name, cost ));
	}
	
	//search functions to get the index of your appointment object in its respective lists.
	public int AppointmentConfirmedIndex(String Day, String Month, String Year, String Time) {
		for(int i = 0; i < this.myUpcomingAppointments.size(); i++) {
			AppointmentConfirmed curr = this.myUpcomingAppointments.get(i);
			if(curr.getDay().equals(Day) && 
			   curr.getMonth().equals(Month) && 
			   curr.getYear().equals(Year) && 
			   curr.getTime().equals(Time)) {
				return i;
			}
		}
		return -1;
	}
		
	
	//returns true if successfully remmoved appointment, false if appointment not found 
	//(which should not happen) 
	public boolean removeAppointmentConfirmed(String Day, String Month, String Year, String Time) {
		int index = this.AppointmentConfirmedIndex(Day, Month, Year, Time);
		if(index != -1) {
			this.myUpcomingAppointments.remove(index);
			
			return true;
		}
		return false;
		
	}
		
	
	

	//Rate Appointment: Leave a 1–5 star rating and an optional comment after each completed appointment.
	public void rateAppointment(AppointmentConfirmed appointment, int rating, String comment) {
		if (appointment != null && myPastAppointments.contains(appointment)) {
			Barber barber = null;
			for (Barber b : myFavoriteBarbers) {
				if (b.getName().equals(appointment.getBarberName())) {
					barber = b;
					break;
				}
			}
			if (barber != null) {
				barber.addReview(rating, comment);
			}
		}
	}
	
	//Leave Barber Shop Rating: Allows customers to rate the barber shop out of 5
	public void rateBarberShop(BarberShop shop, int rating, String comment) {
		if (shop != null) {
			shop.addReview(rating, comment);
		}
	}
	
	//Delete Account: Remove client account from the system
	public void deleteAccount(AccountData accounts) {
		if (accounts != null) {
			accounts.deleteClient(this.username);
		}
	}
}
