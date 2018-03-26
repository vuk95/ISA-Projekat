package rs.ac.uns.ftn.informatika.Cinema.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.model.users.NewUserForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.AllUsersService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private AllUsersService allUsersService;
	
	@Autowired
	private RegularUserService regularUserService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showRegistrationForm(WebRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new NewUserForm());
		modelAndView.setViewName("registration");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerRegularUser(@ModelAttribute("user") @Valid NewUserForm newUser, BindingResult result) {
		ModelAndView model = new ModelAndView();
		if(allUsersService.emailExists(newUser.getEmail())) {
			result.rejectValue("email", "error.user", "Vec postoji korisnik sa takvim email-om.");
		}
		
		//if(result.hasErrors()) {
		//	model.setViewName("registration");
		//	System.out.println("****** result.hasErrors - usao");
	//	} else {
			regularUserService.createNewRegularUser(newUser);
			model.addObject("successMessage", "Korisnik je uspesno registrovan!");
			model.addObject("user", new NewUserForm());
			model.setViewName("registration");
	//	}
		
		return model;
	}
	
	
}
