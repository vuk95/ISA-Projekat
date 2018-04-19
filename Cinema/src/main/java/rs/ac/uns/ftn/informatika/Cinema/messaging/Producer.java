package rs.ac.uns.ftn.informatika.Cinema.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private SimpMessagingTemplate template;
	
	public void sendFriendRequestTo(Long userId) {
		this.template.convertAndSend("/topic/" + userId, "Novi zahtev");
	}
	
}
