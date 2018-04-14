package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.users.Administrator;
import rs.ac.uns.ftn.informatika.Cinema.model.users.FZAdminForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.NewAdminForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.NewUserForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.ProfileForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Role;
import rs.ac.uns.ftn.informatika.Cinema.repository.AdministratorRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.AdministratorService;
import rs.ac.uns.ftn.informatika.Cinema.service.AllUsersService;

@Transactional
@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	public AdministratorRepository administratorRepository;
	
	@Autowired
	public AllUsersService allUserService;
	
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
	
	@Override
	public Administrator createNewAdminCT(NewAdminForm newAdmin) {
		if(allUserService.emailExists(newAdmin.getEmail())) {
			return null;
		} else {
		
			Administrator admin = new Administrator();
			admin.setRole(Role.CINEMA_THEATRE);
			admin.setEnabled(true);
			admin.setFirstLogin(true);
			admin.setPredefinisani(false);
			admin.setEmail(newAdmin.getEmail());
			admin.setName(newAdmin.getName());
			admin.setLastname(newAdmin.getLastname());
			admin.setCity(newAdmin.getCity());
			admin.setPhone(newAdmin.getPhone());
			admin.setPassword(newAdmin.getPassword());
			
			return administratorRepository.save(admin);
		}
	}
	
	@Override
	public Administrator createNewAdminFZ(NewAdminForm newAdmin) {
		if(allUserService.emailExists(newAdmin.getEmail())) {
			return null;
		} else {
		
			Administrator admin = new Administrator();
			admin.setRole(Role.FAN_ZONE);
			admin.setEnabled(true);
			admin.setFirstLogin(true);
			admin.setPredefinisani(false);
			admin.setEmail(newAdmin.getEmail());
			admin.setName(newAdmin.getName());
			admin.setLastname(newAdmin.getLastname());
			admin.setCity(newAdmin.getCity());
			admin.setPhone(newAdmin.getPhone());
			admin.setPassword(newAdmin.getPassword());
			
			return administratorRepository.save(admin);
		}
	}
	
	@Override
	public Administrator createNewAdminSystem(NewAdminForm newAdmin) {
		if(allUserService.emailExists(newAdmin.getEmail())) {
			return null;
		} else {
		
			Administrator admin = new Administrator();
			admin.setRole(Role.SYSTEM);
			admin.setEnabled(true);
			admin.setFirstLogin(true);
			admin.setPredefinisani(false);
			admin.setEmail(newAdmin.getEmail());
			admin.setName(newAdmin.getName());
			admin.setLastname(newAdmin.getLastname());
			admin.setCity(newAdmin.getCity());
			admin.setPhone(newAdmin.getPhone());
			admin.setPassword(newAdmin.getPassword());
			
			return administratorRepository.save(admin);
		}
	}
	
	@Override
	public Administrator updateFZAdminProfile(FZAdminForm form) {
		Administrator user = administratorRepository.findOne(form.getId());
		user.setPassword(form.getPassword());
		user.setName(form.getName());
		user.setLastname(form.getLastname());
		user.setCity(form.getCity());
		user.setPhone(form.getPhone());
		
		return administratorRepository.save(user);
	}

	
	
}
