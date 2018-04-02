package rs.ac.uns.ftn.informatika.Cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatreType;

@Repository
public interface CinemaTheatreRepository extends JpaRepository<CinemaTheatre,Long> {
	
	List<CinemaTheatre> findByType(CinemaTheatreType type);
}
