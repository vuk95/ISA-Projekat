package rs.ac.uns.ftn.informatika.Cinema.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name  = "Ime")
	private String name;
	
	@Column(name = "brojRedova")
	private int rowNumber;
	 
	@Column(name = "brojSedista")
	private int seatNumber; //broj sedista po redu
	 
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Projections> projections;
	
	
	 public Hall() {
	 
	 }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRowNumber() {
		return rowNumber;
	}


	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}


	public int getSeatNumber() {
		return seatNumber;
	}


	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Set<Projections> getProjections() {
		return projections;
	}


	public void setProjections(Set<Projections> projections) {
		this.projections = projections;
	}
	
}
