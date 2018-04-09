package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

//POSTOJI GRESKA DA KREIRA DUPLIKATE
@Entity(name="Ponuda") 	
public class Ponuda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ponuda_id")
	private Long id;
	
	@Column(name="Cena", columnDefinition="INTEGER")
	private int iznos;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private RegularUser user;
	
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
	
}
