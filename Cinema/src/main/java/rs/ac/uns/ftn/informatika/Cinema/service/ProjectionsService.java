package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.Projections;

public interface ProjectionsService {

	public Projections findOne(Long id);
	
	public Iterable<Projections> findAll();

	
}
