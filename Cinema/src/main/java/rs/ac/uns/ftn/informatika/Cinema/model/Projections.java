package rs.ac.uns.ftn.informatika.Cinema.model;


import java.sql.Time;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.GenerationType;

@Entity(name = "Projekcije")
public class Projections {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "Naziv", nullable = false)
	@NotEmpty(message = "Polje ne sme biti prazno !")
	private String name;
	
	//enumeracija koja ce definisati tip projekcije- (filmska ili pozorisna projekcija)
	//@Column(name = "Tip", nullable = false)
	//@Enumerated(EnumType.STRING)
	//private MoviePerformanceType type;
	
	@Column(name = "Zanr")
	@NotEmpty(message = "Polje ne sme biti prazno !")
	private String genre;
	
	@Column(name = "Trajanje", nullable = false)
	@NotNull(message = "Morate uneti trajanje projekcije!")
	@Min(value=30, message = "Trajanje projekcije ne sme biti manje od 30 minuta!")
	@Max(value=300, message = "Trajanje projekcije ne sme biti vece od 300 minuta!")
	private int duration;
	
	@Column(name = "Opis")
	private String description;
	
	@Lob
	@Column(name = "Slika")
	private Byte[] picture;
	
	@Column(name = "Reditelj", nullable = false)
	@NotEmpty(message = "Polje ne sme biti prazno !")
	private String director;
	
	@Column(name = "Glumci")
	private String actors;
	
/*	@ManyToMany
	@JoinTable(name = "glumi",
    			joinColumns = @JoinColumn(name="Projection_id", referencedColumnName="Id"),
    			inverseJoinColumns = @JoinColumn(name="Actor_id", referencedColumnName="Id"))
	private Set<Actor> actors = new HashSet<Actor>();
	
*/	
	@ManyToOne
	@JoinColumn
	private CinemaTheatre cinemaTheatre;
	
	@ManyToOne
	@JoinColumn
	private Hall hall;
	
	@Column(name = "Datum")
	private java.sql.Date date;
	
	@Column(name = "Vreme")
	private Time time;
	
	@Column
	private double price;
	
	@OneToMany
	private Set<Reservation> reservations;
	
	@Column(name = "Prosecna_ocena")
	private double avgraiting;
	
	@OneToMany
	private List<Ticket> tickets;
	
	public Projections() {
		
	}
	
		
	public double getAvgraiting() {
		return avgraiting;
	}

	public void setAvgraiting(double avgraiting) {
		this.avgraiting = avgraiting;
	}

	public String getActors() {
		return actors;
	}


	public void setActors(String actors) {
		this.actors = actors;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	//public Set<Actor> getActors() {
		//return actors;
	//}

	//public void setActors(Set<Actor> actors) {
		//this.actors = actors;
	//}

	
	
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
	
	public java.sql.Date getDate() {
		return date;
	}


	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	
	public Time getTime() {
		return time;
	}


	public void setTime(Time time) {
		this.time = time;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}


	public List<Ticket> getTickets() {
		return tickets;
	}


	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
}
