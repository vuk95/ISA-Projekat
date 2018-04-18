package rs.ac.uns.ftn.informatika.Cinema.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

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

import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.service.ImageOglasService;
import rs.ac.uns.ftn.informatika.Cinema.service.OglasService;

@Controller
public class ImageOglasController {

	@Autowired
	private OglasService oglasService;
	
	@Autowired
	private ImageOglasService imageService;
	
	//obican treba zastiti da samo vlasnik moze da menja
    @GetMapping("fzoglas/{id}/image")
    public String showUploadForm(@PathVariable Long id, ModelMap map){

        map.put("oglas",oglasService.find(id));

        return "oglasuploadform";
    }
    //obican
    @PostMapping("fzoglas/{id}/image")
    public String handleImagePost(@PathVariable Long id, @RequestParam("imagefile") MultipartFile file){

        imageService.saveImageFile(id,file);

        //return "redirect:/fanzone/show/" + id;
        return "redirect:/fanzone/getOglasi/mojiOglasi";
    }
    //moze i obican
    @GetMapping("oglas/{id}/oglasimage")
    public void renderImageFromDB(@PathVariable Long id, HttpServletResponse response) throws IOException {
    	
    	Oglas oglas = oglasService.find(id);
        
        if(oglas == null){
            throw new RuntimeException("there is no oglas with this id : " + id);
        }

        //baca null exception ali u principu radi
        byte[] byteArray = new byte[oglas.getSlika().length];
        int i= 0;
      
        for(Byte wrappedByte : oglas.getSlika() ){

            byteArray[i++] = wrappedByte;
        }
        
        response.setContentType("image/jpeg");
        InputStream is = new ByteArrayInputStream(byteArray);
        IOUtils.copy(is,response.getOutputStream());


    }
	
}
