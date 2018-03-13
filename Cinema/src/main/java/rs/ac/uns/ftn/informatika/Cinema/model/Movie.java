package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Film")
public class Movie {

	@Column(name = "Naziv")
	private String name;
	
	@Column(name = "Zanr")
	private String genre;
	
	@Column(name = "Reditelj")
	private String director;
	
	@Column(name = "Trajanje")
	private int duration; //trajanje filma-stavio sam int ako se izrazava u minutima
	
	@Column(name = "Ocena")
	private double rating; //prosecna ocena
	
	@Column(name = "Opis")
	private String description; //kratak opis
	//fali spisak glumaca
	
	//Konstruktori
	public Movie() {
		
	}
	
	public Movie(String name,String genre,String director,int duration,double rating,String description) {
		
		this.name = name;
		this.genre = genre;
		this.director = director;
		this.duration = duration;
		this.rating = rating;
		this.description = description;
		
	}

	//Geteri i Seteri
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
