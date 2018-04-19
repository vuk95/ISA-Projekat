package rs.ac.uns.ftn.informatika.Cinema.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.uns.ftn.informatika.Cinema.model.users.FriendInvite;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

@Repository
public interface FriendInviteRepository extends JpaRepository<FriendInvite, Long> {

	public Set<FriendInvite> findByReceiver(RegularUser receiver);
	
	public Set<FriendInvite> findBySender(RegularUser sender);
	
}
