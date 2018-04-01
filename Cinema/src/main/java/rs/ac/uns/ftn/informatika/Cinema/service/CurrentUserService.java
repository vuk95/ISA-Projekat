package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.users.CurrentUser;

public interface CurrentUserService {

	boolean canAccess(CurrentUser user, Long userId);
}
