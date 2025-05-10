package review;

import appointments.*;
import barbers.Barber;
import system.BarberShop;

public class reviewHandler {
	
	
	//Add review to barber shop
	
	public void addBarberShopReview(BarberShop barberShop, int rating, String review) {
		
		
		barberShop.addReview(rating, review);
		
		
	}

}
