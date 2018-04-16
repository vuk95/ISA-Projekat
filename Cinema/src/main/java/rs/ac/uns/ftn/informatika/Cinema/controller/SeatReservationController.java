package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.model.Reservation;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionsService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;

@Controller
public class SeatReservationController {

	@Autowired
	private CinemaTheatreService cinemaTheatreService;
	
	@Autowired
	private ProjectionsService projectionsService;
	
	@Autowired
	private RegularUserService regularUserService;
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/cinematheatre/getPredstave/{ctId}/{pId}", method = RequestMethod.GET)
	public ModelAndView showPerformance(@PathVariable("ctId") Long ctId, @PathVariable("pId") Long pId, Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		Projections projection = cinemaTheatreService.findMyProjectionById(ctId, pId);
		RegularUser user = regularUserService.findByEmail(principal.getName());
		
		if(projection == null) {
			modelAndView.addObject("error", "Doslo je do greske!");
		}
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("seatConfig", projectionsService.getSeatConfiguration(projection));
		modelAndView.addObject("reservedSeats", projectionsService.getReservedSeats(projection));
		modelAndView.addObject("projection", projection);
		modelAndView.setViewName("projection");
		
		return modelAndView;
	}
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/cinematheatre/getProjekcije/{ctId}/{pId}", method = RequestMethod.GET)
	public ModelAndView showProjection(@PathVariable("ctId") Long ctId, @PathVariable("pId") Long pId, Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		Projections projection = cinemaTheatreService.findMyProjectionById(ctId, pId);
		RegularUser user = regularUserService.findByEmail(principal.getName());
		
		if(projection == null) {
			modelAndView.addObject("error", "Doslo je do greske!");
		}
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("seatConfig", projectionsService.getSeatConfiguration(projection));
		modelAndView.addObject("reservedSeats", projectionsService.getReservedSeats(projection));
		modelAndView.addObject("projection", projection);
		modelAndView.setViewName("projection");
		
		return modelAndView;
	}
	
}
