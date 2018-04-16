package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.Hall;
import rs.ac.uns.ftn.informatika.Cinema.repository.HallRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.HallService;

@Service
@Transactional
public class HallServiceImpl implements HallService {

	@Autowired
	private HallRepository repository;
	
	@Override
	public Hall findOne(Long id) {
		return repository.findOne(id);
	}

}
