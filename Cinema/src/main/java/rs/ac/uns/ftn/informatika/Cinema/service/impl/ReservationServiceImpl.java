package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.model.Reservation;
import rs.ac.uns.ftn.informatika.Cinema.model.SeatDTO;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.repository.ProjectionsRepository;
import rs.ac.uns.ftn.informatika.Cinema.repository.RegularUserRepository;
import rs.ac.uns.ftn.informatika.Cinema.repository.ReservationRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.ReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ProjectionsRepository projectionsRepository;
	
	@Autowired
	private RegularUserRepository regularUserRepository;
	
	@Override
	public Reservation createNewReservation(SeatDTO res) {
		Reservation reservation = new Reservation();
		Projections projection = projectionsRepository.findOne(res.getProjectionId());
		RegularUser user = regularUserRepository.findOne(res.getUserId());
		
		reservation.setSeats(res.getSeats());
		reservation.setProjection(projection);
		reservation.setUser(user);
		
		return reservationRepository.save(reservation);
	}

	
}
