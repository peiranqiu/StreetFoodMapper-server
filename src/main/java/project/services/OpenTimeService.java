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

import project.models.OpenTime;
import project.models.Schedule;
import project.repositories.OpenTimeRepository;
import project.repositories.ScheduleRepository;

@RestController
@CrossOrigin(origins =  "*", maxAge = 3600, allowCredentials = "true")
public class OpenTimeService {
	@Autowired
	ScheduleRepository scheduleRepository;
	@Autowired
	OpenTimeRepository openTimeRepository;

	@GetMapping("/api/truck/{truckId}/schedule/{scheduleId}/openTime")
	public List<OpenTime> findOpenTimesForSchedule(
			@PathVariable("scheduleId") int scheduleId, HttpServletResponse response) {
		Optional<Schedule> data = scheduleRepository.findById(scheduleId);
		if(data.isPresent()) {
			Schedule schedule = data.get();
			return schedule.getOpenTimes();
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;		
	}
	
	@GetMapping("/api/openTime")
	public List<OpenTime> findAllOpenTimes()
	{
		return (List<OpenTime>) openTimeRepository.findAll();
	}
	
	@PostMapping("/api/truck/{truckId}/schedule/{scheduleId}/openTime")
	public OpenTime createOpenTime(@PathVariable("scheduleId") int scheduleId, 
			@RequestBody OpenTime newOpenTime, HttpServletResponse response) {
		Optional<Schedule> data = scheduleRepository.findById(scheduleId);
		if (data.isPresent()) {
			Schedule schedule = data.get();
			newOpenTime.setSchedule(schedule);
			return openTimeRepository.save(newOpenTime);
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	

	@DeleteMapping("/api/truck/{truckId}/schedule/{scheduleId}/openTime/{openTimeId}")
	public void deleteOpenTime(@PathVariable("openTimeId") int openTimeId)
	{
		openTimeRepository.deleteById(openTimeId);
	}
	
	@GetMapping("/api/truck/{truckId}/schedule/{scheduleId}/openTime/{openTimeId}")
	public OpenTime findOpenTimeById(@PathVariable("openTimeId") int openTimeId, HttpServletResponse response) {
		Optional<OpenTime> data = openTimeRepository.findById(openTimeId);
		if (data.isPresent()) {
			return data.get();
		} 
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	
	@PutMapping("/api/truck/{truckId}/schedule/{scheduleId}/openTime/{openTimeId}")
	public OpenTime updateOpenTime(@PathVariable("openTimeId") int openTimeId, 
			@RequestBody OpenTime newOpenTime, HttpServletResponse response) {
		Optional<OpenTime> data = openTimeRepository.findById(openTimeId);
		if (data.isPresent()) {
			OpenTime openTime = data.get();
			//openTime.setId(newOpenTime.getId());
			//openTime.setDay(newOpenTime.getDay());
			openTime.setStartTime(newOpenTime.getStartTime());
			openTime.setEndTime(newOpenTime.getEndTime());
			//openTime.setSchedule(newOpenTime.getSchedule());

			openTimeRepository.save(openTime);
			return openTime;
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	
}