package com.example.myapp.services;

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

import com.example.myapp.models.Lesson;
import com.example.myapp.models.Topic;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicService {
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TopicRepository topicRepository;

	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
	public List<Topic> findAllTopicsForLesson(
			@PathVariable("courseId") int courseId, 
			@PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if(data.isPresent()) {
			Lesson lesson = data.get();
			return lesson.getTopics();
		}
		return null;		
	}
	
	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
	public Topic createTopic(@PathVariable("courseId") int courseId, 
			@PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId,
			@RequestBody Topic newTopic) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if (data.isPresent()) {
			Lesson lesson = data.get();
			newTopic.setLesson(lesson);
			return topicRepository.save(newTopic);
		}
		return null;
	}
	

	@DeleteMapping("/api/topic/{topicId}")
	public void deleteTopic(@PathVariable("topicId") int topicId)
	{
		topicRepository.deleteById(topicId);
	}
	
	@GetMapping("/api/topic")
	public List<Topic> findAllTopics()
	{
		return (List<Topic>) topicRepository.findAll();
	}
	
	@GetMapping("/api/topic/{topicId}")
	public Topic findTopicById(@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	
	@PutMapping("/api/topic/{topicId}")
	public Topic updateTopic(@PathVariable("topicId") int topicId, @RequestBody Topic newTopic) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			Topic topic = data.get();
			topic.setId(newTopic.getId());
			topic.setTitle(newTopic.getTitle());
			topic.setLesson(newTopic.getLesson());

			topicRepository.save(topic);
			return topic;
		}
		return null;
	}
}