package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;

public interface OglasService {

	public Iterable<Oglas> findAll();
	public Oglas find(Long id);
	public void save(Oglas oglas);
	
}
