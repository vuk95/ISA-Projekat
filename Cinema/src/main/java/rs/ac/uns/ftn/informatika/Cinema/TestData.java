package rs.ac.uns.ftn.informatika.Cinema;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatreType;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.RekvizitService;



@Component
public class TestData {

	@Autowired
	private RekvizitService service;
	
	@PostConstruct
	private void init(){
		
		ZvanicniRekvizit r1 = new ZvanicniRekvizit();
		r1.setIme("Ime");
		r1.setCena(100);
		r1.setOpis("Opis");
		service.save(r1);
		
		ZvanicniRekvizit r2 = new ZvanicniRekvizit();
		r2.setIme("Ime2");
		r2.setCena(200);
		r2.setOpis("Opis2");
		service.save(r2);
				
	}

}
