package rs.ac.uns.ftn.informatika.Cinema.model;

import org.hibernate.validator.constraints.NotEmpty;

public class NewOglasForm {

	@NotEmpty(message = "Morate zadati ime")
	private String naziv;
	
	@NotEmpty(message = "Morate zadati opis")
	private String opis;
	
	@NotEmpty(message = "Morate zadati datum isteka")
	private String datum;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	public NewOglasForm() {
		
	}
	
}
