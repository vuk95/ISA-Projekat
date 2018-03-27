package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		
		return model;	
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView redirect() {
		ModelAndView model = new ModelAndView("pocetnaUlogovani");
		
		return model;	
	}
	
}
