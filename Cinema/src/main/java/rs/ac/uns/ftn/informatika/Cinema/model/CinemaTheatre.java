package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "BioskopPozoriste")
public class CinemaTheatre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "tip", nullable = false)
	@Enumerated(EnumType.STRING)
	private CinemaTheatreType type;
	
	@Column(name = "Naziv", nullable = false)
	private String name;
	
	@Column(name = "Adresa", nullable = false)
	private String adress;
	
	@Column(name = "Opis")
	private String description;
	
	//TO DO: repertoar, spisak karata sa popustima, konfiguracija segmenata i mesta u salama
	
	public CinemaTheatre() {
		
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
