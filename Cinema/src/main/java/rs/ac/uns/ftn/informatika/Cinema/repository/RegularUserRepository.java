package rs.ac.uns.ftn.informatika.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

public interface RegularUserRepository extends JpaRepository<RegularUser, Long> {
	
}
