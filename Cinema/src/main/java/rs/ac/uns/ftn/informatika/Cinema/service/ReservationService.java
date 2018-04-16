package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.Reservation;
import rs.ac.uns.ftn.informatika.Cinema.model.SeatDTO;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

public interface ReservationService {

	public Reservation createNewReservation(SeatDTO res);
	
}
