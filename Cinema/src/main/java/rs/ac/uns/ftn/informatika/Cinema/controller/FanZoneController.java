package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.security.Principal;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.uns.ftn.informatika.Cinema.model.NewOglasForm;
import rs.ac.uns.ftn.informatika.Cinema.model.NewRekvizitForm;
import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.model.Ponuda;
import rs.ac.uns.ftn.informatika.Cinema.model.RekvizitForm;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Administrator;
import rs.ac.uns.ftn.informatika.Cinema.model.users.CurrentUser;
import rs.ac.uns.ftn.informatika.Cinema.model.users.FZAdminForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.model.users.Role;
import rs.ac.uns.ftn.informatika.Cinema.service.AdministratorService;
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
	
	@Autowired
	private AdministratorService adminService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap map) {
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser user = (CurrentUser) auth.getPrincipal();
		
		map.put("logged", user);
		
		return "fanzone";
		
	}
	//=======================================================================================
	//PROFIL ADMINISTRATORA FAN ZONE
	@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public String showProfile(@PathVariable Long id, ModelMap map) {
		
		Administrator fzadmin = adminService.findOne(id);
		if(fzadmin.getRole().equals(Role.FAN_ZONE)) {
		map.put("user", fzadmin);
		}
		return "fzprofile";
	}
	@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
	@RequestMapping(value = "/profile/{id}/edit", method = RequestMethod.GET)
	public String editProfile(@PathVariable Long id, ModelMap map) {
		
		Administrator fzadmin = adminService.findOne(id);
		FZAdminForm user = new FZAdminForm(fzadmin);
		map.put("user", user);
		return "fzeditprofile";
	}
	
	@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
	@RequestMapping(value = "/profile/{id}/edit", method = RequestMethod.PUT)
	public String putEditProfile(@ModelAttribute("user") FZAdminForm form, @PathVariable Long id) {
		
		adminService.updateFZAdminProfile(form);
		return "redirect:/fanzone/profile/" + id;
	}
	
	//=======================================================================================
	//fz admin
	@RequestMapping(value = "/getRekviziti", method = RequestMethod.GET)
	public String rekviziti(ModelMap map) {
		
		map.put("rekviziti", servis.findAll());
		return "rekviziti";
		
	}
	//obican
	@RequestMapping(value = "/getRekvizitiObican", method = RequestMethod.GET)
	public String rekvizitiObican(ModelMap map) {
		
		
		
		map.put("rekviziti", servis.findAll());
		return "rekvizitiObican";
		
	}
	//obican
	@RequestMapping(value = "/getOglasi", method = RequestMethod.GET)
	public String oglasi(ModelMap map) {
		
		map.put("oglasi", oglServis.findAll());
		return "oglas";
		
	}
	//fz admin
	@RequestMapping(value = "/getOglasiAdmin", method = RequestMethod.GET)
	public String oglasiAdmin(ModelMap map) {
		
		map.put("oglasi", oglServis.findAll());
		return "oglasAdmin";
		
	}
	//fz admin
	@RequestMapping(value = "getRekviziti/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		
		map.put("rekvizit", new ZvanicniRekvizit());
		return "dodajRekvizit";
	
	}
	//fz admin
	@RequestMapping(value = "getRekviziti/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("rekvizit") NewRekvizitForm newRekvizit , BindingResult bindingResult, ModelMap map) {
		
		ZvanicniRekvizit rekvizit = new ZvanicniRekvizit();
		
		if(bindingResult.hasErrors()) {
			return "dodajRekvizit";
		}
		
		if(!bindingResult.hasErrors()) {
			rekvizit = servis.createNewZvanicniRekvizit(newRekvizit);
		}
		
		servis.save(rekvizit);
		return "redirect:../getRekviziti";
	
	}
	//fz admin
	@RequestMapping(value = "getRekviziti/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		servis.delete(servis.find(id));
		return "redirect:/fanzone/getRekviziti";
	
	}
	//fz admin
	@RequestMapping(value = "getRekviziti/show/{id}", method = RequestMethod.GET)
    public String showById(@PathVariable Long id, ModelMap map){
		if(!servis.find(id).isRezervisan()) {
    	map.put("rekvizit",servis.find(id));
        return "showRekvizit";
		}
		
		return "greskaIzmena";
		
    }
	//fz admin
	@RequestMapping(value = "getRekviziti/update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, ModelMap map) {
		if(!servis.find(id).isRezervisan()) {
		RekvizitForm rekvizit = new RekvizitForm(servis.find(id));
		
		map.put("rekvizit", rekvizit);
		
		return "izmeniRekvizit";
		}
		return "greskaIzmena";
	}
	//fz admin
	@RequestMapping(value = "getRekviziti/update", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("rekvizit") RekvizitForm rekvizit, BindingResult bindingResult , ModelMap map) {
		
		
		if(bindingResult.hasErrors()) {
			return "izmeniRekvizit";
		}
		
		if(!bindingResult.hasErrors()) {
			servis.updateZvanicniRekvizit(rekvizit);
		}
		
		return "redirect:/fanzone/getRekviziti";
	
	}
	
	/*STARO
	//fz admin
	@RequestMapping(value = "getRekviziti/update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, ModelMap map) {
		if(!servis.find(id).isRezervisan()) {
		map.put("rekvizit", servis.find(id));
		
		return "izmeniRekvizit";
		}
		
		return "greskaIzmena";
		
	
	}
	//fz admin
	//TREBA URADITI DA SE SALJE DTO ZBOG VALIDACIJE
	@RequestMapping(value = "getRekviziti/update", method = RequestMethod.POST)
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
		
		return "redirect:../getRekviziti";
	
	}
	*/
	//obican
	//OVA METODA BI SE MOGLA REFAKTORISATI
	@RequestMapping(value = "getRekvizitiObican/reserve/{id}", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "getOglasi/addOglas", method = RequestMethod.GET)
	public String addOglas(ModelMap map) {
		
		
		map.put("oglas", new Oglas());
		return "dodajOglas";
	
	}
	
	@RequestMapping(value = "getOglasi/addOglas", method = RequestMethod.POST)
	public String addOglas(@Valid @ModelAttribute("oglas") NewOglasForm o,BindingResult result, Principal principal, ModelMap map) {
		
		Oglas oglas = new Oglas();
		
		if(result.hasErrors()) {
			return "dodajOglas";
		}
		if(!result.hasErrors()) {
		
			oglas = oglServis.createNewOglas(o);
		}
			RegularUser user = userServis.findByEmail(principal.getName());
			RegularUser reg = userServis.addMojOglas(oglas, user.getId());
			userServis.save(reg);
		
		return "redirect:../getOglasi";
	
	}
	
	//obican
	//ZASTITI DA ADMIN NE MOZE OVDE DA UDJE ZAPRAVO SVI LINKOVI UNUTAR ONOGA STO JE ZABRANJENO
	//SU DOZVOLJENI TO ISPRAVITI
	/*
	@RequestMapping(value = "getOglasi/addOglas", method = RequestMethod.GET)
	public String addOglas(ModelMap map) {
		
		
		map.put("oglas", new Oglas());
		return "dodajOglas";
	
	}
	//obican
	//TREBA URADITI DA SE SALJE DTO ZBOG VALIDACIJE
	//TREBA URADITI UPLOAD SLIKE
	@RequestMapping(value = "getOglasi/addOglas", method = RequestMethod.POST)
	public String addOglas(@ModelAttribute("oglas") Oglas oglas, Principal principal, ModelMap map) {
			
		oglServis.save(oglas);
		RegularUser user = userServis.findByEmail(principal.getName());
		RegularUser reg = userServis.addMojOglas(oglas, user.getId());
		userServis.save(reg);
		
		return "redirect:../getOglasi";
	
	}
	*/
	//admin fz
	@RequestMapping(value = "getOglasiAdmin/approve/{id}", method = RequestMethod.GET)
	public String odobri(@PathVariable("id") Long id, ModelMap map) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CurrentUser user = (CurrentUser) auth.getPrincipal();
		if(user.getUloga().equals("FAN_ZONE")) {
		Oglas zaOdobravanje = oglServis.find(id);
		zaOdobravanje.setOdobren(true);
		oglServis.save(zaOdobravanje);
		}
		return "redirect:/fanzone/getOglasiAdmin";
	}
	
	//obican
	@RequestMapping(value = "getRekvizitiObican/myReservations")
	public String mojeRezervacije(Principal principal, ModelMap map) {
		
		RegularUser user = userServis.findByEmail(principal.getName());
		map.put("user", user);
		
		return "mojeRezervacije";
	}
	
	//obican
	@RequestMapping(value = "getOglasi/mojiOglasi")
	public String mojiOglasi(Principal principal, ModelMap map) {
		
		
		RegularUser user = userServis.findByEmail(principal.getName());
		map.put("user", user);
		
		return "mojiOglasi";
	}
	
	//obican
	@RequestMapping(value = "getOglasi/ponude/{id}", method = RequestMethod.GET)
	public String ponude(@PathVariable("id") Long id, ModelMap map) {
		
		Oglas oglas = oglServis.find(id);
		
		map.put("oglas", oglas);
		
		return "ponudeOglas";
	}
	//obican
	@RequestMapping(value = "getOglasi/offer/{id}", method = RequestMethod.GET)
	public String offer(@PathVariable("id") Long id, ModelMap map) {
		
		map.put("ponuda", new Ponuda());
		map.put("oglas", oglServis.find(id));
		return "dajPonudu";
	
	}
	//obican
	@RequestMapping(value = "getOglasi/offer/{id}", method = RequestMethod.POST)
	public String offer(@PathVariable("id") Long id,@Valid @ModelAttribute("ponuda") Ponuda ponuda,BindingResult result, Principal principal, ModelMap map) {
		
		if(result.hasErrors()) {
			map.put("oglas", oglServis.find(id));
			return "dajPonudu";
		}
		
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
		
		return "redirect:/fanzone/getOglasi/ponude/" + id;
	
	}
	
	//obican
		@RequestMapping(value = "getOglasi/updateoffer/{id}", method = RequestMethod.GET)
		public String editoffer(@PathVariable("id") Long id, ModelMap map) {
			
			Ponuda p = ponudaServis.find(id);
			
			map.put("ponuda", p);
			map.put("oglas", p.getOglas());
			return "izmeniPonudu";
		
		}
		
		//obican
		@RequestMapping(value = "getOglasi/updateoffer/{id}", method = RequestMethod.POST)
		public String editoffer(@PathVariable("id") Long id,@Valid @ModelAttribute("ponuda") Ponuda ponuda,BindingResult result, Principal principal, ModelMap map) {
			
			if(result.hasErrors()) {
				map.put("ponuda", ponudaServis.find(id));
				return "izmeniPonudu";
			}
			Ponuda p = ponudaServis.find(ponuda.getId());
			
			RegularUser user = userServis.findByEmail(principal.getName());
			
			if(p.isPrihvacena()) {
				System.out.println("Ne mozete menjati prihvacenu ponudu");
			}
			
			else if(!p.getUser().getId().equals(user.getId())) {
				System.out.println("Ne mozete menjati tudju ponudu!");
			}
			else {
			p.setIznos(ponuda.getIznos());
			
			
			ponudaServis.save(p);
			}
			//nesto redirekcija ne valja
			return "redirect:/fanzone/getOglasi/ponude/" + p.getOglas().getId();
		
		}
	
	//obican
	@RequestMapping(value = "getOglasi/ponudeprim/{id}", method = RequestMethod.GET)
	public String ponudePrimljene(@PathVariable("id") Long id, ModelMap map, Principal principal) {
		
		RegularUser user = userServis.findByEmail(principal.getName());
		
		Oglas oglas = oglServis.find(id);
		for(int i = 0; i < user.getMojiOglasi().size(); i++) {
			if(user.getMojiOglasi().get(i).equals(oglas)){
				map.put("oglas", oglas);
			}
		}
		
		map.put("info", "Niste vlasnik ovog oglasa!");
		
		return "primljene";
	}
	//obican
	//OVAKVE STVARI BI TREBALO ZASTITI DA MOZE SAMO TAJ REGULAR USER CIJA JE PONUDA DA PRIHVATI
	@RequestMapping(value = "getOglasi/accept/{id}", method = RequestMethod.GET)
	public String accept(@PathVariable("id") Long id, ModelMap map, Principal principal) {
		
		RegularUser user = userServis.findByEmail(principal.getName());
		
		Ponuda ponuda = ponudaServis.find(id);
		Oglas o = ponuda.getOglas();
		for(int j = 0; j < user.getMojiOglasi().size(); j++) {
			if(user.getMojiOglasi().get(j).equals(o)) {
		
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
			}
			else {
				System.out.println("Nemate prava da prihvatate ponude za tudj oglas!");
			}
		}
		
		return "redirect:/fanzone/getOglasi/mojiOglasi";
	}
	//obican
	@RequestMapping(value = "getOglasi/obavestenja/{id}", method = RequestMethod.GET)
	public String obavestenja(@PathVariable("id") Long id, ModelMap map, Principal principal) {
		Oglas o = oglServis.find(id);
		RegularUser user = userServis.findByEmail(principal.getName());
		for(int i = 0; i < o.getPonudeZaOglas().size(); i++) {
			if(o.getPonudeZaOglas().get(i).getUser().equals(user)) {
				map.put("oglas", o);
				map.put("ponuda", o.getPonudeZaOglas().get(i));
				if(o.getPonudeZaOglas().get(i).isPrihvacena()) {
				map.put("rez", " je prihvacena");
				}
				else {
				map.put("rez", " nije prihvacena");
				}
			}
		}
		return "obavestenje";
	}
	
}
