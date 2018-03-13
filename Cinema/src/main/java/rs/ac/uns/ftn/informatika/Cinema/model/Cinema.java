package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Bioskop")
public class Cinema {
    
	@Column(name = "Naziv" , columnDefinition = "VARCHAR(40)")
	private String name;
	
	@Column(name = "Adresa" , columnDefinition = "VARCHAR(50)")
	private String address;
	
	@Column(name = "Promotivni opis"  , columnDefinition = "VARCHAR(100)")
	private String description;
	
	@Column(name = "Repertoar" ,  columnDefinition = "VARCHAR(100)")
	private String repertoire;
	
	
	//Konstruktori
	public Cinema() {
		
	}
	
	public Cinema(String name,String address,String description,String repertoire) {
		
		this.name = name;
		this.address = address;
		this.description = description;
		this.repertoire = repertoire;
	
	}

	//Geteri i Seteri
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRepertoire() {
		return repertoire;
	}

	public void setRepertoire(String repertoire) {
		this.repertoire = repertoire;
	}
	
	
	
}
