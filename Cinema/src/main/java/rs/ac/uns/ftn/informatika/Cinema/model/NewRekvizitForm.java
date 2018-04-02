package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class NewRekvizitForm {

	
	
	@NotEmpty(message = "Morate zadati ime")
	private String ime;
	
	@NotNull(message = "Morate uneti neku cenu")
	@Min(value=100, message = "Cena ne sme biti manja od 100")
	@Max(value=4000, message = "Cena ne sme biti veca od 4000")
	private int cena;
	
	@NotEmpty(message = "Morate dati opis")
	private String opis;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public NewRekvizitForm() {
		
	}
	
}
