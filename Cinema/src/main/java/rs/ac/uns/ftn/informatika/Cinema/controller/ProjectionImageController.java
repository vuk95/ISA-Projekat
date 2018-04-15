package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.service.CinemaTheatreService;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionImageService;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionsService;

@Controller
public class ProjectionImageController {

	@Autowired
	private ProjectionsService  pservice;
	
	@Autowired
	private  CinemaTheatreService service;
	
	@Autowired
	private ProjectionImageService imgservice;
	
	@GetMapping("pozoriste/{id}/image")
    public String showUploadTheatreForm(@PathVariable Long id, ModelMap map){

        map.put("predstava",pservice.findOne(id));
        
        
        return "predstaveimageupload";
    }
	
	 @PostMapping("pozoriste/{id}/image")
	 public String handleTheatreImagePost(@PathVariable Long id, @RequestParam("imagefile") MultipartFile file){

		 	imgservice.saveImageFile(id,file);

		 	//String referer = request.getHeader("Referer");
			
			//return "redirect:"+ referer;
		 	
	        return "redirect:/cinematheatre/updatePredstave/" + id;
	    }
	
	
	 @GetMapping("pozoriste/{id}/pozoristeimage")
	 public void renderTheatreImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
	    	
	    	Projections projekcija = pservice.findOne(id);
	        
	        if(projekcija == null){
	            throw new RuntimeException("there is no rekvizit with this id : " + id);
	        }

	        //baca null exception na ovoj liniji koda zato sto u bazi u ovom trenutku nema slike
	        //pa ne moze da vrati length
	        byte[] byteArray = new byte[projekcija.getPicture().length];
	        int i= 0;
	      
	        for(Byte wrappedByte : projekcija.getPicture() ){

	            byteArray[i++] = wrappedByte;
	        }
	        
	        response.setContentType("image/jpeg");
	        InputStream is = new ByteArrayInputStream(byteArray);
	        IOUtils.copy(is,response.getOutputStream());


	    }
	
	 @GetMapping("bioskop/{id}/image")
	    public String showUploadCinemaForm(@PathVariable Long id, ModelMap map){

	        map.put("projekcija",pservice.findOne(id));
	        
	        
	        return "projekcijeimageupload";
	    }
		
		 @PostMapping("bioskop/{id}/image")
		 public String handleCinemaImagePost(@PathVariable Long id, @RequestParam("imagefile") MultipartFile file){

			 	imgservice.saveImageFile(id,file);

			 	//String referer = request.getHeader("Referer");
				
				//return "redirect:"+ referer;
			 	
		        return "redirect:/cinematheatre/updateProjekcije/" + id;
		    }
		
		
		 @GetMapping("bioskop/{id}/bioskopimage")
		 public void renderCinemaImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
		    	
		    	Projections projekcija = pservice.findOne(id);
		        
		        if(projekcija == null){
		            throw new RuntimeException("there is no rekvizit with this id : " + id);
		        }

		        //baca null exception na ovoj liniji koda zato sto u bazi u ovom trenutku nema slike
		        //pa ne moze da vrati length
		        byte[] byteArray = new byte[projekcija.getPicture().length];
		        int i= 0;
		      
		        for(Byte wrappedByte : projekcija.getPicture() ){

		            byteArray[i++] = wrappedByte;
		        }
		        
		        response.setContentType("image/jpeg");
		        InputStream is = new ByteArrayInputStream(byteArray);
		        IOUtils.copy(is,response.getOutputStream());


		    }
	 
	 
		/* @GetMapping("/getPredstave/{id}/addPredstaveImage")
		    public String showUploadAddTheatreForm(@PathVariable Long id, ModelMap map){

		        map.put("pozoriste",service.findOne(id));
		        
		        return "dodajimagepredstave";
		    }
			
			 @PostMapping("/getPredstave/{id}/addPredstaveImage")
			 public String handleAddTheatreImagePost(@PathVariable Long id, @RequestParam("imagefile") MultipartFile file,ModelMap map){

				 
				 	map.put("pozoriste",service.findOne(id));
				 	imgservice.saveImageFile(id,file);

				 	//String referer = request.getHeader("Referer");
					
					//return "redirect:"+ referer;
				 	
			        return "redirect:/cinematheatre/getPredstave/" + id;
			    }
			
			
			 @GetMapping("/getPredstave/{id}/pozoristeimage")
			 public void renderAddTheatreImage(@PathVariable Long id, HttpServletResponse response) throws IOException {
			    	
			    	Projections projekcija = pservice.findOne(id);
			        
			        if(projekcija == null){
			            throw new RuntimeException("there is no rekvizit with this id : " + id);
			        }

			        //baca null exception na ovoj liniji koda zato sto u bazi u ovom trenutku nema slike
			        //pa ne moze da vrati length
			        byte[] byteArray = new byte[projekcija.getPicture().length];
			        int i= 0;
			      
			        for(Byte wrappedByte : projekcija.getPicture() ){

			            byteArray[i++] = wrappedByte;
			        }
			        
			        response.setContentType("image/jpeg");
			        InputStream is = new ByteArrayInputStream(byteArray);
			        IOUtils.copy(is,response.getOutputStream());


			    }
		 
		 */
	
}
