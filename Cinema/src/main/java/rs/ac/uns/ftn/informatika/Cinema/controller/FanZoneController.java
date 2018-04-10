package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.security.Principal;
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
import rs.ac.uns.ftn.informatika.Cinema.model.Ponuda;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.model.users.CurrentUser;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.OglasService;
import rs.ac.uns.ftn.informatika.Cinema.service.PonudaService;
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
	
	@Autowired
	private PonudaService ponudaServis;
	
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
		if(!servis.find(id).isRezervisan()) {
    	map.put("rekvizit",servis.find(id));
        return "showRekvizit";
		}
		
		return "greskaIzmena";
		
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
		if(!servis.find(id).isRezervisan()) {
		map.put("rekvizit", servis.find(id));
		
		return "izmeniRekvizit";
		}
		
		return "greskaIzmena";
		
	
	}
	//TREBA URADITI DA SE SALJE DTO ZBOG VALIDACIJE
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
	
	//OVA METODA BI SE MOGLA REFAKTORISATI
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
	
	//ZASTITI DA ADMIN NE MOZE OVDE DA UDJE ZAPRAVO SVI LINKOVI UNUTAR ONOGA STO JE ZABRANJENO
	//SU DOZVOLJENI TO ISPRAVITI
	@RequestMapping(value = "/addOglas", method = RequestMethod.GET)
	public String addOglas(ModelMap map) {
		
		
		map.put("oglas", new Oglas());
		return "dodajOglas";
	
	}
	//TREBA URADITI DA SE SALJE DTO ZBOG VALIDACIJE
	//TREBA URADITI UPLOAD SLIKE
	@RequestMapping(value = "/addOglas", method = RequestMethod.POST)
	public String addOglas(@ModelAttribute("oglas") Oglas oglas, Principal principal, ModelMap map) {
			
		oglServis.save(oglas);
		RegularUser user = userServis.findByEmail(principal.getName());
		RegularUser reg = userServis.addMojOglas(oglas, user.getId());
		userServis.save(reg);
		
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
	public String mojeRezervacije(Principal principal, ModelMap map) {
		
		RegularUser user = userServis.findByEmail(principal.getName());
		map.put("user", user);
		
		return "mojeRezervacije";
	}
	
	@RequestMapping(value = "/mojiOglasi")
	public String mojiOglasi(Principal principal, ModelMap map) {
		
		
		RegularUser user = userServis.findByEmail(principal.getName());
		map.put("user", user);
		
		return "mojiOglasi";
	}
	
	@RequestMapping(value = "/ponude/{id}", method = RequestMethod.GET)
	public String ponude(@PathVariable("id") Long id, ModelMap map) {
		
		Oglas oglas = oglServis.find(id);
		
		map.put("oglas", oglas);
		
		return "ponudeOglas";
	}
	
	@RequestMapping(value = "/offer/{id}", method = RequestMethod.GET)
	public String offer(@PathVariable("id") Long id, ModelMap map) {
		
		map.put("ponuda", new Ponuda());
		map.put("oglas", oglServis.find(id));
		return "dajPonudu";
	
	}
	
	@RequestMapping(value = "/offer/{id}", method = RequestMethod.POST)
	public String addOglas(@PathVariable("id") Long id, @ModelAttribute("ponuda") Ponuda ponuda, Principal principal, ModelMap map) {
			
		
		RegularUser user = userServis.findByEmail(principal.getName());
		
		if(!userServis.nemozePonuditi(oglServis.find(id), user)) {
			if(!userServis.daoPonudu(oglServis.find(id), user)) {
				ponuda.setUser(user);
				ponuda.setOglas(oglServis.find(id));
				//ponudaServis.save(ponuda);
				Oglas ogl = oglServis.addPonuda(ponuda, id);
				//oglServis.save(ogl);
				
			}
			else {
				System.out.println("Ne mozete dati dve ponude");
			}
		}
		else {
			System.out.println("Ne mozete dati ponudu na svoj oglas");
		}
		
		return "redirect:../ponude/" + id;
	
	}
	
	@RequestMapping(value = "/ponudeprim/{id}", method = RequestMethod.GET)
	public String ponudePrimljene(@PathVariable("id") Long id, ModelMap map) {
		
		Oglas oglas = oglServis.find(id);
		
		map.put("oglas", oglas);
		
		return "primljene";
	}
	
	@RequestMapping(value = "/accept/{id}", method = RequestMethod.GET)
	public String accept(@PathVariable("id") Long id, ModelMap map) {
		

		
		Ponuda ponuda = ponudaServis.find(id);
		Oglas o = ponuda.getOglas();
		for(int i = 0; i < o.getPonudeZaOglas().size(); i++) {
			if(o.getPonudeZaOglas().get(i).getId().equals(id)) {
				if(!ponuda.isPrihvacena()) {
				ponuda.setPrihvacena(true);
				ponudaServis.save(ponuda);
				}
			}
			else {
				o.getPonudeZaOglas().get(i).setPrihvacena(false);
				ponudaServis.save(o.getPonudeZaOglas().get(i));
			}
			//o.getPonudeZaOglas().get(i).setPrihvacena(false);
			//ponudaServis.save(o.getPonudeZaOglas().get(i));
		}
		
		return "redirect:../mojiOglasi";
	}
	
}
