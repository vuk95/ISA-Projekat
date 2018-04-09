package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.Ponuda;

public interface PonudaService {

	public Iterable<Ponuda> findAll();
	public Ponuda find(Long id);
	public void save(Ponuda ponuda);
	
}
