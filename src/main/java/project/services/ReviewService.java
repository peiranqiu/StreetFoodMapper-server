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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.models.Review;
import project.models.Truck;
import project.repositories.ReviewRepository;
import project.repositories.TruckRepository;

@RestController
@CrossOrigin(origins =  "*", maxAge = 3600, allowCredentials = "true")
public class ReviewService {
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	TruckRepository truckRepository;
	
	@PostMapping("/api/truck/{truckId}/review")
	public Review createReview(@PathVariable("truckId") int truckId, @RequestBody Review newReview, HttpServletResponse response) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if (data.isPresent()) {
			Truck truck = data.get();
			newReview.setTruck(truck);
			return reviewRepository.save(newReview);
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	

	@DeleteMapping("/api/review/{reviewId}")
	public void deleteReview(@PathVariable("reviewId") int reviewId)
	{
		reviewRepository.deleteById(reviewId);
	}
	
	@GetMapping("/api/review")
	public List<Review> findAllReviews()
	{
		return (List<Review>) reviewRepository.findAll();
	}
	
	@GetMapping("/api/review/{reviewId}")
	public Review findReviewById(@PathVariable("reviewId") int reviewId, HttpServletResponse response) {
		Optional<Review> data = reviewRepository.findById(reviewId);
		if (data.isPresent()) {
			return data.get();
		} 
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	
	@GetMapping("/api/truck/{truckId}/review")
	public List<Review> findReviewsForTruck(
			@PathVariable("truckId") int truckId, HttpServletResponse response) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if(data.isPresent()) {
			Truck truck = data.get();
			return truck.getReviews();
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;		
	}
}
	
	