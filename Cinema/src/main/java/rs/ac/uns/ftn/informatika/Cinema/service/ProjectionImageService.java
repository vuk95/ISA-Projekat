package rs.ac.uns.ftn.informatika.Cinema.service;

import org.springframework.web.multipart.MultipartFile;

public interface ProjectionImageService {

	public void saveImageFile(Long projectionId,MultipartFile file);

}
