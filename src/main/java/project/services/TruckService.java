package project.services;


import project.models.Truck;
import project.models.User;
import project.repositories.TruckRepository;
import project.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TruckService {
	@Autowired
	TruckRepository truckRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/api/user/{userId}/truck")
	public List<Truck> findAllTrucksForUser(
			@PathVariable("userId") int userId) {
		Optional<User> data = userRepository.findById(userId);
		if(data.isPresent()) {
			User user = data.get();
			//return user.getTrucks();
		}
		return null;		
	}
	
	@GetMapping("/api/truck")
	public Iterable<Truck> findAllTrucks() {
		return truckRepository.findAll();
	}
	
	@PostMapping("/api/truck")
	public Truck createTruck
	(@RequestBody Truck truck) {
	return truckRepository.save(truck);
	}
	
	@DeleteMapping("/api/truck/{truckId}")
	public void deleteTruck(
	@PathVariable("truckId") int id) {
	truckRepository.deleteById(id);
	}
	
	@GetMapping("/api/truck/{truckId}")
	public Truck findTruckById(@PathVariable("truckId") int truckId) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	
	@PutMapping("/api/truck/{truckId}")
	public Truck updateTruck(@PathVariable("truckId") int truckId, @RequestBody Truck newTruck) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if (data.isPresent()) {
			Truck truck = data.get();
			truck.setId(newTruck.getId());
			truck.setTitle(newTruck.getTitle());
			truck.setUser(newTruck.getUser());
			truck.setCreated(newTruck.getCreated());
			truck.setPhotos(newTruck.getPhotos());
			truck.setSchedules(newTruck.getSchedules());
			truck.setAddress(newTruck.getAddress());
			truck.setPhone(newTruck.getPhone());
			truck.setCategories(newTruck.getCategories());
			truck.setYelp(newTruck.getYelp());
			truck.setTwitter(newTruck.getTwitter());
			truck.setRating(newTruck.getRating());
			truck.setMenu(newTruck.getMenu());

			truckRepository.save(truck);
			return truck;
		}
		return null;
	}
	
}