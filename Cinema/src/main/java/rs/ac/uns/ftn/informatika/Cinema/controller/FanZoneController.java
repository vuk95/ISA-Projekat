package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;

import rs.ac.uns.ftn.informatika.Cinema.service.RekvizitService;


@Controller
@RequestMapping("/fanzone")
public class FanZoneController {

	@Autowired
	private RekvizitService servis;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
	
		return "fanzone";
		//mora biti u templates
	}
	
	@RequestMapping(value = "/getRekviziti", method = RequestMethod.GET)
	public String rekviziti(ModelMap map) {
		
		map.put("rekviziti", servis.findAll());
		return "rekviziti";
		//mora biti u templates
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		
		map.put("rekvizit", new ZvanicniRekvizit());
		return "dodajRekvizit";
	
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("rekvizit") ZvanicniRekvizit rekvizit, ModelMap map) {
		
		servis.save(rekvizit);
		return "redirect:../fanzone/getRekviziti";
	
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		
		servis.delete(servis.find(id));
		return "redirect:../getRekviziti";
	
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, ModelMap map) {
		
		map.put("rekvizit", servis.find(id));
		return "izmeniRekvizit";
	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String edit(@ModelAttribute("rekvizit") ZvanicniRekvizit rekvizit, ModelMap map) {
		
		ZvanicniRekvizit trenutniRekvizit = servis.find(rekvizit.getId());
		trenutniRekvizit.setSlika(rekvizit.getSlika());
		trenutniRekvizit.setIme(rekvizit.getIme());
		trenutniRekvizit.setCena(rekvizit.getCena());
		trenutniRekvizit.setOpis(rekvizit.getOpis());
		
		servis.save(trenutniRekvizit);
		return "redirect:../fanzone/getRekviziti";
	
	}
	
}
