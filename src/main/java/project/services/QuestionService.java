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

import com.example.myapp.models.EssayQuestion;
import com.example.myapp.models.Exam;
import com.example.myapp.models.FillInTheBlankQuestion;
import com.example.myapp.models.MultipleChoiceQuestion;
import com.example.myapp.models.Question;
import com.example.myapp.models.TrueOrFalseQuestion;
import com.example.myapp.repositories.EssayQuestionRepository;
import com.example.myapp.repositories.ExamRepository;
import com.example.myapp.repositories.FillInTheBlankQuestionRepository;
import com.example.myapp.repositories.MultipleChoiceQuestionRepository;
import com.example.myapp.repositories.QuestionRepository;
import com.example.myapp.repositories.TrueOrFalseQuestionRepository;

@RestController
@CrossOrigin(origins="*")
public class QuestionService {
	@Autowired
	ExamRepository examRepository; 
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	EssayQuestionRepository essayQuestionRepository; 
	@Autowired
	FillInTheBlankQuestionRepository fillInTheBlankQuestionRepository;
	@Autowired
	TrueOrFalseQuestionRepository trueOrFalseQuestionRepository;
	@Autowired
	MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
	
	@GetMapping("api/question")
	public List<Question> findAllQuestions() {
		return (List<Question>) questionRepository.findAll();
	}
	
	@PostMapping("/api/question") 
	public Question createQuestion(@RequestBody Question question) {
		return questionRepository.save(question);
	}
	
	@PostMapping("/api/exam/{examId}/essay")
	public EssayQuestion createEssayQuestion(@PathVariable("examId") int examId, @RequestBody EssayQuestion essayQuestion) {
		Optional<Exam> data = examRepository.findById(examId);
		if (data.isPresent()) {
			essayQuestion.setExam(data.get());
			return essayQuestionRepository.save(essayQuestion);
		}
		return null;
	}
	
	@PutMapping("/api/exam/{examId}/essay/{questionId}")
	public EssayQuestion updateEssayQuestion(
			@PathVariable("questionId") int questionId, 
			@RequestBody EssayQuestion newQuestion) {
		Optional<EssayQuestion> data = essayQuestionRepository.findById(questionId);
		if (data.isPresent()) {
			EssayQuestion question = data.get();
			if (newQuestion.getTitle() != null && !newQuestion.getTitle().equals("")) {
				question.setTitle(newQuestion.getTitle());
			}
			if (newQuestion.getPoints() != 0) {
				question.setPoints(newQuestion.getPoints());
			}
			if (newQuestion.getDescription() != null) {
				question.setDescription(newQuestion.getDescription());
			}
			if (newQuestion.getEssay() != null) {
				question.setEssay(newQuestion.getEssay());
			}
			essayQuestionRepository.save(question);
			return question;
		}
		return null;
	}
	
	@PostMapping("/api/exam/{examId}/blanks")
	public FillInTheBlankQuestion createFillInTheBlankQuestion(
			@PathVariable("examId") int examId, 
			@RequestBody FillInTheBlankQuestion fillInTheBlankQuestion) {
		Optional<Exam> data = examRepository.findById(examId);
		if (data.isPresent()) {
			fillInTheBlankQuestion.setExam(data.get());
			return fillInTheBlankQuestionRepository.save(fillInTheBlankQuestion);
		}
		return null;
	}
	
	@PutMapping("/api/exam/{examId}/blanks/{questionId}")
	public FillInTheBlankQuestion updateFillInTheBlankQuestion(
			@PathVariable("questionId") int questionId, 
			@RequestBody FillInTheBlankQuestion newQuestion) {
		Optional<FillInTheBlankQuestion> data = fillInTheBlankQuestionRepository.findById(questionId);
		if (data.isPresent()) {
			FillInTheBlankQuestion question = data.get();
			if (newQuestion.getTitle() != null && !newQuestion.getTitle().equals("")) {
				question.setTitle(newQuestion.getTitle());
			}
			if (newQuestion.getPoints() != 0) {
				question.setPoints(newQuestion.getPoints());
			}
			if (newQuestion.getDescription() != null) {
				question.setDescription(newQuestion.getDescription());
			}
			if (newQuestion.getVariables() != null) {
				question.setVariables(newQuestion.getVariables());
			}
			fillInTheBlankQuestionRepository.save(question);
			return question;
		}
		return null;
	}

