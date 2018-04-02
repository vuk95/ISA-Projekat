package rs.ac.uns.ftn.informatika.Cinema.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String name;
	
	@Column(name = "Adresa", nullable = false)
	private String address;
	
	@Column(name = "Opis")
	private String description;
	
	//@Column(name = "Repertoar")
	//private List<MoviePerformance> repertoire; 
	
	//TO DO: repertoar, spisak karata sa popustima, konfiguracija segmenata i mesta u salama
	
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
	
}
