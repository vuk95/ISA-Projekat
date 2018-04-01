package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;

public interface RekvizitService {
	
	public Iterable<ZvanicniRekvizit> findAll();
	public ZvanicniRekvizit find(Long id);
	public void save(ZvanicniRekvizit rekvizit);
	public void delete(ZvanicniRekvizit rekvizit);

}
