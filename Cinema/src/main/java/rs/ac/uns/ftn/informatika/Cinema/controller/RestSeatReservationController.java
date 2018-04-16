package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.Cinema.model.Reservation;
import rs.ac.uns.ftn.informatika.Cinema.model.SeatDTO;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionsService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;
import rs.ac.uns.ftn.informatika.Cinema.service.ReservationService;

@RestController
public class RestSeatReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ProjectionsService projectionsService;
	
	@Autowired
	private RegularUserService regularUserService;
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/api/seats/reservation")
	public ResponseEntity<?> makeReservation(@RequestBody SeatDTO seats) {
		//TODO: Ostao je jos feedback kod rezervacije mesta
		//		otkazivanje rezervacija
		Reservation reservation = reservationService.createNewReservation(seats);
		projectionsService.addReservation(reservation.getProjection(), reservation);
		regularUserService.addVisitedCinemaTheatre(reservation.getProjection().getCinemaTheatre(), seats.getUserId());
		regularUserService.addReservation(reservation, seats.getUserId());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
