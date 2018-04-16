package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.Hall;
import rs.ac.uns.ftn.informatika.Cinema.model.NewProjectionsForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
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
		
		return form;
	}

	@Override
	public String[] getSeatConfiguration(Long id) {
		Projections projection = prepository.findOne(id);
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

}
