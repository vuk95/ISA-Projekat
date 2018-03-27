package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="dodaj", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> addRekvizit(@Validated @RequestBody ZvanicniRekvizit rekvizit, Errors errors){

		if(errors.hasErrors()){
			return new
				ResponseEntity<String>(errors.getAllErrors().toString(),
						HttpStatus.BAD_REQUEST);
		}
		
		ZvanicniRekvizit noviRekvizit = service.save(rekvizit);
		return new ResponseEntity<>(noviRekvizit, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ZvanicniRekvizit> delete(@PathVariable Long id){
		ZvanicniRekvizit obrisani = service.delete(id);
		return new ResponseEntity<>(obrisani, HttpStatus.OK);
	}
	
}
