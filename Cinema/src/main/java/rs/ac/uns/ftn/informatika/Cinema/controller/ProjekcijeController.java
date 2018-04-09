package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionService;

@Controller
@RequestMapping(value = "/movieperformance")
public class ProjekcijeController {

/*	@Autowired
	private ProjectionService service;
	
	@RequestMapping(value = "/getCinemaProjections" , method = RequestMethod.GET)
	public String bioskopProjekcije(ModelMap map) {
		
		map.put("repertoariBioskop",service.findMovies());
		
		return "repertoariBioksop";
	}
	
	*/
	
	
}
