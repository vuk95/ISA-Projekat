package rs.ac.uns.ftn.informatika.Cinema.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

@Entity(name = "BioskopPozoriste")
public class CinemaTheatre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "Tip", nullable = false)
	@Enumerated(EnumType.STRING)
	private CinemaTheatreType type;
	
	
	@Column(name = "Naziv", nullable = false)
	@NotEmpty(message = "Polje ne sme biti prazno !")
	private String name;
	
	
	@Column(name = "Adresa", nullable = false)
	@NotEmpty(message = "Polje ne sme biti prazno !")
	private String address;
	
	@Column(name = "Opis")
	private String description;
	
	@ManyToMany(mappedBy = "visitedCinemaTheatre")
	private Set<RegularUser> regularUsers = new HashSet<RegularUser>();
	
	@OneToMany
	private List<Projection> projections;
	
	
	//TO DO: spisak karata sa popustima, konfiguracija segmenata i mesta u salama
	
	public CinemaTheatre() {
		
	}
	
	

	public CinemaTheatre(String address,String description,String name,CinemaTheatreType type) {
		
		this.address = address;
		this.description = description;
		this.name = name;
		this.type = type;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public CinemaTheatreType getType() {
		return type;
	}

	public void setType(CinemaTheatreType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<RegularUser> getRegularUsers() {
		return regularUsers;
	}

	public void setRegularUsers(Set<RegularUser> regularUsers) {
		this.regularUsers = regularUsers;
	}
	
}
