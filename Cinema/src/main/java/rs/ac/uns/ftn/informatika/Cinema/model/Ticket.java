package rs.ac.uns.ftn.informatika.Cinema.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "Karta")
public class Ticket {

	//podaci o predstavi/projekciji-fali
	
	@Column(name = "Datum")
	private Date date;
	
	@Column(name = "Vreme")
	private Time time;
	
	@Column(name = "Sediste")
	private int seat;
	
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
	
	public Ticket(Date date,Time time,int seat,int hall,double price,int discount) {
		
		this.date = date;
		this.time = time;
		this.seat = seat;
		this.hall = hall;
		this.price = price;
		this.discount = discount;
	}

	//Geteri i Seteri
	public Date getDate() {
		return date;
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

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
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
