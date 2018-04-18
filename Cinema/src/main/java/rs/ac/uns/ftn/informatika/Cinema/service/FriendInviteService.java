package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.users.FriendInvite;

public interface FriendInviteService {

	public FriendInvite makeFriendInvite(Long senderId, Long receiverId);
	
}
