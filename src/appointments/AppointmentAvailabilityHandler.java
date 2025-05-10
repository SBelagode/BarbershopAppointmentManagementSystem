package appointments;

import barbers.Barber;

public class AppointmentAvailabilityHandler {
	
	//attributes of old Availability object
	private String Day;
	private String Month; 
	private String Year; 
	
	private String Time;
	
	private float Cost;
	
	
	
	
	
	

	public AppointmentAvailabilityHandler(String day, String month, String year, String time, float cost) {
		super();
		Day = day;
		Month = month;
		Year = year;
		Time = time;
		Cost = cost;
	}

	
	//this deletes the old availability and updates the barber with the new one
	
	public void modifyAvailability(Barber b, String day, String month, String year, String time, float cost) {
		
		for(AppointmentAvailability a: b.getMyAvailability()) {
			//delete the old availability
			if((a.getDay().equals(this.Day)) && (a.getMonth().equals(this.Month)) && (a.getYear().equals(this.Year)) 
					&& (a.getTime().equals(this.Time))) {
				b.removeAppointmentAvailability(this.Day, this.Month, this.Year, this.Time);
				
				break;
				
			}
			
		}
		
		b.addAvailabiliy(day, month, year, time, cost);     
	}
	
	
	
	
	
	
	
	
	
	//getters and setters
	
	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

	public String getMonth() {
		return Month;
	}

	public void setMonth(String month) {
		Month = month;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public float getCost() {
		return Cost;
	}

	public void setCost(float cost) {
		Cost = cost;
	} 
	
	


}
