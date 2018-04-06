package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.repository.OglasRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.OglasService;

@Service
@Transactional
public class OglasServiceImpl implements OglasService{

	@Autowired
	private OglasRepository repository;
	
	@Override
	public Iterable<Oglas> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Oglas find(Long id) {
		// TODO Auto-generated method stub
		return (Oglas) repository.getOne(id);
	}

	@Override
	public void save(Oglas oglas) {
		// TODO Auto-generated method stub
		repository.save(oglas);
	}

}
