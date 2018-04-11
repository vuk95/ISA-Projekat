package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
