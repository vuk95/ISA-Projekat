package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.users.Administrator;
import rs.ac.uns.ftn.informatika.Cinema.repository.AdministratorRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.AdministratorService;

@Transactional
@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	public AdministratorRepository administratorRepository;
		
	@Override
	public Administrator findOne(Long Id) {
		return administratorRepository.findOne(Id);
	}

	@Override
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}

	@Override
	public Administrator save(Administrator admin) {
		return administratorRepository.save(admin);
	}

	@Override
	public List<Administrator> save(List<Administrator> admins) {
		return administratorRepository.save(admins);
	}

	@Override
	public Administrator delete(Long Id) {
		
		Administrator admin = administratorRepository.findOne(Id);
		
		if(admin == null) {
			
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant admin");
		}
		
			administratorRepository.delete(admin);
		
		return admin;
	}

	@Override
	public void delete(List<Long> ids) {
	
		for(Long id:ids) {
			
			this.delete(id);
			
		}
	}

	
	
}
