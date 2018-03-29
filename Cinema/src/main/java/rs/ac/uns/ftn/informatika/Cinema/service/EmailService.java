package rs.ac.uns.ftn.informatika.Cinema.service;

import org.springframework.mail.MailException;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

public interface EmailService {
	
	void sendRegistrationMail(RegularUser user, String url) throws MailException, InterruptedException;
}
