package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.Cinema.model.users.CurrentUser;
import rs.ac.uns.ftn.informatika.Cinema.model.users.User;
import rs.ac.uns.ftn.informatika.Cinema.service.AllUsersService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private AllUsersService allUsersService;
	
	@Override
	public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = allUsersService.findUserByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("No user found with this email:" + email);
		}
		
		return new CurrentUser(user);
	}

}
