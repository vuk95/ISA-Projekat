package rs.ac.uns.ftn.informatika.Cinema.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.model.users.NewUserForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.ProfileForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

public interface RegularUserService {

		//Implementacija osnovnih CRUD operacija
	
		public RegularUser findOne(Long Id);
			
		public List<RegularUser> findAll();
		
		public RegularUser findByEmail(String email);

		public RegularUser save(RegularUser regUser);

		public List<RegularUser> save(List<RegularUser> regUsers);
				
		public RegularUser delete(Long Id);
				
		public void delete(List<Long> ids);
		
		public RegularUser createNewRegularUser(NewUserForm userForm);

		public RegularUser findByConfirmationToken(String confirmationToken);
		
		public RegularUser updateRegularUserProfile(ProfileForm form);
	
		public RegularUser addRekvizit(ZvanicniRekvizit r, Long Id);
}
