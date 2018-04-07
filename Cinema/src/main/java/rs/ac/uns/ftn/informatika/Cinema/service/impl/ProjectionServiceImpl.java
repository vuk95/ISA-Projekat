package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.MoviePerformance;
import rs.ac.uns.ftn.informatika.Cinema.model.MoviePerformanceType;
import rs.ac.uns.ftn.informatika.Cinema.repository.ProjectionRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionService;

@Service
@Transactional
public class ProjectionServiceImpl implements ProjectionService {

	@Autowired
	private ProjectionRepository prepository;
	
	@Override
	public MoviePerformance findOne(Long id) {
		return prepository.findOne(id);
	}

	@Override
	public Iterable<MoviePerformance> findAll() {
		return prepository.findAll();
	}

	@Override
	public Iterable<MoviePerformance> findMovies() {
		return prepository.findByType(MoviePerformanceType.MOVIE);
	}

	@Override
	public Iterable<MoviePerformance> findPerformances() {
		return prepository.findByType(MoviePerformanceType.PERFORMANCE);
	}

	@Override
	public void save(MoviePerformance mp) {
		prepository.save(mp);
	}

	
}
