package barbers;
import java.util.ArrayList;

import appointments.*;
import review.*;

public class Barber {
	
	/***
	 * 
	 * 
	 * Barbers manage their availability, maintain their profiles, and track appointments through the system. Each barber may also be associated with an aggregate rating if clients leave them a review + rating. 
Create Profile: Register on the platform by providing barber name, address, experience level, and specialization.
Edit Availability: Create, modify, or remove available appointment time slots.
View Appointments: Access a list of upcoming client appointments. (implemented by barber GUI)
Cancel Appointment: Cancel appointments if necessary.
Mark Appointment Completed: Confirm when an appointment has been fulfilled.
Delete Account: Remove barber account from the system. (implemented by barber GUI)
View Ratings & Comments: Aggregate and view client ratings (1–5 stars) and comments on past (Implemented by barber GUI) 
	 */
	
	//make all attributes private
	
	private String username; 
	private String password; 
	
	private String name; 
	private String address;
	//newHire, InterMediate, LongServing
	private String experienceLevel; 
	private String specialization; 
	
	private ArrayList<AppointmentConfirmed> myAppointments;
	private ArrayList<AppointmentAvailability> myAvailability;
	private ArrayList<Review> myReviews;
	private ArrayList<Integer> ratingList;
	private float rating; 
	
	
	public Barber(String Username, String Password, String Name, String Address, String ExperienceLevel, String Specialization,
			ArrayList<AppointmentConfirmed> MyAppointments, ArrayList<AppointmentAvailability> MyAvailability,
			ArrayList<Review> MyReviews) {
		super();
		this.username = Username; 
		this.password = Password; 
		this.name = Name;
		this.address = Address;
		this.experienceLevel = ExperienceLevel;
		this.specialization = Specialization;
		this.myAppointments = MyAppointments;
		this.myAvailability = MyAvailability;
		this.myReviews = MyReviews;
	}
	
	
	
	public Barber(String Username, String Password,String Name, String Address, String ExperienceLevel, String Specialization) {
		super();
		this.username = Username; 
		this.password = Password; 
		this.name = Name;
		this.address = Address;
		this.experienceLevel = ExperienceLevel;
		this.specialization = Specialization;
		
		this.myAppointments = new ArrayList<AppointmentConfirmed>();
		this.myAvailability = new ArrayList<AppointmentAvailability>();
		this.myReviews = new ArrayList<Review>();
		this.ratingList = new ArrayList<Integer>();
		
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	} 
	public ArrayList<AppointmentConfirmed> getMyAppointments() {
		return myAppointments;
	}
	public ArrayList<AppointmentAvailability> getMyAvailability() {
		return myAvailability;
	}
	public ArrayList<Review> getMyReviews() {
		return myReviews;
	}
	
	public ArrayList<Integer> getRatingList() {
		return ratingList;
	}
	public float getRating() {
		return rating;
	}
	
	
	
	
	//adding availability and appointments to your lists
	public void addAvailabiliy(String Day, String Month, String Year, String Time, float cost) {
		this.myAvailability.add(new AppointmentAvailability(Day, Month, Year, Time, cost));
	}
	
	public void addAppointment(String Day, String Month, String Year, String Time, String client, float cost ) {
		this.myAppointments.add(new AppointmentConfirmed(Day, Month, Year, Time, this.name, client, cost ));
	}
	
	
	//this method adds the review to the barber's list, while also updating his current star rating. 
	public void addReview(int rating, String review ) {
		this.myReviews.add(new Review(rating, review));
		this.ratingList.add(rating);
		int currSum = 0; 
		for(int i: this.ratingList) {
			currSum += i; 
		}
		this.rating = currSum /(this.ratingList.size());
	}
	
	
	//search functions to get the index of your appointment object in its respective lists.
	public int AppointmentConfirmedIndex(String Day, String Month, String Year, String Time) {
		
		for(int i =0; i <  this.myAppointments.size() ; i++) {
			AppointmentConfirmed curr = this.myAppointments.get(i);
			if((curr.getDay().equals(Day)) && (curr.getDay().equals(Month)) && (curr.getDay().equals(Year)) && (curr.getTime().equals(Time)) ) {
				return i;
			}
		}
		return -1;
	}
	
	public int AppointmentAvailabilityIndex(String Day, String Month, String Year, String Time) {
		
		for(int i =0; i <  this.myAvailability.size() ; i++) {
			AppointmentAvailability curr = this.myAvailability.get(i);
			if((curr.getDay().equals(Day)) && (curr.getDay().equals(Month)) && (curr.getDay().equals(Year)) && (curr.getTime().equals(Time)) ) {
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
				this.myAppointments.remove(index);
				
				
				return true;
			}
			
			
			return false;
			
		}
		
		//mark an appointment as visited and remove it from your list
		public boolean markAppointed(String Day, String Month, String Year, String Time) {
			int index = this.AppointmentConfirmedIndex(Day, Month, Year, Time);
			if(index != -1) {
				this.myAppointments.get(index).setCompleted(true);
				this.removeAppointmentConfirmed(Day, Month, Year, Time);
				
				return true;
			}
			return false;
			
		}

		
		//edit appoinment's date/time, nothing else should be able to be edited. 
		public boolean editAppointmentAvailability(String Day, String Month, String Year, String Time) {
			int index = this.AppointmentAvailabilityIndex(Day, Month, Year, Time);
			if(index != -1) {
				
				this.myAvailability.get(index).setDay(Day);
				this.myAvailability.get(index).setMonth(Month);
				this.myAvailability.get(index).setYear(Year);
				this.myAvailability.get(index).setTime(Time);
				
				return true;
			}
			return false;
			
		}
		
		
		
		
		
		
		//returns true if successfully remmoved appointment, false if appointment not found 
		//(which should not happen) 
		public boolean removeAppointmentAvailability(String Day, String Month, String Year, String Time) {
			int index = this.AppointmentAvailabilityIndex(Day, Month, Year, Time);
			if(index != -1) {
				this.myAvailability.remove(index);
				
				return true;
			}
			return false;
			
		}
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	

}
