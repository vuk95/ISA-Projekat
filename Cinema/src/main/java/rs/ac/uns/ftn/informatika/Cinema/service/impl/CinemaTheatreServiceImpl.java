package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.repository.CinemaTheatreRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;

@Transactional
@Service
public class CinemaTheatreServiceImpl implements CinemaTheatreService {

	@Autowired
	private CinemaTheatreRepository ctrepository;

	@Override
	public Iterable<CinemaTheatre> findAll() {
		return ctrepository.findAll();
	}

	@Override
	public void save(CinemaTheatre ct) {
		
		ctrepository.save(ct);
	}

	

}
