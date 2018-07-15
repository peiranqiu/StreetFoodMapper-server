package project.services;

import project.models.Schedule;
import project.models.Truck;
import project.repositories.ScheduleRepository;
import project.repositories.TruckRepository;

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
public class ScheduleService {
	@Autowired
	ScheduleRepository scheduleRepository;

	@Autowired
	TruckRepository truckRepository;

	@GetMapping("/api/truck/{truckId}/schedule")
	public List<Schedule> findAllSchedulesForTruck(
			@PathVariable("truckId") int truckId) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if(data.isPresent()) {
			Truck truck = data.get();
			return truck.getSchedules();
		}
		return null;		
	}
	
	@GetMapping("/api/schedule")
	public Iterable<Schedule> findAllSchedules() {
		return scheduleRepository.findAll();
	}
	
	@PostMapping("/api/schedule")
	public Schedule createSchedule
	(@RequestBody Schedule schedule) {
	return scheduleRepository.save(schedule);
	}
	
	@DeleteMapping("/api/schedule/{scheduleId}")
	public void deleteSchedule(
	@PathVariable("scheduleId") int id) {
		scheduleRepository.deleteById(id);
	}
	
	@GetMapping("/api/schedule/{scheduleId}")
	public Schedule findScheduleById(@PathVariable("scheduleId") int scheduleId) {
		Optional<Schedule> data = scheduleRepository.findById(scheduleId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	
	@PutMapping("/api/schedule/{scheduleId}")
	public Schedule updateSchedule(@PathVariable("scheduleId") int scheduleId, @RequestBody Schedule newSchedule) {
		Optional<Schedule> data = scheduleRepository.findById(scheduleId);
		if (data.isPresent()) {
			Schedule schedule = data.get();
			schedule.setId(newSchedule.getId());
			schedule.setTruck(newSchedule.getTruck());
			schedule.setDay(newSchedule.getDay());
			schedule.setStartTime(newSchedule.getStartTime());
			schedule.setEndTime(newSchedule.getEndTime());
			schedule.setAddress(newSchedule.getAddress());

			scheduleRepository.save(schedule);
			return schedule;
		}
		return null;
	}
	
}