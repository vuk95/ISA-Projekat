package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.NewRekvizitForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Ponuda;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.repository.PonudaRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.PonudaService;

@Service
@Transactional
public class PonudaServiceImpl implements PonudaService{

	@Autowired
	private PonudaRepository repository;
	
	@Override
	public Iterable<Ponuda> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Ponuda find(Long id) {
		// TODO Auto-generated method stub
		return repository.getOne(id);
	}

	@Override
	public void save(Ponuda ponuda) {
		// TODO Auto-generated method stub
		repository.save(ponuda);
	}

}
