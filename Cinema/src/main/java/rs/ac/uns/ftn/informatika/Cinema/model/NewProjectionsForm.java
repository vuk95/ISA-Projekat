package rs.ac.uns.ftn.informatika.Cinema.model;

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
	
	
	
	
	
	
}