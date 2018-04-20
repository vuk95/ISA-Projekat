package rs.ac.uns.ftn.informatika.Cinema.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.NewProjectionsForm;
import rs.ac.uns.ftn.informatika.Cinema.model.NewTicketForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Administrator;
import rs.ac.uns.ftn.informatika.Cinema.model.users.FZAdminForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Role;
import rs.ac.uns.ftn.informatika.Cinema.model.users.User;
import rs.ac.uns.ftn.informatika.Cinema.service.AdministratorService;
import rs.ac.uns.ftn.informatika.Cinema.service.AllUsersService;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionsService;
import rs.ac.uns.ftn.informatika.Cinema.service.TicketService;


@Controller
@RequestMapping(value = "/cinematheatre")
public class PozoristaIBioskopiController {

	@Autowired
	private CinemaTheatreService service;
	
	@Autowired
	private ProjectionsService pservice;
	
	@Autowired
	private AllUsersService allService;
	
	@Autowired
	private TicketService tservice;
	
	@Autowired
	private AdministratorService adminService;
	
	//@Autowired
	//private HallService hservice;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap map, Principal principal) {
		
		User user = allService.findUserByEmail(principal.getName());
		
		
		if(user.getRole().equals(Role.CINEMA_THEATRE)) {
			
			Administrator admin = (Administrator) user;
	
			if(admin.isFirstLogin()) {
				
				map.put("admin", admin);
				System.out.println(admin.isFirstLogin());
				
				return "cinemaFirstLogin";
			}
			else {
				map.put("admin", admin);
				//ovde ce posle ici pravi homepage ali nmg da prebacim zbog toga sto nije u templates
				return "homePageCTAdmin";
			}
		}
		
