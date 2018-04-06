package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.uns.ftn.informatika.Cinema.model.NewRekvizitForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.model.users.CurrentUser;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.OglasService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;
import rs.ac.uns.ftn.informatika.Cinema.service.RekvizitService;


@Controller
@RequestMapping("/fanzone")
public class FanZoneController {

	@Autowired
	private RekvizitService servis;
	
	@Autowired
	private RegularUserService userServis;
	
	@Autowired
	private OglasService oglServis;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap map) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser user = (CurrentUser) auth.getPrincipal();
		
		map.put("logged", user);
		
		return "fanzone";
		
	}
	
	@RequestMapping(value = "/getRekviziti", method = RequestMethod.GET)
	public String rekviziti(ModelMap map) {
		
		map.put("rekviziti", servis.findAll());
		return "rekviziti";
		
	}
	
	@RequestMapping(value = "/getRekvizitiObican", method = RequestMethod.GET)
	public String rekvizitiObican(ModelMap map) {
		
		map.put("rekviziti", servis.findAll());
		return "rekvizitiObican";
		
	}
	
	@RequestMapping(value = "/getOglasi", method = RequestMethod.GET)
	public String oglasi(ModelMap map) {
		
		map.put("oglasi", oglServis.findAll());
		return "oglas";
		
	}
	
	@RequestMapping(value = "/getOglasiAdmin", method = RequestMethod.GET)
	public String oglasiAdmin(ModelMap map) {
		
		map.put("oglasi", oglServis.findAll());
		return "oglasAdmin";
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		
		map.put("rekvizit", new ZvanicniRekvizit());
		return "dodajRekvizit";
	
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("rekvizit") NewRekvizitForm newRekvizit , BindingResult bindingResult, ModelMap map) {
		
		ZvanicniRekvizit rekvizit = new ZvanicniRekvizit();
		
		if(bindingResult.hasErrors()) {
			return "dodajRekvizit";
		}
		
		if(!bindingResult.hasErrors()) {
			rekvizit = servis.createNewZvanicniRekvizit(newRekvizit);
		}
		
		servis.save(rekvizit);
		return "redirect:../fanzone/getRekviziti";
	
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		servis.delete(servis.find(id));
		return "redirect:../getRekviziti";
	
	}
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showById(@PathVariable Long id, ModelMap map){
        
    	map.put("rekvizit",servis.find(id));
        return "showRekvizit";
    }
	//NEKI PROBLEM SA DTO KOD UPDATEA
	/*@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, ModelMap map) {
		
		map.put("rekvizit", servis.setForm(servis.find(id)));
		return "izmeniRekvizit";
	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("rekvizit") NewRekvizitForm forma, BindingResult bindingResult , ModelMap map) {
		
		ZvanicniRekvizit trenutniRekvizit = new ZvanicniRekvizit();
		
		if(bindingResult.hasErrors()) {
			return "izmeniRekvizit";
		}
		
		if(!bindingResult.hasErrors()) {
			trenutniRekvizit = servis.createNewZvanicniRekvizit(forma);
		}
		
		
		
		servis.save(trenutniRekvizit);
		return "redirect:../fanzone/getRekviziti";
	
	}
	*/
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, ModelMap map) {
		
		map.put("rekvizit", servis.find(id));
		return "izmeniRekvizit";
	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("rekvizit") ZvanicniRekvizit rekvizit, BindingResult bindingResult , ModelMap map) {
		
		if(bindingResult.hasErrors()) {
			return "izmeniRekvizit";
		}
		
		
		ZvanicniRekvizit trenutniRekvizit = servis.find(rekvizit.getId());
		trenutniRekvizit.setSlika(rekvizit.getSlika());
		trenutniRekvizit.setIme(rekvizit.getIme());
		trenutniRekvizit.setCena(rekvizit.getCena());
		trenutniRekvizit.setOpis(rekvizit.getOpis());
		
		servis.save(trenutniRekvizit);
		return "redirect:../fanzone/getRekviziti";
	
	}
	
	@RequestMapping(value = "/reserve/{id}", method = RequestMethod.GET)
	public String rezervisi(@PathVariable("id") Long id, ModelMap map) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser user = (CurrentUser) auth.getPrincipal();
		if(user.getUloga().equals("REGULAR")) {
			RegularUser ru = (RegularUser) user.getUser();
			ZvanicniRekvizit rezervisani = servis.find(id);
			if(rezervisani.isRezervisan() == false) {
			rezervisani.setUser(ru);
			rezervisani.setRezervisan(true);
			servis.save(rezervisani);
			RegularUser reg = userServis.addRekvizit(rezervisani, ru.getId());
			userServis.save(reg);
			map.put("logged", user);
			map.put("rekvizit", rezervisani);
			}
			else {
				System.out.println("Rekvizit je vec rezervisan!");
			}
		}
		
		return "redirect:/fanzone/getRekvizitiObican";
	}
	
	@RequestMapping(value = "/addOglas", method = RequestMethod.GET)
	public String addOglas(ModelMap map) {
		
		map.put("oglas", new Oglas());
		return "dodajOglas";
	
	}
	
	@RequestMapping(value = "/addOglas", method = RequestMethod.POST)
	public String addOglas(@ModelAttribute("oglas") Oglas oglas, ModelMap map) {
			
		oglServis.save(oglas);
		return "redirect:../fanzone/getOglasi";
	
	}
	
	@RequestMapping(value = "/approve/{id}", method = RequestMethod.GET)
	public String odobri(@PathVariable("id") Long id, ModelMap map) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser user = (CurrentUser) auth.getPrincipal();
		if(user.getUloga().equals("FAN_ZONE")) {
		Oglas zaOdobravanje = oglServis.find(id);
		zaOdobravanje.setOdobren(true);
		oglServis.save(zaOdobravanje);
		}
		return "redirect:../getOglasiAdmin";
	}
	
	@RequestMapping(value = "/myReservations")
	public String mojeRezervacije(ModelMap map) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser user = (CurrentUser) auth.getPrincipal();
		
		
		if(user.getUloga() == "REGULAR") {
			RegularUser regular = (RegularUser) user.getUser();
			//IMA NEKU GRESKU OVDE OPET BUDE PRAZNA LISTA DA BI SE PRIKAZALO
		
			map.put("user", regular);
		}	
		
		
		
		
		return "mojeRezervacije";
	}
	
	
}
