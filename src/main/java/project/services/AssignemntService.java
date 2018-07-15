package com.example.myapp.services;
import java.util.ArrayList;
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

import com.example.myapp.models.Assignment;
import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.AssignmentRepository;
import com.example.myapp.repositories.TopicRepository;

@RestController
@CrossOrigin(origins="*")
public class AssignemntService {
	@Autowired
	AssignmentRepository assignmentRepository; 
	@Autowired
	TopicRepository topicRepository; 
	
	@GetMapping("/api/assignment")
	public List<Assignment> findAllAssignments() {
		return (List<Assignment>) assignmentRepository.findAll();
	}
	
	@GetMapping("/api/assignment/{aid}")
	public Assignment findAssignmentById(@PathVariable("aid") int id) {
		Optional<Assignment> data = assignmentRepository.findById(id);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}
	
	@GetMapping("/api/topic/{topicId}/assignment")
	public List<Assignment> findAllAssignmentsForLesson(@PathVariable("topicId") int id) {
		Optional<Topic> data = topicRepository.findById(id);
		if (data.isPresent()) {
			List<Widget> widgets = data.get().getWidgets();
			List<Assignment> res = new ArrayList<Assignment>();
			for (Widget w : widgets) {
				if (w instanceof Assignment) {
					res.add((Assignment) w);
				}
			}
			return res;
		}
		return null;
	}
	
	@PostMapping("/api/topic/{topicId}/assignment") 
	public Assignment createAssignment(@PathVariable("topicId") int id, @RequestBody Assignment assignment) {
		Optional<Topic> data = topicRepository.findById(id);
		if (data.isPresent()) {
			assignment.setTopic(data.get());
			return assignmentRepository.save(assignment);	
		}
		return null;
	}
	
	@PutMapping("/api/topic/{topicId}/assignment/{assignmentId}") 
	public Assignment updateAssignment(
			@PathVariable("assignmentId") int id,
			@RequestBody Assignment newAssignment) {
		Optional<Assignment> data = assignmentRepository.findById(id);
		if (data.isPresent()) {
			Assignment assignment = data.get();
			if (newAssignment.getTitle() != null && !newAssignment.getTitle().equals("")) {
				assignment.setTitle(newAssignment.getTitle());
			}
			if (newAssignment.getPoints() != 0) {
				assignment.setPoints(newAssignment.getPoints());
			}
			if (newAssignment.getDescription() != null) {
				assignment.setDescription(newAssignment.getDescription());
			}
			return assignmentRepository.save(assignment);	
		}
		return null;
	}
	
	@DeleteMapping("/api/assignment/{aid}")
	public void deleteAssignment(@PathVariable("aid") int id) {
		assignmentRepository.deleteById(id);
	}
}