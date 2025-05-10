package system;

import java.util.ArrayList;

import barbers.Barber;
import review.Review;

public class BarberShop {
	
	
	//private ArrayList<Barber> barbers; 
	private ArrayList<Integer> ratingList;
	private ArrayList<Review> reviews;
	private float rating; 
	private String address;
	private String email;
	private String phone;
	
	
	
	
	
	public BarberShop() {
		super();
		//this.barbers = new ArrayList<Barber>();
		this.ratingList = new ArrayList<Integer>();
		this.reviews = new ArrayList<Review>();
		this.rating = 0.0f;
		this.address = "123 Main St, City, State 12345";
		this.email = "contact@barbershop.com";
		this.phone = "(555) 123-4567";
	}
	
	



	public ArrayList<Integer> getRatingList() {
		return ratingList;
	}



	public ArrayList<Review> getReviews() {
		return reviews;
	}



	public float getRating() {
		return rating;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}


	
	
	//this method adds the review to the barberShop's list, while also updating the current star rating. 
	public void addReview(int rating, String review ) {
		this.reviews.add(new Review(rating, review));
		this.ratingList.add(rating);
		int currSum = 0; 
		for(int i: this.ratingList) {
			currSum += i; 
		}
		this.rating =( (float) currSum /(this.ratingList.size()));
	}

}
