package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.Projections;



public interface CinemaTheatreService {

	public CinemaTheatre findOne(Long id);
	
	public Iterable<CinemaTheatre> findAll();
	
	public void save(CinemaTheatre ct);
		
	public Iterable<CinemaTheatre> findCinemas();
	
	public Iterable<CinemaTheatre> findTheatres();
	
	public CinemaTheatre addProjection(Projections p,Long id); 
	
}
