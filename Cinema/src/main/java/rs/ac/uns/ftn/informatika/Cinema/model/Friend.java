package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Prijatelj")
public class Friend {

	@Column(name ="Ime")
	private String firstname;
	
	@Column(name = "Prezime")
	private String lastname;
	
	//nisam siguran da li treba
	@Column(name = "Korisnicko ime")
	private String username;
}
