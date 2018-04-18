package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import rs.ac.uns.ftn.informatika.Cinema.model.Oglas;
import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.repository.OglasRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.ImageOglasService;


@Service
public class ImageOglasServiceImpl implements ImageOglasService{
	
	@Autowired
	private OglasRepository repository;

	@Override
	public void saveImageFile(Long oglasId, MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			Oglas oglas = repository.findOne(oglasId);
			Byte[] byteObjects = new Byte[file.getBytes().length];
			
			 int i = 0;
	            
	            for(byte b : file.getBytes()){
	                byteObjects[i++] =  b;
	            }
	            

	            oglas.setSlika(byteObjects);
	            
	            repository.save(oglas);

		}catch (IOException e){

            e.printStackTrace();
        }
	}

}
