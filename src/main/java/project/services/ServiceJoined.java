package com.example.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Question;
import com.example.myapp.models.FillInTheBlankQuestion;
import com.example.myapp.models.TrueOrFalseQuestion;
import com.example.myapp.repositories.QuestionRepository;
import com.example.myapp.repositories.FillInTheBlankQuestionRepository;
import com.example.myapp.repositories.TrueOrFalseQuestionRepository;

@RestController
public class ServiceJoined {
	@Autowired
	QuestionRepository baseRepo;

	@Autowired
	FillInTheBlankQuestionRepository fillRepo;

	@Autowired
	TrueOrFalseQuestionRepository trueRepo;

	@GetMapping("/api/inheritance/joined/base")
	public Question createBaseQuestion() {
		Question q = new Question();
		q.setDescription("descriptions 123");
		q.setInstructions("instructions 123");
		q.setPoints(123);
		q.setTitle("title 123");
		return baseRepo.save(q);
	}

	@GetMapping("/api/inheritance/joined/fill")
	public FillInTheBlankQuestion createFillQuestion() {
		FillInTheBlankQuestion q = new FillInTheBlankQuestion();
		q.setDescription("descriptions 234");
		q.setInstructions("instructions 234");
		q.setPoints(234);
		q.setTitle("title 234");
		q.setVariables("variables 234");
		return fillRepo.save(q);
	}

	@GetMapping("/api/inheritance/joined/true")
	public TrueOrFalseQuestion createTrueQuestion() {
		TrueOrFalseQuestion q = new TrueOrFalseQuestion();
		q.setDescription("descriptions 345");
		q.setInstructions("instructions 345");
		q.setPoints(345);
		q.setTitle("title 345");
		q.setIsTrue(true);
		return trueRepo.save(q);
	}

}