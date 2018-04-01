package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Controller
public class ProfileController {

	@Autowired
	private RegularUserService regularUserService;
	
	@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public ModelAndView showProfile(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		RegularUser user = regularUserService.findOne(id);

		modelAndView.addObject("welcomeMessage", "Dobrodosli " + user.getName());
		modelAndView.setViewName("profile");
		return modelAndView;
	}
	
}
