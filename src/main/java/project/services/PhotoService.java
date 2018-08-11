package project.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.models.Holiday;
import project.models.Photo;
import project.models.Truck;
import project.repositories.PhotoRepository;
import project.repositories.TruckRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class PhotoService {
	@Autowired
	PhotoRepository photoRepository;
	@Autowired
	TruckRepository truckRepository;

	@GetMapping("/api/truck/{truckId}/photo")
	public List<Photo> findAllphotosForTruck(
			@PathVariable("truckId") int truckId, HttpServletResponse response) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if(data.isPresent()) {
			Truck truck = data.get();
			return truck.getPhotos();
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;		
	}
	
	@PostMapping("/api/truck/{truckId}/photo")
	public Photo createPhoto(@PathVariable("truckId") int truckId, @RequestBody Photo newPhoto, HttpServletResponse response) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if (data.isPresent()) {
			Truck truck = data.get();
			newPhoto.setTruck(truck);
			return photoRepository.save(newPhoto);
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}

	@DeleteMapping("/api/photo/{photoId}")
	public void deletePhoto(@PathVariable("photoId") int photoId)
	{
		photoRepository.deleteById(photoId);
	}
	
	@GetMapping("/api/photo")
	public List<Photo> findAllPhotos()
	{
		return (List<Photo>) photoRepository.findAll();
	}
	
	@GetMapping("/api/photo/{photoId}")
	public Photo findPhotoById(@PathVariable("photoId") int photoId, HttpServletResponse response) {
		Optional<Photo> data = photoRepository.findById(photoId);
		if (data.isPresent()) {
			return data.get();
		} 
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	@PutMapping("/api/truck/{truckId}/photo/{photoId}")
	public Photo updatePhoto(@PathVariable("photoId") int photoId, @RequestBody Photo newPhoto, HttpServletResponse response) {
		Optional<Photo> data = photoRepository.findById(photoId);
		if (data.isPresent()) {
			Photo photo = data.get();
			photo.setHref(newPhoto.getHref());

			photoRepository.save(photo);
			return photo;
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
}