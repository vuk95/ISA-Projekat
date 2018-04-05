package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
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
	
	@RequestMapping(value = "/updateCinema" , method = RequestMethod.POST)
	public String editCinema(@ModelAttribute("bioskop") CinemaTheatre bioskop,ModelMap map) {
		
		CinemaTheatre currentCinema = service.findOne(bioskop.getId());
		
		currentCinema.setName(bioskop.getName());
		currentCinema.setAddress(bioskop.getAddress());
		currentCinema.setDescription(bioskop.getDescription());
		
		service.save(currentCinema);
		
		return "redirect:../cinematheatre/getCinema";
	}
	
	@RequestMapping(value = "/updateTheatre" , method = RequestMethod.POST)
	public String editTheatre(@ModelAttribute("pozoriste") CinemaTheatre pozoriste ,ModelMap map) {
		
		CinemaTheatre currentTheatre = service.findOne(pozoriste.getId());
		
		currentTheatre.setName(pozoriste.getName());
		currentTheatre.setAddress(pozoriste.getAddress());
		currentTheatre.setDescription(pozoriste.getDescription());

	    service.save(currentTheatre);
		
	    return "redirect:../cinematheatre/getTheatre";
	}
	
}
