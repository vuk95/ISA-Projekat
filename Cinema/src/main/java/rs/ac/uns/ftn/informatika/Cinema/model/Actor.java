package rs.ac.uns.ftn.informatika.Cinema.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Glumac")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name = "Ime", nullable = false)
	private String firstname;
	
	@Column(name = "Prezime", nullable = false)
	private String lastname;
	
	//@ManyToMany(mappedBy = "actors")
	//private Set<Projections> projections = new HashSet<Projections>();
	
	
	
	public Actor() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	//public Set<Projections> getProjections() {
		//return projections;
	//}

	//public void setProjections(Set<Projections> projections) {
		//this.projections = projections;
	//}

	
}
