package system;

import java.util.ArrayList;

import barbers.Barber;
import clients.Client;
import main.main;

public class AccountData {
	private ArrayList<Barber> barbers;
	private ArrayList<Client> clients;
	
	
	public AccountData(ArrayList<Barber> Barbers, ArrayList<Client> Clients) {
		super();
		this.barbers = Barbers;
		this.clients = Clients;
	}
	public AccountData() {
		super();
		this.barbers = new ArrayList<Barber>();
		this.clients = new ArrayList<Client>();
	}
	
	//getters and setters
	
	public ArrayList<Barber> getBarbers() {
		return barbers;
	}
	public void setBarbers(ArrayList<Barber> Barbers) {
		this.barbers = Barbers;
	}
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> Clients) {
		this.clients = Clients;
	} 
	
	
	
	//methods to add and delete barbers/clients
	public boolean addBarber(Barber b) {
		if(this.barbers.contains(b)) {
			return false;
		}
		else {
			this.barbers.add(b);
			return true; 
		}
		
	}
	
	public boolean addClient(Client c) {
		if(this.clients.contains(c)) {
			return false;
		}
		else {
			this.clients.add(c);
			return true; 
		}
		
	}
	
	
	
	public void deleteBarber(String username) {
		for(Barber b: this.barbers) {
			if(b.getUsername().equalsIgnoreCase(username)) {
				this.barbers.remove(b);
			}
		}
		
	}
	
	public void deleteClient(String username) {
		for(Client c: this.clients) {
			if(c.getUsername().equalsIgnoreCase(username)) {
				this.clients.remove(c);
			}
		}
		
	}
	
	
	
	
	
	
	//method to validate if username password in system for client accounts. It is case sensitive
	// returns null if not found in system 
	public Client getClientAccount(String username, String password) {
		for(Client c: clients ) {
			if((c.getUsername().equals(username)) && (c.getPassword().equals(password))) {
				return c; 
			}
			
		}
		return null; 
	}
	
	//method to validate if username password in system for barber accounts. It is case sensitive
	// returns null if not found in system 
	public Barber getBarberAccount(String username, String password) {
		for(Barber b: barbers ) {
			if((b.getUsername().equals(username)) && (b.getPassword().equals(password))) {
				return b; 
			}
			
		}
		return null; 
	}
	
	
	//get specific barber by name
	public Barber getSpecificBarber(String name) {
		for(Barber currBarber: this.getBarbers()) {
			if(currBarber.getName().equals(name)) {
				return currBarber;
				
			}
			
		}
		return null;
	}
	
	
	

}
