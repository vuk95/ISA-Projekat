package rs.ac.uns.ftn.informatika.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.ac.uns.ftn.informatika.Cinema.model.users.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long>{

}
