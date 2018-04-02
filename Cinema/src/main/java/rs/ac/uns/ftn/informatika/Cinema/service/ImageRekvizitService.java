package rs.ac.uns.ftn.informatika.Cinema.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageRekvizitService {

	void saveImageFile(Long rekvizitId, MultipartFile file);
	
}
