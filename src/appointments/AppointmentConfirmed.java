package appointments;

public class AppointmentConfirmed {
	private String Day;
	private String Month; 
	private String Year; 
	
	private String Time;
	
	private String barberName; 
	private String clientName; 
	private boolean completed; 
	
	private float cost;
	
	public AppointmentConfirmed(String day, String month, String year, String time, String BarberName,
			String ClientName, float Cost) {
		super();
		Day = day;
		Month = month;
		Year = year;
		Time = time;
		this.barberName = BarberName;
		this.clientName = ClientName;
		this.completed = false;
		this.cost = Cost; 
	}
	
	
	
	
	public float getCost() {
		return cost;
	}




	public void setCost(float cost) {
		this.cost = cost;
	}




	public String getBarberName() {
		return barberName;
	}

	public void setBarberName(String barberName) {
		this.barberName = barberName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
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
	
}
