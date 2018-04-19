package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.security.Principal;

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
import rs.ac.uns.ftn.informatika.Cinema.model.NewRekvizitForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Skala;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Administrator;
import rs.ac.uns.ftn.informatika.Cinema.model.users.NewAdminForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Role;
import rs.ac.uns.ftn.informatika.Cinema.model.users.User;
import rs.ac.uns.ftn.informatika.Cinema.service.AdministratorService;
import rs.ac.uns.ftn.informatika.Cinema.service.AllUsersService;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.SkalaService;

@Controller
public class SystemAdminController {
	
	@Autowired
	private AllUsersService userService;
	
	@Autowired
	private CinemaTheatreService cinemaService;
	
	@Autowired
	private AdministratorService adminService;
	
	@Autowired
	private SkalaService skalaService;
	
	@RequestMapping(value = "systemAdmin", method = RequestMethod.GET)
	public String home(Principal principal, ModelMap map) {

		if(userService.findUserByEmail(principal.getName()).getRole().equals(Role.SYSTEM)) {
			
			Administrator admin = (Administrator) userService.findUserByEmail(principal.getName());
			map.put("user", admin);
		}
		
		map.put("bioskopipozorista", cinemaService.findAll());
		map.put("skala", skalaService.findOne(new Long(1)));
		
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
	
	@RequestMapping(value = "systemAdmin/admini/addCTadmin", method = RequestMethod.GET)
	public String addAdminCT(ModelMap map) {
		
		map.put("admin", new NewAdminForm());
		return "dodajCTadmin";
		
	}
	
	@RequestMapping(value = "systemAdmin/admini/addCTadmin", method = RequestMethod.POST)
	public String addAdminiCT(@Valid @ModelAttribute("admin") NewAdminForm admin , BindingResult bindingResult, ModelMap map) {
		
		Administrator administrator = new Administrator();
		
		if(bindingResult.hasErrors()) {
			return "dodajCTadmin";
		}
		else {
			administrator = adminService.createNewAdminCT(admin);
			if(administrator == null) {
				map.put("erroradmin", "Vec postoji korisnik sa zadatim emailom!");
				return "dodajCTadmin";
			}
		}
	
		return "redirect:/systemAdmin/admini";
		
	}
	
	@RequestMapping(value = "systemAdmin/admini", method = RequestMethod.GET)
	public String addAdmini(ModelMap map, Principal principal) {
		
		Administrator admin = (Administrator) userService.findUserByEmail(principal.getName());
		
		map.put("administratori", adminService.findAll());
		map.put("admin", admin);
		
		return "admini";
		
	}
	
	@RequestMapping(value = "systemAdmin/admini/addFZadmin", method = RequestMethod.GET)
	public String addAdminFZ(ModelMap map) {
		
		map.put("admin", new NewAdminForm());
		return "dodajFZadmin";
		
	}
	
	@RequestMapping(value = "systemAdmin/admini/addFZadmin", method = RequestMethod.POST)
	public String addAdminiFZ(@Valid @ModelAttribute("admin") NewAdminForm admin , BindingResult bindingResult, ModelMap map) {
		
		Administrator administrator = new Administrator();
		
		if(bindingResult.hasErrors()) {
			return "dodajFZadmin";
		}
		else {
			administrator = adminService.createNewAdminFZ(admin);
			if(administrator == null) {
				map.put("erroradmin", "Vec postoji korisnik sa zadatim emailom!");
				return "dodajFZadmin";
			}
		}
	
		return "redirect:/systemAdmin/admini";
		
	}
	
	@RequestMapping(value = "systemAdmin/admini/addSystem", method = RequestMethod.GET)
	public String addSystem(ModelMap map) {
		
		map.put("admin", new NewAdminForm());
		return "dodajSystem";
		
	}
	
	@RequestMapping(value = "systemAdmin/admini/addSystem", method = RequestMethod.POST)
	public String addPozoristeBioskop(@Valid @ModelAttribute("admin") NewAdminForm admin ,BindingResult bindingResult, ModelMap map, Principal principal) {
		
		Administrator administrator = new Administrator();
		
		Administrator a  = (Administrator) userService.findUserByEmail(principal.getName());
		
		if(bindingResult.hasErrors()) {
			return "dodajSystem";
		}
		else {
			if(a.getRole().equals(Role.SYSTEM) && a.isPredefinisani()) {
			administrator = adminService.createNewAdminSystem(admin);
				if(administrator == null) {
					map.put("erroradmin", "Vec postoji korisnik sa zadatim emailom!");
					return "dodajSystem";
				}
			}
			else {
				map.put("error", "Nemate pravo na ovu akciju!");
				System.out.println("Ne mozete dodavati druge administratore sistema!");
				return "dodajSystem";
			}
		}
	
		return "redirect:/systemAdmin/admini";
	}
	
	@RequestMapping(value = "systemAdmin/postaviSkalu", method = RequestMethod.GET)
	public String postaviSkalu(ModelMap map) {
		
		Skala skala = new Skala();
		
		map.put("skala", skala);
		
		return "definisiSkalu";
		
	}
	
	@RequestMapping(value = "systemAdmin/prikaziSkalu", method = RequestMethod.GET)
	public String prikaziSkalu(ModelMap map) {
		
		Skala skala = skalaService.findOne(new Long(1));
		
		map.put("skala", skala);
		
		return "prikaziSkalu";
		
	}
	
	@RequestMapping(value = "systemAdmin/postaviSkalu", method = RequestMethod.POST)
	public String postaviSkalu(@Valid @ModelAttribute("skala") Skala newSkala, BindingResult bindingResult, ModelMap map) {
		
		Skala skala = new Skala();
		
		if(bindingResult.hasErrors()) {
			return "definisiSkalu";
		}
		
			
		skala.setId(new Long(1));
		skala.setBronzani(newSkala.getBronzani());
		skala.setSrebrni(newSkala.getSrebrni());
		skala.setZlatni(newSkala.getZlatni());
		skalaService.save(skala);
			
		
		
		return "redirect:../systemAdmin/prikaziSkalu";
	
	}

}
