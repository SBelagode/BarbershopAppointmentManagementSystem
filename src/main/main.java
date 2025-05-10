package main;
import java.util.ArrayList;
import clients.*;
import mainGUI.mainGUI;
import system.*;
import barbers.*;

public class main {
	public static AccountData systemAccounts;

	public static BarberShop barberShop;
	public static void main(String[] args) {
		
		//holds account data
		systemAccounts = new AccountData();
		
		//barbershop
		barberShop = new BarberShop();
		
		

		
		
		//create main gui
		mainGUI mGUI = new mainGUI();
		mGUI.show();
		
		 
	}

}
