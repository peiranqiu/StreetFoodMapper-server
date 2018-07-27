package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.models.Owner;
import project.repositories.OwnerRepository;

import java.util.*;

@RestController
public class OwnerService {
	@Autowired
	OwnerRepository repository;

	@DeleteMapping("/api/owner/{ownerId}")
	public void deleteOwner(@PathVariable("ownerId") int id) {
		repository.deleteById(id);
	}

	@PostMapping("/api/owner")
	public Owner createOwner(@RequestBody Owner owner) {
		return repository.save(owner);
	}

	@GetMapping("/api/owner")
	public Iterable<Owner> findAllOwners() {
		return repository.findAll();
	}

	@GetMapping("/api/owner/{ownerId}")
	public Owner findOwnerById(@PathVariable("ownerId") int ownerId) {
		Optional<Owner> data = repository.findById(ownerId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	

	@PutMapping("/api/owner/{ownerId}")
	public Owner updateOwner(@PathVariable("ownerId") int ownerId, @RequestBody Owner newOwner) {
		Optional<Owner> data = repository.findById(ownerId);
		if (data.isPresent()) {
			Owner owner = data.get();
			owner.setTrucks(newOwner.getTrucks());
			owner.setPassword(newOwner.getPassword());

			repository.save(owner);
			return owner;
		}
		return null;
	}

	
}
