package rs.ac.uns.ftn.informatika.Cinema.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageOglasService {

	void saveImageFile(Long oglasId, MultipartFile file);
	
}
