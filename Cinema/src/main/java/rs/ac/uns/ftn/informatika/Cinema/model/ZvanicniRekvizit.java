package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;


@Entity(name="Rekvizit")
public class ZvanicniRekvizit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "rekvizit_id")
	private Long id;
	
	@Lob
	@Column(name="Slika")
	private Byte[] slika;
	
	@Column(name="Ime", columnDefinition="VARCHAR(40)")
	private String ime;
	
	@Column(name="Cena", columnDefinition="INTEGER")
	private int cena;
	
	@Column(name="Opis", columnDefinition="VARCHAR(60)")
	private String opis;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private RegularUser user;
	
	@Column
	private boolean rezervisan;
	
	public RegularUser getUser() {
		return user;
	}
	public void setUser(RegularUser user) {
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public Byte[] getSlika() {
		return slika;
	}
	public void setSlika(Byte[] slika) {
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
	
	public boolean isRezervisan() {
		return rezervisan;
	}
	public void setRezervisan(boolean rezervisan) {
		this.rezervisan = rezervisan;
	}
	public ZvanicniRekvizit(Byte[] slika, String ime, int cena, String opis) {
		super();
		this.slika = slika;
		this.ime = ime;
		this.cena = cena;
		this.opis = opis;
	}
	public ZvanicniRekvizit(){
		
	}
	
}
