package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.Skala;

public interface SkalaService {

	public void save(Skala s);
	public Skala findOne(Long id);
	
}
