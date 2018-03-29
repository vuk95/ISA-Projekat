package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Environment env;
	
	@Override
	@Async
	public void sendRegistrationMail(RegularUser user, String url) throws MailException, InterruptedException {
		//Mora da se iskljuci Mail Shield u avastu da ne bi pravilo problema
		
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Aktivacija korisnickog naloga");
		mail.setText("Da bi ste aktivirali svoj korisnicki nalog kliknite na: " + url + "/confirm?token=" + user.getConfirmationToken());
		mailSender.send(mail);
	}

}
