package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;
import rs.ac.uns.ftn.informatika.Cinema.repository.TicketRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.TicketService;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository repository;
	
	@Override
	public Ticket findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Iterable<Ticket> findAll() {
		return repository.findAll();
	}

}
