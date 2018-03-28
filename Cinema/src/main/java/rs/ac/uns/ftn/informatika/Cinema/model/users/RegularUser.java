package rs.ac.uns.ftn.informatika.Cinema.model.users;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;

@Entity(name = "ObicanKorisnik")
public class RegularUser extends User{

	@Column
	private boolean enabled;
	
	@Column
	private String confirmationToken;

//	private Set<CinemaTheatre> cinemasTheatres = new HashSet<CinemaTheatre>();
//	private Set<Ticket> tickets = new HashSet<Ticket>();

	public RegularUser() {
		
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}
	
}
