package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.users.NewUserForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.ProfileForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Role;
import rs.ac.uns.ftn.informatika.Cinema.repository.RegularUserRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.AllUsersService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Transactional
@Service
public class RegularUserServiceImpl implements RegularUserService {

	@Autowired
	public RegularUserRepository regUserRepository;
	
	@Autowired
	public AllUsersService allUserService;
	
	@Override
	public RegularUser findOne(Long Id) {
		return regUserRepository.findOne(Id);
	}

	@Override
	public List<RegularUser> findAll() {
		return regUserRepository.findAll();
	}
	
	@Override
	public RegularUser findByConfirmationToken(String confirmationToken) {
		return regUserRepository.findByConfirmationToken(confirmationToken);
	}
	
	@Override
	public RegularUser createNewRegularUser(NewUserForm newUser) {
		if(allUserService.emailExists(newUser.getEmail())) {
			return null;
		} else {
		
			RegularUser user = new RegularUser();
			user.setRole(Role.REGULAR);
			user.setEnabled(false);
			user.setConfirmationToken(UUID.randomUUID().toString());
			user.setEmail(newUser.getEmail());
			user.setName(newUser.getName());
			user.setLastname(newUser.getLastname());
			user.setCity(newUser.getCity());
			user.setPhone(newUser.getPhone());
			user.setPassword(newUser.getPassword());
			
			return regUserRepository.save(user);
		}
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

	@Override
	public RegularUser updateRegularUserProfile(ProfileForm form) {
		RegularUser user = regUserRepository.findOne(form.getId());
		user.setName(form.getName());
		user.setLastname(form.getLastname());
		user.setCity(form.getCity());
		user.setPhone(form.getPhone());
		
		return regUserRepository.save(user);
	}

}
