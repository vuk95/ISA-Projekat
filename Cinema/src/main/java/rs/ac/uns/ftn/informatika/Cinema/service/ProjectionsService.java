package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.NewProjectionsForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.model.Reservation;
import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;

public interface ProjectionsService {

	public Projections findOne(Long id);
	
	public Iterable<Projections> findAll();
	
	public void save(Projections p);
	
	public Projections delete(Long id);
	
	public Projections createNewProjections(NewProjectionsForm form);
	
	public NewProjectionsForm seForm(Projections p);
	
	public String[] getSeatConfiguration(Projections projection);
	
	public void addReservation(Projections projection, Reservation reservation);
	
	public String[] getReservedSeats(Projections projection);
	
	public void delete(Projections p);
	
	public Projections addTicket(Ticket t,Long id);
	

	
}
