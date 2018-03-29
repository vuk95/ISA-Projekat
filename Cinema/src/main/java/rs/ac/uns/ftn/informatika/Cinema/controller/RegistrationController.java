package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.model.users.NewUserForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.EmailService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegularUserService regularUserService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showRegistrationForm(WebRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new NewUserForm());
		modelAndView.setViewName("registration");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerRegularUser(@ModelAttribute("user") @Valid NewUserForm newUser, BindingResult result,
						HttpServletRequest request, Errors errors) {
		
		RegularUser registered = new RegularUser();
		if(!result.hasErrors()) {
			registered = regularUserService.createNewRegularUser(newUser);
		}
		
		if(registered == null) {
			result.rejectValue("email", "message.regError");
		}
		
		if(result.hasErrors()) {
			return new ModelAndView("registration", "user", newUser);
		} else {
			
			try {
				String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getLocalPort();
				emailService.sendRegistrationMail(registered, url);
				System.out.println("Mejl je poslat!");
			} catch(Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView("proba");
		}
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
		RegularUser user = regularUserService.findByConfirmationToken(token);
		
		if(user == null) {
			modelAndView.addObject("invalidToken", "Doslo je do greske. Ne postoji korisnik sa ovakvim tokenom!");
		} else {
			modelAndView.addObject("confirmationToken", user.getConfirmationToken());
		}
		
		modelAndView.setViewName("confirm");
		return modelAndView;
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public ModelAndView activateUserAccount(ModelAndView modelAndView, @RequestParam("token") String token) {
		
		RegularUser user = regularUserService.findByConfirmationToken(token);
		
		user.setEnabled(true);
		regularUserService.save(user);
		
		modelAndView.addObject("successMessage", "Uspesno ste aktivarali vas nalog!");
		return modelAndView;
	}
	
}
