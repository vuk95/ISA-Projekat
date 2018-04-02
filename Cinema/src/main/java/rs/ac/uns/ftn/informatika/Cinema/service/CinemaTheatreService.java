package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;


public interface CinemaTheatreService {

	public Iterable<CinemaTheatre> findAll();
	
	public void save(CinemaTheatre ct);
	
}
