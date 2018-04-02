package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;

@RestController
@RequestMapping(value = "/cinema_theatre")
public class CinemaTheatreController {

	@Autowired
	private CinemaTheatreService ctservice;
	
	@RequestMapping(value = "/homeTheatres" , method = RequestMethod.GET)
	public String homeTheatres() {
		//sluzice samo za redirekciju na tu stranicu
		
		return "theatres";
		//gadja theatres.html
	}
	
	@RequestMapping(value = "/GetTheatres" , method = RequestMethod.GET)
	public String bioskopi(ModelMap map) {
		
		map.put("theatres",ctservice.findAll());
		
		return "theatres";
	}
	
	
	@RequestMapping(value = "/getCinemaTheatre" , method = RequestMethod.GET)
	public ResponseEntity<List<CinemaTheatre>> getCinemaTheatre() {
				
		List<CinemaTheatre> bioskopIpozorista = ctservice.findAll();
		
		return new ResponseEntity<>(bioskopIpozorista,HttpStatus.OK);
	}
	
	
	
	
}
