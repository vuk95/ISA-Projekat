package rs.ac.uns.ftn.informatika.Cinema.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

public interface RegularUserRepository extends JpaRepository<RegularUser, Long> {
	
	public RegularUser findByEmailAndPassword(String email, String password);
	
	public RegularUser findByEmail(String email);
	
	public RegularUser findByConfirmationToken(String confirmationToken);
	
	public Set<RegularUser> findByName(String name);
	
	public Set<RegularUser> findByLastname(String lastname);
	
	public Set<RegularUser> findByNameAndLastname(String name, String lastname);
}
