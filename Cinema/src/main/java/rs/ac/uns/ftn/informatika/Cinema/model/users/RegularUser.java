package rs.ac.uns.ftn.informatika.Cinema.model.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;

@Entity(name = "ObicanKorisnik")
public class RegularUser extends User{
	
	@Column
	private String confirmationToken;

//	private Set<CinemaTheatre> cinemasTheatres = new HashSet<CinemaTheatre>();
//	private Set<Ticket> tickets = new HashSet<Ticket>();
	
	public RegularUser() {
		
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
}
