package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;
import rs.ac.uns.ftn.informatika.Cinema.repository.CinemaTheatreRepository;
import rs.ac.uns.ftn.informatika.Cinema.repository.TicketRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.TicketService;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository repository;
	
	@Autowired
	private CinemaTheatreRepository ctrepository;
	
	@Override
	public Ticket findOne(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Iterable<Ticket> findAll() {
		return repository.findAll();
	}

		
	
	@Override
	public Iterable<Ticket> findTickets(Long id) {
		
	CinemaTheatre ct = ctrepository.findOne(id);
		
	List<Ticket> karte = new ArrayList<Ticket>();
	
	for(int i=0;i<ct.getProjections().size();i++) {
	
		for(int j=0;j<ct.getProjections().get(i).getTickets().size();j++) {
				
			karte.add(ct.getProjections().get(i).getTickets().get(j));
			
			}
	}
			return karte;
	}

}
