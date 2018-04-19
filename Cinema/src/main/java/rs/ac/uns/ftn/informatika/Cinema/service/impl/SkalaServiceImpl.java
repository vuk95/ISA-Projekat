package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.Skala;
import rs.ac.uns.ftn.informatika.Cinema.repository.SkalaRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.SkalaService;

@Service
@Transactional
public class SkalaServiceImpl implements SkalaService{

	@Autowired
	private SkalaRepository repository;
	
	@Override
	public void save(Skala s) {
		// TODO Auto-generated method stub
		repository.save(s);
	}

	@Override
	public Skala findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	
	
	
	
}
