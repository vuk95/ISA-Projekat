package rs.ac.uns.ftn.informatika.Cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity(name = "Skala")
public class Skala {

	@Id
	@Column(name = "skala_id")
	private Long id;
	
	@Column
	@Min(30)
	@Max(39)
	private int zlatni;
	@Column
	@Min(20)
	@Max(29)
	private int srebrni;
	@Column
	@Min(10)
	@Max(19)
	private int bronzani;

	public int getZlatni() {
		return zlatni;
	}
	public void setZlatni(int zlatni) {
		this.zlatni = zlatni;
	}
	public int getSrebrni() {
		return srebrni;
	}
	public void setSrebrni(int srebrni) {
		this.srebrni = srebrni;
	}
	public int getBronzani() {
		return bronzani;
	}
	public void setBronzani(int bronzani) {
		this.bronzani = bronzani;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Skala(int zlatni, int srebrni, int bronzani) {
		super();
		this.zlatni = zlatni;
		this.srebrni = srebrni;
		this.bronzani = bronzani;
	}
	
	public Skala() {
		
	}
	
}
