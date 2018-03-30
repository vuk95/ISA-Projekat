package rs.ac.uns.ftn.informatika.Cinema.model.users;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	private User user;

	public CurrentUser(User user) {
		//super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, 
				AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public Long getId() {
		return user.getId();
	}
	
	public Role getRole() {
		return user.getRole();
	}
	
}
