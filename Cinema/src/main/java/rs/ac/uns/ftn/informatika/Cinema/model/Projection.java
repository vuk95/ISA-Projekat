package rs.ac.uns.ftn.informatika.Cinema.model;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;

@Entity(name = "Projekcije")
public class Projection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Hall hall;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private MoviePerformance moviePerformance;

	@ManyToOne
	@JoinColumn(nullable = false)
	private CinemaTheatre cinemaTheatre;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private double price;
	
	@OneToMany
	private Set<Seat> seats;

	
	public Projection() {
		
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

	public MoviePerformance getMoviePerformance() {
		return moviePerformance;
	}

	public void setMoviePerformance(MoviePerformance moviePerformance) {
		this.moviePerformance = moviePerformance;
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
