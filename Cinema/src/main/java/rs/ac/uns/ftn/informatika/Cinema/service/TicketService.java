package rs.ac.uns.ftn.informatika.Cinema.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;

public interface TicketService {

	public Ticket findOne(Long id);

	public Iterable<Ticket> findAll();

	public Iterable<Ticket> findTickets(Long id); 

}


