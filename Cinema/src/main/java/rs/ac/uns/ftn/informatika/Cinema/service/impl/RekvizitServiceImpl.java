package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.NewRekvizitForm;
import rs.ac.uns.ftn.informatika.Cinema.model.RekvizitForm;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.model.users.ProfileForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
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
		if(!rekvizit.isRezervisan())
		repository.delete(rekvizit);
	}

	@Override
	public ZvanicniRekvizit createNewZvanicniRekvizit(NewRekvizitForm rekvizitForm) {
		// TODO Auto-generated method stub
		ZvanicniRekvizit rekvizit = new ZvanicniRekvizit();
		rekvizit.setIme(rekvizitForm.getIme());
		rekvizit.setCena(rekvizitForm.getCena());
		rekvizit.setOpis(rekvizitForm.getOpis());
		
		return repository.save(rekvizit);
	}

	@Override
	public NewRekvizitForm setForm(ZvanicniRekvizit rekvizit) {
		// TODO Auto-generated method stub
		NewRekvizitForm forma = new NewRekvizitForm();
		forma.setCena(rekvizit.getCena());
		forma.setIme(rekvizit.getIme());
		forma.setOpis(rekvizit.getOpis());
		
		return forma;
	}
	
	@Override
	public ZvanicniRekvizit updateZvanicniRekvizit(RekvizitForm form) {
		ZvanicniRekvizit rekvizit = repository.findOne(form.getId());
		rekvizit.setIme(form.getIme());
		rekvizit.setCena(form.getCena());
		rekvizit.setOpis(form.getOpis());
		
		return repository.save(rekvizit);
	}


}
