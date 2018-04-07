package rs.ac.uns.ftn.informatika.Cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionService;

@Controller
@RequestMapping(value = "/movieperformance")
public class ProjekcijeController {

	@Autowired
	private ProjectionService service;
	
	
}
