package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.messaging.Producer;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.FriendInviteService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Controller
public class FriendController {

	@Autowired
	private FriendInviteService friendInviteService;
	
	@Autowired
	private RegularUserService regularUserService;
	
	@Autowired
	private Producer producer;
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/addfriend", method = RequestMethod.GET)
	public ModelAndView showAddFriend(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		RegularUser user = regularUserService.findByEmail(principal.getName());
		
		modelAndView.addObject("user", user);
		modelAndView.setViewName("addfriend");
		
		return modelAndView;
	}
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/addfriend", method = RequestMethod.POST)
	public ModelAndView getFutureFriends(@RequestParam("name") String name, @RequestParam("lastname") String lastname,
										Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		RegularUser user = regularUserService.findByEmail(principal.getName());
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("futureFriends", regularUserService.findFutureFriends(name, lastname));
		modelAndView.setViewName("addfriend");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "api/friendrequest/{receiverId}")
	public String sendFriendRequest(@PathVariable Long receiverId, @RequestParam Long senderId) {
		friendInviteService.makeFriendInvite(senderId, receiverId);
		producer.sendFriendRequestTo(receiverId);
		
		return "redirect:/addfriend?added=true";
	}
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/friendrequest", method = RequestMethod.GET)
	public ModelAndView usersRequests(Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		RegularUser user = regularUserService.findByEmail(principal.getName());
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("requests", friendInviteService.getMyUnseenRequests(user));
		modelAndView.setViewName("friendrequest");
		
		return modelAndView;
	}
	
}
