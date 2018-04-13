package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionsService;

@Controller
public class SeatReservationController {

	@Autowired
	private CinemaTheatreService cinemaTheatreService;
	
	@Autowired
	private ProjectionsService projectionsService;
	
	@RequestMapping(value = "/cinematheatre/getPredstave/{ctId}/{pId}", method = RequestMethod.GET)
	public ModelAndView showPerformance(@PathVariable("ctId") Long ctId, @PathVariable("pId") Long pId) {
		ModelAndView modelAndView = new ModelAndView();
		Projections projection = cinemaTheatreService.findMyProjectionById(ctId, pId);
		
		if(projection == null) {
			modelAndView.addObject("error", "Doslo je do greske!");
		}
		
		modelAndView.addObject("seatConfig", projectionsService.getSeatConfiguration(pId));
		modelAndView.addObject("projection", projection);
		modelAndView.setViewName("projection");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/cinematheatre/getProjekcije/{ctId}/{pId}", method = RequestMethod.GET)
	public ModelAndView showProjection(@PathVariable("ctId") Long ctId, @PathVariable("pId") Long pId) {
		ModelAndView modelAndView = new ModelAndView();
		
		Projections projection = cinemaTheatreService.findMyProjectionById(ctId, pId);
		
		if(projection == null) {
			modelAndView.addObject("error", "Doslo je do greske!");
		}
		
		modelAndView.addObject("seatConfig", projectionsService.getSeatConfiguration(pId));
		modelAndView.addObject("projection", projection);
		modelAndView.setViewName("projection");
		
		return modelAndView;
	}
	
}
