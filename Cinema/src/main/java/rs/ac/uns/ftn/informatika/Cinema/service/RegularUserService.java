package rs.ac.uns.ftn.informatika.Cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.Cinema.repository.RegularUserRepository;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

@Service
public class RegularUserService {

	@Autowired
	private RegularUserRepository regularUserRepository;
	
	public List<RegularUser> findAll() {
		return regularUserRepository.findAll();
	}
	
}
