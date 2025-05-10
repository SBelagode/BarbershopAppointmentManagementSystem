package appointments;

import java.util.ArrayList;

import barbers.Barber;
import clients.Client;
import main.*;

public class AppointmentConfirmedHandler {
	private String Day;
	private String Month; 
	private String Year; 
	
	private String Time;
	private Client c; 
	private Barber b; 

	public AppointmentConfirmedHandler(String day, String month, String year, String time) {
		super();
		Day = day;
		Month = month;
		Year = year;
		Time = time;
	}

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
	
	
	public void removeFromBarber(Barber b) {
		for(AppointmentConfirmed a: b.getMyAppointments()) {
			if((a.getDay().equals(this.Day)) && (a.getMonth().equals(this.Month)) && (a.getYear().equals(this.Year)) 
					&& (a.getTime().equals(this.Time))) {
				b.removeAppointmentConfirmed(Day, Month, Year, Time);
				break;
			}
		}
	}
	
	public void removeFromClient(String name) {
		//find client
		for(Client currClient: main.systemAccounts.getClients()) {
			if(currClient.getName().equals(name)) {
				this.c = currClient;
				
			}
			
		}
		for(AppointmentConfirmed a: c.getMyUpcomingAppointments()) {
			if((a.getDay().equals(this.Day)) && (a.getMonth().equals(this.Month)) && (a.getYear().equals(this.Year)) 
					&& (a.getTime().equals(this.Time))) {
				c.removeAppointmentConfirmed(Day, Month, Year, Time);
				break;
			}
		}
	}
	
	
	public void removeFromBarber(String name) {
		//find barber
		for(Barber currBarber: main.systemAccounts.getBarbers()) {
			if(currBarber.getName().equals(name)) {
				this.b = currBarber;
				
			}
			
		}
		for(AppointmentConfirmed a: b.getMyAppointments()) {
			if((a.getDay().equals(this.Day)) && (a.getMonth().equals(this.Month)) && (a.getYear().equals(this.Year)) 
					&& (a.getTime().equals(this.Time))) {
				b.removeAppointmentConfirmed(Day, Month, Year, Time);
				break;
			}
		}
	}
	
	public void addAppointmentToPast(String name) {
		//find client
		for(Client currClient: main.systemAccounts.getClients()) {
			if(currClient.getName().equals(name)) {
				this.c = currClient;
				
			}
			
		}
		
		//add the appointment to the past appointments section of the client
		for(AppointmentConfirmed a: c.getMyUpcomingAppointments()) {
			if((a.getDay().equals(this.Day)) && (a.getMonth().equals(this.Month)) && (a.getYear().equals(this.Year)) 
					&& (a.getTime().equals(this.Time))) {
				//mark as completed.
				a.setCompleted(true);
				c.getMyPastAppointments().add(a);
				break;
			}
		}
	}
	
	
	
	
	
	
	

	
	
	
}
