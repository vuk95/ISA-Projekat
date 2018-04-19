package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.FriendInviteService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Controller
public class HomepageController {

	@Autowired
	private RegularUserService regularUserService;
	
	@Autowired
	private FriendInviteService friendInviteService;
	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public ModelAndView showHomepage(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		RegularUser user = regularUserService.findByEmail(principal.getName());
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("friends", friendInviteService.findMyFriends(user));
		modelAndView.setViewName("homepage");
		
		return modelAndView;
	}
	
}
