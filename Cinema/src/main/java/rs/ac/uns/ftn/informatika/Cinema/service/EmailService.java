package rs.ac.uns.ftn.informatika.Cinema.service;

import org.springframework.mail.MailException;

import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

public interface EmailService {
	
	void sendRegistrationMail(RegularUser user, String url) throws MailException, InterruptedException;
	
	void sendReservationMail(RegularUser user, Projections projection) throws MailException, InterruptedException;
}
