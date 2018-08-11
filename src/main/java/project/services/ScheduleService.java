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

import project.models.Favorite;
import project.models.Schedule;
import project.models.Truck;
import project.repositories.FavoriteRepository;
import project.repositories.ScheduleRepository;
import project.repositories.TruckRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class ScheduleService {
	@Autowired
	ScheduleRepository scheduleRepository;
	@Autowired
	TruckRepository truckRepository;
	@Autowired
	FavoriteRepository favoriteRepository;

	@GetMapping("/api/truck/{truckId}/schedule")
	public List<Schedule> findAllSchedulesForTruck(
			@PathVariable("truckId") int truckId, HttpServletResponse response) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if(data.isPresent()) {
			Truck truck = data.get();
			return truck.getSchedules();
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;		
	}
	
	@PostMapping("/api/truck/{truckId}/schedule")
	public Schedule createSchedule(@PathVariable("truckId") int truckId, @RequestBody Schedule newSchedule, HttpServletResponse response) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if (data.isPresent()) {
			Truck truck = data.get();
			newSchedule.setTruck(truck);
			return scheduleRepository.save(newSchedule);
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	

	@DeleteMapping("/api/schedule/{scheduleId}")
	public void deleteSchedule(@PathVariable("scheduleId") int scheduleId)
	{
		Optional<Schedule> scheduleOptional = scheduleRepository.findById(scheduleId);
		if (scheduleOptional.isPresent()) {
			Schedule schedule = scheduleOptional.get();
			// remove related favorites
			List<Favorite> favorites = (List<Favorite>) favoriteRepository.findAll();
			for (Favorite fav : favorites) {
				if (fav.getSchedule().getId() == scheduleId) {
					scheduleRepository.deleteById(fav.getId());
				}
			}
		}
		scheduleRepository.deleteById(scheduleId);
	}
	
	@GetMapping("/api/schedule")
	public List<Schedule> findAllSchedules()
	{
		return (List<Schedule>) scheduleRepository.findAll();
	}
	
	@GetMapping("/api/schedule/{scheduleId}")
	public Schedule findScheduleById(@PathVariable("scheduleId") int scheduleId, HttpServletResponse response) {
		Optional<Schedule> data = scheduleRepository.findById(scheduleId);
		if (data.isPresent()) {
			return data.get();
		} 
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	
	@PutMapping("/api/truck/{truckId}/schedule/{scheduleId}")
	public Schedule updateSchedule(@PathVariable("scheduleId") int scheduleId, @RequestBody Schedule newSchedule, HttpServletResponse response) {
		Optional<Schedule> data = scheduleRepository.findById(scheduleId);
		if (data.isPresent()) {
			Schedule schedule = data.get();
			schedule.setId(newSchedule.getId());
			schedule.setOpen(newSchedule.isOpen());
			schedule.setLatitude(newSchedule.getLatitude());
			schedule.setLongitude(newSchedule.getLongitude());
			schedule.setOpenTimes(newSchedule.getOpenTimes());
			schedule.setAddress(newSchedule.getAddress());
			schedule.setTruck(newSchedule.getTruck());

			scheduleRepository.save(schedule);
			return schedule;
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	
}