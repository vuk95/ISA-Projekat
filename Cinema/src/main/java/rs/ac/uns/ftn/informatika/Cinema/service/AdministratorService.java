package rs.ac.uns.ftn.informatika.Cinema.service;

import java.util.List;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Administrator;
import rs.ac.uns.ftn.informatika.Cinema.model.users.FZAdminForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.NewAdminForm;

public interface AdministratorService {
	
		//Implementacija osnovnih CRUD operacija
	
		public Administrator findOne(Long Id);
		
		public List<Administrator> findAll();

		public Administrator save(Administrator admin);

		public List<Administrator> save(List<Administrator> admins);
			
		public Administrator delete(Long Id);
			
		public void delete(List<Long> ids);

		public Administrator createNewAdminCT(NewAdminForm newAdmin);

		public Administrator createNewAdminFZ(NewAdminForm newAdmin);

		public Administrator createNewAdminSystem(NewAdminForm newAdmin);

		public Administrator updateFZAdminProfile(FZAdminForm form);

		public Administrator updateFZAdminPassword(FZAdminForm form);
	
	
}


