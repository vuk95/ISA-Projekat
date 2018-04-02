package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.NewRekvizitForm;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.repository.RekvizitRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.RekvizitService;

@Service
@Transactional
public class RekvizitServiceImpl implements RekvizitService{

	@Autowired
	private RekvizitRepository repository;
	
	@Override
	public Iterable<ZvanicniRekvizit> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public ZvanicniRekvizit find(Long id) {
		// TODO Auto-generated method stub
		return (ZvanicniRekvizit) repository.getOne(id);
	}

	@Override
	public void save(ZvanicniRekvizit rekvizit) {
		// TODO Auto-generated method stub
		repository.save(rekvizit);
	}

	@Override
	public void delete(ZvanicniRekvizit rekvizit) {
		// TODO Auto-generated method stub
		repository.delete(rekvizit);
	}

	@Override
	public ZvanicniRekvizit createNewZvanicniRekvizit(NewRekvizitForm rekvizitForm) {
		// TODO Auto-generated method stub
		ZvanicniRekvizit rekvizit = new ZvanicniRekvizit();
		rekvizit.setSlika(rekvizitForm.getSlika());
		rekvizit.setIme(rekvizitForm.getIme());
		rekvizit.setCena(rekvizitForm.getCena());
		rekvizit.setOpis(rekvizitForm.getOpis());
		
		return repository.save(rekvizit);
	}

	@Override
	public NewRekvizitForm setForm(ZvanicniRekvizit rekvizit) {
		// TODO Auto-generated method stub
		NewRekvizitForm forma = new NewRekvizitForm();
		forma.setSlika(rekvizit.getSlika());
		forma.setCena(rekvizit.getCena());
		forma.setIme(rekvizit.getIme());
		forma.setOpis(rekvizit.getOpis());
		
		return forma;
	}


}
