package rs.ac.uns.ftn.informatika.Cinema.model;

public class SeatsResponse {

	private boolean send;
	
	private String message;
	
	public SeatsResponse() {
		
	}

	public boolean isSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
