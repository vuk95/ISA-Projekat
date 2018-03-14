package rs.ac.uns.ftn.informatika.Cinema.model.users;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Entity;

@Entity
public class Administrator extends User{

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private AdministratorType type;
	
	//private boolean firstLogin;
	
	public Administrator() {
		
	}
	
}
