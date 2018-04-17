package rs.ac.uns.ftn.informatika.Cinema.model;

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
	
	@Column(name = "Sediste")
	private String seat;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SeatType seatType;
	
	@Column(name = "Popust")
	private int discount;
	
	@Column
	private boolean rezervisana;
	
	//Konstruktori
	
	public Ticket() {
		
	}
	
	//Geteri i Seteri
	
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


	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public boolean isRezervisana() {
		return rezervisana;
	}

	public void setRezervisana(boolean rezervisana) {
		this.rezervisana = rezervisana;
	}
	
	
}
