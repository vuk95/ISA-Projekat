package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.Cinema.model.users.User;
import rs.ac.uns.ftn.informatika.Cinema.repository.AdministratorRepository;
import rs.ac.uns.ftn.informatika.Cinema.repository.RegularUserRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.AllUsersService;

@Service
public class AllUsersServiceImpl implements AllUsersService {
	
	@Autowired
	private RegularUserRepository regularUserRepository;
	
	@Autowired
	private AdministratorRepository administratorRepository;

	@Override
	public User findUser(String email, String password) {
		if((administratorRepository.findByEmailAndPassword(email, password)) != null) {
			return administratorRepository.findByEmailAndPassword(email, password);
		} else if((regularUserRepository.findByEmail(email)) != null) {
			return regularUserRepository.findByEmailAndPassword(email, password);
		} else {
			return null;
		}
	}

	@Override
	public User findUserByEmail(String email) {
		if((regularUserRepository.findByEmail(email)) != null) {
			return regularUserRepository.findByEmail(email);
		} else if ((administratorRepository.findByEmail(email)) != null) {
			return administratorRepository.findByEmail(email);
		} else {
			System.out.println("Nikog nisam nasao sa emailom " + email);
			return null;
		}
	}
	
	@Override
	public boolean emailExists(String email) {
		if((regularUserRepository.findByEmail(email)) != null) {
			return true;
		} else if ((administratorRepository.findByEmail(email)) != null) {
			return true;
		} else {
			return false;
		}
	}
	
}
