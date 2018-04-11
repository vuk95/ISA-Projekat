package rs.ac.uns.ftn.informatika.Cinema.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;

@Entity(name = "Projekcije")
public class Projections {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "Naziv", nullable = false)
	private String name;
	
	//enumeracija koja ce definisati tip projekcije- (filmska ili pozorisna projekcija)
	//@Column(name = "Tip", nullable = false)
	//@Enumerated(EnumType.STRING)
	//private MoviePerformanceType type;
	
	@Column(name = "Zanr")
	private String genre;
	
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

	public Byte[] getPicture() {
		return picture;
	}

	public void setPicture(Byte[] picture) {
		this.picture = picture;
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

	@Column(name = "Trajanje", nullable = false)
	private int duration;
	
	@Column(name = "Opis")
	private String description;
	
	@Lob
	@Column(name = "Slika")
	private Byte[] picture;
	
	@Column(name = "Reditelj", nullable = false)
	private String director;
	
	@ManyToMany
	@JoinTable(name = "glumi",
    			joinColumns = @JoinColumn(name="Projection_id", referencedColumnName="Id"),
    			inverseJoinColumns = @JoinColumn(name="Actor_id", referencedColumnName="Id"))
	private Set<Actor> actors = new HashSet<Actor>();
	
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private CinemaTheatre cinemaTheatre;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Hall hall;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private double price;
	
	@OneToMany
	private Set<Seat> seats;

	
	public Projections() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	
	public CinemaTheatre getCinemaTheatre() {
		return cinemaTheatre;
	}

	public void setCinemaTheatre(CinemaTheatre cinemaTheatre) {
		this.cinemaTheatre = cinemaTheatre;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}
	
}
