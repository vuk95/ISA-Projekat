package rs.ac.uns.ftn.informatika.Cinema.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.Cinema.model.users.NewUserForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

public interface RegularUserService {

		//Implementacija osnovnih CRUD operacija
	
		public RegularUser findOne(Long Id);
			
		public List<RegularUser> findAll();

		public RegularUser save(RegularUser regUser);

		public List<RegularUser> save(List<RegularUser> regUsers);
				
		public RegularUser delete(Long Id);
				
		public void delete(List<Long> ids);
		
		public RegularUser createNewRegularUser(NewUserForm userForm);

		public RegularUser findByConfirmationToken(String confirmationToken);
	
}
