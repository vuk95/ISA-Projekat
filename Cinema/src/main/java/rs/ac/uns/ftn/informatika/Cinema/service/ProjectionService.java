package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.MoviePerformance;

public interface ProjectionService {

	//public MoviePerformance findOne(Long id);
	
	public Iterable<MoviePerformance> findAll();
	
	public Iterable<MoviePerformance> findMovies();
	
	public Iterable<MoviePerformance> findPerformances();

	public void save(MoviePerformance mp);
	
}
