package rs.ac.uns.ftn.informatika.Cinema.service;

import java.util.Set;

import rs.ac.uns.ftn.informatika.Cinema.model.users.FriendInvite;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

public interface FriendInviteService {

	public FriendInvite makeFriendInvite(Long senderId, Long receiverId);
	
	public Set<FriendInvite> getMyUnseenRequests(RegularUser receiver);
	
}
