package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.model.Reservation;
import rs.ac.uns.ftn.informatika.Cinema.model.SeatDTO;
import rs.ac.uns.ftn.informatika.Cinema.model.SeatsResponse;
import rs.ac.uns.ftn.informatika.Cinema.model.Ticket;
import rs.ac.uns.ftn.informatika.Cinema.model.users.RegularUser;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.EmailService;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionsService;
import rs.ac.uns.ftn.informatika.Cinema.service.RegularUserService;
import rs.ac.uns.ftn.informatika.Cinema.service.ReservationService;
import rs.ac.uns.ftn.informatika.Cinema.service.TicketService;

@Controller
public class SeatReservationController {

	@Autowired
	private CinemaTheatreService cinemaTheatreService;
	
	@Autowired
	private ProjectionsService projectionsService;
	
	@Autowired
	private RegularUserService regularUserService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private TicketService service;
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/cinematheatre/getPredstave/{ctId}/{pId}", method = RequestMethod.GET)
	public ModelAndView showPerformance(@PathVariable("ctId") Long ctId, @PathVariable("pId") Long pId, Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		Projections projection = cinemaTheatreService.findMyProjectionById(ctId, pId);
		RegularUser user = regularUserService.findByEmail(principal.getName());
		
		List<Ticket> ticket = (List<Ticket>) service.findTickets(ctId);
		List<String> seats = new ArrayList<String>();
		
		for(int i=0;i<ticket.size();i++) {
			
			seats.add(ticket.get(i).getSeat());
			
			
			for(int j=0;j<seats.size();j++) {
			
				System.out.println("Seats:" + seats); //test da li ispisuje dobro mesto
			}
			
		}
		
		
		if(projection == null) {
			modelAndView.addObject("error", "Doslo je do greske!");
		}
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("seatConfig", projectionsService.getSeatConfiguration(projection));
		modelAndView.addObject("reservedSeats", projectionsService.getReservedSeats(projection));
		modelAndView.addObject("projection", projection);
		modelAndView.setViewName("projection");
		modelAndView.addObject("discountSeats",seats.toArray());
		
		return modelAndView;
	}
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/cinematheatre/getProjekcije/{ctId}/{pId}", method = RequestMethod.GET)
	public ModelAndView showProjection(@PathVariable("ctId") Long ctId, @PathVariable("pId") Long pId, Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		Projections projection = cinemaTheatreService.findMyProjectionById(ctId, pId);
		RegularUser user = regularUserService.findByEmail(principal.getName());
		
		List<Ticket> ticket = (List<Ticket>) service.findTickets(ctId);
		List<String> seats = new ArrayList<String>();
		
		for(int i=0;i<ticket.size();i++) {
			
			seats.add(ticket.get(i).getSeat());
			
			
			for(int j=0;j<seats.size();j++) {
			
				System.out.println("Seats:" + seats); //test da li ispisuje dobro mesto
			}
			
		}
		
		
		if(projection == null) {
			modelAndView.addObject("error", "Doslo je do greske!");
		}
		
		modelAndView.addObject("user", user);
		modelAndView.addObject("seatConfig", projectionsService.getSeatConfiguration(projection));
		modelAndView.addObject("reservedSeats", projectionsService.getReservedSeats(projection));
		modelAndView.addObject("projection", projection);
		modelAndView.setViewName("projection");
		modelAndView.addObject("discountSeats",seats.toArray());
		
		return modelAndView;
	}
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/api/seats/makereservation", method = RequestMethod.POST,
					produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public SeatsResponse makeSeatReservation(@RequestBody SeatDTO seats, Principal principal) {
		SeatsResponse response = new SeatsResponse();
		Reservation reservation = reservationService.createNewReservation(seats);
		RegularUser user = regularUserService.findByEmail(principal.getName());
		projectionsService.addReservation(reservation.getProjection(), reservation);
		regularUserService.addVisitedCinemaTheatre(reservation.getProjection().getCinemaTheatre(), seats.getUserId());
		regularUserService.addReservation(reservation, seats.getUserId());
		
		response.setSend(true);
		response.setMessage("Uspesno ste rezervisali mesta!");
		
		try {
			emailService.sendReservationMail(user, reservation.getProjection());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	@PreAuthorize("hasAuthority('REGULAR')")
	@RequestMapping(value = "/api/seats/deletereservation", method = RequestMethod.DELETE)
	public String cancelReservation(@RequestParam("reservationId") Long reservationId) {
		reservationService.logicalDelete(reservationId);
		
		return "redirect:/homepage";
	}
	
}
