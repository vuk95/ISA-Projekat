package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="Rekvizit")
public class ZvanicniRekvizit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//kasnije uraditi da bude bas slika
	@Column(name="Slika", columnDefinition="VARCHAR(40)")
	@NotEmpty(message = "Morate odabrati sliku")
	private String slika;
	
	@Column(name="Ime", columnDefinition="VARCHAR(40)")
	@NotEmpty(message = "Morate zadati ime")
	private String ime;
	
	@Column(name="Cena", columnDefinition="INTEGER")
	@NotNull(message = "Morate uneti neku cenu")
	@Min(value=100, message = "Cena ne sme biti manja od 100")
	@Max(value=4000, message = "Cena ne sme biti veca od 4000")
	private int cena;
	
	@Column(name="Opis", columnDefinition="VARCHAR(60)")
	@NotEmpty(message = "Morate dati opis")
	private String opis;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSlika() {
		return slika;
	}
	public void setSlika(String slika) {
		this.slika = slika;
	}
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
	public ZvanicniRekvizit(String slika, String ime, int cena, String opis) {
		super();
		this.slika = slika;
		this.ime = ime;
		this.cena = cena;
		this.opis = opis;
	}
	public ZvanicniRekvizit(){
		
	}
	
}
