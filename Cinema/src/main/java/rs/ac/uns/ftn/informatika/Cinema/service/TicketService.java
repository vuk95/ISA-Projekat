package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;

public interface TicketService {

	public Ticket findOne(Long id);
	
	public void save(Ticket t);

	public Iterable<Ticket> findAll();

	public Iterable<Ticket> findTickets(Long id); 

}


