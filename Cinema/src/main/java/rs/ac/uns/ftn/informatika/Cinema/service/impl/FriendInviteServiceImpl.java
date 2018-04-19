package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.Cinema.model.users.FriendInvite;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
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
		invite.setSeen(false);
		
		return friendInviteRepository.save(invite);
	}

	@Override
	public Set<FriendInvite> getMyUnseenRequests(RegularUser receiver) {
		Set<FriendInvite> allrequests = friendInviteRepository.findByReceiver(receiver);
		Set<FriendInvite> unseenrequests = new HashSet<FriendInvite>();
		for(FriendInvite req : allrequests) {
			if(!req.isSeen()) {
				unseenrequests.add(req);
			}
		}
		
		return unseenrequests;
	}

	@Override
	public FriendInvite acceptRequest(Long requestId) {
		FriendInvite request = friendInviteRepository.findOne(requestId);
		request.setAccepted(true);
		request.setSeen(true);
		
		return friendInviteRepository.save(request);
	}

	@Override
	public FriendInvite declineRequest(Long requestId) {
		FriendInvite request = friendInviteRepository.findOne(requestId);
		request.setAccepted(false);
		request.setSeen(true);
		
		return friendInviteRepository.save(request);
	}

	@Override
	public Set<RegularUser> findMyFriends(RegularUser user) {
		Set<RegularUser> friends = new HashSet<RegularUser>();
		Set<FriendInvite> userIsSender = friendInviteRepository.findBySender(user);
		Set<FriendInvite> userIsReceiver = friendInviteRepository.findByReceiver(user);
		
		for(FriendInvite friend : userIsSender) {
			if(friend.isAccepted()) {
				friends.add(friend.getReceiver());
			}
		}
		
		for(FriendInvite friend : userIsReceiver) {
			if(friend.isAccepted()) {
				friends.add(friend.getSender());
			}
		}
		
		return friends;
	}

	@Override
	public Set<FriendInvite> findMyFriendInvites(RegularUser user) {
		Set<FriendInvite> friendInvites = new HashSet<FriendInvite>();
		Set<FriendInvite> userIsSender = friendInviteRepository.findBySender(user);
		Set<FriendInvite> userIsReceiver = friendInviteRepository.findByReceiver(user);
		
		for(FriendInvite invite : userIsSender) {
			if(invite.isAccepted()) {
				friendInvites.add(invite);
			}
		}
		
		for(FriendInvite invite : userIsReceiver) {
			if(invite.isAccepted()) {
				friendInvites.add(invite);
			}
		}
		
		return friendInvites;
	}
	
}
