package rs.ac.uns.ftn.informatika.Cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;

@Repository
public interface OglasRepository extends JpaRepository<Oglas, Long>{

	
}
