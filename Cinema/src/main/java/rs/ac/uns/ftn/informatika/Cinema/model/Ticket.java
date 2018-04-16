package rs.ac.uns.ftn.informatika.Cinema.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

@Entity(name = "Karta")
public class Ticket {

	//podaci o predstavi/projekciji-fali
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	private Projections projekcija;
	
	@ManyToOne
	private RegularUser user;
	
	@Column(name = "Datum")
	private Date date;
	
	@Column(name = "Vreme")
	private Time time;
	
	@Column(name = "Sediste")
	private String seat;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private SeatType seatType;
	
	@Column(name = "Sala")
	private int hall;
	
	@Column(name = "Cena")
	private double price;
	
	@Column(name = "Popust")
	private int discount;
	
	//Konstruktori
	
	public Ticket() {
		
	}
	
	//Geteri i Seteri
	

	public Date getDate() {
		return date;
	}

	public Projections getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(Projections projekcija) {
		this.projekcija = projekcija;
	}

	public RegularUser getUser() {
		return user;
	}

	public void setUser(RegularUser user) {
		this.user = user;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public int getHall() {
		return hall;
	}

	public void setHall(int hall) {
		this.hall = hall;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
}
