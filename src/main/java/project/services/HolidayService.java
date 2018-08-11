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

import project.models.Holiday;
import project.models.Schedule;
import project.models.Truck;
import project.repositories.HolidayRepository;
import project.repositories.TruckRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
public class HolidayService {
	@Autowired
	HolidayRepository holidayRepository;
	@Autowired
	TruckRepository truckRepository;

	@GetMapping("/api/truck/{truckId}/holiday")
	public List<Holiday> findAllHolidaysForTruck(
			@PathVariable("truckId") int truckId, HttpServletResponse response) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if(data.isPresent()) {
			Truck truck = data.get();
			return truck.getHolidays();
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;		
	}
	
	@PostMapping("/api/truck/{truckId}/holiday")
	public Holiday createHoliday(@PathVariable("truckId") int truckId, @RequestBody Holiday newHoliday, HttpServletResponse response) {
		Optional<Truck> data = truckRepository.findById(truckId);
		if (data.isPresent()) {
			Truck truck = data.get();
			newHoliday.setTruck(truck);
			return holidayRepository.save(newHoliday);
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	

	@DeleteMapping("/api/holiday/{holidayId}")
	public void deleteHoliday(@PathVariable("holidayId") int holidayId)
	{
		holidayRepository.deleteById(holidayId);
	}
	
	@GetMapping("/api/holiday")
	public List<Holiday> findAllHolidays()
	{
		return (List<Holiday>) holidayRepository.findAll();
	}
	
	@GetMapping("/api/holiday/{holidayId}")
	public Holiday findHolidayById(@PathVariable("holidayId") int holidayId, HttpServletResponse response) {
		Optional<Holiday> data = holidayRepository.findById(holidayId);
		if (data.isPresent()) {
			return data.get();
		} 
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	
	@PutMapping("/api/truck/{truckId}/holiday/{holidayId}")
	public Holiday updateHoliday(@PathVariable("holidayId") int holidayId, @RequestBody Holiday newHoliday, HttpServletResponse response) {
		Optional<Holiday> data = holidayRepository.findById(holidayId);
		if (data.isPresent()) {
			Holiday holiday = data.get();
			holiday.setDate(newHoliday.getDate());

			holidayRepository.save(holiday);
			return holiday;
		}
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}
	
	
	
	
}