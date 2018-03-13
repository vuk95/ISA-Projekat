package rs.ac.uns.ftn.informatika.Cinema.users;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Administrator extends User{

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private AdministratorType type;
	
	
	private boolean firstLogin;
	
}
