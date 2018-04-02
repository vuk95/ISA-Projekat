package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import rs.ac.uns.ftn.informatika.Cinema.model.ZvanicniRekvizit;
import rs.ac.uns.ftn.informatika.Cinema.repository.RekvizitRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.ImageRekvizitService;

@Service
public class ImageRekvizitServiceImpl implements ImageRekvizitService{

	@Autowired
	private RekvizitRepository repository;
	
	@Transactional
	@Override
	public void saveImageFile(Long rekvizitId, MultipartFile file) {
		
		try {
			ZvanicniRekvizit rekvizit = repository.findOne(rekvizitId);
			Byte[] byteObjects = new Byte[file.getBytes().length];
			
			 int i = 0;
	            
	            for(byte b : file.getBytes()){
	                byteObjects[i++] =  b;
	            }
	            

	            rekvizit.setSlika(byteObjects);
	            
	            repository.save(rekvizit);

		}catch (IOException e){

            e.printStackTrace();
        }
		
	}

}