	@PostMapping("/api/exam/{examId}/choice")
	public MultipleChoiceQuestion createMultipleChoiceQuestion(
			@PathVariable("examId") int examId, 
			@RequestBody MultipleChoiceQuestion multipleChoiceQuestion) {
		Optional<Exam> data = examRepository.findById(examId);
		if (data.isPresent()) {
			multipleChoiceQuestion.setExam(data.get());
			return multipleChoiceQuestionRepository.save(multipleChoiceQuestion);
		}
		return null;
	}
	
	@PutMapping("/api/exam/{examId}/choice/{questionId}")
	public MultipleChoiceQuestion updateMultipleChoiceQuestion(
			@PathVariable("questionId") int questionId, 
			@RequestBody MultipleChoiceQuestion newQuestion) {
		Optional<MultipleChoiceQuestion> data = multipleChoiceQuestionRepository.findById(questionId);
		if (data.isPresent()) {
			MultipleChoiceQuestion question = data.get();
			if (newQuestion.getTitle() != null && !newQuestion.getTitle().equals("")) {
				question.setTitle(newQuestion.getTitle());
			}
			if (newQuestion.getPoints() != 0) {
				question.setPoints(newQuestion.getPoints());
			}
			if (newQuestion.getDescription() != null) {
				question.setDescription(newQuestion.getDescription());
			}
			if (newQuestion.getOptions() != null) {
				question.setOptions(newQuestion.getOptions());
			}
			if (newQuestion.getCorrectOption() != 0) {
				question.setCorrectOption(newQuestion.getCorrectOption());
			}
			multipleChoiceQuestionRepository.save(question);
			return question;
		}
		return null;
	}
	
	@PostMapping("/api/exam/{examId}/truefalse")
	public TrueOrFalseQuestion createMultipleChoiceQuestion(
			@PathVariable("examId") int examId, 
			@RequestBody TrueOrFalseQuestion trueOrFalseQuestion) {
		Optional<Exam> data = examRepository.findById(examId);
		if (data.isPresent()) {
			trueOrFalseQuestion.setExam(data.get());
			return trueOrFalseQuestionRepository.save(trueOrFalseQuestion);
		}
		return null;
	}
	
	@PutMapping("/api/exam/{examId}/truefalse/{questionId}")
	public TrueOrFalseQuestion updateTrueFalseQuestion(
			@PathVariable("questionId") int questionId, 
			@RequestBody TrueOrFalseQuestion newQuestion) {
		Optional<TrueOrFalseQuestion> data = trueOrFalseQuestionRepository.findById(questionId);
		if (data.isPresent()) {
			TrueOrFalseQuestion question = data.get();
			if (newQuestion.getTitle() != null && !newQuestion.getTitle().equals("")) {
				question.setTitle(newQuestion.getTitle());
			}
			if (newQuestion.getPoints() != 0) {
				question.setPoints(newQuestion.getPoints());
			}
			if (newQuestion.getDescription() != null) {
				question.setDescription(newQuestion.getDescription());
			}
			if (newQuestion.getIsTrue() != null) {
				question.setIsTrue(newQuestion.getIsTrue());
			}
			trueOrFalseQuestionRepository.save(question);
			return question;
		}
		return null;
	}

	@DeleteMapping("/api/question/{questionId}")
	public void deleteQuestion(@PathVariable("questionId") int questionId) {
		questionRepository.deleteById(questionId);
	}
}