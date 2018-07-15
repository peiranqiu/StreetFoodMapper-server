package com.example.myapp.services;

import com.example.myapp.models.Course;
import com.example.myapp.repositories.CourseRepository;

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
public class CourseService {
	@Autowired
	CourseRepository courseRepository;

	@GetMapping("/api/course")
	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll();
	}
	
	@PostMapping("/api/course")
	public Course createCourse
	(@RequestBody Course course) {
	return courseRepository.save(course);
	}
	
	@DeleteMapping("/api/course/{courseId}")
	public void deleteCourse(
	@PathVariable("courseId") int id) {
	courseRepository.deleteById(id);
	}
	
	@GetMapping("/api/course/{courseId}")
	public Course findCourseById(@PathVariable("courseId") int courseId) {
		Optional<Course> data = courseRepository.findById(courseId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	
	@PutMapping("/api/course/{courseId}")
	public Course updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course newCourse) {
		Optional<Course> data = courseRepository.findById(courseId);
		if (data.isPresent()) {
			Course course = data.get();
			course.setId(newCourse.getId());
			course.setTitle(newCourse.getTitle());
			course.setOwner(newCourse.getOwner());
			course.setCreated(newCourse.getCreated());
			course.setModified(newCourse.getModified());
			course.setModules(newCourse.getModules());

			courseRepository.save(course);
			return course;
		}
		return null;
	}
	
}