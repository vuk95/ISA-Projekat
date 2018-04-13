package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.List;

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

	@Override
	public Projections findMyProjectionById(Long ctId, Long pId) {
		Projections projection = null;
		CinemaTheatre ct = ctrepository.findOne(ctId);
		List<Projections> projections = ct.getProjections();
		
		for(Projections proj : projections) {
			if(proj.getId().equals(pId)) {
				projection = proj;
			}
		}
		
		return projection;
	}

	

}
