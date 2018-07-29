package project.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import project.models.Favorite;
import project.models.Owner;
import project.models.Truck;
import project.models.User;
import project.repositories.FavoriteRepository;
import project.repositories.OwnerRepository;
import project.repositories.TruckRepository;
import project.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class TruckService {
	@Autowired
	OwnerRepository ownerRepository;
	@Autowired
	TruckRepository truckRepository;
	@Autowired
	FavoriteRepository favoriteRepository;

	@GetMapping("/api/owner/{ownerId}/truck")
	public List<Truck> findAllTrucksForOwner(@PathVariable("ownerId") int ownerId, HttpServletResponse response) {
		Optional<Owner> data = ownerRepository.findById(ownerId);
		if (data.isPresent()) {
			Owner owner = data.get();
			return owner.getTrucks();
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}

	@PostMapping("/api/owner/{ownerId}/truck")
	public Truck createTruck(@PathVariable("ownerId") int ownerId, @RequestBody Truck newTruck, 
			HttpServletResponse response) {
		Optional<Owner> data = ownerRepository.findById(ownerId);
		if (data.isPresent()) {
			Owner owner = data.get();
			newTruck.setOwner(owner);
			return truckRepository.save(newTruck);
		}
		response.setStatus(HttpServletResponse.SC_CONFLICT);
		return null;
	}

	@DeleteMapping("/api/truck/{truckId}")
	public void deleteTruck(@PathVariable("truckId") int truckId) {
		Optional<Truck> truckOptional = truckRepository.findById(truckId);
		if (truckOptional.isPresent()) {
			Truck truck = truckOptional.get();
			// remove related favorites
			List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();
			for (Favorite fav : favorites) {
				if (fav.getTruck().getId() == truckId) {
					favoriteRepository.deleteById(fav.getId());
				}
			}
		}
		truckRepository.deleteById(truckId);
	}

	@GetMapping("/api/truck")
	public List<Truck> findAllTrucks() {
		return (List<Truck>) truckRepository.findAll();
	}

	@GetMapping("/api/truck/{truckId}")
	public Truck findTruckById(@PathVariable("truckId") int truckId, HttpServletResponse response) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if (data.isPresent()) {
			return data.get();
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}

	@PutMapping("/api/truck/{truckId}")
	public Truck updateTruck(@PathVariable("truckId") int truckId, @RequestBody Truck newTruck, 
			HttpServletResponse response) {
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
			truck.setPhotos(newTruck.getPhotos());
			truck.setHolidays(newTruck.getHolidays());
			truck.setSchedules(newTruck.getSchedules());
			truck.setOwner(newTruck.getOwner());
			truck.setWebsite(newTruck.getWebsite());
			truck.setCategory1(newTruck.getCategory1());
			truck.setCategory2(newTruck.getCategory2());
			truck.setCategory3(newTruck.getCategory3());
			truck.setIsOpen(newTruck.getIsOpen());

			truckRepository.save(truck);
			return truck;
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
}