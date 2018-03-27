package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.repository.RekvizitRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.RekvizitService;

@Transactional
@Service
public class RekvizitServiceImpl implements RekvizitService{

	@Autowired
	private RekvizitRepository repo;
	
	@Override
	public List<ZvanicniRekvizit> findAll() {
		return repo.findAll();
	}

	@Override
	public ZvanicniRekvizit save(ZvanicniRekvizit rekvizit) {
		return repo.save(rekvizit);
	}
	
	@Override
	public ZvanicniRekvizit delete(Long id) {
		ZvanicniRekvizit rekvizit = repo.findOne(id);
		if(rekvizit == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant product");
		}
		repo.delete(rekvizit);
		return rekvizit;
	}

	@Override
	public void update(Long id, ZvanicniRekvizit rekvizit) {
		repo.save(rekvizit);
	}

	@Override
	public ZvanicniRekvizit findOne(Long id) {
		ZvanicniRekvizit nadjeni = repo.findOne(id);
		return nadjeni;
	}
}
