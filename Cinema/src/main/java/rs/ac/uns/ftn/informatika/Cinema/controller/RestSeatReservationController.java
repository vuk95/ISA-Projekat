package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.Cinema.model.SeatDTO;

@RestController
public class RestSeatReservationController {

	@RequestMapping(value = "/api/seats/reservation")
	public ResponseEntity<?> makeReservation(@RequestBody SeatDTO reservation) {
		//TO DO: Napravi novu rezervaciju(dodaj u nju seatDto, usera i projekciju) i sacuvaj je u bazi
		//		 Stavi sva mesta na 'unavailable' koja su rezervisana
		//		 Obavesti nekako korisnika da su mu mesta rezervisana
		
		
		for(int i = 0; i < reservation.getSeats().size(); i++) {
			System.out.println("Rezervisano mesto: " + reservation.getSeats().get(i));
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
