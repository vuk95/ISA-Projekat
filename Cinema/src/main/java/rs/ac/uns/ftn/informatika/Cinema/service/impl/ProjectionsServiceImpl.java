package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.Hall;
import rs.ac.uns.ftn.informatika.Cinema.model.NewProjectionsForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.model.Reservation;
import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;
import rs.ac.uns.ftn.informatika.Cinema.repository.ProjectionsRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionsService;

@Service
@Transactional
public class ProjectionsServiceImpl implements ProjectionsService {

	@Autowired
	ProjectionsRepository prepository;
	
	
	@Override
	public Projections findOne(Long id) {
		return prepository.findOne(id);
	}

	@Override
	public Iterable<Projections> findAll() {
		return prepository.findAll();
	}

	@Override
	public void save(Projections p) {
		prepository.save(p);
		
	}

	@Override
	public Projections delete(Long id) {
		
		Projections p = prepository.findOne(id);
			
		if(p == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant movie-performance projection");
		}
			
		prepository.delete(p);
			
			return p;
		
	}

	@Override
	public Projections createNewProjections(NewProjectionsForm form) {
		
		Projections p = new Projections();
		
		p.setName(form.getName());
		p.setGenre(form.getGenre());
		p.setDuration(form.getDuration());
		p.setDirector(form.getDirector());
		p.setDescription(form.getDescription());
		p.setPrice(form.getPrice());
		p.setAvgraiting(form.getAvgraiting());
		p.setActors(form.getActors());
		p.setPicture(form.getPicture());
		p.setDate(form.getDate());
		p.setTime(form.getTime());
		p.setHall(form.getHall());
		
		return prepository.save(p);
	}

	@Override
	public NewProjectionsForm seForm(Projections p) {
		
		NewProjectionsForm form =  new NewProjectionsForm();
		
		form.setName(p.getName());
		form.setGenre(p.getGenre());
		form.setDuration(p.getDuration());
		form.setDirector(p.getDirector());
		form.setDescription(p.getDescription());
		form.setPrice(p.getPrice());
		form.setAvgraiting(p.getAvgraiting());
		form.setActors(p.getActors());
		form.setPicture(p.getPicture());
		form.setDate(p.getDate());
		form.setTime(p.getTime());
		form.setHall(p.getHall());
		
		return form;
	}

	@Override
	public String[] getSeatConfiguration(Projections projection) {
		Hall hall = projection.getHall();
		StringBuilder sb = new StringBuilder();
		ArrayList<String> lista = new ArrayList<String>();
		
		for(int i = 0; i < hall.getRowNumber(); i++) {
			for(int j = 0; j < hall.getSeatNumber(); j++) {
				sb.append("s");
			}
			lista.add(sb.toString());
			sb = new StringBuilder();
		}
		
		return lista.toArray(new String[lista.size()]);
	}

	@Override
	public void addReservation(Projections projection, Reservation reservation) {
		projection.getReservations().add(reservation);
		prepository.save(projection);
		
	}

	@Override
	public String[] getReservedSeats(Projections projection) {
		List<Reservation> reservations = new ArrayList<Reservation>(projection.getReservations());
		List<String> seats = new ArrayList<String>();
		for(int i = 0; i < reservations.size(); i++) {
			if(!reservations.get(i).isDeleted()) {
				for(int j = 0; j < reservations.get(i).getSeats().size(); j++) {	
					seats.add(reservations.get(i).getSeats().get(j).toString());
				}
			}
		}
		
		return seats.toArray(new String[seats.size()]);
	}

	@Override
	public void delete(Projections p) {
		prepository.delete(p);
	}

	@Override
	public Projections addTicket(Ticket t, Long id) {
		
		Projections p = prepository.findOne(id);
		
		p.getTickets().add(t);
		t.setProjekcija(p);
		prepository.save(p);
		
		return p;
	}

	@Override
	public Projections deleteTicket(Ticket t, Long id) {
		
		Projections p = prepository.findOne(id);
		
		for(int i=0;i<p.getTickets().size();i++) {
		
			if(t.getId().equals(p.getTickets().get(i).getId())) {
				p.getTickets().get(i).setProjekcija(null);
				p.getTickets().remove(i);
				
			}
			
		}
		
		prepository.save(p);
		return p;
	}



}
