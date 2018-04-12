package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.model.CinemaTheatre;
import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;

@Controller
public class SeatReservationController {

	@Autowired
	private CinemaTheatreService cinemaTheatreService;
	
	@RequestMapping(value = "/cinematheatre/getPredstave/{ctId}/{pId}", method = RequestMethod.GET)
	public ModelAndView showPerformance(@PathVariable("ctId") Long ctId, @PathVariable("pId") Long pId) {
		ModelAndView modelAndView = new ModelAndView();
		
		CinemaTheatre theatre = cinemaTheatreService.findOne(ctId);
		List<Projections> projections = theatre.getProjections();
		Projections projection = null;
		
		for(Projections proj : projections) {
			if(proj.getId().equals(pId)) {
				projection = proj;
			}
		}
		
		if(projection == null) {
			modelAndView.addObject("error", "Doslo je do greske!");
		}
		
		modelAndView.addObject("projection", projection);
		modelAndView.setViewName("projection");
		
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/cinematheatre/getProjekcije/{ctId}/{pId}", method = RequestMethod.GET)
	public ModelAndView showProjection(@PathVariable("ctId") Long ctId, @PathVariable("pId") Long pId) {
		ModelAndView modelAndView = new ModelAndView();
		
		CinemaTheatre cinema = cinemaTheatreService.findOne(ctId);
		List<Projections> projections = cinema.getProjections();
		Projections projection = null;
		
		for(Projections proj : projections) {
			if(proj.getId().equals(pId)) {
				projection = proj;
			}
		}
		
		if(projection == null) {
			modelAndView.addObject("error", "Doslo je do greske!");
		}
		
		modelAndView.addObject("projection", projection);
		modelAndView.setViewName("projection");
		
		
		return modelAndView;
	}
	
}
