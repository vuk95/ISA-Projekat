package rs.ac.uns.ftn.informatika.Cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.informatika.Cinema.model.MoviePerformance;
import rs.ac.uns.ftn.informatika.Cinema.model.MoviePerformanceType;

@Repository
public interface ProjectionRepository  extends JpaRepository<MoviePerformance, Long> {

	List<MoviePerformance> findByType(MoviePerformanceType type);
	
}
