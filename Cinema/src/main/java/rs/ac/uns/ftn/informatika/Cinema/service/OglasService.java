package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.NewOglasForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.model.Ponuda;

public interface OglasService {

	public Iterable<Oglas> findAll();
	public Oglas find(Long id);
	public void save(Oglas oglas);
	public Oglas addPonuda(Ponuda p, Long id);
	public Oglas createNewOglas(NewOglasForm oglasForm);
	public void delete(Oglas oglas);
	
}
