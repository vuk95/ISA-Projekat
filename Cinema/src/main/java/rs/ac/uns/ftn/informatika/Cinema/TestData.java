package rs.ac.uns.ftn.informatika.Cinema;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatreType;
import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.OglasService;
import rs.ac.uns.ftn.informatika.Cinema.service.RekvizitService;



@Component
public class TestData {

	@Autowired
	private RekvizitService service;
	
	@Autowired
	private OglasService oglService;
	
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
		
		//IMA NEKI ERROR KADA OVO OBRISEM NE RADI KAKO TREBA BACA EXCEPTION NA DRUGU PONUDU!!!
		Oglas o = new Oglas();
		o.setNaziv("Naziv");
		o.setOpis("Opis");
		//o.setDatum("datum");
		oglService.save(o);
		
		Oglas o1 = new Oglas();
		o1.setNaziv("Naziv2");
		o1.setOpis("Opis2");
		//o1.setDatum("datum2");
		oglService.save(o1);
		
		Oglas o2 = new Oglas();
		o2.setNaziv("Naziv3");
		o2.setOpis("Opis3");
		//o2.setDatum("datum3");
		oglService.save(o2);
				
	}

}
