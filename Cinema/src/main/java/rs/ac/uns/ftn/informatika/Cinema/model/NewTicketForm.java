package rs.ac.uns.ftn.informatika.Cinema.model;


public class NewTicketForm {

	private Projections projekcija;
	
	private String seat;
	
	private SeatType seatType;
	
	private int discount;
	
	private boolean rezervisana;
	
	public NewTicketForm() {
		
		
	}


	
	public Projections getProjekcija() {
		return projekcija;
	}


	public void setProjekcija(Projections projekcija) {
		this.projekcija = projekcija;
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



	public boolean isRezervisana() {
		return rezervisana;
	}



	public void setRezervisana(boolean rezervisana) {
		this.rezervisana = rezervisana;
	}
	
	
	
}
