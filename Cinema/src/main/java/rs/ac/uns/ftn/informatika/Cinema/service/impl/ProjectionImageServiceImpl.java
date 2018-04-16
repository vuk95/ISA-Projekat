package rs.ac.uns.ftn.informatika.Cinema.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import rs.ac.uns.ftn.informatika.Cinema.model.Projections;
import rs.ac.uns.ftn.informatika.Cinema.repository.ProjectionsRepository;
import rs.ac.uns.ftn.informatika.Cinema.service.ProjectionImageService;

@Service
public class ProjectionImageServiceImpl  implements ProjectionImageService {

	@Autowired
	private ProjectionsRepository repository;
	
	@Transactional
	@Override
	public void saveImageFile(Long projectionId, MultipartFile file) {
		
		try {
			Projections projekcija = repository.findOne(projectionId);
			Byte[] byteObjects = new Byte[file.getBytes().length];
			
			 int i = 0;
	            
	            for(byte b : file.getBytes()){
	                byteObjects[i++] =  b;
	            }
	            

	            projekcija.setPicture(byteObjects);
	            
	            repository.save(projekcija);

		}catch (IOException e){

            e.printStackTrace();
        }
		
	}
		
		
	}
