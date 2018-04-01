package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.Cinema.model.users.CurrentUser;
import rs.ac.uns.ftn.informatika.Cinema.service.CurrentUserService;

@Service
public class CurrentUserServiceImpl implements CurrentUserService{

	@Override
	public boolean canAccess(CurrentUser user, Long userId) {
		return user != null && user.getId().equals(userId);
	}

}
