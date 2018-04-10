package rs.ac.uns.ftn.informatika.Cinema.controller;

import javax.servlet.http.HttpServletRequest;
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
import rs.ac.uns.ftn.informatika.Cinema.model.MoviePerformance;
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
	
	//Prikazuje filmske projekcije za dati bioskop
	@RequestMapping(value = "/getProjekcije/{id}" , method = RequestMethod.GET)
	public String projekcije(@PathVariable("id") Long id,ModelMap map) {
		
		map.put("bioskop",service.findOne(id));
		
		return "projekcije";
	}
	
	//Prikazuje predstave za dato pozoriste
	@RequestMapping(value = "/getPredstave/{id}" , method = RequestMethod.GET)
	public String predstave(@PathVariable("id") Long id,ModelMap map) {
		
		map.put("pozoriste",service.findOne(id));
	
		return "predstave";
	}
	
	
	@RequestMapping(value = "/updateProjekcije/{id}")
	public String editProjekcije(@PathVariable("id") Long id,ModelMap map) {
		
		map.put("projekcija",pservice.findOne(id));
		
		return "izmeniProjekcije";
	}
	
	
	@RequestMapping(value = "/updatePredstave/{id}")
	public String editPredstave(@PathVariable("id") Long id,ModelMap map) {
		
		map.put("predstava",pservice.findOne(id));
		
		return "izmeniPredstave";
	}
	
	
	@RequestMapping(value = "/updateProjekcije" , method = RequestMethod.POST)
	public String editProjekcije(@ModelAttribute("projekcija") MoviePerformance projekcija,ModelMap map,HttpServletRequest request) {
		

		MoviePerformance currentMovie =  pservice.findOne(projekcija.getId());
		
		currentMovie.setName(projekcija.getName());
		currentMovie.setGenre(projekcija.getGenre());
		currentMovie.setDuration(projekcija.getDuration());
		currentMovie.setDirector(projekcija.getDirector());
		currentMovie.setDescription(projekcija.getDescription());
		
		pservice.save(currentMovie);
		
		String referer = request.getHeader("Referer");
		
		return "redirect:"+ referer;
		//ovde bi trebalo da se namesti da gadja:
		//return "redirect:../cinematheatre/updateProjekcije/{id}"
		
	}
	
	
	@RequestMapping(value = "/updatePredstave" , method = RequestMethod.POST)
	public String editPredstave(@ModelAttribute("predstava") MoviePerformance predstava,ModelMap map,HttpServletRequest request) {
		
		MoviePerformance currentPerformance =  pservice.findOne(predstava.getId());
		
		currentPerformance.setName(predstava.getName());
		currentPerformance.setGenre(predstava.getGenre());
		currentPerformance.setDuration(predstava.getDuration());
		currentPerformance.setDirector(predstava.getDirector());
		currentPerformance.setDescription(predstava.getDescription());
		
		pservice.save(currentPerformance);
		
		String referer = request.getHeader("Referer");
		
		return "redirect:"+ referer;
		//ovde bi trebalo da se namesti da gadja:
		//return "redirect:../cinematheatre/updatePredstave/{id}"
		
	}


	@RequestMapping(value = "deletePredstave/{id}" , method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		pservice.delete(id);
		
		return "redirect:../getPredstave";
		
	}
	

 /*	@RequestMapping(value = "/deletePredstave/{id}" , method = RequestMethod.GET)
	public String deletePredstave(@PathVariable("id") Long id,HttpServletRequest request) {
		
		MoviePerformance predstava = pservice.findOne(id);
		
		String referer = request.getHeader("Referer");
		
		pservice.delete(predstava);
		
		return "redirect:"+ referer; 
		//bezveze dodato, posto svakako ne moze return "redirect:../cinematheatre/deletePredstave/{id}"
		
	}

	
	*/
	
}
