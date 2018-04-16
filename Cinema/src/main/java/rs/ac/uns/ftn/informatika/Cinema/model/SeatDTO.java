package rs.ac.uns.ftn.informatika.Cinema.model;

import java.util.ArrayList;
import java.util.List;

public class SeatDTO {

	private List<String> seats = new ArrayList<String>();
	
	private Long projectionId;
	
	private Long userId;
	
	public SeatDTO() {
		
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}

	public Long getProjectionId() {
		return projectionId;
	}

	public void setProjectionId(Long projectionId) {
		this.projectionId = projectionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
