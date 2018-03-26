package rs.ac.uns.ftn.informatika.Cinema.service;

import rs.ac.uns.ftn.informatika.Cinema.model.users.User;

public interface AllUsersService {

	public User findUser(String email, String password);
	
	public User findUserByEmail(String email);

	boolean emailExists(String email);
	
}
