package rs.ac.uns.ftn.informatika.Cinema.model.users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;

@Entity(name = "ObicanKorisnik")
public class RegularUser extends User{
	
	@Column
	private String confirmationToken;

	@ManyToMany
	@JoinTable(name = "poseceniBioskopiPozorista",
				joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "cinematheatre_id", referencedColumnName = "id"))
	private Set<CinemaTheatre> visitedCinemaTheatre = new HashSet<CinemaTheatre>();
	
//	private Set<Ticket> tickets = new HashSet<Ticket>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "mojiRekviziti",
				joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "rekvizit_id", referencedColumnName = "rekvizit_id"))
	private List<ZvanicniRekvizit> mojiRekviziti = new ArrayList<ZvanicniRekvizit>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "mojiOglasi",
				joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "oglas_id", referencedColumnName = "oglas_id"))
	private List<Oglas> mojiOglasi = new ArrayList<Oglas>();
	
	public RegularUser() {
		
	}
	
	public List<Oglas> getMojiOglasi() {
		return mojiOglasi;
	}

	public void setMojiOglasi(List<Oglas> mojiOglasi) {
		this.mojiOglasi = mojiOglasi;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Set<CinemaTheatre> getVisitedCinemaTheatre() {
		return visitedCinemaTheatre;
	}

	public void setVisitedCinemaTheatre(Set<CinemaTheatre> visitedCinemaTheatre) {
		this.visitedCinemaTheatre = visitedCinemaTheatre;
	}

	public List<ZvanicniRekvizit> getMojiRekviziti() {
		return mojiRekviziti;
	}

	public void setMojiRekviziti(List<ZvanicniRekvizit> mojiRekviziti) {
		this.mojiRekviziti = mojiRekviziti;
	}
	
	
	
}