		return "homePageCTAdmin";
		
	}
	
		@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
		@RequestMapping(value = "/profile/{id}/editpass", method = RequestMethod.PUT)
		public String putEditPassword(@ModelAttribute("admin") Administrator admin, @PathVariable Long id, ModelMap map, Principal principal) {
		
			Administrator administrator = adminService.findOne(id);
			if(!administrator.getPassword().equals(admin.getPassword())) {
				
				administrator.setPassword(admin.getPassword());
				administrator.setFirstLogin(false);
				adminService.save(administrator);
			
				//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				//CurrentUser user = (CurrentUser) auth.getPrincipal();
				map.put("admin", administrator);
			}
			else {
				System.out.println("Morate promeniti lozinku!");
				return "cinemaFirstLogin";
			}
			
			return "redirect:/cinematheatre/home";
		}
	
		@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
		@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
		public String showProfile(@PathVariable Long id, ModelMap map) {
			
			Administrator admin = adminService.findOne(id);
			if(admin.getRole().equals(Role.CINEMA_THEATRE)) {
			map.put("user", admin);
			}
			return "ctprofile";
		}
		@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
		@RequestMapping(value = "/profile/{id}/edit", method = RequestMethod.GET)
		public String editProfile(@PathVariable Long id, ModelMap map) {
			
			Administrator admin = adminService.findOne(id);
			FZAdminForm user = new FZAdminForm(admin);
			map.put("user", user);
			return "cteditprofile";
		}
		
		@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
		@RequestMapping(value = "/profile/{id}/edit", method = RequestMethod.PUT)
		public String putEditProfile(@ModelAttribute("user") FZAdminForm form, @PathVariable Long id) {
			
			adminService.updateFZAdminProfile(form);
			return "redirect:/cinematheatre/profile/" + id;
		}	
	
		
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
	
	//stranica koju mogu da vide svi sem admina bioskopa/pozorista
	@RequestMapping(value = "/getBioskopi" , method = RequestMethod.GET)
	public String cinemas(ModelMap map) {
		
		map.put("bioskopi",service.findCinemas());
		
	    return "bioskopiOstali";
	}
	
	//stranica koju mogu da vide svi sem admina bioskopa/pozorista
		@RequestMapping(value = "/getPozorista" , method = RequestMethod.GET)
		public String theatres(ModelMap map) {
			
			map.put("pozorista",service.findTheatres());
			
		    return "pozoristaOstali";
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

	//Prikazuje filmske projekcije za dati bioskop
			@RequestMapping(value = "/getProjection/{id}" , method = RequestMethod.GET)
			public String projection(@PathVariable("id") Long id,ModelMap map) {
				
				map.put("bioskop",service.findOne(id));
						
				return "projekcijeOstali";
		}


	//Prikazuje predstave za dato pozoriste
	@RequestMapping(value = "/getPredstave/{id}" , method = RequestMethod.GET)
	public String predstave(@PathVariable("id") Long id,ModelMap map) {
		
		map.put("pozoriste",service.findOne(id));
	
		return "predstave";
	}
	
	//Prikazuje predstave za dato pozoriste
			@RequestMapping(value = "/getPerformance/{id}" , method = RequestMethod.GET)
			public String performance(@PathVariable("id") Long id,ModelMap map) {
				
				map.put("pozoriste",service.findOne(id));
			
				return "predstaveOstali";
			}
		

	
	@RequestMapping(value = "/updateProjekcije/{id}")
	public String editProjekcije(@PathVariable("id") Long id,ModelMap map) {
		
		map.put("projekcija",pservice.findOne(id));
		
		return "izmeniProjekcije";
	}
	
	
	@RequestMapping(value = "/updatePredstave/{id}")
	public String editPredstave(@PathVariable("id") Long id,ModelMap map) {
		
		//map.put("bioskop",service.findOne(id));
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
		currentMovie.setAvgraiting(projekcija.getAvgraiting());
		currentMovie.setPrice(projekcija.getPrice());
		currentMovie.setActors(projekcija.getActors());
		currentMovie.setDate(projekcija.getDate());
		currentMovie.setTime(projekcija.getTime());
		currentMovie.setHall(projekcija.getHall());
		
		pservice.save(currentMovie);
		
		return "redirect:/cinematheatre/getProjekcije/" + currentMovie.getCinemaTheatre().getId();
				
	}
	
	
	@RequestMapping(value = "/updatePredstave" , method = RequestMethod.POST)
	public String editPredstave(@Valid @ModelAttribute("predstava") Projections predstava,BindingResult result,ModelMap map) {
		
		if(result.hasErrors()) {
			return "izmeniPredstave";
		}
		
		Projections currentPerformance =  pservice.findOne(predstava.getId());
		
		currentPerformance.setName(predstava.getName());
		currentPerformance.setGenre(predstava.getGenre());
		currentPerformance.setDuration(predstava.getDuration());
		currentPerformance.setDirector(predstava.getDirector());
		currentPerformance.setDescription(predstava.getDescription());
		currentPerformance.setAvgraiting(predstava.getAvgraiting());
		currentPerformance.setPrice(predstava.getPrice());
		currentPerformance.setActors(predstava.getActors());
		currentPerformance.setDate(predstava.getDate());
		currentPerformance.setTime(predstava.getTime());
		currentPerformance.setHall(predstava.getHall());
		
		pservice.save(currentPerformance);
		
		return "redirect:/cinematheatre/getPredstave/" + currentPerformance.getCinemaTheatre().getId();
		
	}


	@RequestMapping(value = "/deleteProjekcije/{id}" , method = RequestMethod.GET)
	public String deleteMovie(@PathVariable("id") Long id) {
		
		Projections p = pservice.findOne(id);
		
		CinemaTheatre ct = service.deleteProjection(p,p.getCinemaTheatre().getId());
		//pservice.delete(p);
		service.save(ct);
			
		return "redirect:/cinematheatre/getProjekcije/" + ct.getId(); 
		
	}

	@RequestMapping(value = "/deletePredstave/{id}" , method = RequestMethod.GET)
	public String deletePerformance(@PathVariable("id") Long id) {
		
		Projections p = pservice.findOne(id);
		
		CinemaTheatre ct = service.deleteProjection(p,p.getCinemaTheatre().getId());
		//pservice.delete(p);
		service.save(ct);
			
		return "redirect:/cinematheatre/getPredstave/" + ct.getId(); 
		
	}
	
	
	
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
	
	@RequestMapping(value = "/getReports/raitingCinemas")
	public String raitingsOfCinemas(ModelMap map) {
		
		map.put("bioskopi",service.findCinemas());
		
		return "oceneBioskopi";
	}
	
	@RequestMapping(value = "/getReports/raitingTheatres")
	public String raitingsOfTheatres(ModelMap map) {
		
		map.put("pozorista",service.findTheatres());
		
		return "ocenePozorista";
	}
	
	@RequestMapping(value = "/getReports/raitingProjections")
	public String raitingsOfMovies(ModelMap map) {
		
		map.put("projekcije",pservice.findAll());
		
		return "oceneProjekcije";
	}
	
 	@RequestMapping(value = "/getReports/cinemaVisitGraphic")
	public String cinemaGraphic() {
				
		return "cinemaGraphic";
	}

	
	@RequestMapping(value = "getCinema/{id}/tickets",method = RequestMethod.GET)
	public String cinemaDiscountTickets(@PathVariable("id") Long id, ModelMap map) {
			
		map.put("bioskop",service.findOne(id));
		map.put("karte",tservice.findTickets(id));
		
		return "ticket";
	} 
	
	
	@RequestMapping(value = "getTheatre/{id}/tickets")
	public String theatreDiscountTicket(@PathVariable("id") Long id,ModelMap map) {
		
		map.put("pozoriste",service.findOne(id));
		map.put("karte",tservice.findTickets(id));

		return "ticketPozoriste";
	}
	
 	@RequestMapping("/cinemaTicketsReserve/{id}")
	public String reserveCinemaTickets(@PathVariable("id") Long id,ModelMap map) {
		
		Ticket karta = tservice.findOne(id);
		
		if(karta.isRezervisana()==false) {
			karta.setRezervisana(true);
			tservice.save(karta);
		
			map.put("karta", karta);
		
		}
		
		return "redirect:/cinematheatre/getCinema/" +  karta.getProjekcija().getCinemaTheatre().getId()  + "/tickets";
	}
	
 	@RequestMapping("/theatreTicketsReserve/{id}")
 	public String reserveTheatreTickets(@PathVariable("id") Long id,ModelMap map) {
 		
 		Ticket karta = tservice.findOne(id);
		
		if(karta.isRezervisana()==false) {
			karta.setRezervisana(true);
			tservice.save(karta);
		
			map.put("karta", karta);
		
		}
		
		return "redirect:/cinematheatre/getTheatre/" + karta.getProjekcija().getCinemaTheatre().getId() + "/tickets";
 	
 	}
 	
 	@RequestMapping(value = "/getCinema/{id}/addCinemaTickets" ,method = RequestMethod.GET)
 	public String addCinemaTicket(@PathVariable("id") Long id ,ModelMap map) {
 		
 		map.put("bioskop",service.findOne(id));
 		map.put("karta",new Ticket());
 		
 		return "dodajKartuNaPopustu";
 	}
 	
 	@RequestMapping(value = "/getCinema/{id}/addCinemaTickets" , method = RequestMethod.POST)
	public String addCinemaTicket(@PathVariable("id") Long id,@ModelAttribute("karta") NewTicketForm cinemaTicket,ModelMap map) {
		
 		Ticket karta = new Ticket();
 		
 		karta  = tservice.createNewDiscountTicket(cinemaTicket);
 		
 		map.put("projekcija",pservice.findOne(karta.getProjekcija().getId()));
 		map.put("bioskop",service.findOne(id));
 		
 		Projections p = pservice.addTicket(karta,karta.getProjekcija().getId());
 		pservice.save(p);
 		
 		tservice.save(karta);
 		
		return "redirect:/cinematheatre/getCinema/" + id + "/tickets";
	}
 	
 	@RequestMapping(value = "/getTheatre/{id}/addTheatreTickets" ,method = RequestMethod.GET)
 	public String adTheatreTicket(@PathVariable("id") Long id ,ModelMap map) {
 		
 		map.put("pozoriste",service.findOne(id));
 		map.put("karta",new Ticket());
 		
 		return "dodajPozorisneKartePopust";
 	}
 	
 	@RequestMapping(value = "/getTheatre/{id}/addTheatreTickets" , method = RequestMethod.POST)
	public String addTheatreTicket(@PathVariable("id") Long id,@ModelAttribute("karta") NewTicketForm cinemaTicket,ModelMap map) {
		
 		Ticket karta = new Ticket();
 		
 		karta  = tservice.createNewDiscountTicket(cinemaTicket);
 		
 		map.put("projekcija",pservice.findOne(karta.getProjekcija().getId()));
 		map.put("pozoriste",service.findOne(id));
 		
 		Projections p = pservice.addTicket(karta,karta.getProjekcija().getId());
 		pservice.save(p);
 		
 		tservice.save(karta);
 		
		return "redirect:/cinematheatre/getTheatre/" + id + "/tickets";
	}
 	
 	@RequestMapping(value = "/deleteCinemaTicket/{id}" ,  method = RequestMethod.GET)
 	public String deleteDiscountCinemaTicket(@PathVariable("id") Long id,ModelMap map) {
 		
 		Ticket t = tservice.findOne(id);
 		
 		Projections p = pservice.deleteTicket(t, t.getProjekcija().getId());
 		pservice.save(p);
 		
 		tservice.delete(t);
 		
 		
 		return "redirect:/cinematheatre/getCinema/" + p.getCinemaTheatre().getId() + "/tickets";
 	}
 	
 	
 	@RequestMapping(value = "/deleteTheatreTicket/{id}" ,  method = RequestMethod.GET)
 	public String deleteDiscountThetatreTicket(@PathVariable("id") Long id,ModelMap map) {
 		
 		Ticket t = tservice.findOne(id);
 		
 		Projections p = pservice.deleteTicket(t, t.getProjekcija().getId());
 		pservice.save(p);
 		
 		tservice.delete(t);
 		
 		
 		return "redirect:/cinematheatre/getTheatre/" + p.getCinemaTheatre().getId() + "/tickets";
 	}
 	
}
