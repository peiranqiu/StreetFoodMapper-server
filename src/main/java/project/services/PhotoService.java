package project.services;



import project.models.Photo;
import project.models.Truck;
import project.repositories.PhotoRepository;
import project.repositories.TruckRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PhotoService {
	@Autowired
	PhotoRepository photoRepository;

	@Autowired
	TruckRepository truckRepository;

	@GetMapping("/api/truck/{truckId}/photo")
	public List<Photo> findAllPhotosForTruck(
			@PathVariable("truckId") int truckId) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if(data.isPresent()) {
			Truck truck = data.get();
			return truck.getPhotos();
		}
		return null;		
	}
	
	@GetMapping("/api/photo")
	public Iterable<Photo> findAllPhotos() {
		return photoRepository.findAll();
	}
	
	@PostMapping("/api/photo")
	public Photo createPhoto
	(@RequestBody Photo photo) {
	return photoRepository.save(photo);
	}
	
	@DeleteMapping("/api/photo/{photoId}")
	public void deletePhoto(
	@PathVariable("photoId") int id) {
		photoRepository.deleteById(id);
	}
	
	@GetMapping("/api/photo/{photoId}")
	public Photo findPhotoById(@PathVariable("photoId") int photoId) {
		Optional<Photo> data = photoRepository.findById(photoId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	
}