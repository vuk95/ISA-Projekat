package rs.ac.uns.ftn.informatika.Cinema.model.users;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Administrator extends User{
	
	@Column(name = "firstLogin", nullable = false)
	private boolean firstLogin;
	
	@Column(name = "predefinisani", nullable = false)
	private boolean predefinisani;
	
	public Administrator() {
		
	}

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	public boolean isPredefinisani() {
		return predefinisani;
	}

	public void setPredefinisani(boolean predefinisani) {
		this.predefinisani = predefinisani;
	}
	
	
}
