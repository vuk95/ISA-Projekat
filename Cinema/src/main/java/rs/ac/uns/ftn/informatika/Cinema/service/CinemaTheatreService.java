package rs.ac.uns.ftn.informatika.Cinema.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;

public interface CinemaTheatreService {

	List<CinemaTheatre> findAll();
	
	CinemaTheatre save(CinemaTheatre ct);
	
}
