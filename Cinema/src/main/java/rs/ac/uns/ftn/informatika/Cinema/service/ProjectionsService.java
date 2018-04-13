package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.NewProjectionsForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Projections;

public interface ProjectionsService {

	public Projections findOne(Long id);
	
	public Iterable<Projections> findAll();
	
	public void save(Projections p);
	
	public Projections delete(Long id);
	
	public Projections createNewProjections(NewProjectionsForm form);
	
	public NewProjectionsForm seForm(Projections p);
	
	public String[] getSeatConfiguration(Long id);
	
}
