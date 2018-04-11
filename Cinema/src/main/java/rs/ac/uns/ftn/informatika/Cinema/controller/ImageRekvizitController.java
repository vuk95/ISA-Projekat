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

import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.service.ImageRekvizitService;
import rs.ac.uns.ftn.informatika.Cinema.service.RekvizitService;



@Controller
public class ImageRekvizitController {
	
	@Autowired
	private ImageRekvizitService imageService;

	@Autowired
	private RekvizitService rekvizitService;
	//fz admin
    @GetMapping("fzrekvizit/{id}/image")
    public String showUploadForm(@PathVariable Long id, ModelMap map){

        map.put("rekvizit",rekvizitService.find(id));

        return "imageuploadform";
    }
    //fz admin
    @PostMapping("fzrekvizit/{id}/image")
    public String handleImagePost(@PathVariable Long id, @RequestParam("imagefile") MultipartFile file){

        imageService.saveImageFile(id,file);

        //return "redirect:/fanzone/show/" + id;
        return "redirect:/fanzone/getRekviziti";
    }
    //moze i obican
    @GetMapping("rekvizit/{id}/rekvizitimage")
    public void renderImageFromDB(@PathVariable Long id, HttpServletResponse response) throws IOException {
    	
    	ZvanicniRekvizit rekvizit = rekvizitService.find(id);
        
        if(rekvizit == null){
            throw new RuntimeException("there is no rekvizit with this id : " + id);
        }

        //baca null exception ali u principu radi
        byte[] byteArray = new byte[rekvizit.getSlika().length];
        int i= 0;
      
        for(Byte wrappedByte : rekvizit.getSlika() ){

            byteArray[i++] = wrappedByte;
        }
        
        response.setContentType("image/jpeg");
        InputStream is = new ByteArrayInputStream(byteArray);
        IOUtils.copy(is,response.getOutputStream());


    }
}
