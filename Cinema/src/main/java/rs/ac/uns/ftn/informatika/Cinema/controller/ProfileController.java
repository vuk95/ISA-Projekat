package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.model.users.ProfileForm;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.FriendInviteService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Controller
public class ProfileController {

	@Autowired
	private RegularUserService regularUserService;
	
	@Autowired
	private FriendInviteService friendInviteService;
	
	@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public ModelAndView showProfile(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		RegularUser user = regularUserService.findOne(id);

		modelAndView.addObject("welcomeMessage", "Dobrodosli " + user.getName() + ", ovo su podaci o vama");
		modelAndView.addObject("user", user);
		modelAndView.addObject("friendInvites", friendInviteService.findMyFriendInvites(user));
		modelAndView.setViewName("profile");
		return modelAndView;
	}
	
	@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
	@RequestMapping(value = "/profile/{id}/edit", method = RequestMethod.GET)
	public ModelAndView getEditProfile(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		RegularUser regUser = regularUserService.findOne(id);
		ProfileForm user = new ProfileForm(regUser);
		
		modelAndView.addObject("user", user);
		modelAndView.setViewName("editprofile");
		return modelAndView;
	}
	
	
	
	@PreAuthorize("@currentUserServiceImpl.canAccess(principal, #id)")
	@RequestMapping(value = "/profile/{id}/edit", method = RequestMethod.PUT)
	public ModelAndView putEditProfile(@ModelAttribute("user") ProfileForm form, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView();
		regularUserService.updateRegularUserProfile(form);
		
		modelAndView.addObject("successMessage", "Uspesno ste izmenili svoje podatke!");
		modelAndView.setViewName("editprofile");
		
		return modelAndView;
	}
	
}
