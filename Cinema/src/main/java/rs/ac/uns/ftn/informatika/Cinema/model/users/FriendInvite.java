package rs.ac.uns.ftn.informatika.Cinema.model.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FriendInvite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	private RegularUser sender;
	
	@ManyToOne
	private RegularUser receiver;
	
	@Column
	private boolean accepted;
	
	@Column 
	private boolean seen;
	
	public FriendInvite() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public RegularUser getSender() {
		return sender;
	}

	public void setSender(RegularUser sender) {
		this.sender = sender;
	}

	public RegularUser getReceiver() {
		return receiver;
	}

	public void setReceiver(RegularUser receiver) {
		this.receiver = receiver;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	
}
