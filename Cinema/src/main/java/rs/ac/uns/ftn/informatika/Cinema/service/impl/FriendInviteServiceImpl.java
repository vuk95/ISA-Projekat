package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.users.FriendInvite;
import rs.ac.uns.ftn.informatika.Cinema.repository.FriendInviteRepository;
import rs.ac.uns.ftn.informatika.Cinema.repository.RegularUserRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.FriendInviteService;

@Service
@Transactional
public class FriendInviteServiceImpl implements FriendInviteService {

	@Autowired
	private FriendInviteRepository friendInviteRepository;
	
	@Autowired
	private RegularUserRepository regularUserRepository;

	@Override
	public FriendInvite makeFriendInvite(Long senderId, Long receiverId) {
		FriendInvite invite = new FriendInvite();
		
		invite.setSender(regularUserRepository.findOne(senderId));
		invite.setReceiver(regularUserRepository.findOne(receiverId));
		invite.setAccepted(false);
		
		return friendInviteRepository.save(invite);
	}
	
}
