package rs.ac.uns.ftn.informatika.Cinema.model.users;

import java.util.HashSet;
import java.util.Set;

import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;

public class RegularUser extends User{


//	private Set<CinemaTheatre> cinemasTheatres = new HashSet<CinemaTheatre>();
	private Set<Ticket> tickets = new HashSet<Ticket>();

	public RegularUser() {
		
	}
	
}
