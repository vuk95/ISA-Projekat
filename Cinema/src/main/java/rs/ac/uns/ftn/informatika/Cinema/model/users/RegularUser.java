package rs.ac.uns.ftn.informatika.Cinema.model.users;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;

@Entity(name = "ObicanKorisnik")
public class RegularUser extends User{

	@Column(name = "test")
	private String test;

//	private Set<CinemaTheatre> cinemasTheatres = new HashSet<CinemaTheatre>();
//	private Set<Ticket> tickets = new HashSet<Ticket>();

	public RegularUser() {
		
	}
	
}
