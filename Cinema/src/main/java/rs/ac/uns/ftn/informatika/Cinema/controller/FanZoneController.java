package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.service.RekvizitService;

@RestController
@RequestMapping(value = "/fanZone")
public class FanZoneController {
	
	@Autowired
	private RekvizitService service;
	
	@RequestMapping(value="getRekviziti", method = RequestMethod.GET)
	public ResponseEntity<List<ZvanicniRekvizit>> getRekviziti(){
		
		List<ZvanicniRekvizit> rekviziti = service.findAll();
		return new ResponseEntity<>(rekviziti, HttpStatus.OK);
		
	}

}
