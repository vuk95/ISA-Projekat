package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatreType;
import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.repository.CinemaTheatreRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;

@Transactional
@Service
public class CinemaTheatreServiceImpl implements CinemaTheatreService {

	@Autowired
	private CinemaTheatreRepository ctrepository;
	
	@Override
	public CinemaTheatre findOne(Long id) {
		return ctrepository.findOne(id);
	}

	@Override
	public Iterable<CinemaTheatre> findAll() {
		return ctrepository.findAll();
	}

	@Override
	public void save(CinemaTheatre ct) {
		
		ctrepository.save(ct);
	}

	

	@Override
	public Iterable<CinemaTheatre> findCinemas() {
			
		return ctrepository.findByType(CinemaTheatreType.CINEMA);
		
	}

	@Override
	public Iterable<CinemaTheatre> findTheatres() {
		
		return ctrepository.findByType(CinemaTheatreType.THEATRE);
	}

	@Override
	public CinemaTheatre addProjection(Projections p, Long id) {
		
		CinemaTheatre ct = ctrepository.findOne(id);
		ct.getProjections().add(p);
		p.setCinemaTheatre(ct);
		ctrepository.save(ct);
			
		return ct;
	}

	

}
