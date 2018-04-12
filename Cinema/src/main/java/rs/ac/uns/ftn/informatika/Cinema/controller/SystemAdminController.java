package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Administrator;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Role;
import rs.ac.uns.ftn.informatika.Cinema.service.AllUsersService;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;

@Controller
public class SystemAdminController {
	
	@Autowired
	private AllUsersService userService;
	
	@Autowired
	private CinemaTheatreService cinemaService;
	
	
	@RequestMapping(value = "systemAdmin", method = RequestMethod.GET)
	public String home(Principal principal, ModelMap map) {

		if(userService.findUserByEmail(principal.getName()).getRole().equals(Role.SYSTEM)) {
			
			Administrator admin = (Administrator) userService.findUserByEmail(principal.getName());
			map.put("user", admin);
		}
		
		map.put("bioskopipozorista", cinemaService.findAll());
		
		return "systemAdminPage";
	}
	
	@RequestMapping(value = "systemAdmin/addCT", method = RequestMethod.GET)
	public String addPozoristeBioskop(ModelMap map) {
		
		map.put("ct", new CinemaTheatre());
		return "dodajCT";
		
	}
	
	@RequestMapping(value = "systemAdmin/addCT", method = RequestMethod.POST)
	public String addPozoristeBioskop(@Valid @ModelAttribute("ct") CinemaTheatre ct , BindingResult bindingResult, ModelMap map) {
		
		if(bindingResult.hasErrors()) {
			return "dodajCT";
		}
		
		cinemaService.save(ct);
		return "redirect:/systemAdmin";
		
	}

}
