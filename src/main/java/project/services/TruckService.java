package project.services;

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
import project.models.Owner;
import project.models.Truck;
import project.models.User;
import project.repositories.OwnerRepository;
import project.repositories.TruckRepository;
import project.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TruckService {
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TruckRepository truckRepository;

	@GetMapping("/api/user/{userId}/truck")
	public List<Truck> findAllTrucksForUser(
			@PathVariable("userId") int userId) {
		Optional<User> data = userRepository.findById(userId);
		if(data.isPresent()) {
			User user = data.get();
			return user.getTrucks();
		}
		return null;		
	}
	
	@GetMapping("/api/owner/{ownerId}/truck")
	public List<Truck> findAllTrucksForOwner(
			@PathVariable("ownerId") int ownerId) {
		Optional<Owner> data = ownerRepository.findById(ownerId);
		if(data.isPresent()) {
			Owner owner = data.get();
			return owner.getTrucks();
		}
		return null;		
	}
	
	@PostMapping("/api/owner/{ownerId}/truck")
	public Truck createTruck(@PathVariable("ownerId") int ownerId, @RequestBody Truck newTruck) {
		Optional<Owner> data = ownerRepository.findById(ownerId);
		if (data.isPresent()) {
			Owner owner = data.get();
			newTruck.setOwner(owner);
			return truckRepository.save(newTruck);
		}
		return null;
	}
	

	@DeleteMapping("/api/truck/{truckId}")
	public void deleteTruck(@PathVariable("truckId") int truckId)
	{
		truckRepository.deleteById(truckId);
	}
	
	@GetMapping("/api/truck")
	public List<Truck> findAllTrucks()
	{
		return (List<Truck>) truckRepository.findAll();
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
			truck.setYelpId(newTruck.getYelpId());
			truck.setName(newTruck.getName());
			truck.setUrl(newTruck.getUrl());
			truck.setMenu(newTruck.getMenu());
			truck.setPhone(newTruck.getPhone());
			truck.setTwitter(newTruck.getTwitter());
			truck.setRating(newTruck.getRating());
			truck.setReviews(newTruck.getReviews());
			truck.setImages(newTruck.getImages());
			truck.setCategories(newTruck.getCategories());
			truck.setHolidays(newTruck.getHolidays());
			truck.setSchedules(newTruck.getSchedules());
			truck.setOwner(newTruck.getOwner());

			truckRepository.save(truck);
			return truck;
		}
		return null;
	}
}