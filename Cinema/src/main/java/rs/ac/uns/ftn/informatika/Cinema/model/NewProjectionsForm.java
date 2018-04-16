package rs.ac.uns.ftn.informatika.Cinema.model;


import java.sql.Time;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class NewProjectionsForm {

	@NotEmpty(message = "Polje ne sme biti prazno !")
	private String name;
	
	@NotEmpty(message = "Polje ne sme biti prazno !")
	private String genre;
	
	@NotNull(message = "Morate uneti trajanje projekcije!")
	@Min(value=30, message = "Trajanje projekcije ne sme biti manje od 30 minuta!")
	@Max(value=300, message = "Trajanje projekcije ne sme biti vece od 300 minuta!")
	private int duration;
	
	@NotEmpty(message = "Polje ne sme biti prazno !")
	private String director;
	
	@NotEmpty(message = "Polje ne sme biti prazno !")
	private String description;
	
	private double price;

	private double avgraiting;
	
	private String actors;
	
	private Byte[] picture;
	
	private java.sql.Date date;
	
	private Time time;
	
	private Hall hall;
	
	public NewProjectionsForm() {
		
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


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
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


	public Byte[] getPicture() {
		return picture;
	}


	public void setPicture(Byte[] picture) {
		this.picture = picture;
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


	public Hall getHall() {
		return hall;
	}


	public void setHall(Hall hall) {
		this.hall = hall;
	}
	
	
	
}
