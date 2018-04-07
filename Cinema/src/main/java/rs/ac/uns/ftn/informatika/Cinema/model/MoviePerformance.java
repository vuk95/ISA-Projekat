package rs.ac.uns.ftn.informatika.Cinema.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GenerationType;

@Entity(name = "FilmPredstava")
public class MoviePerformance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "Tip", nullable = false)
	@Enumerated(EnumType.STRING)
	private MoviePerformanceType type;
	
	@Column(name = "Naziv", nullable = false)
	private String name;
	
	@Column(name = "Zanr")
	private String genre;
	
	@Column(name = "Trajanje", nullable = false)
	private int duration;
	
	@Column(name = "Opis")
	private String description;
	
	@Lob
	@Column(name = "Slika")
	private Byte[] picture;
	
	@Column(name = "Cena", nullable = false)
	private double price;
	
	@Column(name = "Reditelj", nullable = false)
	private String director;
	
	@ManyToMany
	@JoinTable(name = "glumi",
    			joinColumns = @JoinColumn(name="MoviePerformance_id", referencedColumnName="Id"),
    			inverseJoinColumns = @JoinColumn(name="Actor_id", referencedColumnName="Id"))
	private Set<Actor> actors = new HashSet<Actor>();
	
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "PozoristeBioskop_id" , referencedColumnName = "PozoristeBioskop_id")
	//private CinemaTheatre ct; 
	
	//TO DO: ocena(nova tabela)
	
	public MoviePerformance() {
		
	}

	public Byte[] getPicture() {
		return picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public MoviePerformanceType getType() {
		return type;
	}

	public void setType(MoviePerformanceType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	
}
