package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

@Entity(name="Ponuda") 	
public class Ponuda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ponuda_id")
	private Long id;
	
	@Column(name="Cena", columnDefinition="INTEGER")
	@Min(value=100, message = "Cena ne sme biti manja od 100")
	private int iznos;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private RegularUser user;
	
	@ManyToOne
	@JoinColumn(name = "oglas_id", referencedColumnName = "oglas_id")
	private Oglas oglas;
	
	@Column
	private boolean prihvacena;
	
	public Ponuda() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIznos() {
		return iznos;
	}

	public void setIznos(int iznos) {
		this.iznos = iznos;
	}

	public RegularUser getUser() {
		return user;
	}

	public void setUser(RegularUser user) {
		this.user = user;
	}
	
	public Oglas getOglas() {
		return oglas;
	}

	public void setOglas(Oglas oglas) {
		this.oglas = oglas;
	}

	public boolean isPrihvacena() {
		return prihvacena;
	}

	public void setPrihvacena(boolean prihvacena) {
		this.prihvacena = prihvacena;
	}
	
}
