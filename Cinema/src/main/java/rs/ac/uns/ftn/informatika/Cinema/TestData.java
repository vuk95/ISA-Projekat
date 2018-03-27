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

	private CinemaTheatreType CINEMA = null;

	@Autowired
	private RekvizitService service;
	
	@Autowired
	private CinemaTheatreService ctservice;
	
	@PostConstruct
	private void init(){
		
		ZvanicniRekvizit r1 = new ZvanicniRekvizit("a.gif","Mac", 1000, "Sablja");
		service.save(r1);
		
		ZvanicniRekvizit r2 = new ZvanicniRekvizit("b.gif","Solja", 5000, "za kafu");
		service.save(r2);
		
		
		//CinemaTheatre ct = new CinemaTheatre("Bulevar Mihajla Pupina 3,Novi Sad","Jedan od najposecenijih bioskopa u zemlji","Arena Cineplex",CINEMA);
		//ctservice.save(ct);
		
		
	}
	
}
