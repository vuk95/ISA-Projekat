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
import rs.ac.uns.ftn.informatika.Cinema.model.NewProjectionsForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionsService;

@Controller
@RequestMapping(value = "/cinematheatre")
public class PozoristaIBioskopiController {

	@Autowired
	private CinemaTheatreService service;
	
	@Autowired
	private ProjectionsService pservice;
		
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
	public String editProjekcije(@Valid @ModelAttribute("projekcija") Projections projekcija,BindingResult result,ModelMap map,HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "izmeniProjekcije";
		}

		Projections currentMovie =  pservice.findOne(projekcija.getId());
		
		currentMovie.setName(projekcija.getName());
		currentMovie.setGenre(projekcija.getGenre());
		currentMovie.setDuration(projekcija.getDuration());
		currentMovie.setDirector(projekcija.getDirector());
		currentMovie.setDescription(projekcija.getDescription());
	/*	currentMovie.setActors(projekcija.getActors());
		currentMovie.setAvgraiting(projekcija.getAvgraiting());
		currentMovie.setDate(projekcija.getDate());
		currentMovie.setGenre(projekcija.getGenre());
		currentMovie.setPrice(projekcija.getPrice());
		currentMovie.setHall(projekcija.getHall());
	
	*/	
		pservice.save(currentMovie);
		
		String referer = request.getHeader("Referer");
		
		return "redirect:"+ referer;
		//ovde bi trebalo da se namesti da gadja:
		//return "redirect:../cinematheatre/updateProjekcije/{id}"
		
	}
	
	
	@RequestMapping(value = "/updatePredstave" , method = RequestMethod.POST)
	public String editPredstave(@Valid @ModelAttribute("predstava") Projections predstava,BindingResult result,ModelMap map,HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return "izmeniPredstave";
		}
		
		Projections currentPerformance =  pservice.findOne(predstava.getId());
		
		currentPerformance.setName(predstava.getName());
		currentPerformance.setGenre(predstava.getGenre());
		currentPerformance.setDuration(predstava.getDuration());
		currentPerformance.setDirector(predstava.getDirector());
		currentPerformance.setDescription(predstava.getDescription());
		//currentPerformance.setActors(predstava.getActors());
		//currentPerformance.setAvgraiting(predstava.getAvgraiting());
		//currentPerformance.setDate(predstava.getDate());
		//currentPerformance.setGenre(predstava.getGenre());
		//currentPerformance.setPrice(predstava.getPrice());
		//currentPerformance.setHall(predstava.getHall());
		
		pservice.save(currentPerformance);
		
		String referer = request.getHeader("Referer");
		
		return "redirect:"+ referer;
		//ovde bi trebalo da se namesti da gadja:
		//return "redirect:../cinematheatre/updatePredstave/{id}"
		
	}


	@RequestMapping(value = "/deleteProjekcije/{id}" , method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id,HttpServletRequest request) {
		
		pservice.delete(id);
		
		String referer = request.getHeader("Referer");
		
		return "redirect:"+ referer; 
		
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
	
	@RequestMapping(value = "/getProjekcije/{id}/addProjekcije" , method = RequestMethod.GET)
	public String addProjekcije(@PathVariable("id") Long id, ModelMap map) {
		
		map.put("bioskop", service.findOne(id));
		map.put("projekcija",new Projections());
		
		return "dodajProjekciju";
	}
	
	@RequestMapping(value = "/getProjekcije/{id}/addProjekcije" , method = RequestMethod.POST)
	public String addProjekcije(@PathVariable("id") Long id, @Valid @ModelAttribute("projekcija") NewProjectionsForm newProjection,BindingResult result,ModelMap map) {
		
		Projections projekcija = new Projections();
		
		if(result.hasErrors()) {
			return "dodajProjekciju";
		}
		
		if(!result.hasErrors()) {
			projekcija = pservice.createNewProjections(newProjection);
		}
		
		
		map.put("bioskop",service.findOne(id));		
		
		CinemaTheatre ct = service.addProjection(projekcija, id);
		service.save(ct);
		
		pservice.save(projekcija);
	
		return "redirect:/cinematheatre/getProjekcije/" + id;
	}
	
	@RequestMapping(value = "/getPredstave/{id}/addPredstave" , method = RequestMethod.GET)
	public String addPredstave(@PathVariable("id") Long id,ModelMap map) {
		
		map.put("pozoriste",service.findOne(id));
		map.put("predstava",new Projections());
		
		return "dodajPredstavu";
	}
	
	@RequestMapping(value = "/getPredstave/{id}/addPredstave" , method = RequestMethod.POST)
	public String addPredstave(@PathVariable("id") Long id,@Valid @ModelAttribute("predstava") NewProjectionsForm newPerformance,BindingResult result,ModelMap map) {
		
		Projections predstava = new Projections();
		
		if(result.hasErrors()) {
			return "dodajPredstavu";
		}
		
		if(!result.hasErrors()) {
			predstava = pservice.createNewProjections(newPerformance);
		}
		
		map.put("pozoriste",service.findOne(id));
		
		CinemaTheatre ct = service.addProjection(predstava, id);
		service.save(ct);
			
		pservice.save(predstava);
		
		return "redirect:/cinematheatre/getPredstave/" + id;
	}
	
	
	@RequestMapping(value = "/getReports")
	public String getReports() {
		
		return "reports";
	}
	
	@RequestMapping(value = "/raitingCinemas")
	public String raitingsOfCinemas(ModelMap map) {
		
		map.put("bioskopi",service.findCinemas());
		
		return "oceneBioskopi";
	}
	
	@RequestMapping(value = "/raitingTheatres")
	public String raitingsOfTheatres(ModelMap map) {
		
		map.put("pozorista",service.findTheatres());
		
		return "ocenePozorista";
	}
	
	@RequestMapping(value = "/raitingProjections")
	public String raitingsOfMovies(ModelMap map) {
		
		map.put("projekcije",pservice.findAll());
		
		return "oceneProjekcije";
	}
	
	
}
