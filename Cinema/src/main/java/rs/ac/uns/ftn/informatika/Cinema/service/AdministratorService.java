package rs.ac.uns.ftn.informatika.Cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.Cinema.model.users.Administrator;
import rs.ac.uns.ftn.informatika.Cinema.repository.AdministratorRepository;

@Service
public class AdministratorService {
	
	@Autowired
	public AdministratorRepository administratorRepository;
	
	public List<Administrator> findAll() {
		return administratorRepository.findAll();
	}
}
