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

import com.example.myapp.models.Exam;
import com.example.myapp.models.Question;
import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.ExamRepository;
import com.example.myapp.repositories.QuestionRepository;
import com.example.myapp.repositories.TopicRepository;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
public class ExamService {
	@Autowired
	ExamRepository examRepository;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	TopicRepository topicRepository; 
	
	@GetMapping("/api/exam")
	public List<Exam> findAllExams() {
		return (List<Exam>) examRepository.findAll();
	}
	
	@GetMapping("/api/exam/{examid}")
	public Exam findExamById(@PathVariable("examid") int examId) {
		Optional<Exam> data = examRepository.findById(examId);
		if (data.isPresent()) {
			return data.get();
		}
		return null;
	}
	
	@GetMapping("/api/topic/{topicId}/exam")
	public List<Exam> findAllExamsForTopic(@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			List<Widget> widgets = data.get().getWidgets();
			List<Exam> res = new ArrayList<Exam>();
			for (Widget w : widgets) {
				if (w instanceof Exam) {
					res.add((Exam) w);
				}
			}
			return res;
		}
		return null;
	}

	@PostMapping("/api/topic/{topicId}/exam")
	public Exam createExamForTopic(@PathVariable("topicId") int topicId, @RequestBody Exam exam) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if (data.isPresent()) {
			exam.setTopic(data.get());
			return examRepository.save(exam);
		}
		return null;
	}
	
	@DeleteMapping("/api/exam/{examId}")
	public void deleteExam(@PathVariable("examId") int examId) {
		examRepository.deleteById(examId);
	}

	@PutMapping("api/exam/{examId}")
	public Exam updateExam(@PathVariable("examId") int examId,
			@RequestBody Exam newExam) {
		Optional<Exam> data = examRepository.findById(examId);
		if (data.isPresent()) {
			Exam exam = data.get();
			if (newExam.getTitle() != null && !newExam.getTitle().equals("")) {
				exam.setTitle(newExam.getTitle());
			}
			if (newExam.getDescription() != null) {
				exam.setDescription(newExam.getDescription());
			}
			examRepository.save(exam);
			return exam;
		}
		return null;
	}

	@GetMapping("/api/exam/{examId}/question")
	public List<Question> findAllQuestionsForExam(@PathVariable("examId") int examId) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			List<Question> questions = exam.getQuestions();
			return questions;
		}
		return null;
	}
	
}