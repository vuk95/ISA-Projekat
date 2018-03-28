package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Environment env;
	
	@Async
	public void sendMail(RegularUser user) throws MailException, InterruptedException{
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Aktivacija korisnickog naloga");
		mail.setText("Proba samo nesto nek pise: " + user.getName());
		mailSender.send(mail);
		
	}
}
