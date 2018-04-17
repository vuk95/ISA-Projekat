package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.Reservation;
import rs.ac.uns.ftn.informatika.Cinema.model.SeatDTO;

public interface ReservationService {

	public Reservation createNewReservation(SeatDTO res);
	
	public Reservation delete(Long id);
	
	public Reservation logicalDelete(Long id);
	
}
