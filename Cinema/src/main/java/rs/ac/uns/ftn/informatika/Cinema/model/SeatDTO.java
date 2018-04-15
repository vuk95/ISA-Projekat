package rs.ac.uns.ftn.informatika.Cinema.model;

import java.util.ArrayList;
import java.util.List;

public class SeatDTO {

	private List<String> seats = new ArrayList<String>();
	
	public SeatDTO() {
		
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
	
}
