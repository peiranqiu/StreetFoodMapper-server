package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.models.Owner;
import project.models.User;
import project.repositories.OwnerRepository;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins =  "*", maxAge = 3600, allowCredentials = "true")
public class OwnerService {
	@Autowired
	OwnerRepository ownerRepository;
	
	
	  @PutMapping("/api/login/owner")
	  @ResponseBody
	  public Owner ownerLogin(@RequestBody Owner owner, HttpServletResponse response,
	                                        HttpServletRequest request) {
	    String email = owner.getEmail();
	    String password = owner.getPassword();

	    HttpSession session = request.getSession();

	    Optional<Owner> data = ownerRepository.findOwnerByCredentials(email, password);
	    if (data.isPresent()) {
	      Owner currOwner = data.get();
	      session.setAttribute("owner", currOwner);
	      return currOwner;
	    }
	    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	    return null;
	  }
	
	  @PostMapping("/api/register/owner")
	  @ResponseBody
	  public Owner ownerRegister(@RequestBody Owner owner,
	                                   HttpServletResponse response,
	                                   HttpServletRequest request) {
	    String email = owner.getEmail();

	    HttpSession session = request.getSession();

	    Optional<Owner> data = ownerRepository.findOwnerByEmail(email);
	    if (!data.isPresent()) {
	      session.setAttribute("owner", owner);
	      return ownerRepository.save(owner);
	    }
	    response.setStatus(HttpServletResponse.SC_CONFLICT);
	    return null;
	  }
	
	  @PutMapping("/api/profile/owner/{ownerId}")
	  public Owner updateOwnerProfile(@PathVariable("ownerId") int ownerId,
	                                               @RequestBody Owner owner) {
	    Optional<Owner> data = ownerRepository.findById(ownerId);
	    if (data.isPresent()) {
	      Owner res = data.get();
	      if (!owner.getPassword().equals(res.getPassword())) {
	        res.setPassword(owner.getPassword());
	      }
	      return ownerRepository.save(res);
	    }
	    return null;
	  }
	  
	  @PostMapping("/api/logout/owner")
	  public void ownerLogout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	      session.invalidate();
	    }
	  }
	  
	  @GetMapping("/api/session/owner")
	  public Owner findCurrentOwner(HttpServletRequest request, HttpServletResponse response) {
	    HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("owner") != null) {
	      return (Owner) session.getAttribute("owner");
	    }
	    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	    return null;
	  }

	@DeleteMapping("/api/owner/{ownerId}")
	public void deleteOwner(@PathVariable("ownerId") int id) {
		ownerRepository.deleteById(id);
	}
	
	@GetMapping("/api/owner")
	public Iterable<Owner> findAllOwners() {
		return ownerRepository.findAll();
	}

	@GetMapping("/api/owner/{ownerId}")
	public Owner findOwnerById(@PathVariable("ownerId") int ownerId) {
		Optional<Owner> data = ownerRepository.findById(ownerId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	

	
}
