package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;

@Controller
@RequestMapping(value = "/cinematheatre")
public class PozoristaIBioskopiController {

	@Autowired
	private CinemaTheatreService service;
	
	//Puni model pronadjenim pozoristima
	@RequestMapping(value ="/getTheatre" , method = RequestMethod.GET )
	public String pozorista(ModelMap map) {
		
		map.put("pozorista",service.findTheatres()); //puni model po principu [key,value]
		
		return "pozorista"; //vraca pozorista.html
	}
	
	//Puni model pronadjenim bioskopima
	@RequestMapping(value = "/getCinema" , method = RequestMethod.GET)
	public String bioskopi(ModelMap map) {
		
		map.put("bioskopi",service.findCinemas());
		
		return "bioskopi";
	}
	
	
		
	@RequestMapping(value = "/updateTheatre/{id}" , method = RequestMethod.GET)
	public String editTheatre(@PathVariable("id") Long id, ModelMap map) {
		
		map.put("pozoriste",service.findOne(id));
		
		return "izmeniPozoriste";
	}
	
	@RequestMapping(value = "/updateCinema/{id}" , method = RequestMethod.GET)
	public String editCinema(@PathVariable("id") Long id, ModelMap map) {
		
		map.put("bioskop",service.findOne(id));
		
		return "izmeniBioskop";
	}
	
}
