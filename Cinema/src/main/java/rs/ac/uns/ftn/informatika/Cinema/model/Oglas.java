package rs.ac.uns.ftn.informatika.Cinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

@Entity(name = "Oglas")
public class Oglas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "oglas_id")
	private Long id;
	
	@Column(name="Naziv", columnDefinition="VARCHAR(40)")
	private String naziv;
	
	@Column(name="Opis", columnDefinition="VARCHAR(60)")
	private String opis;
	//posle ispraviti da ovo bude date
	@Column(name="Datum", columnDefinition="VARCHAR(40)")
	private String datum;
	//slika
	
	@Column
	private boolean odobren = false;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ponudeZaOglas",
				joinColumns = @JoinColumn(name = "oglas_id", referencedColumnName = "oglas_id"),
				inverseJoinColumns = @JoinColumn(name = "ponuda_id", referencedColumnName = "ponuda_id"))
	private List<Ponuda> ponudeZaOglas = new ArrayList<Ponuda>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private RegularUser user;
	
	public List<Ponuda> getPonudeZaOglas() {
		return ponudeZaOglas;
	}
	public void setPonudeZaOglas(List<Ponuda> ponudeZaOglas) {
		this.ponudeZaOglas = ponudeZaOglas;
	}
	public String getNaziv() {
		return naziv;
	}
	public Long getId() {
		return id;
	}
	public boolean isOdobren() {
		return odobren;
	}
	public void setOdobren(boolean odobren) {
		this.odobren = odobren;
	}
	public void setId(Long id) {
		this.id = id;
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
	public RegularUser getUser() {
		return user;
	}
	public void setUser(RegularUser user) {
		this.user = user;
	}
	public Oglas(String naziv, String opis, String datum) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.datum = datum;
	}
	
	public Oglas() {
		
	}

}
