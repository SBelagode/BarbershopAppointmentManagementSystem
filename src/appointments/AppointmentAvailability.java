package appointments;

public class AppointmentAvailability {
	private String Day;
	private String Month; 
	private String Year; 
	
	private String Time;
	
	private float Cost; 

	

	public AppointmentAvailability(String day, String month, String year, String time, float cost) {
		super();
		Day = day;
		Month = month;
		Year = year;
		Time = time;
		Cost = cost;
	}

	public float getCost() {
		return Cost;
	}

	public void setCost(float cost) {
		this.Cost = cost;
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
