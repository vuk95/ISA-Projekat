package rs.ac.uns.ftn.informatika.Cinema.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionService;

@Controller
@RequestMapping(value = "/cinematheatre")
public class PozoristaIBioskopiController {

	@Autowired
	private CinemaTheatreService service;
		
	@Autowired
	private ProjectionService pservice;
	
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
	public String editCinema(@Valid @ModelAttribute("bioskop") CinemaTheatre bioskop,BindingResult result,ModelMap map) {
		
		//Ako ima gresaka ostani na toj stranici
		if(result.hasErrors()) {
			return "izmeniBioskop";
		}
		
		CinemaTheatre currentCinema = service.findOne(bioskop.getId());
		
		currentCinema.setName(bioskop.getName());
		currentCinema.setAddress(bioskop.getAddress());
		currentCinema.setDescription(bioskop.getDescription());
		
		service.save(currentCinema);
		
		return "redirect:../cinematheatre/getCinema";
	}
	
	@RequestMapping(value = "/updateTheatre" , method = RequestMethod.POST)
	public String editTheatre(@Valid @ModelAttribute("pozoriste") CinemaTheatre pozoriste,BindingResult result,ModelMap map) {
		
		//Ako ima gresaka ostani na toj stranici
		if(result.hasErrors()) {
			return "izmeniPozoriste";
		}
		
		CinemaTheatre currentTheatre = service.findOne(pozoriste.getId());
		
		currentTheatre.setName(pozoriste.getName());
		currentTheatre.setAddress(pozoriste.getAddress());
		currentTheatre.setDescription(pozoriste.getDescription());

	    service.save(currentTheatre);
		
	    return "redirect:../cinematheatre/getTheatre";
	}
	
	@RequestMapping(value = "/getProjekcije" , method = RequestMethod.GET)
	public String projekcije(ModelMap map) {
		
		map.put("projekcije",pservice.findMovies());
		
		return "projekcije";
	}
	
	@RequestMapping(value = "/getPredstave" , method = RequestMethod.GET)
	public String predstave(ModelMap map) {
		
		map.put("predstave",pservice.findPerformances());
	
		return "predstave";
	}
	
}
