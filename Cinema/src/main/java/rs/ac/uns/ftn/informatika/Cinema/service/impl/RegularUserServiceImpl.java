package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.repository.RegularUserRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Transactional
@Service
public class RegularUserServiceImpl implements RegularUserService {

	@Autowired
	public RegularUserRepository regUserRepository;
	
	@Override
	public RegularUser findOne(Long Id) {
		return regUserRepository.findOne(Id);
	}

	@Override
	public List<RegularUser> findAll() {
		return regUserRepository.findAll();
	}

	@Override
	public RegularUser save(RegularUser regUser) {
		return regUserRepository.save(regUser);
	}

	@Override
	public List<RegularUser> save(List<RegularUser> regUsers) {
		return regUserRepository.save(regUsers);
	}

	@Override
	public RegularUser delete(Long Id) {

		RegularUser regUser = regUserRepository.findOne(Id);	
		
		if(regUser == null) {
			
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant regular user");
		}
		
			regUserRepository.delete(regUser);
		
		return regUser;
	}

	@Override
	public void delete(List<Long> ids) {
		
		for(Long id:ids) {
			
			this.delete(id);
			
		}
		
	}

}
