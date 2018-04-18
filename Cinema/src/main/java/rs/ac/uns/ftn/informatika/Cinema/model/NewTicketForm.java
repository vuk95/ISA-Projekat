package rs.ac.uns.ftn.informatika.Cinema.model;


public class NewTicketForm {

	private Projections projection;
	
	private Hall hall;
	
	private String seat;
	
	private SeatType seatType;
	
	private int discount;
	
	
	
	public NewTicketForm() {
		
		
	}


	public Projections getProjection() {
		return projection;
	}



	public void setProjection(Projections projection) {
		this.projection = projection;
	}



	public Hall getHall() {
		return hall;
	}



	public void setHall(Hall hall) {
		this.hall = hall;
	}



	public String getSeat() {
		return seat;
	}



	public void setSeat(String seat) {
		this.seat = seat;
	}



	public SeatType getSeatType() {
		return seatType;
	}



	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}



	public int getDiscount() {
		return discount;
	}



	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
	
}
